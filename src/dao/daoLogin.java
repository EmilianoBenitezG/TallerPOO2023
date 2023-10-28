package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;

public class daoLogin {

    Conexion cx;
    
    // Constructor de la clase daoLogin, inicializa la conexion a la base de datos.
    public daoLogin() {
        cx = new Conexion();
    }
    
    // Funcion para realizar el proceso de inicio de sesion.
    public String login(String usuario, String contrasenia){
        String rol = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Preparar la sentencia SQL para buscar un usuario con el nombre de usuario y contrasenia proporcionados.
            ps = cx.conectar().prepareStatement("SELECT * FROM Usuario a INNER JOIN Rol b on a.idRol = b.idRol WHERE UPPER(usuario) = ? AND UPPER(contrasenia) = ?");
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            while(rs.next()) {
                rol = rs.getString("nombreRol");
            }
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error.
        } finally {
            // Cerrar recursos y desconectar la base de datos.
        }
        
        return rol; // Devuelve el rol del usuario (si se encontro una coincidencia).
    }
}
