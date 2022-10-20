package section04;

import java.util.Locale;

public class Aula023SaidaDeDados {

	public static void main(String[] args) {
		saidaDeDados();
		
	}

	private static void saidaDeDados() {
		Locale.setDefault(Locale.US);		
		
		// Saída de dados
		System.out.printf("int: %d\n",  42);
		System.out.println("E aí mundão, blz?");		
		System.out.printf("float: %.2f\n",  3.1415f);
		System.out.println("Juntado " + "as " + "partes.");
		
		// Interpolando outros valores
		int inteiro = 10;
		float flutuante = 3.1415f;
		String nome = "Joana";
		
		System.out.printf("%s aprendeu o %.4f em %d minutos.\n",
				nome, flutuante, inteiro);
	}

}
