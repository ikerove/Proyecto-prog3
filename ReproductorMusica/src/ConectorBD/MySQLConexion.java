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
/*	public static Connection getConexion() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost/BD_Proyecto";
			String usuario = "root";
			String contrasena = "";
			
			con = DriverManager.getConnection(url,usuario,contrasena);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectar con la Base de Datos");
 			e.printStackTrace();
		}
		
		
		return con;
	}
}*/
