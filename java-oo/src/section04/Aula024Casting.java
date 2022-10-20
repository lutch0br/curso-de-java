package section04;

public class Aula024Casting {

	public static void main(String[] args) {
		//Casting e conversão de dados
		int a, b;
		double c, d;
		a = 3;
		b = 4; 
		c = 12.0; //indicando que é double
		d = (a + b) * c;
		
		System.out.println(d);
		
		// Outros exemplos de casting, conversão explícita
		int x = 5;
		int y = 2;
		double z = x / y; 
		/* apesar do destino ser double, é necessário
			Ser explícito para indicar que o resultado deve ser double
		*/
				
		System.out.println("Resultado: " + z);				
	}

}
