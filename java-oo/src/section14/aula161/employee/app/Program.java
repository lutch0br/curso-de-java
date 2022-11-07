package section14.aula161.employee.app;


import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import section14.aula161.employee.entities.Employee;
import section14.aula161.employee.entities.OutsourcedEmployee;
import section14.aula161.employee.entities.enums.EmployeeType;       
import util.Screen;
import com.github.javafaker.Faker;

public class Program {
    static final Faker faker = new Faker();
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        List<Employee> employees = new ArrayList<>();
        EmployeeType employeeType;

        Screen.clear();
        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = faker.number().numberBetween(1, 5);
        System.out.printf("%d\n", numberOfEmployees);
        System.out.println();

        for(int i = 1; i <= numberOfEmployees; i++){
            employeeType = faker.options().option(
            EmployeeType.EMPLOYEE, EmployeeType.OUTSOURCED);
            System.out.printf("Empployee %d data:\n", i);
            System.out.printf("Empployee type: %s\n", employeeType);
            employees.add(getEmployee(employeeType));
            System.out.println();
        }

        System.out.printf("PAYMENTS:\n");
        for (Employee employee: employees)
            System.out.printf("%s\n", employee);
    }

    static Employee getEmployee(EmployeeType employeeType){
        
        Employee employee = null;
        String name = faker.name().fullName();
        int hours = faker.number().numberBetween(40, 200);
        double valuePerHour = faker.number().randomDouble(2, 5, 20);
        double additionalCharge = faker.number().randomDouble(2, 10, 100);

        switch(employeeType){
            case EMPLOYEE:
                System.out.printf("Name: %s\n", name);
                System.out.printf("Hours: %d\n", hours);
                System.out.printf("Value per Hour: %.2f\n", valuePerHour);
                employee = new Employee(name, hours, valuePerHour); 
                break;
            case OUTSOURCED:
                System.out.printf("Name: %s\n", name);
                System.out.printf("Name: %d\n", hours);
                System.out.printf("Value per Hour: %.2f\n", valuePerHour);
                System.out.printf("Additional Charge: %.2f\n", additionalCharge);
                employee= new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                break;
        }  

        return employee;          
    }
}
