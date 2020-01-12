package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConectorBD.MySQLConexion;

public class SqlUsuarios extends MySQLConexion {

	public boolean	 registrarUsuario(Usuario usu) {
		
		Usuario usuario=null;
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
			con = MySQLConexion.getConexion();
			
			String sql = "INSERT INTO usuario (id_usuario, nombre_usuario, tipo_usuario, contrasenya_usuario, correo_usuario) VALUES (?,?,?,?,?)";
			
			
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, usu.getIdUsuario());
				pst.setString(2, usu.getNombre_usuario());
				pst.setInt(3, usu.getTipo_usuario());
				pst.setString(4, usu.getContrasenya_usuario());
				pst.setString(5, usu.getCorreo_usuario());
				pst.execute();
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			
			
			
			
		
	}
}
