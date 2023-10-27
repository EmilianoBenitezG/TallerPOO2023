package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;

public class daoLogin {

    Conexion cx;
    
    // Constructor de la clase daoLogin, inicializa la conexi�n a la base de datos.
    public daoLogin() {
        cx = new Conexion();
    }
    
    // Funci�n para realizar el proceso de inicio de sesi�n.
    public String login(String usuario, String contrase�a){
        String rol = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Preparar la sentencia SQL para buscar un usuario con el nombre de usuario y contrase�a proporcionados.
            ps = cx.conectar().prepareStatement("SELECT * FROM Usuario a INNER JOIN Rol b on a.idRol = b.idRol WHERE UPPER(usuario) = ? AND UPPER(contrase�a) = ?");
            ps.setString(1, usuario);
            ps.setString(2, contrase�a);
            rs = ps.executeQuery();
            while(rs.next()) {
                rol = rs.getString("nombreRol");
            }
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error.
        } finally {
            // Cerrar recursos y desconectar la base de datos.
        }
        
        return rol; // Devuelve el rol del usuario (si se encontr� una coincidencia).
    }
}
