package section14.aula165.person.app;


import  section14.aula165.person.entities.Person;
import  section14.aula165.person.entities.NaturalPerson;
import  section14.aula165.person.entities.JuristicPerson;
import  section14.aula165.person.entities.enums.PersonType;

import com.github.javafaker.Faker;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import util.Screen;


public class Program {
    static final Faker faker = new Faker();

    public static void main(String...args){
        Locale.setDefault(Locale.US);
        List<Person> persons = new ArrayList<>();
        double totalTaxes = 0.0;

        Screen.clear();
        System.out.print("Enter the number of tax payers: ");
        int numberOfTaxPayers = faker.number().numberBetween(1, 5);
        System.out.printf("%d\n", numberOfTaxPayers);
        System.out.println();

        for(int i = 1; i <= numberOfTaxPayers; i++){
            System.out.printf("Tax payer #%d data:\n", i);
            PersonType personType = faker.options().option(PersonType.values());
            System.out.printf("Person type: %s\n", personType);
            persons.add(getPerson(personType));
            System.out.println();
        }

        System.out.println("TAXES PAID:");
        for (Person person : persons){
            System.out.printf("%s\n", person);
            totalTaxes  += person.taxDue();
        }

        System.out.println();
        
        System.out.printf("TOTAL TAXES: $ %.2f\n", totalTaxes);
        System.out.println();
    }

    static Person getPerson(PersonType personType){
        
        String name = faker.name().firstName();
        double income = faker.number().randomDouble(2, 5000, 200000);
        double healthSpending = faker.number().randomDouble(2, 1000, 20000);
        int numberOfEmployees = faker.number().numberBetween(1, 200);
        Person person = null;

        System.out.printf("Name: %s\n", name);
        System.out.printf("Anual income: $ %.2f\n", income);

        switch(personType){
            case NATURAL:
                System.out.printf("Health expenditures: $ %.2f\n", healthSpending);
                person = new NaturalPerson(name, income, healthSpending);
                break;
            case JURISTIC:
                person = new JuristicPerson(name, income, numberOfEmployees);
                System.out.printf("Number of employees: %d\n", numberOfEmployees);
                break;
        }

        return person;
    }
}