package section20.aula256;


import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

import java.util.function.Consumer;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Consumer
*/
public class Program {

    static final Faker faker = new Faker();

    public static void main(String...args){
        Locale.setDefault(Locale.US);

        Screen.clear();

        List<Person> persons = getPersons();
        System.out.println("Original List");
        persons.forEach(System.out::println);

        // o método forEach recebe um consumer como arg.
        System.out.println("Object Consumer");
        persons.forEach(new BalanceUpdate());
        persons.forEach(System.out::println);
   
        // o método forEach recebe um consumer como arg.
        System.out.println("Static Balance Update");
        persons.forEach(Person::staticBalanceUpdate);
        persons.forEach(System.out::println);

        // o método forEach recebe um consumer como arg.
        System.out.println("Non Balance Update");
        persons.forEach(Person::nonStaticBalanceUpdate);
        persons.forEach(System.out::println);     

        // o método forEach recebe um consumer como arg.        
        System.out.println("Lambda");
        persons.forEach(p -> p.balance *= 1.1);
        persons.forEach(System.out::println);         


    }

    static List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 5; i++){  
            String name = faker.name().firstName();
            int age = faker.number().numberBetween(20, 60);
            double balance = faker.number().randomDouble(2, 100, 10000);

            persons.add(new Person(name, age, balance));
        }   

        return persons;
    }
}

class BalanceUpdate implements Consumer<Person>{

    @Override
    public void accept(Person p)
    {
        p.balance *= 1.1;
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

    public static void staticBalanceUpdate(Person p)    
    {
        p.balance *= 1.1;
    }

    public void nonStaticBalanceUpdate()    
    {
        balance *= 1.1;
    }

    @Override
    public String toString(){
        return String.format("%s, %d, %.2f", name, age, balance);
    }
}