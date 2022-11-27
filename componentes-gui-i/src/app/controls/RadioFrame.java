package app.controls;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.github.javafaker.Faker;

public class RadioFrame  extends JFrame{

	private final JLabel label;
	private final JTextField textField;
	private final JButton button;
	private final JRadioButton radioButton1;
	private final JRadioButton radioButton2;
	private final ButtonGroup buttonGroup;

	static final Faker faker = new Faker();
	
	public RadioFrame() {
		super("Name Generator");
		setLocationRelativeTo(null);;
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		
		label = new JLabel("Name: ");
		
		textField = new JTextField(25);
		textField.setText(faker.name().fullName());
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		
		button = new JButton("New");
		radioButton1 = new JRadioButton("Bold", true);
		radioButton2 = new JRadioButton("Italic", false);		
		
		add(label); add(textField); add(button); 
		add(radioButton1); add(radioButton2); 
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton1); buttonGroup.add(radioButton2);
		
		HandleButton buttonHandle = new HandleButton();
		button.addActionListener(buttonHandle);	
		
		Font font1 = new Font("SansSerif", Font.PLAIN, 14);
		Font font2 = new Font("Serif", Font.ITALIC, 14);		
		
		radioButton1.addItemListener(new RadioHandler(font1));
		radioButton2.addItemListener(new RadioHandler(font2));		
		
	}
	
	private void generateNewName() {
		textField.setText(faker.name().fullName());
	}
	
	private class RadioHandler implements ItemListener {
		private Font font;
		
		public RadioHandler(Font f) {
			font = f;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
					
			textField.setFont(font);
			
		}
		
	}
	
	private class HandleButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			generateNewName();			
		}		
	}

	public static void main(String[] args) {
		
		RadioFrame frame = new RadioFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(480, 100);		
		
		frame.setVisible(true);		
	}	
}