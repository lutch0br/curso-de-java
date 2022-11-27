package app.controls;

import javax.swing.JOptionPane; 

public class ProgramAdd {

	public static void main(String[] args) {
		String firstNumber = JOptionPane.showInputDialog("Entrer first integer: ");
		String secondNumber = JOptionPane.showInputDialog("Entrer second integer: ");
		
		int number1 = Integer.parseInt(firstNumber);
		int number2 = Integer.parseInt(secondNumber);
		
		int sum = number1 + number2;
		
		JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of two integers", JOptionPane.PLAIN_MESSAGE);
		testandoJOptionPanes(JOptionPane.ERROR_MESSAGE);
		testandoJOptionPanes(JOptionPane.INFORMATION_MESSAGE);
		testandoJOptionPanes(JOptionPane.WARNING_MESSAGE);
		testandoJOptionPanes(JOptionPane.QUESTION_MESSAGE);
		
	}
	
	static void testandoJOptionPanes(int message) {
		
		JOptionPane.showMessageDialog(null, "Teste 1", "Title", message);
		
	}

}

