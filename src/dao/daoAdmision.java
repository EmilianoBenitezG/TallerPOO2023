package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.Conexion;
import modelo.Admision;
import modelo.Paciente;

public class daoAdmision {
    private Conexion cx;

    // Constructor de la clase daoAdmision, inicializa la conexio a la base de datos.
    public daoAdmision() {
        cx = new Conexion();
    }
    
    // Funcion para insertar una nueva admision en la base de datos.
    public boolean insertarAdmision(Admision admision) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean salida = false;

        try {
            connection = cx.conectar();
            // Preparar la sentencia SQL para insertar una admision en la tabla Admision.
            ps = connection.prepareStatement("INSERT INTO Admision (PacienteID, NombreApellido, DNI, MotivoConsulta, Fecha, Hora) VALUES (?,?,?,?,?,?)");
            
            // Obtener el ID del paciente y verificar si es valido.
            int pacienteID = admision.getPaciente().getId();
            if (pacienteID <= 0) {
                System.err.println("ID de paciente no válido");
                return false;
            }
            // Establecer los valores de los parametros en la sentencia SQL.
            ps.setInt(1, pacienteID);
            ps.setString(2, admision.getPaciente().getNombreApellido());
            ps.setString(3, admision.getPaciente().getDNI());
            ps.setString(4, admision.getMotivoConsulta().toUpperCase());
            ps.setString(5, admision.getFecha().toUpperCase());
            ps.setString(6, admision.getHora().toUpperCase());

            // Ejecutar la sentencia SQL para insertar la admision en la base de datos.
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                salida = true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar admision: " + e.getMessage());
        } finally {
            cx.desconectar(); // Cerrar la conexion a la base de datos.
        }
        return salida;
    }

    // Funcion para consultar todas las admisiones en la base de datos y devolver una lista de objetos Admision.
    public ArrayList<Admision> consultarAdmisiones() {
        ArrayList<Admision> lista = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = cx.conectar();
            // Preparar la sentencia SQL para consultar informacion de admisiones y pacientes.
            ps = connection.prepareStatement("SELECT Admision.ID, Admision.MotivoConsulta, Admision.Fecha, Admision.Hora, Pacientes.Nombre, Pacientes.Apellido, Pacientes.DNI FROM Admision INNER JOIN Pacientes ON Admision.PacienteID = Pacientes.ID");
            rs = ps.executeQuery();
            while (rs.next()) {
                Admision admision = new Admision();
                admision.setId(rs.getInt("ID"));
                admision.setMotivoConsulta(rs.getString("MotivoConsulta"));
                admision.setFecha(rs.getString("Fecha"));
                admision.setHora(rs.getString("Hora"));

                Paciente paciente = new Paciente();
                paciente.setNombre(rs.getString("Nombre"));
                paciente.setApellido(rs.getString("Apellido"));
                paciente.setDNI(rs.getString("DNI"));
                admision.setPaciente(paciente);

                lista.add(admision); // Agregar la admision a la lista de resultados.
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar admisiones: " + e.getMessage());
        } finally {
            cx.desconectar(); // Cerrar la conexion a la base de datos.
        }
        return lista; // Devolver la lista de admisiones consultadas.
    }
}
