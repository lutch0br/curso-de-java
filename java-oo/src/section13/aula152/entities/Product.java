package section13.aula152.entities;


public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public String toString(){
        return String.format("Produto: %s, Valor: %.2f\n", 
            name, price);
    }

}