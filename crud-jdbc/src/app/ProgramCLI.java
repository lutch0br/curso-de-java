package app;

import controller.DepartmentController;
import controller.SellerController;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ProgramCLI {

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int option = 0;

		SellerController sellerController = new SellerController();
		DepartmentController departmentController = new DepartmentController();

		menu: while (true) {
			System.out.println("0 - Exist");
			System.out.println("1 - List");
			System.out.println("2 - List by Id");
			System.out.println("3 - Insert");
			System.out.println("4 - Update");
			System.out.println("5 - Delete");

			System.out.print("Enter the option: ");
			option = Integer.parseInt(sc.nextLine());

			clear();
			switch (option) {
			case 0:
				System.out.println("...finalized");
				break menu;
			case 1:
				list(sellerController);				
				break;
			case 2:
				System.out.println("...finalized");
				break menu;
			case 3:
				System.out.println("...finalized");
				break menu;
			case 4:
				System.out.println("...finalized");
				break menu;
			case 5:
				System.out.println("...finalized");
				break menu;
			}
			
			System.out.println("");
		}
	}

	private static void list(SellerController s) {
		s.findAll().forEach(System.out::println);

	}

	static void testSeller() {
		SellerController sc = new SellerController();
		sc.findAll().forEach(System.out::println);
		sc.delete(1);
		sc.findAll().forEach(System.out::println);

	}

	static void testDepartment() {
		DepartmentController dc = new DepartmentController();
		dc.findAll().forEach(System.out::println);
		int id = 1;
		System.out.printf("Department %d: %s\n", id, dc.findById(id));
		;

	}

	static void clear() throws IOException {
		Runtime.getRuntime().exec("clear");
//		System.out.print("\033[H\033[2J");
//		System.out.flush();
	}

}
