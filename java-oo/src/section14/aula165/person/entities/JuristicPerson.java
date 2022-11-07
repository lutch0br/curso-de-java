package section14.aula165.person.entities;


public class JuristicPerson extends Person {
    
    private Integer numberOfEmployees;

    public JuristicPerson(String name, Double income, Integer numberOfEmployees){
        super(name, income);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double taxDue(){
        double value = 0.0;

        if (numberOfEmployees > 10){
            value = income * 0.14;
        } else {
            value = income * 0.16;
        }

        return value;
    }

    @Override
    public String toString(){
        return String.format("%s, Tax Due: $ %.2f", 
            super.toString(), taxDue());
    }    
}