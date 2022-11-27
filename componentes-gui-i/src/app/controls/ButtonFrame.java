package app.controls;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.javafaker.Faker;

public class ButtonFrame extends JFrame {

	private JLabel label;
	private JTextField textField;
	private JButton button;

	static final Faker faker = new Faker();
	
	public ButtonFrame() {
		super("Name Generator");
		setLocationRelativeTo(null);;
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		label = new JLabel("Name: ");
		textField = new JTextField(25);
		textField.setText(faker.name().fullName());
		button = new JButton("New");
		
		add(label); add(textField); add(button);
		
		HandleButton handle = new HandleButton();
		button.addActionListener(handle);
		
	}
	
	private void generateNewName() {
		textField.setText(faker.name().fullName());
	}
	
	private class HandleButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			generateNewName();			
		}		
	}
	
	public static void main(String[] args) {
		
		ButtonFrame frame = new ButtonFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(430, 75);
		frame.setVisible(true);		
	}	
}
