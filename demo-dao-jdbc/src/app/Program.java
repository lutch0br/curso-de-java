package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.github.javafaker.Faker;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	static final Faker faker = new Faker();
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		
		Department d = new Department(1, "TI");
		System.out.println(d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Seller s = new Seller(
				1, "Bea", "bea@email.com", sdf.parse("05/07/1995"), 2500.0, d);
		SellerDao sellerDAO = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: findById ===");
		System.out.println(sellerDAO.findById(faker.number().numberBetween(1,  4)));
		System.out.println();
		
		System.out.println("=== Test 2: findByDepartment ===");
		Department dep = new Department(1, "Computers");
		sellerDAO.findByDepartment(dep).forEach(System.out::println);
		System.out.println();
		
		System.out.println("=== Test 3: findAll ===");
		sellerDAO.findAll().forEach(System.out::println);
		System.out.println();
		
		System.out.println("=== Test 4: insert  ===");
		System.out.println();
		
		System.out.println("=== Test 5: update  ===");
		System.out.println();
		
		System.out.println("=== Test 6: delete  ===");
	}

}
