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

    public daoAdmision() {
        cx = new Conexion();
    }
    
    public boolean insertarAdmision(Admision admision) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean salida = false;

        try {
            connection = cx.conectar();
            ps = connection.prepareStatement("INSERT INTO Admision (PacienteID, MotivoConsulta, Fecha, Hora) VALUES (?,?,?,?)");
            
            int pacienteID = admision.getPaciente().getId();
            if (pacienteID <= 0) {
                System.err.println("ID de paciente no válido");
                return false;
            }

            ps.setInt(1, pacienteID);
            ps.setString(2, admision.getMotivoConsulta());
            ps.setString(3, admision.getFecha());
            ps.setString(4, admision.getHora());

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                salida = true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar admisión: " + e.getMessage());
        } finally {
            cx.desconectar();
        }

        return salida;
    }

    public ArrayList<Admision> consultarAdmisiones() {
        ArrayList<Admision> lista = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = cx.conectar();
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

                lista.add(admision);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar admisiones: " + e.getMessage());
        } finally {
            cx.desconectar();
        }

        return lista;
    }
}
