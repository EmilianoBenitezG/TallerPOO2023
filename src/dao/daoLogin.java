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
	
	public String login(String usuario, String contraseņa){
		String rol = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=cx.conectar().prepareStatement("SELECT * FROM Usuario WHERE UPPER(usuario) = ? AND UPPER(contraseņa) = ?");
			ps.setString(1, usuario);
			ps.setString(2, contraseņa);
			rs=ps.executeQuery();
			while(rs.next()) {
				rol = rs.getString("idRol");
			}
		} catch (SQLException e) {
			
		}
		
		return rol;
	}
}
