package section14.aula161.employee.entities;


public class Employee {

    protected String name;
    protected Integer hours;
    protected Double valuePerHour;

    public Employee(String name, Integer hours, Double valuePerHour){
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public Double payment(){
        return valuePerHour * hours;
    }

    @Override
    public String toString(){
        return String.format(
            "Name: %s, Hours: %d, Value per Hour: %.2f, Payment: %.2f",
            name, hours, valuePerHour, payment()
        );
    }
}