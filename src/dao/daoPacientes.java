package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Paciente;
import modelo.Roles;

// Importaciones omitidas para brevedad...

public class daoPacientes {
    private Conexion cx;

    public daoPacientes() {
        cx = new Conexion();
    }

    public boolean insertarPacientes(Paciente paciente) {
        PreparedStatement ps = null;
        boolean salida = false;  // Cambiamos a false inicialmente
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO Pacientes (Nombre, Apellido, FechaNacimiento, Domicilio, DNI, TelFijo, TelCelular, EstadoCivil, Email, PersonaContacto) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, paciente.getNombre().toUpperCase());
            ps.setString(2, paciente.getApellido().toUpperCase());
            ps.setString(3, paciente.getFechaNacimiento().toUpperCase());
            ps.setString(4, paciente.getDomicilio().toUpperCase());
            ps.setString(5, paciente.getDNI().toUpperCase());
            ps.setString(6, paciente.getTelFijo().toUpperCase());
            ps.setString(7, paciente.getTelCelular().toUpperCase());
            ps.setString(8, paciente.getEstadoCivil().toUpperCase());
            ps.setString(9, paciente.getEmail().toUpperCase());
            ps.setString(10, paciente.getPersonaContacto().toUpperCase());
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                salida = true; // Si se inserta con �xito, cambiamos salida a true
            }

            cx.desconectar();
        } catch (SQLException e) {
            // Agregamos un mensaje de error m�s detallado
            System.err.println("Error al insertar paciente: " + e.getMessage());
        }
        return salida;
    }

    public ArrayList<Paciente> ConsultaPacientes() {
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM Pacientes");
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("Nombre"));
                paciente.setApellido(rs.getString("Apellido"));
                paciente.setFechaNacimiento(rs.getString("FechaNacimiento"));
                paciente.setDomicilio(rs.getString("Domicilio"));
                paciente.setDNI(rs.getString("DNI"));
                paciente.setTelFijo(rs.getString("TelFijo"));
                paciente.setTelCelular(rs.getString("TelCelular"));
                paciente.setEstadoCivil(rs.getString("EstadoCivil"));
                paciente.setEmail(rs.getString("Email"));
                paciente.setPersonaContacto(rs.getString("PersonaContacto"));
                lista.add(paciente);
            }
            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al consultar pacientes: " + e.getMessage());
        }
        return lista;
    }
    
    public boolean modificarPacientes (Paciente paciente) {
		PreparedStatement ps = null;
		boolean salida = true;
		try {
			ps=cx.conectar().prepareStatement("UPDATE Pacientes SET nombre = ?, apellido = ?, fechaNacimiento = ?, domicilio = ?, DNI = ?, telFijo = ?, telCelular = ?, estadoCivil = ?, email = ?, personaContacto = ? WHERE iD = ?");
			ps.setString(1, paciente.getNombre().toUpperCase());
            ps.setString(2, paciente.getApellido().toUpperCase());
            ps.setString(3, paciente.getFechaNacimiento().toUpperCase());
            ps.setString(4, paciente.getDomicilio().toUpperCase());
            ps.setString(5, paciente.getDNI().toUpperCase());
            ps.setString(6, paciente.getTelFijo().toUpperCase());
            ps.setString(7, paciente.getTelCelular().toUpperCase());
            ps.setString(8, paciente.getEstadoCivil().toUpperCase());
            ps.setString(9, paciente.getEmail().toUpperCase());
            ps.setString(10, paciente.getPersonaContacto().toUpperCase());
            ps.setInt(11, paciente.getId());
            ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e) {
			salida = false;
			e.printStackTrace();
		}
		return salida;
	}
}
