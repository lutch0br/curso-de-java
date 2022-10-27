package section10.aula090;

import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
import util.Screen;

public class Application {
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Screen.clear();
        exercicio09(sc);

        sc.close();

    }

    /**
    * Faça um programa que leia um número inteiro positivo N (máximo = 10) e 
    * depois N números inteiros e armazene-os em um vetor. Em seguida, mostrar 
    * na tela todos os números negativos lidos. 
    */
    static void exercicio01(Scanner sc){        
        System.out.print("Entre com o tamanho do vetor: ");
        int n = sc.nextInt();
        int[] vect = new int[n];

        for (int i = 0; i < vect.length; i++){
            System.out.printf("Entre com o valor na posição %d: ", i);
            vect[i] = sc.nextInt();
        }
        
        System.out.print("Números negativos: ");
        for (int i = 0; i < vect.length; i++){
            if (vect[i] < 0)
                System.out.printf("%d ", vect[i]);
        }

        System.out.println();

    }

    /** 
    * Faça um programa que leia N números reais e armazene-os em um vetor. 
    * Em seguida:
    * Imprimir todos os elementos do vetor
    * Mostrar na tela a soma e a média dos elementos do vetor 
    */
    static void exercicio02(Scanner sc){
        System.out.printf("Entre com o tamanho do vetor: ");
        int n = sc.nextInt();
        Double[] vect = new Double[n];
        Double media = 0.0;
        Double soma = 0.0;


        for (int i = 0; i < vect.length; i++){
            System.out.printf("Digite o valor da posição %d: ", i);
            vect[i] = sc.nextDouble();
            soma += vect[i];
            media = soma / vect.length;
        }

        System.out.print("\nValores: ");
        for (int i = 0; i < vect.length; i++){
            System.out.printf("%.2f ", vect[i]);
        }

        System.out.printf("\nSoma: %.2f\n", soma);
        System.out.printf("Média: %.2f\n", media);
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
            v[i] = sc.nextInt();
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
            System.out.print("Digite um número: ");
            v[i] = sc.nextDouble();
            if (v[i] > maior) {
                maior = v[i];
                posicaoDoMaior = i;
            }
        }
 
        System.out.println();
        System.out.printf("MAIOR VALOR = %.2f\nPOSICAO DO MAIOR VALOR = %d\n",
            maior, posicaoDoMaior);

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

        System.out.print("Digite os valores do vetor A: \n");
        for (int i = 0; i < vA.length; i++){
            vA[i] = sc.nextInt();
            vC[i] = vA[i];
        }

        System.out.print("Digite os valores do vetor B: \n");
        for (int i = 0; i < vB.length; i++){
            vB[i] = sc.nextInt();
            vC[i] += vB[i];
        }

        System.out.printf("VETOR RESULTANTE:\n");
        for(int i = 0; i < vC.length; i++){
            System.out.printf("%d\n", vC[i]);
        }
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
            System.out.printf("Digite o valor %d: ", (i + 1));
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
        System.out.printf("MEDIA DO VETOR = %.3f\n", media);
        System.out.printf("ELEMENTOS ABAIXO DA MEDIA: \n%s", abaixoDaMedia);

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
            System.out.printf("Digite o valor %d: ", (i + 1));
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
        
    }

}

class Pessoa{
    private String nome;
    private Integer idade;
    private Double altura;

    public Pessoa(String nome, Integer idade, Double altura){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome(){
        return nome;
    }

    public Integer getIdade(){
        return idade;        
    }

    public Double getAltura(){
        return altura;
    }

    public String toString(){
        return String.format(
            "Nome: %s, Idade: %d, Altura: %.2f\n",
            getNome(),  getIdade(), getAltura()
        );
    }
}

class Data{

    static Pessoa[] pessoas = new Pessoa[5];
    private static int quantidade;

    public static void adicionaPessoa(Pessoa pessoa){
        if (quantidade >= pessoas.length){
            int new_length = quantidade * 2;
            pessoas = Arrays.copyOf(pessoas, new_length);
        }

        pessoas[quantidade] = pessoa;
        quantidade++;
    }

    public static int quantidade(){
        return quantidade;
    }

    public static double alturaMedia(){
        double media = 0.0;
        for (int i = 0; i < quantidade; i++)
            media += pessoas[i].getAltura() / quantidade;
        
        return media;
    }

    public static void pessoas(){
        for (int i = 0; i < quantidade; i++)
            System.out.printf("%s\n", pessoas[i]);
    }

    public static int quantidadeMenoresQue16(){
        int quantidadeMenoresQue16 = 0;

        for (int i = 0; i < quantidade; i++){
            if (pessoas[i].getIdade() < 16)
                quantidadeMenoresQue16++;
        }  

        return quantidadeMenoresQue16;
    }

    public static double percentualMenoresQue16(){
        return (double) quantidadeMenoresQue16() / quantidade() * 100;

    }

    public static String pessoasMenoresQue16(){
        StringBuilder pessoasMenoresQue16 = new StringBuilder();

        for (int i = 0; i < quantidade; i++){
            if (pessoas[i].getIdade() < 16){
                pessoasMenoresQue16.append(pessoas[i]);
            }
        }

        return pessoasMenoresQue16.toString();        
    }

    public static void estatisticas(){
        System.out.println();
        System.out.printf("Quantidade de pessoas: %d\n", 
            Data.quantidade());
        System.out.printf("Altura Média: %.2f\n", Data.alturaMedia());
        
        System.out.println();
        System.out.printf("Quantidade de pessoas menores que 16: %d\n", 
            Data.quantidadeMenoresQue16());            
        System.out.printf("Percentual de menores que 16: %.2f\n", 
            Data.percentualMenoresQue16());
        System.out.println("Pessoas menores que 16:");
        System.out.printf("%s", Data.pessoasMenoresQue16());
        System.out.println();
    }

}