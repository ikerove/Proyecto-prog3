import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NuevoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	
	//private static JFrame Logueo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario frame = new NuevoUsuario(/*Logueo*/);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NuevoUsuario() {
		
		/*	JFrame l = this;
		Logueo = lo;*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 19, 424, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo electronico:");
		lblNewLabel.setBounds(31, 10, 122, 27);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(163, 10, 226, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(31, 59, 122, 27);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 55, 134, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Contrasena:");
		lblNewLabel_2.setBounds(31, 101, 122, 27);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(163, 99, 200, 31);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Repita su Contrasena:");
		lblNewLabel_3.setBounds(31, 143, 122, 27);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(163, 142, 200, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Bienvenido a");
		lblNewLabel_4.setBounds(5, 5, 424, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(5, 211, 424, 45);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textField_2.getText().equals(textField_3.getText())) {
					System.out.println("CORRECTO");
				}
				else {
					System.out.println("INCORRECTO");
				}
				
				/*
				l.dispose();
				Logueo.setVisible(true);*/

			}
		});
		
		
		
	}

}
