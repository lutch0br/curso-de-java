package section20.revision;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Revisão da utilização da classe Comparable
*/
public class ComparableTest {

    final static Faker faker = new Faker();

    public static void main(String...args){
        Screen.clear();
        List<Person> persons = getPersons(20);
        Collections.sort(persons);
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


class Person implements Comparable<Person>{
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

    @Override
    public int compareTo(Person p){
        int compValue = 0;

        if (birth.after(p.birth)){
            compValue =  -1;
        }
        else if (birth.before(p.birth)){
            compValue =  1;
        }else {
            compValue =  0;
        }

        return compValue;
    }

    public String toString(){
        return String.format("%s, %s, %d", name, birth, age);
    }
} 