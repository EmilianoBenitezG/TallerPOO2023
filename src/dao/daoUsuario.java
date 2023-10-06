package dao;

import conexion.Conexion;
import modelo.Rol;
import modelo.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoUsuario {
	
	Conexion cx;

	public daoUsuario() {
		cx = new Conexion();
	}
	
	public boolean insertarUsuario (Usuario usuario) {
		PreparedStatement ps = null;
		boolean salida = true;
		try {
			ps=cx.conectar().prepareStatement("INSERT INTO Usuario VALUES (null,?,?,?)");
			ps.setString(1, usuario.getUsuario().toUpperCase());
			ps.setString(2, usuario.getContrase�a().toUpperCase());
			ps.setLong(3, usuario.getRol().getId());
			ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e) {
			salida = false;
		}
		return salida;
	}
	
	public ArrayList<Usuario> ConsultaUsuario(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=cx.conectar().prepareStatement("SELECT * FROM Usuario a INNER JOIN Rol b on a.idRol = b.idRol");
			rs=ps.executeQuery();
			while(rs.next()) {
				Integer idRol = rs.getInt("idRol");
				String nombreRol = rs.getString("nombreRol");
				Rol rol = new Rol(idRol,nombreRol);
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("Usuario"));
				usuario.setContrase�a(rs.getString("Contrase�a"));
				usuario.setRol(rol);
				lista.add(usuario);
			}
		} catch (SQLException e) {
			
		}
		
		return lista;
	}
	
	public boolean eliminarUsuario (int ID) {
		PreparedStatement ps = null;
		boolean salida = true;
		try {
			ps=cx.conectar().prepareStatement("DELETE FROM Usuario WHERE idUsuario = ?");
			ps.setInt(1, ID);
			ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e) {
			salida = false;
		}
		return salida;
	}
	
	public boolean modificarUsuario (Usuario usuario) {
		PreparedStatement ps = null;
		boolean salida = true;
		try {
			ps=cx.conectar().prepareStatement("UPDATE Usuario SET Usuario = ?, Contrase�a = ?, idRol = ? WHERE idUsuario = ?");
			ps.setString(1, usuario.getUsuario().toUpperCase());
			ps.setString(2, usuario.getContrase�a().toUpperCase());
			ps.setLong(3, usuario.getRol().getId());
			ps.setInt(4, usuario.getId());
			ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e) {
			salida = false;
		}
		return salida;
	}
}
