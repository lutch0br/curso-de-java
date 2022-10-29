package section10.aula093.entities;

import java.util.Scanner;
import java.util.Locale;
import section10.aula093.entities.Quarto;

public class Hostel {
    private static Quarto[] quartos = new Quarto[10];

    public static void reservar(int quantidade){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < quantidade; i++){   
            System.out.printf("Quarto %d: \n", i + 1);
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            Integer quarto = Integer.parseInt(sc.nextLine());

            quartos[quarto] = new Quarto(nome, email, quarto);
            System.out.println();
        }

        sc.close();
    }

    public static void quartosReservados(){
        System.out.println("Quartos ocupados: ");
        for(int i = 0; i < quartos.length; i++)
        if (quartos[i] != null){
            System.out.printf("%s\n", 
                quartos[i]);
        }
    }
}