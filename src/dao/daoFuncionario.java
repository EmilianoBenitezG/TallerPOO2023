package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Funcionario;

public class daoFuncionario {
    private Conexion cx;

    public daoFuncionario() {
        cx = new Conexion();
    }
    
    // Inserta un nuevo funcionario en la base de datos
    public boolean insertarFuncionario(Funcionario funcionario) {
        PreparedStatement ps = null;
        boolean salida = false;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO Funcionarios (nombre, apellido, fechaNacimiento, domicilio, DNI, telFijo, telCelular, estadoCivil, email, Puesto) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, funcionario.getNombre().toUpperCase());
            ps.setString(2, funcionario.getApellido().toUpperCase().toUpperCase());
            ps.setString(3, funcionario.getFechaNacimiento().toUpperCase());
            ps.setString(4, funcionario.getDomicilio().toUpperCase());
            ps.setString(5, funcionario.getDNI().toUpperCase());
            ps.setString(6, funcionario.getTelFijo().toUpperCase());
            ps.setString(7, funcionario.getTelCelular().toUpperCase());
            ps.setString(8, funcionario.getEstadoCivil().toUpperCase());
            ps.setString(9, funcionario.getEmail().toUpperCase());
            ps.setString(10, funcionario.getPuesto().toUpperCase());
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
    
    // Consulta y retorna la lista de todos los funcionarios
    public ArrayList<Funcionario> consultarFuncionarios() {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM Funcionarios");
            rs = ps.executeQuery();
            while (rs.next()) {
            	Funcionario funcionario = new Funcionario();
            	funcionario.setId(rs.getInt("id"));
            	funcionario.setNombre(rs.getString("nombre"));
                funcionario.setApellido(rs.getString("apellido"));
                funcionario.setFechaNacimiento(rs.getString("fechaNacimiento"));
                funcionario.setDomicilio(rs.getString("domicilio"));
                funcionario.setDNI(rs.getString("DNI"));
                funcionario.setTelFijo(rs.getString("telFijo"));
                funcionario.setTelCelular(rs.getString("telCelular"));
                funcionario.setEstadoCivil(rs.getString("estadoCivil"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setPuesto(rs.getString("Puesto"));
                lista.add(funcionario);
            }
            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al consultar funcionarios: " + e.getMessage());
        }
        return lista;
    }
    
    // Modifica un funcionario existente en la base de datos
    public boolean modificarFuncionario(Funcionario funcionario) {
        PreparedStatement ps = null;
        boolean salida = false;
        try {
            ps = cx.conectar().prepareStatement("UPDATE Funcionarios SET nombre=?, apellido=?, fechaNacimiento=?, domicilio=?, DNI=?, telFijo=?, telCelular=?, estadoCivil=?, email=?, Puesto=? WHERE id=?");
            ps.setString(1, funcionario.getNombre().toUpperCase());
            ps.setString(2, funcionario.getApellido().toUpperCase().toUpperCase());
            ps.setString(3, funcionario.getFechaNacimiento().toUpperCase());
            ps.setString(4, funcionario.getDomicilio().toUpperCase());
            ps.setString(5, funcionario.getDNI().toUpperCase());
            ps.setString(6, funcionario.getTelFijo().toUpperCase());
            ps.setString(7, funcionario.getTelCelular().toUpperCase());
            ps.setString(8, funcionario.getEstadoCivil().toUpperCase());
            ps.setString(9, funcionario.getEmail().toUpperCase());
            ps.setString(10, funcionario.getPuesto().toUpperCase());
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

    // Busca funcionarios en la base de datos por su numero de DNI
    public ArrayList<Funcionario> buscarFuncionarioPorDNI(String dni) {
        ArrayList<Funcionario> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Funcionarios WHERE DNI = ?";
            ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, dni.toUpperCase());

            rs = ps.executeQuery();
            while (rs.next()) {
            	Funcionario funcionario = new Funcionario();
            	funcionario.setId(rs.getInt("id"));
            	funcionario.setNombre(rs.getString("nombre"));
                funcionario.setApellido(rs.getString("apellido"));
                funcionario.setFechaNacimiento(rs.getString("fechaNacimiento"));
                funcionario.setDomicilio(rs.getString("domicilio"));
                funcionario.setDNI(rs.getString("DNI"));
                funcionario.setTelFijo(rs.getString("telFijo"));
                funcionario.setTelCelular(rs.getString("telCelular"));
                funcionario.setEstadoCivil(rs.getString("estadoCivil"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setPuesto(rs.getString("Puesto"));
                lista.add(funcionario);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar funcionario por DNI: " + e.getMessage());
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
    
    // Verifica si existe un funcionario con el numero de DNI
    public boolean existeFuncionarioConDNI(String dni) {
        boolean existe = false;

        try (PreparedStatement ps = cx.conectar().prepareStatement("SELECT COUNT(*) FROM Funcionarios WHERE DNI = ?")) {
            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    existe = (count > 0);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar si existe el funcionario con DNI: " + e.getMessage());
        } finally {
            cx.desconectar();
        }

        return existe;
    }
    
}