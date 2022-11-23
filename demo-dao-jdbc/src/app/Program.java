package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.github.javafaker.Faker;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	static final Faker faker = new Faker();
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		
		// testSellerDAO();
		testDepartmentDAO();
		
	}

	private static void testDepartmentDAO() {
		DepartmentDao depDAO = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: findById ===");
		Department d1 = depDAO.findById(1);
		System.out.printf("%s\n", d1);
		System.out.println();		

		System.out.println("=== Test 2: delete  ===");
		depDAO.findAll().forEach(System.out::println);
		// depDAO.delete(1);
		System.out.println();		
		
		System.out.println("=== Test 3: findAll ===");
		depDAO.findAll().forEach(System.out::println);
		System.out.println();
		
		System.out.println("=== Test 4: insert  ===");
		Department d2 = getDepartment();
		depDAO.insert(d2);
		depDAO.findAll().forEach(System.out::println);
		System.out.println();
		
		System.out.println("=== Test 5: update  ===");
		d1.setName(faker.commerce().department());
		depDAO.update(d1);
		depDAO.findAll().forEach(System.out::println);
		System.out.println();
		
	}
	
	static Department getDepartment() {
		Department dep = new Department();
		dep.setName(faker.commerce().department());
		
		return dep;
		
	}

	@SuppressWarnings("unused")
	private static void testSellerDAO() throws ParseException {
		Department d = new Department(1, "TI");
		System.out.println(d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Seller s = new Seller(
				1, "Bea", "bea@email.com", sdf.parse("05/07/1995"), 2500.0, d);
		SellerDao sellerDAO = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: findById ===");
		Seller s3 = sellerDAO.findById(faker.number().numberBetween(1,  4));
		System.out.println(s3);
		System.out.println();
		
		System.out.println("=== Test 2: findByDepartment ===");
		Department dep = new Department(1, "Computers");
		sellerDAO.findByDepartment(dep).forEach(System.out::println);
		System.out.println();
		
		System.out.println("=== Test 3: findAll ===");
		sellerDAO.findAll().forEach(System.out::println);
		System.out.println();
		
		System.out.println("=== Test 4: insert  ===");
		Seller s2 = getSeller();
		sellerDAO.insert(s2);
		sellerDAO.findAll().forEach(System.out::println);		
		System.out.println();
		
		System.out.println("=== Test 5: update  ===");
		s3.setBaseSalary(faker.number().randomDouble(2, 1, 3) * s3.getBaseSalary());
		sellerDAO.update(s3);
		sellerDAO.findAll().forEach(System.out::println);
		System.out.println();
		
		System.out.println("=== Test 6: delete  ===");
		sellerDAO.findAll().forEach(System.out::println);
		int value = 1;
		System.out.printf("apagando %d\n", value);
		sellerDAO.delete(1);
		sellerDAO.findAll().forEach(System.out::println);
		System.out.println();
	}
	
	static Seller getSeller() {
		Seller s2 = new Seller();
		s2.setName(faker.name().firstName());
		s2.setEmail(faker.internet().emailAddress());
		s2.setBirthDate(new java.sql.Date(faker.date().birthday(18, 70).getTime()));
		s2.setBaseSalary(faker.number().randomDouble(2, 1000, 10000));
		Department d2 = new Department();
		d2.setId(faker.number().numberBetween(1, 5));
		s2.setDepartment(d2);
		
		return s2;
	}

}
