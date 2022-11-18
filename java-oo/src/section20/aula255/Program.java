package section20.aula255;


import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

import java.util.function.Predicate;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Predicate
*/
public class Program {

    static final Faker faker = new Faker();

    public static void main(String...args){
        Locale.setDefault(Locale.US);

        Screen.clear();

        List<Person> persons = getPersons();
        
        persons.forEach(System.out::println);

        // Predicate inline
        persons.removeIf(p -> p.age >= 40);

        System.out.println("Predicate convencional");
        persons.forEach(System.out::println);

        // Implementação de interface
        persons.removeIf(new MyPredicate());

        System.out.println("Implementação de interface");
        persons.forEach(System.out::println);

        // Method reference static
        persons.removeIf(Person::myPredicateAge);

        System.out.println("Method reference static");
        persons.forEach(System.out::println);   

        // Method reference non static
        persons.removeIf(Person::myPredicateAgeNS);

        System.out.println("Method reference non static");
        persons.forEach(System.out::println); 

        // Predicate
        Predicate<Person> pre = p -> p.age > 30;
        persons.removeIf(pre);

        System.out.println("Predicate");
        persons.forEach(System.out::println); 

        // Predicate inline
          persons.removeIf(p -> p.age > 25);

        System.out.println("Predicate inline");
        persons.forEach(System.out::println);                              

    }

    static List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 50; i++){  
            String name = faker.name().firstName();
            int age = faker.number().numberBetween(20, 60);
            double balance = faker.number().randomDouble(2, 100, 10000);

            persons.add(new Person(name, age, balance));
        }   

        return persons;
    }
}

class MyPredicate implements Predicate<Person>{

    public boolean test(Person p)
    {
        return p.balance < 5000.0;
    }
}

class Person {
    String name;
    Integer age;
    Double balance;


    public Person(String name, Integer age, Double balance){
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    public static boolean myPredicateAge(Person p)    
    {
        return p.age % 2 == 0;
    }

    public boolean myPredicateAgeNS()    
    {
        return balance < 7000.0;
    }


    public String toString(){
        return String.format("%s, %d, %.2f", name, age, balance);
    }
}