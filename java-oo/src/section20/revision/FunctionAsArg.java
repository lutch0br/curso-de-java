package section20.revision;


import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Revisão da utilização de função como args
*/
public class FunctionAsArg {

    final static Faker faker = new Faker();

    public static void main(String...args) throws ParseException {
        Screen.clear();
        List<Product> products = getProducts(10);
        
        System.out.println("Original list");
        products.forEach(System.out::println);

        System.out.println("----------");
        System.out.println("Filtered Sum");

        SumService s = new SumService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // final Date d1 = new Date();
        final Date d1 = sdf.parse("25/12/2022");
        String dateSTR = sdf.format(d1);
        double sum = s.filteredSum(products, p -> p.validity.before(d1));
        System.out.printf("Vencimento antes de %s: %.2f\n", dateSTR, sum);
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

class SumService {
    
    public double filteredSum(
        List<Product> list, Predicate<Product> criteria) throws ParseException {
        double sum = 0.0;

        for (Product p : list){
            if (criteria.test(p)){
                sum += p.price;
            }
        }
        return sum;
    }
}