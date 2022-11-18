package section20.aula258;


import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

import java.util.stream.Collectors;

import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Function as args
*/
public class Program {

    static final Faker faker = new Faker();

    public static void main(String...args){
        Locale.setDefault(Locale.US);

        Screen.clear();

        List<Person> persons = getPersons();
        System.out.println("Original List");
        persons.forEach(System.out::println);
        System.out.println();

        PersonService ps = new PersonService();

        double sum = ps.filteredSum(persons, p -> p.name.charAt(0) == 'C');
        System.out.printf("Total amount: %.2f\n", sum);
        System.out.println();
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

class Person {
    String name;
    Integer age;
    Double balance;

    public Person(String name, Integer age, Double balance){
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    @Override
    public String toString(){
        return String.format("%s, %d, %.2f", name, age, balance);
    }
}

class PersonService {
    public double filteredSum(List<Person> persons, Predicate<Person> criteria){
        double sum = 0.0;
        for (Person p : persons){
            if (criteria.test(p)){
                sum += p.balance;
            }
        }

        return sum;
    }
}