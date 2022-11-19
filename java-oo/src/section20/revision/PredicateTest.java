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

        persons.forEach(System.out::println);

        System.out.println("-------");
        persons.removeIf(p -> p.age > 40); 
        persons.forEach(System.out::println);

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

}

class Person{
    static final SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
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

class MyPredicate implements Predicate<Person>{
    @Override
    public boolean test(Person p){
        return  p.age > 30;
    }
}
