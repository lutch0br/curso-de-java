package section20.aula261;

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

    static final File file = new File("java-oo/src/section20/aula261/file.txt");
    static final Faker faker = new Faker();
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String...args) throws IOException, ParseException {
        Locale.setDefault(Locale.US);
        Screen.clear();
        write();

        List<Product> products = read()
            .stream()
            .map(s -> {
                try { 
                    return parseToProduct(s);
                } catch(ParseException e){
                    System.out.printf("%s", e.getMessage());
                }
                return null;
            })            
            .collect(Collectors.toList());

        products
            .stream()
            .collect(Collectors.toList())
            .forEach(System.out::println);

        System.out.println();

        double sum = products
            .stream()
            .map(p -> p.price)            
            .reduce(0.0, (x, y) -> x + y);
        int quantity = products.size();
        double averagePrice = sum / quantity;

        System.out.printf("Sum: %.2f, Quantity: %d, Average: %.2f\n", 
            sum, quantity, averagePrice);

        System.out.println();

        products
            .stream()
            .filter(p -> p.price < averagePrice)
            .sorted(Comparator.comparing(Product::getName).reversed())
            .collect(Collectors.toList())
            .forEach(System.out::println);
    }

    static Product parseToProduct(String line) throws ParseException {
        String fields[] = line.split(",");
        Date validity = sdf.parse(fields[1]);
        return new Product(fields[0], validity, Double.parseDouble(fields[2]));
    }

    static List<Product> getProducts(int quantity){
        List<Product> products = new ArrayList<>();

        for(int i = 0; i < quantity; i++){
            String name = faker.commerce().productName();
            Date validity = faker.date().future(60, TimeUnit.DAYS);
            double price = faker.number().randomDouble(2, 10, 1000);
            products.add(new Product(name, validity, price));
        }

        return products;
    }

    static void write() throws IOException {        
        Files.write(file.toPath(), getProducts(10)
            .stream()
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

class Product {
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String name;
    Double price;
    Date validity;

    public Product(String name, Date validity, Double price){
        this.name = name;
        this.validity = validity;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        String validitySTR = sdf.format(validity);

        return String.format("%s,%s,%.2f", name, validitySTR, price);
    }
}

class MyFunctionDate implements Function<String, Product> {
    
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Product apply(String line) {
        try {
            String fields[] = line.split(",");
            Date validity = sdf.parse(fields[1]);
            return new Product(fields[0], validity, Double.parseDouble(fields[2]));
        } catch(ParseException e){
            System.out.printf("%s\n", e.getMessage());
        }

        return null;
    }
}