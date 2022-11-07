package section14.aula162.product.entities;


public class ImportedProduct extends Product {
    protected Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee){
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double totalPrice(){
        return price + customsFee;
    }

    @Override
    public String priceTag(){
        return String.format("Product: %s, Price: %.2f, (Customs Fee: $%.2f)", 
        name, totalPrice(), customsFee);
    }
}