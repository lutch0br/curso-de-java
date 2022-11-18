package section20.aula257;


import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

import java.util.stream.Collectors;

import java.util.function.Function;
import java.util.function.Consumer;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Function
*/
public class Program {

    static final Faker faker = new Faker();

    public static void main(String...args){
        Locale.setDefault(Locale.US);

        Screen.clear();

        List<Person> persons = getPersons();
        System.out.println("Original List");
        persons.forEach(System.out::println);

        List<String> names = persons
            .stream()
            .map(new UpperCaseName())
            .collect(Collectors.toList());

        names.forEach(System.out::println);
        
        
        System.out.println("Method static");
        List<String> names2 = persons
            .stream()
            .map(Person::staticLowerCaseName)
            .collect(Collectors.toList());       

        names2.forEach(System.out::println);   

        System.out.println("Lambda inline");
        List<String> names3 = persons
            .stream()
            .map(p -> p.name.toUpperCase())
            .collect(Collectors.toList());       

        names3.forEach(System.out::println);        

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

class UpperCaseName implements Function<Person, String>{

    @Override
    public String apply(Person p)
    {
        return p.name.toUpperCase();
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

    public static String staticLowerCaseName(Person p)    
    {
        return p.name.toLowerCase();
    }

    public String nonStaticLowerCaseName()    
    {
        return name.toLowerCase();
    }

    @Override
    public String toString(){
        return String.format("%s, %d, %.2f", name, age, balance);
    }
}