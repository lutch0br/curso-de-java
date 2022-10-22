package section05;

import java.util.Scanner;

public class Aula040SwitchTernarioEscopo {
    public static void main(String[] args){

        // operadoresCumulativos();
        // switchCase();
        // escopo();
        ternario();

    }

    /**
    * Operadores cumulativos
    */
    static void operadoresCumulativos(){
        
        int a = 1;
        System.out.println("Valor de a: " + a);
        int b = 2;
        System.out.println("Valor de b: " + b);
        int c = 0;
        System.out.println("Valor de c: " + c);
        c += a;
        System.out.println("Valor de c: " + c);
        c += b;
        System.out.println("Valor de c: " + c);

        System.out.println("Concluído");

    }

    static void switchCase(){
        System.out.println("Escolha um país: ");
        System.out.println();
        System.out.printf("%-8s%s\n", "CÓDIGO", "PAÍS");
        System.out.printf("%6d  %-8s\n", 1, "Brasil");
        System.out.printf("%6d  %-8s\n", 2, "Portugal");
        System.out.printf("%6d  %-8s\n", 3, "Espanha");
        System.out.printf("%6d  %-8s\n", 4, "Itália");
        System.out.printf("%6d  %-8s\n", 5, "Chile");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int pais = sc.nextInt();

        switch(pais) {
            case 1:
                System.out.println("Brasil");
                break;
            case 2:
                System.out.println("Portugal");
                break;
            case 3:
                System.out.println("Espanha");
                break;
            case 4:
                System.out.println("Itália");
                break;
            case 5:
                System.out.println("Chile");
                break;
            default:
                System.out.println("Código não encontrado");
        }
    }

    static void escopo(){
       
        String a = "Java";

        if (true) {
            int b = 1;
            System.out.println(a);
        }
        
        /**
        * System.out.println(b);
        * error: cannot find symbol        
        */
    }

    static void ternario(){

        int x = 5;
        System.out.printf("x é maior que 5: ");
        String resp = (x < 5) ? "sim" : "não";

        System.out.println(resp);
    }
}