package section08.aula069.exercicio03.app;

import java.util.Scanner;
import java.util.Locale;
import section08.aula069.exercicio03.entity.Student;
import util.Screen;

public class Application {
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        Screen.clear();
        System.out.printf("Name: ");
        student.name = sc.nextLine();

        System.out.printf("Grade 1: ");
        student.grade1 = sc.nextDouble();

        System.out.printf("Grade 2: ");
        student.grade2 = sc.nextDouble();

        System.out.printf("Grade 3: ");
        student.grade3 = sc.nextDouble();

        showFinalGrade(student);
        showStatusFinal(student);

        sc.close();
    }

    static void showFinalGrade(Student student){
        System.out.printf("FINAL GRADE = %.2f\n", student.finalGrade());
    }

    static void showStatusFinal(Student student){
        if (student.finalGrade() >= 60)
            System.out.println("PASS");
        else 
            System.out.printf(
                "FAILED\nMISSING %.2f POINTS\n", 
                (60 - student.finalGrade()));
    }
}