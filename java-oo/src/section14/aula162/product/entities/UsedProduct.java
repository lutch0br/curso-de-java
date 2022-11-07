package section14.aula162.product.entities;

import java.util.Date;
import java.text.SimpleDateFormat;

public class UsedProduct extends Product {
    protected Date manufactureDate;

    public UsedProduct(String name, Double price, Date manufactureDate){
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return String.format("%s, (Manufatured Date: %s)", super.priceTag(),
            sdf.format(manufactureDate));
    }
}

