package section20.revision;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Revisão da utilização da classe Predicate
*/
public class PredicateTest {

    final static Faker faker = new Faker();

    public static void main(String...args){
        Screen.clear();
        List<Person> persons = getPersons(20);
        
        System.out.println("Original list");
        persons.forEach(System.out::println);

        System.out.println("-------");
        System.out.println("Lambda");
        persons.removeIf(p -> p.age > 40); 
        persons.forEach(System.out::println);

        System.out.println("-------");
        System.out.println("method filteredList1");
        filteredList1(persons, new MyPredicate());

        System.out.println("-------");
        System.out.println("With class Predicate");
        persons.removeIf(new MyPredicate()); 
        persons.forEach(System.out::println);        

    }

    static List<Person> getPersons(int quantity){
        List<Person> persons = new ArrayList<>();

        for(int i = 0; i < quantity; i++){
            String name = faker.name().fullName();
            Date birth = faker.date().birthday(15, 60);
            persons.add(new Person(name, birth));
        }

        return persons;
    }

    static void filteredList(List<Person> persons){
        ArrayList<Person> l = (ArrayList)((ArrayList)persons).clone();
        l.removeIf(new MyPredicate());

        l.forEach(System.out::println);
    }

    static void filteredList1(List<Person> persons, MyPredicate<Person> criteria){
        ArrayList<Person> l = (ArrayList)((ArrayList)persons).clone();
        l.removeIf(criteria);

        l.forEach(System.out::println);
    }    

    static void filteredList2(List<Person> persons, Predicate<Person> criteria){
        ArrayList<Person> l = (ArrayList)((ArrayList)persons).clone();
        l.removeIf(criteria);

        l.forEach(System.out::println);
    }     

}

class Person{
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String name;
    Integer age;
    Date birth;
    
    public Person(String name, Date birth){
        this.name = name;
        this.birth = birth;
        this.age = calculateAge(birth);
    }

    private int calculateAge(Date birth){
        Date today = new Date();
        long diff = Math.abs(today.getTime() - birth.getTime());
        return (int) (diff / (1000L * 60 * 60 * 24 * 365));
    }

    public String toString(){
        String birthSTR = sdf.format(birth);

        return String.format("%-25s %s %d", name, birthSTR, age);
    }
} 

class MyPredicate<T> implements Predicate<Person>{
    @Override
    public boolean test(Person p){
        System.out.printf("Verifing person ... %s, %s\n", p, p.age > 30);
        return  p.age > 30;
    }
}
