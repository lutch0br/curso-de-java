package section08.aula069.exercicio02.app;

import java.util.Scanner;
import java.util.Locale;
import section08.aula069.exercicio02.entity.Employee;
import util.Screen;

public class Application{
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee emp1 = new Employee();

        Screen.clear();
        System.out.printf("Name: ");
        emp1.name = sc.nextLine();

        System.out.printf("Gross Salary: ");
        emp1.grossSalary = sc.nextDouble();

        System.out.printf("Tax: ");
        emp1.tax = sc.nextDouble();

        System.out.printf("\nEmployee: %s\n\n", emp1);

        System.out.printf("Which percentage to increase salary? ");
        double percentageIncrease = sc.nextDouble();
        emp1.increaseSalary(percentageIncrease);

        System.out.printf("\nUpdated data: %s\n\n", emp1);
        sc.close();

    }
}