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
	
	// Insertar un nuevo usuario en la base de datos
	public boolean insertarUsuario (Usuario usuario) {
		PreparedStatement ps = null;
		boolean salida = true;
		try {
			// Preparar la sentencia SQL para la inserci�n
			ps=cx.conectar().prepareStatement("INSERT INTO Usuario VALUES (null,?,?,?)");
			ps.setString(1, usuario.getUsuario().toUpperCase());
			ps.setString(2, usuario.getContrasenia().toUpperCase());
			ps.setLong(3, usuario.getRol().getId());
			// Ejecutar la sentencia SQL
			ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e) {
			salida = false;
		}
		return salida;
	}
	
	 // Consultar y retornar la lista de usuarios con informaci�n de roles
	public ArrayList<Usuario> ConsultaUsuario(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			 // Preparar la sentencia SQL para la consulta
			ps=cx.conectar().prepareStatement("SELECT * FROM Usuario a INNER JOIN Rol b on a.idRol = b.idRol");
			rs=ps.executeQuery();
			while(rs.next()) {
				// Obtener los datos del resultado
				Integer idRol = rs.getInt("idRol");
				String nombreRol = rs.getString("nombreRol");
				Rol rol = new Rol(idRol,nombreRol);
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("Usuario"));
				usuario.setContrasenia(rs.getString("Contrase�a"));
				usuario.setRol(rol);
				// Agregar el usuario a la lista
				lista.add(usuario);
			}
		} catch (SQLException e) {
			
		}
		
		return lista;
	}
	
	// Eliminar un usuario por su ID
	public boolean eliminarUsuario (int ID) {
		PreparedStatement ps = null;
		boolean salida = true;
		try {
			 // Preparar la sentencia SQL para eliminar
			ps=cx.conectar().prepareStatement("DELETE FROM Usuario WHERE idUsuario = ?");
			ps.setInt(1, ID);
			// Ejecutar la sentencia SQL
			ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e) {
			salida = false;
		}
		return salida;
	}
	
	 // Modificar un usuario existente en la base de datos
	public boolean modificarUsuario (Usuario usuario) {
		PreparedStatement ps = null;
		boolean salida = true;
		try {
			// Preparar la sentencia SQL para la modificaci�n
			ps=cx.conectar().prepareStatement("UPDATE Usuario SET Usuario = ?, Contrasenia = ?, idRol = ? WHERE idUsuario = ?");
			ps.setString(1, usuario.getUsuario().toUpperCase());
			ps.setString(2, usuario.getContrasenia().toUpperCase());
			ps.setLong(3, usuario.getRol().getId());
			ps.setInt(4, usuario.getId());
			// Ejecutar la sentencia SQL
			ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e) {
			salida = false;
		}
		return salida;
	}
}
