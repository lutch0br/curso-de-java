package section19.aula247.app;

import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;

import section19.aula247.entities.Course;
import section19.aula247.entities.Student;
import section19.aula247.entities.Instructor;

import com.github.javafaker.Faker;
import util.Screen;

/**
* Em um portal de cursos online, cada usuário possui um código único, 
* representado por um número inteiro.
* Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno 
* pode se matricular em quantos cursos quiser. Assim, o número total de alunos 
* de um instrutor não é simplesmente a soma dos alunos de todos os cursos que 
* ele possui, pois pode haver alunos repetidos em mais de um curso.
* O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total
* de alunos.
* Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois 
* mostrar a quantidade total e alunos dele, conforme exemplo.
*/
public class Program {
    static final Faker faker = new Faker();   

    public static void main(String...args){

        Screen.clear();

        Set<Student> students = new TreeSet<>();
        Set<Course> courses = new TreeSet<>();
        Set<Instructor> instructors = new HashSet<>();

        // create students
        for (int i = 1; i <= 20; i++){
            String name = faker.name().firstName();
            students.add(new Student(i, name));
        }

        // create instructors
        for (int i = 1; i <= 1; i++){
            String name = faker.name().fullName();
            instructors.add(new Instructor(i, name));
        }

        List<Instructor> instructorsList = new ArrayList<>(instructors);
        List<Student> studentsList = new ArrayList<>(students);

        // create courses
        for (int i = 1; i <= 3; i++){
            String name = faker.educator().course();
            Instructor instructor = 
                faker.options().nextElement(instructorsList);
            Course c = new Course(i, name, instructor);
            
            for(int s = 1; s <= 5; s++)
                c.addStudent(faker.options().nextElement(studentsList));

            courses.add(c);
        }

        // count students
        Set<Student> totalStudent = new TreeSet<>();
        List<Student> totalEnrollment = new ArrayList();
        for(Course c: courses){
            for (Student s: c.getStudents()){
                totalEnrollment.add(s);
                totalStudent.add(s);
            }
        }

        courses.forEach(System.out::println);

        System.out.printf("Total students: %d\n", totalStudent.size());
        System.out.printf("Total enrollment: %d\n", totalEnrollment.size());

    }
}