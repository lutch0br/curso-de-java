package section13.aula152.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import section13.aula152.entities.Order;
import section13.aula152.entities.Client;
import section13.aula152.entities.Product;
import section13.aula152.entities.OrderItem;
import util.Screen;


public class Application {
    public static void main(String...args) throws ParseException {
        Locale.setDefault(Locale.US);

        Client c1 = new Client(
            "Alex", 
            "alex@email.com", 
            new SimpleDateFormat("dd/MM/yyyy").parse("15/03/1985"));

        Product p1 = new Product("TV", 1000.0);
        Product p2 = new Product("Mouse", 40.0);

        Order o1 = new Order(c1);
        OrderItem i1 = new OrderItem(p1, 1);
        OrderItem i2 = new OrderItem(p2, 2);

        o1.addItem(i1);
        o1.addItem(i2);

        Screen.clear();
        System.out.printf("%s\n", o1);
    }
}