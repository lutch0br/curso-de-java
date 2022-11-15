package section19.aula249.app;



public class Vote {

    private String name;
    private Integer quantity;

    public Vote(String name, Integer quantity){
        this.name = name;
        this.quantity = quantity;        
    }

    public String getName(){
        return name;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public String toString(){
        return String.format("%s,%d", getName(), getQuantity());
    }
}