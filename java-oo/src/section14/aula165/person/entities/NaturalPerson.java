package section14.aula165.person.entities;


public class NaturalPerson extends Person {

    private Double healthSpending;

    public NaturalPerson(){
        super();
    }

    public NaturalPerson(String name, Double income, Double healthSpending){
        super(name, income);
        this.healthSpending = healthSpending;
    }    

    @Override
    public Double taxDue(){
        double value = 0.0;

        if (income < 20000.0){
            value = (income * 0.15) - (healthSpending * 0.50);
        } else {
            value = (income * 0.25) - (healthSpending * 0.50);
        }

        return value;
    }

    @Override
    public String toString(){
        return String.format("%s, Tax Due: $ %.2f", 
            super.toString(), taxDue());
    }

}