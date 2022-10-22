package section05;

import java.util.Scanner;
import java.util.Locale;


class Aula036Exercicios {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        // exercicio01(sc);
        // exercicio02(sc);
        // exercicio03(sc);
        // exercicio04(sc);
        // exercicio05(sc);
        // exercicio06(sc);
        // exercicio07(sc);
        exercicio08(sc);
    }

    /**
    * Fazer um programa para ler um número inteiro, e depois dizer se este 
    * número é negativo ou não.
    */
    static void exercicio01(Scanner sc){
        System.out.println("Entre com um número inteiro: ");
        int numero = sc.nextInt();

        if (numero > 0)
            System.out.println("POSITIVO");
        else
            System.out.println("NÃO NEGATIVO");

        System.out.println("Concluído");
    }

    /**
    * Fazer um programa para ler um número inteiro e dizer se este número é par 
    * ou ímpar.
    */
    static void exercicio02(Scanner sc){
        System.out.println("Entre com um número inteiro: ");
        int numero = sc.nextInt();

        if ((numero % 2) == 0)
            System.out.println("Número PAR");
        else 
            System.out.println("Número IMPAR");

        System.out.println("Concluído");
    }

    /**
    * Leia 2 valores inteiros (A e B). Após, o programa deve mostrar uma 
    * mensagem "Sao Multiplos" ou "Nao sao Multiplos", indicando se os valores 
    * lidos são múltiplos entre si. Atenção: os números devem poder ser 
    * digitados em ordem crescente ou decrescente. 
    */
    static void exercicio03(Scanner sc){
        System.out.println("Entre com um número inteiro A e B: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a > b) {
            if ((a % b) == 0)
                System.out.println("Múltiplos");
            else 
                System.out.println("NÃO Múltiplos");
        } else {
            if ((b % a) == 0)
                System.out.println("Múltiplos");
            else 
                System.out.println("NÃO Múltiplos");
        }

        System.out.println("Concluído.");
    
    }

    /**
    * Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração 
    * do jogo, sabendo que o mesmo pode começar em um dia e terminar em outro, 
    * tendo uma duração mínima de 1 hora e máxima de 24 horas. 
    */
    static void exercicio04(Scanner sc){
        System.out.println("Entre com a hora de início e hora de fim: ");
        int inicio = sc.nextInt();
        int fim = sc.nextInt();
        int duracao;

        if (inicio < fim) {
            duracao = fim - inicio;
        } else {
            duracao = (24 - inicio) + fim;
        }

        System.out.printf("O jogo durou %d horas\n", duracao);
        System.out.println("Concluído");
    }

    /**
    * Com base na tabela abaixo, escreva um programa que leia o código de um 
    * item e a quantidade deste item. A seguir, calcule e mostre o valor da 
    * conta a pagar 
    */
    static void exercicio05(Scanner sc){
        System.out.printf("\n%-10s", "CÓDIGO");
        System.out.printf("%-18s", "ESPECIFICAÇÃO");
        System.out.printf("PREÇO\n");
        System.out.printf("%-10s", "1");
        System.out.printf("%-18s", "Cachorro Quente");
        System.out.printf("R$ 4.00\n");
        System.out.printf("%-10s", "2");
        System.out.printf("%-18s", "X-Salada");
        System.out.printf("R$ 4.50\n");
        System.out.printf("%-10s", "3");
        System.out.printf("%-18s", "X-Bacon");
        System.out.printf("R$ 5.00\n");
        System.out.printf("%-10s", "4");
        System.out.printf("%-18s", "Torrada Simples");
        System.out.printf("R$ 2.00\n");
        System.out.printf("%-10s", "5");
        System.out.printf("%-18s", "Refrigerante");
        System.out.printf("R$ 1.50\n\n");
        System.out.println("Entre com o código e a quantidade do item:");

        int codigo = sc.nextInt();
        int quantidade = sc.nextInt();

        double valorAPagar = 0;

        if (codigo == 1)
            valorAPagar = quantidade * 4.00;
        if (codigo == 2)
            valorAPagar = quantidade * 4.50;
        if (codigo == 3)
            valorAPagar = quantidade * 5.00;
        if (codigo == 4)
            valorAPagar = quantidade * 2.00;
        if (codigo == 5)
            valorAPagar = quantidade * 1.50;

        System.out.printf("Total: R$ %.2f\n", valorAPagar);
        System.out.println("Concluído");
    }

    /**
    * Você deve fazer um programa que leia um valor qualquer e apresente uma 
    * mensagem dizendo em qual dos seguintes intervalos 
    * ([0,25], (25,50], (50,75], (75,100]) este valor se encontra. Obviamente 
    * se o valor não estiver em nenhum destes intervalos, deverá ser impressa a 
    * mensagem “Fora de intervalo” 
    */
    static void exercicio06(Scanner sc){
        sc = sc.useLocale(Locale.US);
        System.out.println("Digite um valor entre 0-100: ");
        double valor = sc.nextDouble();

        if (valor >= 0.0 && valor <= 25.0)
            System.out.println("Intervalo [0, 25]");
        if (valor > 25.0 && valor <= 50.0)
            System.out.println("Intervalo (25, 50]");
        if (valor > 50.0 && valor <= 75.0)
            System.out.println("Intervalo (50, 75]");
        if (valor > 75.0 && valor <= 100.0)
            System.out.println("Intervalo (75, 25]");                                

        System.out.println("Concluído");
    }

    /**
    * Leia 2 valores com uma casa decimal (x e y), que devem representar as 
    * coordenadas de um ponto em um plano. A seguir, determine qual o quadrante 
    * ao qual pertence o ponto, ou se está sobre um dos eixos cartesianos ou 
    * na origem (x = y = 0).
    * Se o ponto estiver na origem, escreva a mensagem “Origem”.
    * Se o ponto estiver sobre um dos eixos escreva “Eixo X” ou “Eixo Y”, 
    * conforme for a situação. 
    */
    static void exercicio07(Scanner sc){
        sc = sc.useLocale(Locale.US);

        System.out.println("Entre com os valores de X e Y: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        if (x == 0.0 && y == 0.0)
            System.out.println("Origem");
        else if (x == 0.0)
            System.out.println("Eixo Y");
        else if (y == 0.0)
            System.out.println("Eixo X");
        else if (x > 0.0 && y > 0.0)
            System.out.println("Q1");
        else if (x > 0.0 && y < 0.0)
            System.out.println("Q4");
        else if (x < 0.0 && y > 0.0)
            System.out.println("Q2");
        else if (x < 0.0 && y < 0.0)
            System.out.println("Q3");


        System.out.println("Concluído");
    }

    /**
    * Em um país imaginário denominado Lisarb, todos os habitantes ficam 
    * felizes em pagar seus impostos, pois sabem que nele não existem políticos
    * corruptos e os recursos arrecadados são utilizados em benefício da 
    * população, sem qualquer desvio. A moeda deste país é o Rombus, cujo 
    * símbolo é o R$.
    * Leia um valor com duas casas decimais, equivalente ao salário de uma 
    * pessoa de Lisarb. Em seguida, calcule e mostre o valor que esta pessoa 
    * deve pagar de Imposto de Renda, segundo a tabela abaixo. 
    * RENDA                         IR
    * de 0.00 a R$ 2000             Isento
    * de R$ 2000.01 a R$ 3000.00    8%
    * de R$ 3000.01 a R$ 4500.00    18%
    * acima de R$ 4500.00           28%
    * Lembre que, se o salário for R$ 3002.00, a taxa que incide é de 8% apenas 
    * sobre R$ 1000.00, pois a faixa de salário que fica de R$ 0.00 até 
    * R$ 2000.00 é isenta de Imposto de Renda. No exemplo fornecido (abaixo), 
    * a taxa é de 8% sobre R$ 1000.00 + 18% sobre R$ 2.00, o que resulta em 
    * R$ 80.36 no total. O valor deve ser impresso com duas casas decimais.
    */
    static void exercicio08(Scanner sc){
        // Locale.setDefault(Locale.US);
        sc = sc.useLocale(Locale.US);
        double ir = 0.0;

        System.out.println("Entre com o valor do salário: ");
        double salario = sc.nextDouble();

        if (salario < 2000.0)
            System.out.println("Isento");
        else if (salario > 2000.0 && salario < 3000.0){
            ir = (salario - 2000.0) * 0.08;
            System.out.printf("R$ %.2f\n", ir);
        } else if (salario > 3000.0 && salario < 4500.0){
            ir = (1000.0 * 0.08) + ((salario - 3000.0) * 0.18);
            System.out.printf("R$ %.2f\n", ir);
        } else {
            ir = (1000.0 * 0.08) + (1500.0 * 0.18) + ((salario - 4500.0) * 0.28);
            System.out.printf("R$ %.2f\n", ir);
        }

        System.out.println("Concluído");
    }
}