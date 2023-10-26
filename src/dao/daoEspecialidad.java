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

    public daoEspecialidad() {
        cx = new Conexion();
    }

    public void cerrarConexion() {
        cx.desconectar();
    }

    // Insertar una nueva especialidad
    public boolean insertarEspecialidad(Especialidad especialidad) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean exito = false;
        try {
            connection = cx.conectar();
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

    // Consultar y retornar la lista de todas las especialidades
    public ArrayList<Especialidad> consultarEspecialidades() {
        ArrayList<Especialidad> lista = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = cx.conectar();
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
        return lista;
    }
}