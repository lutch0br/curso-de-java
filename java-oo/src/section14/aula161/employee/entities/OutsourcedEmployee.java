package section14.aula161.employee.entities;


public class OutsourcedEmployee extends Employee {

    private Double additionalCharge;

    public OutsourcedEmployee(String name, Integer hours, Double valuePerHour,
        Double additionalCharge){
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment(){
        return super.payment() + (1.10 * additionalCharge);
    }

    @Override
    public String toString(){
        return String.format(
            "%s, Additional Charge: %.2f", 
            super.toString(), additionalCharge
        );
    }    
}