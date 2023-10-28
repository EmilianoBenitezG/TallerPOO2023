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
    
    // Inserta un nuevo paciente en la base de datos
    public boolean insertarPaciente(Paciente paciente) {
        PreparedStatement ps = null;
        boolean salida = false;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO Pacientes (nombre, apellido, fechaNacimiento, domicilio, DNI, telFijo, telCelular, estadoCivil, email, personaContacto,edad, estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, paciente.getNombre().toUpperCase());
            ps.setString(2, paciente.getApellido().toUpperCase().toUpperCase());
            ps.setString(3, paciente.getFechaNacimiento().toUpperCase());
            ps.setString(4, paciente.getDomicilio().toUpperCase());
            ps.setString(5, paciente.getDNI().toUpperCase());
            ps.setString(6, paciente.getTelFijo().toUpperCase());
            ps.setString(7, paciente.getTelCelular().toUpperCase());
            ps.setString(8, paciente.getEstadoCivil().toUpperCase());
            ps.setString(9, paciente.getEmail().toUpperCase());
            ps.setString(10, paciente.getPersonaContacto().toUpperCase());
            Integer edad = paciente.getEdad();
            if(edad == null) {
            	edad = 0;
            }
            ps.setInt(11, edad);
            int estaVivo = paciente.isEstado() ? 1 : 0;
            ps.setInt(12, estaVivo);
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                salida = true;
            }

            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al insertar paciente: " + e.getMessage());
        }
        return salida;
    }
    
    // Consulta y retorna la lista de todos los pacientes
    public ArrayList<Paciente> consultarPacientes() {
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM Pacientes WHERE estado = 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setDNI(rs.getString("DNI"));
                paciente.setTelFijo(rs.getString("telFijo"));
                paciente.setTelCelular(rs.getString("telCelular"));
                paciente.setEstadoCivil(rs.getString("estadoCivil"));
                paciente.setEmail(rs.getString("email"));
                paciente.setPersonaContacto(rs.getString("personaContacto"));
                paciente.setEstado(rs.getInt("estado") == 1);
                lista.add(paciente);
            }
            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al consultar pacientes: " + e.getMessage());
        }
        return lista;
    }
    
    // Modifica un paciente existente en la base de datos
    public boolean modificarPaciente(Paciente paciente) {
        PreparedStatement ps = null;
        boolean salida = false;
        try {
            ps = cx.conectar().prepareStatement("UPDATE Pacientes SET nombre=?, apellido=?, fechaNacimiento=?, domicilio=?, DNI=?, telFijo=?, telCelular=?, estadoCivil=?, email=?, personaContacto=?, estado=?, edad=? WHERE id=?");
            ps.setString(1, paciente.getNombre().toUpperCase());
            ps.setString(2, paciente.getApellido().toUpperCase().toUpperCase());
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
            ps.setInt(12, paciente.getEdad());
            ps.setInt(13, paciente.getId());

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
    
    // Busca pacientes en la base de datos por su n�mero de DNI
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
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setDNI(rs.getString("DNI"));
                paciente.setTelFijo(rs.getString("telFijo"));
                paciente.setTelCelular(rs.getString("telCelular"));
                paciente.setEstadoCivil(rs.getString("estadoCivil"));
                paciente.setEmail(rs.getString("email"));
                paciente.setPersonaContacto(rs.getString("personaContacto"));
                paciente.setEstado(rs.getInt("estado") == 1);
                lista.add(paciente);
            }
        } catch (SQLException e) {
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
    
 // Busca pacientes en la base de datos por su n�mero de DNI
    public ArrayList<Paciente> buscarPacientes() {
        ArrayList<Paciente> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Pacientes";
            ps = cx.conectar().prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setDNI(rs.getString("DNI"));
                paciente.setTelFijo(rs.getString("telFijo"));
                paciente.setTelCelular(rs.getString("telCelular"));
                paciente.setEstadoCivil(rs.getString("estadoCivil"));
                paciente.setEmail(rs.getString("email"));
                paciente.setPersonaContacto(rs.getString("personaContacto"));
                paciente.setEstado(rs.getInt("estado") == 1);
                lista.add(paciente);
            }
        } catch (SQLException e) {
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
    
 // Busca pacientes en la base de datos por su n�mero de DNI
    public ArrayList<Paciente> buscarPacientesEnTriage() {
        ArrayList<Paciente> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Pacientes inner join triage on Pacientes.dni = triage.dni_paciente";
            ps = cx.conectar().prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setDNI(rs.getString("DNI"));
                paciente.setTelFijo(rs.getString("telFijo"));
                paciente.setTelCelular(rs.getString("telCelular"));
                paciente.setEstadoCivil(rs.getString("estadoCivil"));
                paciente.setEmail(rs.getString("email"));
                paciente.setPersonaContacto(rs.getString("personaContacto"));
                paciente.setEstado(rs.getInt("estado") == 1);
                lista.add(paciente);
            }
        } catch (SQLException e) {
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
    
    // Verifica si existe un paciente con el n�mero de DNI
    public boolean existePacienteConDNI(String dni) {
        boolean existe = false;

        try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT COUNT(*) FROM Pacientes WHERE DNI = ?")) {
            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    existe = (count > 0);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar si existe el paciente con DNI: " + e.getMessage());
        } finally {
            cx.desconectar();
        }

        return existe;
    }
    
    // Selecciona un paciente por ID
    public Paciente buscarPacientePorID(int pacienteID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Paciente paciente = null;

        try {
            String sql = "SELECT * FROM Pacientes WHERE id = ?";
            ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, pacienteID);

            rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setDNI(rs.getString("DNI"));
                paciente.setTelFijo(rs.getString("telFijo"));
                paciente.setTelCelular(rs.getString("telCelular"));
                paciente.setEstadoCivil(rs.getString("estadoCivil"));
                paciente.setEmail(rs.getString("email"));
                paciente.setPersonaContacto(rs.getString("personaContacto"));
                paciente.setEstado(rs.getInt("estado") == 1);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar paciente por ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
            cx.desconectar();
        }
        return paciente;
    }

}
