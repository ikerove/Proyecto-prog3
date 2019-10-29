import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrueba extends JFrame {
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	public VentanaPrueba() {
		Container av = this.getContentPane();
		av.setLayout(new GridLayout(1, 2));
		
		
		b1 = new JButton("|<");
		b2 = new JButton(">");
		b3 = new JButton(">|");
		
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		
		
		this.setTitle("Ventana Principal");
		
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100,100,600,300);
		this.setVisible(true);
	}
	
	
public static void main(String[] args) {
	VentanaPrueba vp = new VentanaPrueba();
}
}
