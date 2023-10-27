package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;

public class daoLogin {

    Conexion cx;
    
    // Constructor de la clase daoLogin, inicializa la conexión a la base de datos.
    public daoLogin() {
        cx = new Conexion();
    }
    
    // Función para realizar el proceso de inicio de sesión.
    public String login(String usuario, String contraseña){
        String rol = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Preparar la sentencia SQL para buscar un usuario con el nombre de usuario y contraseña proporcionados.
            ps = cx.conectar().prepareStatement("SELECT * FROM Usuario a INNER JOIN Rol b on a.idRol = b.idRol WHERE UPPER(usuario) = ? AND UPPER(contraseña) = ?");
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            while(rs.next()) {
                rol = rs.getString("nombreRol");
            }
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error.
        } finally {
            // Cerrar recursos y desconectar la base de datos.
        }
        
        return rol; // Devuelve el rol del usuario (si se encontró una coincidencia).
    }
}
