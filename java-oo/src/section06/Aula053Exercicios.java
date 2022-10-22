package section06;

import java.util.Scanner;
import java.util.Locale;


public class Aula053Exercicios {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        Locale.setDefault(Locale.US);

        int exercicio;

        clearScreen();        
        do {             
            System.out.println("Escolha o exercício desejado: ");
            System.out.printf("\n%-5s%s\n", "NRO", "DESCRIÇÃO");
            System.out.printf("%3d  %s\n", 1, "Impares");
            System.out.printf("%3d  %s\n", 2, "Intervalo");
            System.out.printf("%3d  %s\n", 3, "Média");
            System.out.printf("%3d  %s\n", 4, "Divisão");
            System.out.printf("%3d  %s\n", 5, "Fatorial");
            System.out.printf("%3d  %s\n", 6, "Divisores");
            System.out.printf("%3d  %s\n", 7, "Potênciação");
            System.out.printf("%3d  %s\n", 0, "Fim");

            System.out.print("> ");
            exercicio = sc.nextInt();

            switch(exercicio){                
                case 1:
                    clearScreen();
                    exercicio01(sc);                    
                    break;
                case 2:
                    clearScreen();
                    exercicio02(sc);
                    break;
                case 3:
                    clearScreen();
                    exercicio03(sc);                    
                    break;      
                case 4:
                    clearScreen();
                    exercicio04(sc);
                    break;
                case 5:
                    clearScreen();
                    exercicio05(sc);
                    break;
                case 6:
                    clearScreen();
                    exercicio06(sc);
                    break;
                case 7:
                    clearScreen();
                    exercicio07(sc);
                    break;                                         
                case 0: break;
                default: System.out.println("Opção inválida");                
            }
        } while(exercicio != 0);

        sc.close();
        clearScreen();
        System.out.println("Concluído");
    }

    /**
    * Leia um valor inteiro X (1 <= X <= 1000). Em seguida mostre os ímpares 
    * de 1 até X, um valor por linha, inclusive o X, se for o caso.
    */
    static void exercicio01(Scanner sc){

        System.out.printf("Entre com um valor inteiro [1-1000]: ");
        int valor = sc.nextInt();

        while (valor < 1 || valor > 1000){
            clearScreen();
            System.out.println("Valor inválido...");
            System.out.printf("Entre com um valor inteiro [1-1000]: ");
            valor = sc.nextInt();
        } 

        for(int i = 1; i <= valor; i += 2){
            System.out.println(i);
        }

        System.out.println();
    }

    /**
    * Leia um valor inteiro N. Este valor será a quantidade de valores inteiros 
    * X que serão lidos em seguida. Mostre quantos destes valores X estão 
    * dentro do intervalo [10,20] e quantos estão fora do intervalo, mostrando
    * essas informações conforme exemplo (use a palavra "in" para dentro do 
    * intervalo, e "out" para fora do intervalo).
    */
    static void exercicio02(Scanner sc){

        System.out.printf("Informe a quantidade de valores: ");
        int quantidade = sc.nextInt();
        int in = 0;
        int out = 0;
        int valor;

        clearScreen();
        for(int i = 1; i <= quantidade; i++){
            System.out.print("Entre com o valor desejado: ");
            valor = sc.nextInt();
            clearScreen();
            if (valor >= 10 && valor <= 20)
                in++;
            else 
                out++;
        }

        System.out.printf("\n%d in\n%d out\n", in, out);

        System.out.println();
    }

    /**
    * Leia 1 valor inteiro N, que representa o número de casos de teste que 
    * vem a seguir. Cada caso de teste consiste de 3 valores reais, cada um 
    * deles com uma casa decimal. Apresente a média ponderada para cada um 
    * destes conjuntos de 3 valores, sendo que o primeiro valor tem peso 2, o 
    * segundo valor tem peso 3 e o terceiro valor tem peso 5 
    */
    static void exercicio03(Scanner sc){
        System.out.printf("Informe a quantidade de casos: ");
        int quantidade = sc.nextInt();

        clearScreen();
        for (int i = 1; i <= quantidade; i++){
            System.out.printf("Caso %d, informe os 3 valores: ", i);
            double valor1 = sc.nextDouble();
            double valor2 = sc.nextDouble();
            double valor3 = sc.nextDouble();
            double media = (valor1 * 2 + valor2 * 3 + valor3 * 5) / 10;
            System.out.printf("Média: %.1f\n\n", media);
        }
    }

    /**
    * Fazer um programa para ler um número N. Depois leia N pares de números e 
    * mostre a divisão do primeiro pelo segundo. Se o denominador for igual a
    * zero, mostrar a mensagem "divisao impossivel". 
    */
    static void exercicio04(Scanner sc){
        System.out.printf("Entre com a quantidade de divisões: ");
        int quantidade = sc.nextInt();

        clearScreen();

        for (int i = 1; i <= quantidade; i++) {
            System.out.printf("Entre com dois valores para a divisão: ");
            double numerador = sc.nextDouble();
            double denominador = sc.nextDouble();

            if (denominador == 0){
                System.out.println("Divisão impossivel\n");
                continue;
            }

            double resultado = numerador / denominador;
            System.out.printf("Resultado: %.2f\n\n", resultado);
        }

    }

    /**
    * Ler um valor N. Calcular e escrever seu respectivo fatorial. Fatorial 
    * de N = N * (N-1) * (N-2) * (N-3) * ... * 1.
    * Lembrando que, por definição, fatorial de 0 é 1. */
    static void exercicio05(Scanner sc){
        System.out.printf("Entre com o valor de N: ");
        int n = sc.nextInt();
        int fatorial = 1;

        for (int i = n; i > 0; i--) {
            fatorial *= i;
        }

        System.out.printf("%d\n\n", fatorial);
    }

    /**
    * Ler um número inteiro N e calcular todos os seus divisores.    *
    */
    static void exercicio06(Scanner sc){
        System.out.printf("Entre com um número: ");
        int numero = sc.nextInt();

        for (int i = 1; i <= numero; i++) {
            if ((numero % i) == 0){
                System.out.printf("%d\n", i);
            }
        }

        System.out.println();
    }

    /**
    * Fazer um programa para ler um número inteiro positivo N. O programa deve
    * então mostrar na tela N linhas, começando de 1 até N. Para cada linha, 
    * mostrar o número da linha, depois o quadrado e o cubo do valor, conforme
    * exemplo. */
    static void exercicio07(Scanner sc){
        System.out.printf("Informe um número inteiro maior que 0: ");
        int numero = sc.nextInt();

        for (int i = 1; i <= numero; i++){
            System.out.printf("%d %d %d\n", i, 
                (int)Math.pow(i, 2), (int)Math.pow(i, 3));
        }

        System.out.println();
    }
    
    static void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}