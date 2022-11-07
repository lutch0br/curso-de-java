package section14.aula162.product.app;

import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.github.javafaker.Faker;

import util.Screen;
import section14.aula162.product.entities.Product;
import section14.aula162.product.entities.ImportedProduct;
import section14.aula162.product.entities.UsedProduct;
import section14.aula162.product.entities.enums.ProductType;

public class Program{

    static final Faker faker = new Faker();
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String...args) throws ParseException{
        Locale.setDefault(Locale.US);
        final List<Product> products = new ArrayList<>();
        ProductType productType;

        Screen.clear();
        System.out.print("Enter the number of products: ");
        int numberOfProducts = faker.number().numberBetween(1, 5);
        System.out.printf("%d\n", numberOfProducts);
        
        System.out.println();

        for(int i = 1; i <= numberOfProducts; i++){
            productType = faker.options().option(ProductType.values());
            System.out.printf("Product #%d data:\n", i);
            System.out.printf("Product type: %s\n", productType);
            products.add(getProduct(productType));
            System.out.println();
        }
        
        System.out.println("PRICE TAGS: ");
        for (Product product : products)
            System.out.printf("%s\n", product.priceTag());

        System.out.println();
    }

    static Product getProduct(ProductType productType) throws ParseException{
        Product product = null;
        String name = faker.commerce().productName();
        double price = faker.number().randomDouble(2, 10, 2000);
        double customsFee = faker.number().randomDouble(2, 5, 500);
        Date manufactureDate = faker.date().between(
            sdf.parse("01/01/2018"), sdf.parse("01/11/2022")
        );
        
        switch(productType){
            case COMMON:
                System.out.printf("Name: %s\n", name);
                System.out.printf("Price: %.2f\n", price);                
                product = new Product(name, price);;
                break;
            case IMPORTED:
                System.out.printf("Name: %s\n", name);
                System.out.printf("Price: %.2f\n", price);
                System.out.printf("Customs Fee: %.2f\n", customsFee);
                product = new ImportedProduct(name, price, customsFee);
                break;
            case USED:
                System.out.printf("Name: %s\n", name);
                System.out.printf("Price %.2f\n", price);
                System.out.printf("Manufacture Date: %s\n", 
                    sdf.format(manufactureDate));
                product = new UsedProduct(name + " (used)", 
                    price, manufactureDate);
                break;
        }

        return product;
    }
}