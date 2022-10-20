package section04;

import java.util.Locale;
import java.util.Scanner;

public class Aula025EntradaDeDados {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String x;
		System.out.println("Entre com um valor inteiro: ");
		x = sc.next();
		System.out.println("Você digitou: " + x);
		
		System.out.println("Entre com um valor inteiro: ");
		int i = sc.nextInt();
		System.out.println("Voce digitou: " + i); 
			
		int x1;
		System.out.println("Entre com um valor inteiro: ");
		x1 = sc.nextInt();
		sc.nextLine();
		String s1, s2, s3;
		System.out.println("Entre com uma palavra: ");
		s1 = sc.nextLine();
		System.out.println("Entre com uma palavra: ");
		s2 = sc.nextLine();
		System.out.println("Entre com uma palavra: ");
		s3 = sc.nextLine();
		System.out.println("Dados digitados: ");
		System.out.println(x1);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println("Entre com o número decimal: ");
		Locale.setDefault(Locale.US);
		double d = sc.nextDouble(); // use locale para alterar o separador de decimais.
		
		sc.close();

	}

}
