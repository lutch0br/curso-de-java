package section08.aula069.exercicio01.app;

import java.util.Locale;
import java.util.Scanner;
import section08.aula069.exercicio01.entity.Rectangle;
import util.Screen;


public class Application {
    public static void main(String...args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Rectangle rec = new Rectangle();

        Screen.clear();
        System.out.print("Enter rectangle width and height: ");
        rec.width = sc.nextDouble();
        rec.height = sc.nextDouble();

        System.out.printf("%-15s%9s\n", "MEDIDA", "RESULTADO");
        System.out.printf("%-15s%9.2f\n", "Area", rec.area());
        System.out.printf("%-15s%9.2f\n", "Perimeter", rec.perimeter());
        System.out.printf("%-15s%9.2f\n", "Diagonal", rec.diagonal());
        sc.close();

    }
}