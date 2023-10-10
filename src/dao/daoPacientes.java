package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Paciente;

public class daoPacientes {
    private Conexion cx;

    public daoPacientes() {
        cx = new Conexion();
    }

    public boolean insertarPacientes(Paciente paciente) {
        PreparedStatement ps = null;
        boolean salida = false;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO Pacientes (Nombre, Apellido, FechaNacimiento, Domicilio, DNI, TelFijo, TelCelular, EstadoCivil, Email, PersonaContacto, Estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
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
            int estaVivo = paciente.isEstado() ? 1 : 0;
            ps.setInt(11, estaVivo);
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                salida = true; // Si se inserta con éxito, cambiamos salida a true
            }

            cx.desconectar();
        } catch (SQLException e) {
            // Agregamos un mensaje de error más detallado
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
                paciente.setEstado(rs.getInt("Estado") == 1); // Convertir el valor entero en booleano
                lista.add(paciente);
            }
            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al consultar pacientes: " + e.getMessage());
        }
        return lista;
    }

    public boolean modificarPacientes(Paciente paciente) {
        PreparedStatement ps = null;
        boolean salida = false;
        try {
            ps = cx.conectar().prepareStatement("UPDATE Pacientes SET Nombre=?, Apellido=?, FechaNacimiento=?, Domicilio=?, DNI=?, TelFijo=?, TelCelular=?, EstadoCivil=?, Email=?, PersonaContacto=?, Estado=? WHERE ID=?");
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
            int estaVivo = paciente.isEstado() ? 1 : 0;
            ps.setInt(11, estaVivo);
            ps.setInt(12, paciente.getId());

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                salida = true;
            }

            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al modificar paciente: " + e.getMessage());
        }
        return salida;
    }

    public ArrayList<Paciente> buscarPacientesPorDNI(String dni) {
        ArrayList<Paciente> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT * FROM Pacientes WHERE DNI = ?";
            ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, dni.toUpperCase());

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
                paciente.setEstado(rs.getInt("Estado") == 1); // Convertir el valor entero en booleano
                lista.add(paciente);
            }
        } catch (SQLException e) {
            // Manejo adecuado de la excepción, por ejemplo, registro de error o lanzar excepción personalizada.
            System.err.println("Error al buscar pacientes por DNI: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
            cx.desconectar();
        }
        return lista;
    }
    
    public boolean existePacienteConDNI(String dni) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean existe = false;
        
        try {
            ps = cx.conectar().prepareStatement("SELECT COUNT(*) FROM Pacientes WHERE DNI = ?");
            ps.setString(1, dni.toUpperCase());
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                existe = (count > 0);
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar si existe el paciente con DNI: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
            cx.desconectar();
        }
        return existe;
    }

}


