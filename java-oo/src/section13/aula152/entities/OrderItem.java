package section13.aula152.entities;


public class OrderItem {
    private Double price;
    private Integer quantity;
    private Product product;

    public OrderItem(Product product, Integer quantity){
        this.product = product;
        this.price = product.getPrice();
        this.quantity = quantity;
    }

    public Double subTotal(){
        return quantity * product.getPrice();
    }

    public String toString(){
        return String.format(
            "%s, $%.2f, Quantity: %d, SubTotal: %.2f\n",
            product.getName(), price, quantity, subTotal()
        );
    }
}