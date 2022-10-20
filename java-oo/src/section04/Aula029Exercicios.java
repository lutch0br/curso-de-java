package section04;

import java.util.Locale;
import java.util.Scanner;


public class Aula029Exercicios {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		exercicio01(sc);
		exercicio02(sc);
		exercicio03(sc);
		exercicio04(sc);
		exercicio05(sc);
		exercicio06(sc);
	}

	
	/** 
	 * Faça um programa para ler dois valores inteiros, e depois mostrar na 
	 * tela a soma desses números com uma mensagem explicativa, conforme 
	 * exemplos.
	 */
	static void exercicio01(Scanner sc) {
		
		int a, b;
		System.out.println("Entre com um valor inteiro: ");
		a = sc.nextInt();
		System.out.println("Entre com outro valor inteiro: ");		
		b = sc.nextInt();
		System.out.println("Soma = " + (a + b));
	}
	
	/**
	 * Faça um programa para ler o valor do raio de um círculo, e depois 
	 * mostrar o valor da área deste círculo com quatro casas decimais 
	 * conforme exemplos. 
	 * Fórmula da área: area = π . raio2
	 * Considere o valor de π = 3.14159
	 */
	static void exercicio02(Scanner sc) {

		System.out.println("Entre com o valor do raio do círculo: ");
		double raio = sc.nextDouble();
		Double area = Math.PI * Math.pow(raio, 2);
		System.out.printf("Áre do Círculo = %.4f", area);
		
	}
	
	/**
	 * Fazer um programa para ler quatro valores inteiros A, B, C e D. A 
	 * seguir, calcule e mostre a diferença do produto
	 * de A e B pelo produto de C e D segundo a fórmula: 
	 * DIFERENCA = (A * B - C * D).
	 */
	static void exercicio03(Scanner sc) {	
		int a, b, c, d, diferenca;
		
		System.out.println("Entre com o valor de a: ");
		a = sc.nextInt();
		System.out.println("Entre com o valor de b: ");
		b = sc.nextInt();
		System.out.println("Entre com o valor de c: ");
		c = sc.nextInt();
		System.out.println("Entre com o valor de d: ");
		d = sc.nextInt();		
		diferenca = (a * b - c * d);

		System.out.println("Diferença:  " + diferenca);
				
	}
	
	/**
	 * Fazer um programa que leia o número de um funcionário, seu número de 
	 * horas trabalhadas, o valor que recebe por
	 * hora e calcula o salário desse funcionário. A seguir, mostre o número e 
	 * o salário do funcionário, com duas casas decimais.
	 */
	static void exercicio04(Scanner sc) {
		Locale.setDefault(Locale.US);
		System.out.println("Entre com o id do funcionário: ");
		int id = sc.nextInt();
		
		System.out.println("Entre com a quantidade de horas trabalhadas: ");
		double hours = sc.nextDouble();
		
		System.out.println("Entre com o valor da hora: ");
		double valueHour = sc.nextDouble();
		
		double salary = hours * valueHour;		
		System.out.printf("Funcionário n. %d: Salário a receber: %.2f\n", 
				id, salary);
		
		System.out.println("Concluído");
	}

	/**
	 * Fazer um programa para ler o código de uma peça 1, o número de peças 1, 
	 * o valor unitário de cada peça 1, o código de uma peça 2, o número de 
	 * peças 2 e o valor unitário de cada peça 2. Calcule e mostre o valor a 
	 * ser pago.
	 * 
	 */
	static void exercicio05(Scanner sc) {
		Locale.setDefault(Locale.US);

		System.out.println("Entre com o id quantidade valor da peça 01");
		int idNumeroPeca01 = sc.nextInt();
		int quantidadePeca01 = sc.nextInt();
		double valorPeca01 = sc.nextDouble();
		double valorTotal01 = quantidadePeca01 * valorPeca01;

		System.out.println("Entre com o id quantidade valor da peça 02");
		int idNumeroPeca02 = sc.nextInt();
		int quantidadePeca02 = sc.nextInt();
		double valorPeca02 = sc.nextDouble();		
		double valorTotal02 = quantidadePeca02 * valorPeca02;

		double valorTotal = valorTotal01 + valorTotal02;

		System.out.printf("Valor a pagar: %.2f\n", valorTotal);
		System.out.println("Concluído");
	}

	/**
	 * Fazer um programa que leia três valores com ponto flutuante de dupla 
	 * precisão: A, B e C. Em seguida, calcule e mostre:
	 * a) a área do triângulo retângulo que tem A por base e C por altura.
	 * b) a área do círculo de raio C. (pi = 3.14159)
	 * c) a área do trapézio que tem A e B por bases e C por altura.
	 * d) a área do quadrado que tem lado B.
	 * e) a área do retângulo que tem lados A e B
	 * 
	 */
	static void exercicio06(Scanner sc) {
		Locale.setDefault(Locale.US);
		
		System.out.println("Entre com os valores de A B C: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		double areaDoTriangulo = (a * c / 2);
		double areaDoCirculo = Math.PI * Math.pow(c, 2);
		double areaDoTrapezio = ((a + b) * c) / 2;
		double areaDoQuadrado = b * b;
		double areaDoRetangulo = a * b;
		
		System.out.println();
		System.out.printf("Área do triângulo retângulo que tem A por base e C por altura: %.3f\n", areaDoTriangulo);
		System.out.printf("Área do círculo de raio C. (pi = 3.14159): %.3f\n", areaDoCirculo);
		System.out.printf("Área do trapézio que tem A e B por bases e C por altura: %.3f\n", areaDoTrapezio);
		System.out.printf("Área do quadrado que tem lado B: %.3f\n", areaDoQuadrado);
		System.out.printf("Área do retângulo que tem lados A e B: %.3f\n", areaDoRetangulo);	
		
	}
}

