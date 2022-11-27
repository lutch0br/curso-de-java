package app.controls;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.github.javafaker.Faker;

public class ComboFrame extends JFrame {
	
	private final JComboBox<String> comboBox;
	private final JLabel label;
	private final JLabel label1;	
	
	private static final Faker faker = new Faker();
	
	public ComboFrame() {
		super("ComboBox Test");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		
		label = new JLabel("Select a item: ");
		label1 = new JLabel("");
		comboBox = new JComboBox<>(getNames());
		
		add(label);
		add(comboBox);
		add(label1);
		comboBox.addItemListener(new ComboHandler());
	}
	
	private String[] getNames() {
		String[] names = new String[10];
		
		for(int i = 0; i < 10; i++) {
			names[i] = faker.name().fullName();
		}
		
		return names;
		
	}
	
	private class ComboHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED)
				label1.setText(comboBox.getSelectedItem() + " selected.");
		}		
	}	
	
	public static void main(String[] args) {
		
		ComboFrame frame = new ComboFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
