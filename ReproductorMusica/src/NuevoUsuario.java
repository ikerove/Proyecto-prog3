import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConectorBD.MySQLConexion;
import mantenimientos.GestionUsuario;
import mantenimientos.hash;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class NuevoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txt5;
	private JTextField txt1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnRegistrarse;
	private JPasswordField txtpassword;
	private JPasswordField txtpassword2;
	
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
		setBounds(100, 100, 467, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 19, 424, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo electronico:");
		lblNewLabel.setBounds(41, 143, 122, 27);
		panel.add(lblNewLabel);
		
		txt5 = new JTextField();
		txt5.setBounds(189, 141, 226, 31);
		panel.add(txt5);
		txt5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setBounds(41, 10, 122, 27);
		panel.add(lblNewLabel_1);
		
		txt1 = new JTextField();
		txt1.setBounds(189, 8, 134, 31);
		panel.add(txt1);
		txt1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Contrasena:");
		lblNewLabel_2.setBounds(41, 52, 122, 27);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Repita su Contrasena:");
		lblNewLabel_3.setBounds(41, 101, 134, 27);
		panel.add(lblNewLabel_3);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(189, 50, 200, 29);
		panel.add(txtpassword);
		
		txtpassword2 = new JPasswordField();
		txtpassword2.setBounds(189, 99, 200, 31);
		panel.add(txtpassword2);
		
		lblNewLabel_4 = new JLabel("Bienvenido a Viri, introduzca sus credenciales:");
		lblNewLabel_4.setBounds(5, 5, 424, 14);
		contentPane.add(lblNewLabel_4);
		
		
		
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrarse.setBounds(5, 211, 424, 45);
		contentPane.add(btnRegistrarse);
	
		btnRegistrarse.addActionListener(new ActionListener() {	
			@Override
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				GestionUsuario modSql = new GestionUsuario();
				Usuarios mod = new Usuarios();
				
				String pass =new String(txtpassword.getContrasenya_usuario());
				String passCon = new String(( txtpassword2).getContrasenya_usuario());
				
				if(pass.equals(passCon)) {
					String nuevoPass = hash.sha1(pass);
					
					mod.setNombre_usuario.getText();
					mod.setContrasenya_usuario(nuevoPass);
					mod.setCorreo_usuario.getText();
					mod.setTipo_usuario(1);
				
					if(modSql.registrar(mod)) {
						JOptionPane.showMessageDialog(null, "Nuevo Usuario creado");
						limpiar();
					}else {
						JOptionPane.showMessageDialog(null, "Error al guardar los datos");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Las contrasenyas no coinciden");
				}
				
				
				/*
				l.dispose();
				Logueo.setVisible(true);*/

			} 
			private void limpiar() {
				txt1.setText("");
				txt5.setText("");
				txtpassword.setText("");
				txtpassword2.setText("");
			}
		});
		
		
		
	}
}
