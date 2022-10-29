package section10.aula090.app;

import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
import section10.aula090.entities.Pessoa;
import section10.aula090.util.Data;
import util.Screen;

public class Application {
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Screen.clear();
        menu:
        do{
            
            System.out.printf("Selecione um exercício [1-11]:\n");
            System.out.printf("%3s%-4s%s", "NRO", " ", "EXERCICIO\n");
            System.out.printf("%3d%-4s%s", 0, " ", "SAIR\n" );
            System.out.printf("%3d%-4s%s", 1, " ", "NEGATIVOS\n" );
            System.out.printf("%3d%-4s%s", 2, " ", "SOMA VETOR\n" );
            System.out.printf("%3d%-4s%s", 3, " ", "ALTURAS\n" );
            System.out.printf("%3d%-4s%s", 4, " ", "NUMEROS PARES\n" );
            System.out.printf("%3d%-4s%s", 5, " ", "MAIOR POSIÇÃO\n" );
            System.out.printf("%3d%-4s%s", 6, " ", "SOMA VETORES\n" );
            System.out.printf("%3d%-4s%s", 7, " ", "ABAIXO DA MÉDIA\n" );
            System.out.printf("%3d%-4s%s", 8, " ", "MÉDIAS PARES\n" );
            System.out.printf("%3d%-4s%s", 9, " ", "MAIS VELHO\n" );
            System.out.printf("%3d%-4s%s", 10, " ", "APROVADOS\n" );
            System.out.printf("%3d%-4s%s", 11, " ", "DADOS PESSOAS\n" );

            System.out.print("> ");
            int exercicio = Integer.parseInt(sc.nextLine());
            
            Screen.clear();            
            switch(exercicio){
                case 0: System.out.println("...finalizado.");
                    break menu;
                case 1:
                    exercicio01(sc);
                    break;
                case 2:
                    exercicio02(sc);
                    break;
                case 3:
                    exercicio03(sc);
                    break;
                case 4:
                    exercicio04(sc);
                    break;
                case 5:
                    exercicio05(sc);
                    break;
                case 6:
                    exercicio06(sc);
                    break;
                case 7:
                    exercicio07(sc);
                    break;
                case 8:
                    exercicio08(sc);
                    break;
                case 9:
                    exercicio09(sc);
                    break;
                case 10:
                    exercicio10(sc);
                    break;
                case 11:
                    exercicio11(sc);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (true);
        sc.close();

    }

    /**
    * Faça um programa que leia um número inteiro positivo N (máximo = 10) e 
    * depois N números inteiros e armazene-os em um vetor. Em seguida, mostrar 
    * na tela todos os números negativos lidos. 
    */
    static void exercicio01(Scanner sc){        
        System.out.print("Entre com o tamanho do vetor: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] vect = new int[n];

        for (int i = 0; i < vect.length; i++){
            System.out.printf("Entre com o valor na posição %d: ", i + 1);
            vect[i] = Integer.parseInt(sc.nextLine());
        }
        
        System.out.print("Números negativos: ");
        for (int i = 0; i < vect.length; i++){
            if (vect[i] < 0)
                System.out.printf("%d ", vect[i]);
        }

        System.out.println("\n");

    }

    /** 
    * Faça um programa que leia N números reais e armazene-os em um vetor. 
    * Em seguida:
    * Imprimir todos os elementos do vetor
    * Mostrar na tela a soma e a média dos elementos do vetor 
    */
    static void exercicio02(Scanner sc){
        System.out.printf("Entre com o tamanho do vetor: ");
        int n = Integer.parseInt(sc.nextLine());
        Double[] vect = new Double[n];
        Double media = 0.0;
        Double soma = 0.0;


        for (int i = 0; i < vect.length; i++){
            System.out.printf("Digite o valor da posição %d: ", i + 1);
            vect[i] = Double.parseDouble(sc.nextLine());
            soma += vect[i];
            media = soma / vect.length;
        }

        System.out.print("\nValores: ");
        for (int i = 0; i < vect.length; i++){
            System.out.printf("%.2f ", vect[i]);
        }

        System.out.printf("\nSoma: %.2f\n", soma);
        System.out.printf("Média: %.2f\n", media);
        System.out.println("");
    }

    /** 
    * Fazer um programa para ler nome, idade e altura de N pessoas, conforme
    * exemplo. Depois, mostrar na tela a altura média das pessoas, e mostrar 
    * também a porcentagem de pessoas com menos de 16 anos, bem como os nomes 
    * dessas pessoas caso houver. 
    */
    static void exercicio03(Scanner sc){

        System.out.print("Quantas pessoas serão digitadas: ");
        int quantidade = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < quantidade; i++){
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            Integer idade = Integer.parseInt(sc.nextLine());
            System.out.print("Altura: ");
            Double altura = Double.parseDouble(sc.nextLine());
            Data.adicionaPessoa(new Pessoa(nome, idade, altura));
        }

        Data.estatisticas();

    }

    /**
    * Faça um programa que leia N números inteiros e armazene-os em um vetor. 
    * Em seguida, mostre na tela todos os números pares, e também a quantidade 
    * de números pares. 
    */
    static void exercicio04(Scanner sc){
        
        System.out.print("Quantos valores terá o vetor: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] v = new int[n];
        int quantidadeDePares = 0;

        for(int i = 0; i < n; i++){
            System.out.printf("Digite o valor %d: ", (i + 1));
            v[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println();
        System.out.println("NUMEROS PARES: ");
        for (int i = 0; i < v.length; i++){
            if (v[i] % 2 == 0){
                System.out.printf("%d ", v[i]);
                quantidadeDePares++;
            }
        }
        
        System.out.println();
        System.out.println();
        System.out.printf("QUANTIDADE DE PARES = %d\n", quantidadeDePares);
        System.out.println();

    }

    /**
    * Faça um programa que leia N números reais e armazene-os em um vetor. 
    * Em seguida, mostrar na tela o maior número do vetor (supor não haver 
    * empates). Mostrar também a posição do maior elemento, considerando a 
    * primeira posição como 0 (zero).
    */
    static void exercicio05(Scanner sc){
        
        System.out.print("Quantos números vai digitar: ");
        int n = Integer.parseInt(sc.nextLine());
        double[] v = new double[n];
        double maior = 0;
        int posicaoDoMaior = 0;

        for (int i = 0; i < n; i++){
            System.out.print("Digite um número real: ");
            v[i] = Double.parseDouble(sc.nextLine());
            if (v[i] > maior) {
                maior = v[i];
                posicaoDoMaior = i;
            }
        }
 
        System.out.println();
        System.out.printf("MAIOR VALOR = %.2f\nPOSICAO DO MAIOR VALOR = %d\n",
            maior, posicaoDoMaior);

        System.out.println();

    }

    /** 
    * Faça um programa para ler dois vetores A e B, contendo N elementos cada. 
    * Em seguida, gere um terceiro vetor C onde cada elemento de C é a soma dos
    * elementos correspondentes de A e B. Imprima o vetor C gerado 
    */
    static void exercicio06(Scanner sc){
        System.out.print("Tamanho de cada vetor: ");
        int n = Integer.parseInt(sc.nextLine());
        int vA[] = new int[n];
        int vB[] = new int[n];
        int vC[] = new int[n];

        System.out.print("Digite os valores inteiros do vetor A: \n");
        for (int i = 0; i < vA.length; i++){
            vA[i] = Integer.parseInt(sc.nextLine());
            vC[i] = vA[i];
        }

        System.out.print("Digite os valores inteiros do vetor B: \n");
        for (int i = 0; i < vB.length; i++){
            vB[i] = Integer.parseInt(sc.nextLine());
            vC[i] += vB[i];
        }

        System.out.printf("VETOR RESULTANTE:\n");
        for(int i = 0; i < vC.length; i++){
            System.out.printf("%d\n", vC[i]);
        }

        System.out.println();
    }

    /**
    * Fazer um programa para ler um número inteiro N e depois um vetor de N 
    * números reais. Em seguida, mostrar na tela a média aritmética de todos 
    * elementos com três casas decimais. Depois mostrar todos os elementos do 
    * vetor que estejam abaixo da média, com uma casa decimal cada. 
    */
    static void exercicio07(Scanner sc){
        System.out.print("Tamanho do vetor: ");
        int n = Integer.parseInt(sc.nextLine());
        double v[] = new double[n];
        double media = 0.0;

        for (int i = 0; i < v.length; i++){
            System.out.printf("Digite o valor inteiro %d: ", (i + 1));
            v[i] = Double.parseDouble(sc.nextLine());
            media += v[i] / v.length;
        }

        StringBuilder abaixoDaMedia = new StringBuilder();

        for(int i = 0; i < v.length; i++){
            if (v[i] < media) {
                abaixoDaMedia.append(v[i] + "\n");
            }
        }

        System.out.println();
        System.out.printf("MÉDIA DO VETOR = %.3f\n", media);
        System.out.printf("ELEMENTOS ABAIXO DA MEDIA: \n%s\n", abaixoDaMedia);

    }

    /**
    * Fazer um programa para ler um vetor de N números inteiros. Em seguida, 
    * mostrar na tela a média aritmética somente dos números pares lidos, com 
    * uma casa decimal. Se nenhum número par for digitado, mostrar a mensagem 
    * "NENHUM NUMERO PAR" 
    */
    static void exercicio08(Scanner sc){
        System.out.print("Tamanho do vetor: ");
        int n = Integer.parseInt(sc.nextLine());
        int v[] = new int[n];
        double numerosPares = 0.0;
        double somaNumerosPares = 0.0;
        double mediaNumPar = 0.0;

        for (int i = 0; i < v.length; i++){
            System.out.printf("Digite o valor inteiro %d: ", (i + 1));
            v[i] = Integer.parseInt(sc.nextLine());
            if (v[i] % 2 == 0){
                numerosPares++;
                somaNumerosPares += v[i];
            }
        }

        double mediaNumerosPares = (somaNumerosPares / numerosPares);

        String mensagem = 
            (numerosPares > 0.0) ? "MEDIA DOS PARES = " + 
                mediaNumerosPares : "NENHUM NUMERO PAR";

        System.out.printf("%s\n", mensagem);
        System.out.println();
    }

    /**
    * Fazer um programa para ler um conjunto de nomes de pessoas e suas
    * respectivas idades. Os nomes devem ser armazenados em um vetor, e as 
    * idades em um outro vetor. Depois, mostrar na tela o nome da pessoa mais 
    * velha. 
    */
    static void exercicio09(Scanner sc){

        System.out.print("Quantas pessoas vc vai digitar?: ");
        int n = Integer.parseInt(sc.nextLine());
        String[] nomes = new String[n];
        int[] idades = new int[n];
        int maisVelho = 0;

        for(int i = 0; i < nomes.length; i++){
            System.out.printf("Dados da %da\n", (i + 1));
            System.out.print("Nome: ");
            nomes[i] = sc.nextLine();
            System.out.print("Idade: ");
            idades[i] = Integer.parseInt(sc.nextLine());

            maisVelho = (idades[i] > idades[maisVelho]) ? i : maisVelho;
        }

        System.out.printf("PESSOA MAIS VELHA: %s\n", nomes[maisVelho]);
        System.out.println();

    }

    /**
    * Fazer um programa para ler um conjunto de N nomes de alunos, bem como as 
    * notas que eles tiraram no 1º e 2º semestres. Cada uma dessas informações 
    * deve ser armazenada em um vetor. Depois, imprimir os nomes dos alunos 
    * aprovados, considerando aprovados aqueles cuja média das notas seja maior
    * ou igual a 6.0 (seis). 
    */
    static void exercicio10(Scanner sc){
        System.out.print("Quantos alunos serão digitados?: ");
        int n = Integer.parseInt(sc.nextLine());
        String[] alunos = new String[n];

        double nota1[] = new double[n];
        double nota2[] = new double[n];
        double media;
        int quantidadeAprovados = 0;
        StringBuilder aprovados = new StringBuilder();

        for(int i = 0; i < alunos.length; i++){
            System.out.printf(
                "Digite nome, primeira e segunda nota do %do aluno:\n", i + 1);
            alunos[i] = sc.nextLine();
            nota1[i] = Double.parseDouble(sc.nextLine());
            nota2[i] = Double.parseDouble(sc.nextLine());
            media = (double)(nota1[i] + nota2[i]) / 2;
            if ( media >= 6.0){  
                aprovados.append(
                    String.format(
                        "Aluno: %s, Média: %.2f\n", alunos[i], media)
                );
                quantidadeAprovados++;
            }
        }

        if (quantidadeAprovados > 0){
            System.out.printf("ALUNOS APROVADOS: \n%s", aprovados);
        } else {
            System.out.printf("NENHUM ALUNO APROVADO\n");
        }

        System.out.println();

    }

    /**
    * Tem-se um conjunto de dados contendo a altura e o gênero (M, F) de N 
    * pessoas. Fazer um programa que calcule e escreva a maior e a menor altura 
    * do grupo, a média de altura das mulheres, e o número de homens. 
    */
    static void exercicio11(Scanner sc){
        System.out.print("Quantas pessoas serão digitadas?: ");
        int n = Integer.parseInt(sc.nextLine());

        double alturas[] = new double[n];
        char generos[] = new char[n];

        double menorAltura = 0.0;
        double maiorAltura = 0.0;
        
        int quantidadeDeMulheres = 0;
        int quantidadeDeHomens = 0;

        double mediaAlturaMulheres = 0.0;
        double mediaAlturaHomens = 0.0;

        double somaAlturaMulheres = 0.0;
        double somaAlturaHomens = 0.0;

        for(int i = 0; i < alturas.length; i++){
            System.out.printf("Altura da %da pessoa: ", i + 1);
            alturas[i] = Double.parseDouble(sc.nextLine());
            System.out.printf("Gênero da %da pessoa: ", i + 1);
            generos[i] = sc.nextLine().toUpperCase().charAt(0);

            maiorAltura = (alturas[i] > maiorAltura ? alturas[i] : maiorAltura);

            menorAltura = 
                ((menorAltura < alturas[i] && menorAltura > 0.0) ? menorAltura : alturas[i]);

            if (generos[i] == 'F'){
                quantidadeDeMulheres++;
                somaAlturaMulheres += alturas[i];
                mediaAlturaMulheres = somaAlturaMulheres / quantidadeDeMulheres;
            }
            if (generos[i] == 'M') {
                quantidadeDeHomens++;
                somaAlturaHomens += alturas[i];
                mediaAlturaHomens = somaAlturaHomens / quantidadeDeHomens;
            }
        }

        System.out.println();

        System.out.printf("MENOR ALTURA = %.2f\nMAIOR ALTURA = %.2f\n" +
            "MÉDIA DAS ALTURAS DAS MULHERES = %.2f\nNÚMERO DE HOMENS = %d\n", 
            menorAltura, maiorAltura, mediaAlturaMulheres, quantidadeDeHomens);

        System.out.println();
    }
}
