package app.layouts.flow;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Program {
	public static void main(String[] args) {
		FlowFrame frame = new FlowFrame();
		frame.setSize(500, 120);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class FlowFrame extends JFrame {

	private final JButton buttons[] = new JButton[3];
	private final FlowLayout layout;
	private final Container container;	

	public FlowFrame() {
		super("FlowLayout Test");
		layout = new FlowLayout(FlowLayout.LEFT, 30, 30);
		container = getContentPane();
		setLayout(layout);
		
		setLocationRelativeTo(null);

		String[] labels = { "LEFT", "CENTER", "RIGHT" };
		int[] alignments = {FlowLayout.LEFT, FlowLayout.CENTER, FlowLayout.RIGHT};

		buttons[0] = new JButton(labels[0]);
		add(buttons[0]);
		buttons[0].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					layout.setAlignment(alignments[0]);
					layout.layoutContainer(container);
				}
		});
		
		buttons[1] = new JButton(labels[1]);
		add(buttons[1]);
		buttons[1].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					layout.setAlignment(alignments[1]);
					layout.layoutContainer(container);
				}
		});
		
		buttons[2] = new JButton(labels[2]);
		add(buttons[2]);
		buttons[2].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					layout.setAlignment(alignments[2]);
					layout.layoutContainer(container);
				}
		});		
	}

}