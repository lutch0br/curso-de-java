package section19.aula247.entities;


public class Student implements Comparable<Student>{
    private Integer id;
    private String name;

    public Student(Integer id, String name){
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
        return String.format("Id: %03d, Name: %s", getId(), getName());
    }  

    @Override
    public boolean equals(Object other){
        return id.equals(((Student)other).getId());
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public int compareTo(Student other){
        return id.compareTo(other.getId());
    }

}