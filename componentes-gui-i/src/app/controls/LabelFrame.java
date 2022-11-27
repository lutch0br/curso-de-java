package app.controls;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelFrame extends JFrame
{
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	
	public LabelFrame(){
		setTitle("Testando JLabel");
		setDefaultLookAndFeelDecorated(false);
		setLocationRelativeTo(null); // posiciona no centro da tela
		setLayout(new FlowLayout());
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();		
		
		label1.setText("Label 1");
		add(label1);
		
		label2.setText("Label 2");
		label2.setToolTipText("Exemplo de label");
		add(label2);
		
		label3.setText("Label 3");
		add(label3);		
	}	
	
	
	public static void main(String...args) {
		LabelFrame frame = new LabelFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);		
		frame.setVisible(true);
	}
}
