package section19.aula247.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class Course implements Comparable<Course>{

    private Integer id;
    private String name;
    private Instructor instructor;
    private Set<Student> students = new HashSet<>();

    public Course(Integer id, String name, Instructor instructor){
        this.id = id;
        this.name = name;
        this.instructor = instructor;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Instructor getInstrutor(){
        return instructor;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addAllStudents(Set<Student> students){
        students.addAll(students);
    }

    public Set<Student> getStudents(){
        return students;
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        for (Student s: getStudents()){            
            sb.append(String.format("\t\t%s\n", s));
        }

        return String.format(
            "Course: \n\tId: %02d, \n\tName: %s \n\tInstructor: %s\n\t\tStudents:\n%s", 
            getId(), getName(), getInstrutor(), sb.toString());
    }

    @Override
    public boolean equals(Object other){
        return name.equals(((Course)other).getName());
    }

    @Override
    public int hashCode(){        
        return name.hashCode();
    }    

    @Override
    public int compareTo(Course other){
        return id.compareTo(other.getId());
    }    
}