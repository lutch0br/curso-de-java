package section20.revision.stream;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

import util.Screen;

/**
* Revisão da utilização de função como args
*/
public class StreamTest {

    final static Faker faker = new Faker();

    public static void main(String...args) throws ParseException {
        Locale.setDefault(Locale.US);
        Screen.clear();

        List<Product> products = getProducts(20);
        
        System.out.println("Original list");
        products
            .stream()
            .collect(Collectors.toList())
            .forEach(System.out::print);
        
        System.out.println("--------------");        
        System.out.println("Stream from var args");
        Stream ps2 = Stream.of(
            "Synergistic Leather Computer", "Mediocre Steel Lamp");        
        System.out.println(Arrays.toString(ps2.toArray()));
        
        System.out.println("--------------");
        System.out.println("New List added 10% price");
        products
            .stream()
            .filter(p -> p.price < 500)
            .map(p -> new Product(p.name, p.price * 1.1, p.validity))
            .collect(Collectors.toList())
            .forEach(System.out::print);

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
}

class Product{
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

        return String.format("%s, %.2f\n", name, price);
    }
}