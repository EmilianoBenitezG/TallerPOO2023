package dao;

import conexion.Conexion;
import modelo.Especialidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoEspecialidad {
    private Conexion cx;

    // Constructor de la clase daoEspecialidad, inicializa la conexión a la base de datos.
    public daoEspecialidad() {
        cx = new Conexion();
    }

    // Función para cerrar la conexión a la base de datos.
    public void cerrarConexion() {
        cx.desconectar();
    }

    // Función para insertar una nueva especialidad en la base de datos.
    public boolean insertarEspecialidad(Especialidad especialidad) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean exito = false;
        try {
            connection = cx.conectar();
            // Preparar la sentencia SQL para insertar una especialidad en la tabla Especialidades.
            String insertEspecialidadSQL = "INSERT INTO Especialidades (nombreEspecialidad) VALUES (?)";
            ps = connection.prepareStatement(insertEspecialidadSQL);
            ps.setString(1, especialidad.getNombreEspecialidad());
            ps.executeUpdate();

            exito = true;
        } catch (SQLException e) {
            System.err.println("Error al insertar especialidad: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return exito;
    }

    // Función para consultar y retornar la lista de todas las especialidades en la base de datos.
    public ArrayList<Especialidad> consultarEspecialidades() {
        ArrayList<Especialidad> lista = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = cx.conectar();
            // Preparar la sentencia SQL para consultar todas las especialidades.
            ps = connection.prepareStatement("SELECT * FROM Especialidades");
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setId(rs.getInt("id"));
                especialidad.setNombreEspecialidad(rs.getString("nombreEspecialidad"));
                lista.add(especialidad);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar especialidades: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return lista; // Devolver la lista de especialidades consultadas.
    }
}
