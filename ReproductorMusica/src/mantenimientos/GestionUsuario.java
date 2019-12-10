package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ConectorBD.MySQLConexion;
import mantenimientos.Usuario;

public class GestionUsuario {
	
	public Usuario obtenerUsuario(Usuario usu) {
		
		Usuario usuario = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
		con = MySQLConexion.getConexion();
		//String sql = "select*from usuario where usuario = ? and con = ?";
		String sql = "select*from Usuario where nombre_usuario = ? and contrasenya_usuario = ?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1, usu.getNombre_usuario());
		pst.setString(1, usu.getContrasenya_usuario());
		
		rs = pst.executeQuery();
		
		while(rs.next()) {
			usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
			
		}
		
		} catch (Exception e) {
			System.out.println("Error al encontrar el usuario");
		}
			
			
		
		return usuario;
	}
	
}
