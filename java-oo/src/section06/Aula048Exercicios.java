package section06;

import java.util.Scanner;
import java.util.Locale;


public class Aula048Exercicios {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        Locale.setDefault(Locale.US);

        clearScreen();
        menu:
        while(true) {             
            System.out.println("Escolha o exercício desejado: ");
            System.out.printf("%-5s%s\n", "NRO", "DESCRIÇÃO");
            System.out.printf("%3d  %s\n", 1, "Senha");
            System.out.printf("%3d  %s\n", 2, "Coordenadas");
            System.out.printf("%3d  %s\n", 3, "Combustível");
            System.out.printf("%3d  %s\n", 0, "Fim");
            int exercicio = sc.nextInt();
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
                 case 0: break menu;
                default: System.out.println("Opção inválida");
                
            }
        }
        sc.close();
        clearScreen();
        System.out.println("Concluído");
    }

    /**
    * Escreva um programa que repita a leitura de uma senha até que ela seja 
    * válida. Para cada leitura de senha incorreta informada, escrever a 
    * mensagem "Senha Invalida". Quando a senha for informada corretamente deve 
    * ser impressa a mensagem "Acesso Permitido" e o algoritmo encerrado. 
    * Considere que a senha correta é o valor 2002
    */
    static void exercicio01(Scanner sc){
        String passwd = "2002";
        String input = "";

        sc.nextLine();
        System.out.println("Digite a senha: ");
        input = sc.nextLine();

        while(!(input.equals(passwd))){
            clearScreen();
            System.out.println("Senha inválida");
            System.out.println("Digite a senha: ");
            input = sc.nextLine();
        }

        clearScreen();
        System.out.println("Acesso permitido");        
    }

    /**
    * Escreva um programa para ler as coordenadas (X,Y) de uma quantidade 
    * indeterminada de pontos no sistema cartesiano. Para cada ponto escrever o 
    * quadrante a que ele pertence. O algoritmo será encerrado quando pelo
    * menos uma de duas coordenadas for NULA (nesta situação sem escrever 
    * mensagem alguma).
    */
    static void exercicio02(Scanner sc){
        System.out.println("Entre com as coordenadas X e Y: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        while (x != 0 && y != 0){
            clearScreen();
            verificaQuadrante(x, y);
            System.out.println("Entre com as coordenadas X e Y: ");
            x = sc.nextInt();
            y = sc.nextInt();            
        }
    }

    /**
    * Um Posto de combustíveis deseja determinar qual de seus produtos tem a 
    * preferência de seus clientes. Escreva um algoritmo para ler o tipo de 
    * combustível abastecido (codificado da seguinte forma: 1.Álcool 
    * 2.Gasolina 3.Diesel 4.Fim). Caso o usuário informe um código inválido 
    * (fora da faixa de 1 a 4) deve ser solicitado um novo código (até que seja
    * válido). O programa será encerrado quando o código informado for o número
    * 4. Deve ser escrito a mensagem: "MUITO OBRIGADO" e a quantidade de 
    * clientes que abasteceram cada tipo de combustível, conforme exemplo. 
    */
    static void exercicio03(Scanner sc){
        int opcao;
        int etanol = 0;
        int gasolina = 0;
        int diesel = 0;

        menuCombustivel:
        while(true){
            System.out.println("Entre com a opção desejada: ");
            System.out.printf("%-5s%s\n", "NRO", "COMBUSTÍVEL");
            System.out.printf("%3d  %s\n", 1, "Etanol");
            System.out.printf("%3d  %s\n", 2, "Gasolina");
            System.out.printf("%3d  %s\n", 3, "Diesel");
            System.out.printf("%3d  %s\n", 4, "Fim");
            opcao = sc.nextInt();

            switch(opcao){
                case 1: etanol++;
                    break;
                case 2: gasolina++;
                    break;
                case 3: diesel++;
                    break;
                case 4: break menuCombustivel;                    
                default: System.out.println("Opção inválida");
            }
            clearScreen();
        }
        
        clearScreen();

        System.out.println("MUITO OBRIGADO");
        System.out.printf("\t%s: %d\n\t%s: %d\n\t%s: %d\n\n", 
            "Etanol", etanol, "Gasolina", gasolina, "Diesel", diesel);            
    }

    static void verificaQuadrante(int x, int y){
        if (x > 0 && y > 0)
            System.out.println("PRIMEIRO");
        else if (x < 0 && y > 0)
            System.out.println("SEGUNDO");
        else if (x < 0 && y < 0)
            System.out.println("TERCEIRO");
        else if (x > 0 && y < 0)
            System.out.println("QUARTO");
    }

    static void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}