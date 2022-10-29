package section10.aula102;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import util.Screen;

/**
* Programa que gera uma matriz, exibindo sua diagonal e números abaixo de 50.
*/
public class Application {
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println();

        Screen.clear();
        System.out.print("Tamanho da matriz: ");
        int n = Integer.parseInt(sc.nextLine());

        int[][] matriz = new int[n][n];
        int quantidadeDeValoresNegativos = 0;
        Random rand = new Random();


        System.out.printf("Gerando a matriz...\n\n");
        for(int l = 0; l < matriz.length; l++)
            for(int c = 0; c < n; c++)                
                matriz[l][c] = rand.nextInt(99 - (-99)) + (-99);

        System.out.printf("Exibindo a matriz completa: \n");
        for(int l = 0; l < matriz.length; l++){
            for(int c = 0; c < n; c++)
                System.out.printf("% 3d ", matriz[l][c]); 
            
            System.out.println();
        }       

        System.out.println();
        System.out.printf("Exibindo a diagonal da matriz: \n");
        for(int l = 0; l < matriz.length; l++)
            System.out.printf("%02d ", matriz[l][l]); 
        
        System.out.println();

        System.out.println();
        System.out.printf("Contando valores abaixo de 0...: ");
        for(int l = 0; l < matriz.length; l++)
            for(int c = 0; c < n; c++){
                if (matriz[l][c] < 0)
                    quantidadeDeValoresNegativos++;
            }

        System.out.printf("%d\n", 
            quantidadeDeValoresNegativos);
        System.out.printf("Quantidade total de valores: %d\n", 
            matriz.length * matriz.length); 

        System.out.println();        

    }
}