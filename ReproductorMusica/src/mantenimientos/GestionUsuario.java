package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConectorBD.MySQLConexion;
import mantenimientos.Usuario;

public class GestionUsuario {
	
	public boolean	 registrarUsuario(Usuario usu) {
		
		Usuario usuario=null;
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
			con = MySQLConexion.getConexion();
			
			String sql = "INSERT INTO Usuario (id_usuario, nombre_usuario, tipo_usuario, contrasenya_usuario, correo_usuario) values (?,?,?,?)";
			
			
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, usu.getIdUsuario());
				pst.setString(2, usu.getNombre_usuario());
				pst.setString(3, usu.getContrasenya_usuario());
				pst.setString(4, usu.getCorreo_usuario());
				pst.execute();
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			
			
			
			
		
	}
	
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
		pst.setString(2, usu.getContrasenya_usuario());
		
		rs = pst.executeQuery();
		
		while(rs.next()) {
			usuario = new Usuario();
			
		}
		
		} catch (Exception e) {
			System.out.println("Error al encontrar el usuario");
		}
			
			
		
		return usuario;
	}
	
}
