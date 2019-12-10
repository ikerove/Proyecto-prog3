

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionUsuario;
import mantenimientos.Usuario;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logueo extends JFrame {

	private JPanel btnLoguear;
	private JPasswordField jpassClave;
	private JTextField textUser;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logueo frame = new Logueo();
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
	public Logueo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 300);
		setResizable(false);
		setLocationRelativeTo (null);
		
		btnLoguear = new JPanel();
		btnLoguear.setBackground(new Color(192, 192, 192));
		btnLoguear.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(btnLoguear);
		btnLoguear.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(114, 24, 189, 22);
		btnLoguear.add(lblLogin);
		
		JLabel lblUser = new JLabel("User :");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setBounds(55, 76, 56, 16);
		btnLoguear.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(55, 119, 97, 16);
		btnLoguear.add(lblPassword);
		
		jpassClave = new JPasswordField();
		jpassClave.setBounds(185, 116, 169, 22);
		btnLoguear.add(jpassClave);
		
		textUser = new JTextField();
		textUser.setBounds(185, 70, 169, 22);
		btnLoguear.add(textUser);
		textUser.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//char [] contrasena = jpassClave.getPassword();
				//String contrasenaFinal = new String (contrasena);
				String contrasenaFinal = String.valueOf(jpassClave.getPassword());
				String user = textUser.getText();
				
				GestionUsuario gestionUsuario = new GestionUsuario();
				
				Usuario usuario2 = new Usuario();
				usuario2.setNombre_usuario(user);
				usuario2.setContrasenya_usuario(contrasenaFinal);
				
				Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
				
				if (usu != null) {
					dispose();
					VentanaPrincipal p = new VentanaPrincipal();
					p.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o Contrasena incorrectos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textUser.setText("");
					jpassClave.setText("");
					textUser.requestFocus();
				}
				
				/*if (textUser.getText().equals("Miguel") && contrasenaFinal.contentEquals("12345")) {
					dispose();
					VentanaPrincipal p = new VentanaPrincipal();
					p.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o Contrasena incorrectos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					textUser.setText("");
					jpassClave.setText("");
					textUser.requestFocus();
				}
				*/
			}
		});
		btnLogin.setBounds(168, 180, 97, 25);
		btnLoguear.add(btnLogin);
	}
	
}
	
