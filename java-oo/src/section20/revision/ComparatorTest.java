package section20.revision;

import java.util.Date;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Revisão da utilização da classe Comparable
*/
public class ComparatorTest {

    final static Faker faker = new Faker();

    public static void main(String...args){
        Screen.clear();
        List<Person> persons = getPersons(20);

        persons.sort(new MyComparatorByBirth());
        persons.forEach(System.out::println);

        Comparator<Person> comp = new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
            
                if (p1.birth.after(p2.birth)){
                    return -1;
                }
                if (p1.birth.before(p2.birth)){
                    return 1;
                }

                return 0;
            }
        };

        System.out.println("-------");
        persons.sort(comp); 
        persons.forEach(System.out::println);

        System.out.println("-------");
        persons.sort((p1, p2) -> p1.name.compareTo(p2.name)); 
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
        return String.format("%s, %s, %d", name, birth, age);
    }
} 


class MyComparatorByBirth implements Comparator<Person> 
{
    @Override
    public int compare(Person p1, Person p2)
    {    
        if (p1.birth.after(p2.birth)){
            return -1;
        }
        if (p1.birth.before(p2.birth)){
            return 1;
        }
        return 0;
    }
}
