package section20.revision;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Revisão da utilização da classe Function
*/
public class FunctionTest {

    final static Faker faker = new Faker();

    public static void main(String...args){
        Screen.clear();
        List<Product> products = getProducts(10);
        
        System.out.println("Original list");
        products.forEach(System.out::println);

        System.out.println("----------");
        System.out.println("MyConsumerPrice");
        products
            .stream()
            .map(new MyFunctionUpperCase())
            .collect(Collectors.toList())
            .forEach(System.out::println);        
        
    }

    static List<Product> getProducts(int quantity){
        List<Product> products = new ArrayList<>();

        for(int i = 0; i < quantity; i++){
            String name = faker.name().fullName();
            Date birth = faker.date().future(60, TimeUnit.DAYS);
            double price = faker.number().randomDouble(2, 10, 1000);
            products.add(new Product(name, price, birth));
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

        return String.format("%-25s %s %7.2f", name, validitySTR, price);
    }
}

class MyFunctionUpperCase implements Function<Product, String>{
    @Override
    public String apply(Product p){
        return p.name.toUpperCase();
    }
}