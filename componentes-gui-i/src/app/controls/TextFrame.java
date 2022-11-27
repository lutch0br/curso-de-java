package app.controls;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entities.Person;

public class TextFrame extends JFrame {

	private JLabel label;
	private JTextField textField;
	

	public TextFrame() {
		super("Testando eventos");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		label = new JLabel("Name: ");
		textField = new JTextField(25);
		
		Person person = new Person();
		textField.setText(person.toString());

		TextFieldHandler handler = new TextFieldHandler();

		add(label);
		add(textField);
		textField.addActionListener(handler);
	}

	private class TextFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String string = String.format("Hello %s", e.getActionCommand());
			JOptionPane.showMessageDialog(TextFrame.this, string);

		}

	}

	public static void main(String[] args) {

		TextFrame frame = new TextFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(370, 70);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}

