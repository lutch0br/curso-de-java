package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		
		Department d = new Department(1, "TI");
		System.out.println(d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Seller s = new Seller(
				1, "Bea", "bea@email.com", sdf.parse("05/07/1995"), 2500.0);
		System.out.println(s);

	}

}
