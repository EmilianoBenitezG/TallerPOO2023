package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;

public class daoLogin {

	Conexion cx;
	
	public daoLogin() {
		cx = new Conexion();
	}
	
	public String login(String usuario, String contraseña){
		String rol = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=cx.conectar().prepareStatement("SELECT * FROM Usuario a INNER JOIN Rol b on a.idRol = b.idRol WHERE UPPER(usuario) = ? AND UPPER(contraseña) = ?");
			ps.setString(1, usuario);
			ps.setString(2, contraseña);
			rs=ps.executeQuery();
			while(rs.next()) {
				rol = rs.getString("nombreRol");
			}
		} catch (SQLException e) {
			
		}
		
		return rol;
	}
}
