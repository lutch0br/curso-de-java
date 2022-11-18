package section20.aula252;


import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Testando comparator
*/
public class Program {
    static final Faker faker = new Faker();

    public static void main(String...args){

        Screen.clear();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10; i++){  
            String name = faker.name().firstName();
            int age = faker.number().numberBetween(20, 60);
            double balance = faker.number().randomDouble(2, 100, 10000);

            persons.add(new Person(name, age, balance));
        }

        persons.sort(new MyComparatorName());
        persons.forEach(System.out::println);

        System.out.println();

        persons.sort(new MyComparatorAge());
        persons.forEach(System.out::println);

        // Comparator com classe anônima.
        Comparator<Person> comp = new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                return p1.balance.compareTo(p2.balance);
            }
        };

        System.out.println();

        persons.sort(comp);
        persons.forEach(System.out::println);     

        // outras formas

        // lambda com chaves
        Comparator<Person> comp1 = (Person p1, Person p2) -> {
                return p1.balance.compareTo(p2.balance);
        };

        // lambda sem chaves
        Comparator<Person> comp2 = (p1, p2) -> p1.balance.compareTo(p2.balance);

        // Expressão como arg
        persons.sort((p1, p2) -> p1.balance.compareTo(p2.balance));
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

    public String toString(){
        return String.format("%s, %d, %.2f", name, age, balance);
    }
}

class MyComparatorName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2){
        return p1.name.compareTo(p2.name);
    }
}

class MyComparatorAge implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2){
        return p1.age.compareTo(p2.age);
    }
}