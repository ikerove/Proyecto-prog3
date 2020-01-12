package ConectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	
	private static Connection connection;
	public MySQLConexion() {
		
	}
	public static Connection getConexion(){
		return connection;
	}
	
	public void connect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost/BD_Proyecto";
			String usuario = "root";
			String contrasena = "";
			
			connection = DriverManager.getConnection(url,usuario,contrasena);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
	        connection = null;
	}
}
/*
	private final String base = "usuario";
	private final String user = "admin";
	private final String password = "";
	private final String url = "jdbc:mysql://localhost:3306/"+base;
	private Connection con = null;
	
	public Connection getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
	}
}*/
