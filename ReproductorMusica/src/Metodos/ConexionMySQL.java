package Metodos;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexionMySQL {

	
		
	 	private final String db = "usuario";
	    private final String url = "jdbc:mysql://localhost:3306/"+db;
	    private final String user = "root";
	    private final String pass = "123";
	    //private Connection link = null;

	   public Connection Conectar(){

	       Connection link = null;

	       try{

	           Class.forName("com.mysql.jdbc.Driver");

	           link = DriverManager.getConnection(url, user, pass);

	       }catch(Exception ex){

	           JOptionPane.showMessageDialog(null, ex);

	       }


	       return link;

	   }
	   
	   
}
