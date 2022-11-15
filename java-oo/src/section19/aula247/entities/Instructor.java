package section19.aula247.entities;


public class Instructor {
    private Integer id;
    private String name;

    public Instructor(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return String.format("Id: %02d, Name: %s", getId(), getName());
    }

    @Override
    public boolean equals(Object other){
        return name.equals(((Student)other).getName());
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }    
}