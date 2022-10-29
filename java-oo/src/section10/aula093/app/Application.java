package section10.aula093.app;

import java.util.Scanner;
import java.util.Locale;
import section10.aula093.entities.Hostel;
import util.Screen;

public class Application {
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Screen.clear();
        System.out.print("Quantos quartos serão alugados?: ");
        int alugar = Integer.parseInt(sc.nextLine());

        System.out.println();

        Hostel.reservar(alugar);
        Hostel.quartosReservados();

        System.out.println();
        sc.close();
    }
}
