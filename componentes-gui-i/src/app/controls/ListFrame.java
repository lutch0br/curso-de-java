package app.controls;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.github.javafaker.Faker;

public class ListFrame extends JFrame {
	
	private final JList<String> listBox;
	private final JLabel label;
	private final JLabel label1;	
	
	private static final Faker faker = new Faker();
	
	public ListFrame() {
		super("ListBox Test");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		
		label = new JLabel("Select a item: ");
		label1 = new JLabel("");
		listBox = new JList<>(getNames());
		listBox.setVisibleRowCount(5);
		listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add(label);
		add(new JScrollPane(listBox));
		add(label1);
		listBox.addListSelectionListener(new ListHandler());
	}

	private void updateList(JList listBox, String[] strings) {
		listBox.setListData(getNames());
	}

	private String[] getNames() {
		String[] names = new String[10];
		
		for(int i = 0; i < 10; i++) {
			names[i] = faker.name().fullName();
		}

		return names;
		
	}
	
	private class ListHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {			
			label1.setText(listBox.getSelectedValue() + " selected.");			
		}
	}	

	public static void main(String[] args) {		
		ListFrame frame = new ListFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}