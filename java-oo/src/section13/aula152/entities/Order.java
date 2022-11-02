package section13.aula152.entities;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import section13.aula152.entities.enums.OrderStatus;


public class Order {

    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order(Client client){
        this.client = client;
        this.moment = new Date();
        this.status = OrderStatus.PROCESSING;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public Double total(){
        double total = 0.0;

        for (OrderItem item : items){
            total += item.subTotal();
        }

        return total;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMMARY:\n");
        sb.append(String.format("Order moment: %s\n", sdf.format(moment)));
        sb.append(String.format("Order status: %s\n", status));
        sb.append(String.format("%s", client));
        sb.append("Order items:\n");

        for(OrderItem item: items){
            sb.append(item);
        }

        sb.append(String.format("Total Price: $%.2f", total()));

        return sb.toString();

    }
}
