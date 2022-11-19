package section20.revision;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
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

public class StreamEx1 {
    static final File file = new File("java-oo/src/section20/revision/file.txt");
    static final Faker faker = new Faker();
    public static void main(String...args) throws IOException {
        Locale.setDefault(Locale.US);
        Screen.clear();
        write();
        read();
        delete();
    }

    static List<Product> getProducts(int quantity){
        List<Product> products = new ArrayList<>();

        for(int i = 0; i < quantity; i++){
            String name = faker.commerce().productName();
            Date validity = faker.date().future(60, TimeUnit.DAYS);
            double price = faker.number().randomDouble(2, 10, 1000);
            products.add(new Product(name, price, validity));
        }

        return products;
    }

    static void write() throws IOException {        
        Files.write(file.toPath(), getProducts(10)
            .stream()
            .map(p -> p.toString())
            .collect(Collectors.toList()));
    }

    static void delete(){}

    static void read() throws IOException {
        Files.lines(file.toPath())
            .collect(Collectors.toList())
            .forEach(System.out::println);
    }
}

class Product {
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String name;
    Double price;
    Date validity;

    public Product(String name, Double price, Date validity){
        this.name = name;
        this.validity = validity;
        this.price = price;
    }

    public String toString(){
        String validitySTR = sdf.format(validity);

        return String.format("%s,%s,%.2f", name, validitySTR, price);
    }
}