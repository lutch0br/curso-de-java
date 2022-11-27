package app.controls;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.javafaker.Faker;

public class CheckBoxFrame  extends JFrame{

	private final JLabel label;
	private final JTextField textField;
	private final JButton button;
	private final JCheckBox checkBox1;
	private final JCheckBox checkBox2;

	static final Faker faker = new Faker();
	
	public CheckBoxFrame() {
		super("Name Generator");
		setLocationRelativeTo(null);;
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//		setLayout(new FlowLayout());
		
		label = new JLabel("Name: ");
		
		textField = new JTextField(25);
		textField.setText(faker.name().fullName());
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		
		button = new JButton("New");
		checkBox1 = new JCheckBox("Bold");
		checkBox2 = new JCheckBox("Italic");		
		
		add(label); add(textField); add(button); add(checkBox1); add(checkBox2);  
		
		HandleButton buttonHandle = new HandleButton();
		button.addActionListener(buttonHandle);	
		
		CheckHandler checkHandler = new CheckHandler();
		checkBox1.addItemListener(checkHandler);
		checkBox2.addItemListener(checkHandler);		
		
	}
	
	private void generateNewName() {
		textField.setText(faker.name().fullName());
	}
	
	private class CheckHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			Font font = null;
			
			if (checkBox1.isSelected() && checkBox2.isSelected())			
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
			else if(checkBox1.isSelected())
				font = new Font("Serif", Font.BOLD, 14);			
			else if(checkBox2.isSelected())
				font = new Font("Serif", Font.ITALIC, 14);
			else
				font = new Font("Serif", Font.PLAIN, 14);
			
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
		
		CheckBoxFrame frame = new CheckBoxFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(480, 100);		
		
		frame.setVisible(true);		
	}	
}