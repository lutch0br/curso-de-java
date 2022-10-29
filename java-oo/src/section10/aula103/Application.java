package section10.aula103;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import util.Screen;

/**
* Programa que gera uma matriz de tamanho M x N.
* Recebe um valor X e para cada ocorrência de X na matriz, mostrar valores 
* posicionados à esquerda, direita, acima e abaixo.
*/
public class Application {
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println();

        Screen.clear();
        System.out.print("Tamanho (L C) da matriz: ");
        int linhas = sc.nextInt();// Integer.parseInt(sc.nextLine());
        int colunas = sc.nextInt(); //Integer.parseInt(sc.nextLine());

        sc.nextLine();
        int[][] matriz = new int[linhas][colunas];
        Random rand = new Random();


        System.out.printf("Gerando a matriz...\n\n");
        for(int l = 0; l < linhas; l++)
            for(int c = 0; c < colunas; c++)                
                matriz[l][c] = rand.nextInt(99 - (1)) + (1);

        System.out.printf("Exibindo a matriz completa: \n");
        System.out.printf("%3s", " ");

        // labels
        for(int i = 0; i < matriz[0].length; i++){
            System.out.printf("% 3d ", i);
        }
        System.out.println();
        for(int l = 0; l < matriz.length; l++){
            // indexes
            System.out.printf("%2d ", l);
            for(int c = 0; c < colunas; c++)
                System.out.printf("% 3d ", matriz[l][c]); 
            
            System.out.println();
        }

        System.out.println();

        System.out.print("Entre com o valor escolhido: ");
        int valor = Integer.parseInt(sc.nextLine());

        System.out.println();

        System.out.printf("Procurando %d na matriz... \n\n", valor);
        for(int l = 0; l < matriz.length; l++)
            for(int c = 0; c < matriz[l].length; c++){
                if (matriz[l][c] == valor){
                    Integer esquerda = ((c - 1) >= 0) ? matriz[l][c - 1] : null;
                    Integer direita  = ((c + 1) < matriz[l].length) ? matriz[l][c + 1] : null;
                    Integer acima = ((l - 1) >= 0) ? matriz[l - 1][c] : null;
                    Integer abaixo = ((l + 1) < matriz.length) ? matriz[l + 1][c] : null;

                    StringBuilder posicoes = new StringBuilder();
                    
                    posicoes
                        .append(getStringPosicao(esquerda, "Esquerda:"))
                        .append(getStringPosicao(direita, "Direita:"))
                        .append(getStringPosicao(acima, "Acima:"))
                        .append(getStringPosicao(abaixo, "Abaixo:"));
                    
                    System.out.printf("%s: %d, %d:\n", "Posição", l, c);
                    System.out.printf("%s\n", posicoes);                  
                }                
            }
        
        sc.close();
    }

    static String getStringPosicao(Integer posicao, String descricao){
        return (posicao != null) ? String.format("%-10s %4d\n", descricao, posicao) : "";
    }
}