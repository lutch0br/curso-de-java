package section14.aula165.person.entities;


public abstract class Person {
    protected String name;
    protected Double income;

    public Person(){}

    public Person(String name, Double income){
        this.name = name;
        this.income = income;
    }

    public abstract Double taxDue();

    @Override
    public String toString(){
        return String.format("Person: %s", name);
    }
}