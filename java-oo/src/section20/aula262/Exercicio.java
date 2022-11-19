package section20.aula262;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.file.Files;

import com.github.javafaker.Faker;
import util.Screen;

public class Exercicio {

    static final File file = new File("java-oo/src/section20/aula262/file.txt");
    static final Faker faker = new Faker();

    public static void main(String...args) throws IOException{
        Locale.setDefault(Locale.US);
        Screen.clear();

        write(30);

        List<Employee> employees = read()
            .stream()
            .map(s -> parseToEmployee(s))
            .collect(Collectors.toList());

        System.out.println("ORIGINAL LIST");
        employees.forEach(System.out::println);

        double salaryLimit = faker.number().randomDouble(2, 1000, 10000);

        System.out.println();

        System.out.println("SALARY LIMIT");
        System.out.printf("%.2f\n", salaryLimit);

        System.out.println();
        System.out.println("EMPLOYESS WITH SALARY GREATER THAN");
        employees
            .stream()
            .filter(p -> p.salary > salaryLimit)
            .sorted(Comparator.comparing(Employee::getEmail))
            .collect(Collectors.toList())
            .forEach(System.out::println);


        double employeesStartsWithM = employees
            .stream()
            .filter(p -> p.name.charAt(0) == 'M')
            .map(p -> p.salary)
            .reduce(0.0, (x, y) -> x + y);

        System.out.println();
        System.out.println("EMPLOYESS NAMES STARTS WITH M");
        employees
            .stream()
            .filter(p -> p.name.charAt(0) == 'M')            
            .collect(Collectors.toList())
            .forEach(System.out::println);

        System.out.println();
        System.out.println("TOTAL SALARY EMPLOYESS NAMES STARTS WITH M");

        System.out.printf("%.2f\n", employeesStartsWithM);
    }

    static Employee parseToEmployee(String line){
        String fields[] = line.split(",");        
        return new Employee(fields[0], fields[1], Double.parseDouble(fields[2]));
    }

    static List<Employee> getEmployees(int quantity){
        List<Employee> employees = new ArrayList<>();

        for(int i = 0; i < quantity; i++){
            String name = faker.name().firstName();
            String email = faker.internet().emailAddress();
            double salary = faker.number().randomDouble(2, 1000, 10000);
            employees.add(new Employee(name, email, salary));
        }

        return employees;
    }

    static void write(int quantity) throws IOException {        
        Files.write(file.toPath(), getEmployees(quantity)
            .stream()
            .sorted(Comparator.comparing(Employee::getName))
            .map(p -> p.toString())
            .collect(Collectors.toList()));
    }

    static void delete(){
        System.out.println("Not implemented yet...");
    }

    static List<String> read() throws IOException {
        return Files
            .lines(file.toPath())
            .collect(Collectors.toList());
    }
}

class Employee {
    String name;
    String email;
    Double salary;

    public Employee(String name, String email, Double salary){
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String toString(){
        return String.format("%s,%s,%.2f", name, email, salary);
    }
}