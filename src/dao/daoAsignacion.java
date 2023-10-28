package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Asignacion;
import modelo.Medico;
import modelo.Paciente;
import modelo.Triage;

public class daoAsignacion {
    private Conexion cx;

    // Constructor de la clase daoAsignacion, inicializa la conexi�n a la base de datos.
    public daoAsignacion() {
        cx = new Conexion();
    }

    // Funci�n para insertar una nueva asignaci�n en la base de datos.
    public boolean insertarAsignacion(Asignacion asignacion) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean salida = false;

        try {
            connection = cx.conectar();
            // Preparar la sentencia SQL para insertar una asignaci�n en la tabla Asignacion.
            ps = connection.prepareStatement("INSERT INTO Asignacion (dni_paciente, matricula_medico, Box, Fecha, Hora, nombre_paciente, nombre_medico) VALUES (?,?,?,?,?,?,?)");

            // Establecer los valores de los par�metros en la sentencia SQL.
            ps.setString(1, asignacion.getPaciente().getDNI());
            ps.setString(2, asignacion.getMedico().getMatricula());
            ps.setString(3, asignacion.getBox());
            ps.setString(4, asignacion.getFecha().toUpperCase());
            ps.setString(5, asignacion.getHora().toUpperCase());
            ps.setString(6, asignacion.getPaciente().getNombre());
            ps.setString(7, asignacion.getMedico().getNombre());

            // Ejecutar la sentencia SQL para insertar la asignaci�n en la base de datos.
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                salida = true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar Asignacion: " + e.getMessage());
        } finally {
            cx.desconectar(); // Cerrar la conexi�n a la base de datos.
        }
        return salida;
    }

    // Funci�n para consultar todas las asignaciones en la base de datos y devolver una lista de objetos Asignacion.
    public ArrayList<Asignacion> ConsultaAsignaciones() {
        ArrayList<Asignacion> lista = new ArrayList<Asignacion>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Preparar la sentencia SQL para consultar todas las asignaciones.
            ps = cx.conectar().prepareStatement("SELECT * FROM Asignacion");
            rs = ps.executeQuery();
            while (rs.next()) {
                Asignacion asignacion = new Asignacion();
                Paciente paciente = new Paciente();
                Medico medico = new Medico();
                paciente.setNombre(rs.getString("nombre_paciente"));
                paciente.setDNI(rs.getString("dni_paciente"));
                medico.setNombre(rs.getString("nombre_medico"));
                medico.setMatricula(rs.getString("matricula_medico"));
                asignacion.setId(rs.getInt("id"));
                asignacion.setPaciente(paciente);
                asignacion.setMedico(medico);
                asignacion.setFecha(rs.getString("fecha"));
                asignacion.setBox(rs.getString("Box"));
                lista.add(asignacion);
            }
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error.
        } finally {
            cx.desconectar(); // Cerrar la conexi�n a la base de datos.
        }

        return lista; // Devolver la lista de asignaciones consultadas.
    }
}
