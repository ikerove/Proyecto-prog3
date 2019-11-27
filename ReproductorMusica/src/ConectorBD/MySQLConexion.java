package ConectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost/BD_Proyecto";
			String usuario = "root";
			String contrasena = "admin";
			
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
}
