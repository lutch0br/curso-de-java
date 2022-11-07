package section14.aula162.product.entities;


public class Product {
    protected String name;
    protected Double price;

    public Product(){}

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String priceTag(){
        return String.format("Product: %s, Price: $ %.2f", name, price);
    }
}
