package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.HistoriaClinicaPaciente;
import conexion.Conexion;

//Clase que gestiona las operaciones relacionadas con las historias clinicas de los pacientes
public class daoHistoriaClinica {
    private Conexion cx;

    // Constructor que inicializa la conexion a la base de datos
    public daoHistoriaClinica() {
        cx = new Conexion();
    }

    // Metodo para insertar un nuevo registro de historia clinica en la base de datos
    public boolean insertarHistorial(HistoriaClinicaPaciente historial) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = cx.conectar();
            String sql = "INSERT INTO HistoriaClinica (PacienteId, Fecha, Hora, LugarDeAtencion, TextoMedico, HistorialDiagnostico) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, historial.getPacienteId());
            ps.setString(2, historial.getFecha());
            ps.setString(3, historial.getHora());
            ps.setString(4, historial.getLugarDeAtencion());
            ps.setString(5, historial.getTextoMedico());
            ps.setString(6, historial.getHistorialDiagnostico());
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            manejarError("Error al insertar historia clinica: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos(null, ps, conn);
        }
    }

    // Metodo para modificar un registro de historia clinica existente en la base de datos
    public boolean modificarHistoriaClinica(HistoriaClinicaPaciente historiaClinica) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = cx.conectar();
            String sql = "UPDATE HistoriaClinica SET Fecha=?, Hora=?, LugarDeAtencion=?, TextoMedico=?, HistorialDiagnostico=? WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, historiaClinica.getFecha());
            ps.setString(2, historiaClinica.getHora());
            ps.setString(3, historiaClinica.getLugarDeAtencion());
            ps.setString(4, historiaClinica.getTextoMedico());
            ps.setString(5, historiaClinica.getHistorialDiagnostico());
            ps.setInt(6, historiaClinica.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            manejarError("Error al modificar historia clinica: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos(null, ps, conn);
        }
    }

    // Metodo para buscar todas las historias clinicas de un paciente por su ID
    public ArrayList<HistoriaClinicaPaciente> buscarHistoriaClinicaPorPaciente(int pacienteId) {
        ArrayList<HistoriaClinicaPaciente> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = cx.conectar();
            ps = conn.prepareStatement("SELECT * FROM HistoriaClinica WHERE PacienteId = ?");
            ps.setInt(1, pacienteId);
            rs = ps.executeQuery();

            while (rs.next()) {
                HistoriaClinicaPaciente historiaClinica = mapearHistoriaClinica(rs);
                lista.add(historiaClinica);
            }
        } catch (SQLException e) {
            manejarError("Error al buscar historias clinicas por paciente: " + e.getMessage());
        } finally {
            cerrarRecursos(rs, ps, conn);
        }

        return lista;
    }

    // Metodo para buscar una historia clinica por su ID
    public HistoriaClinicaPaciente buscarHistoriaClinicaPorID(int idHistoriaClinica) {
        HistoriaClinicaPaciente historiaClinica = null;
        Connection conn = cx.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM HistoriaClinica WHERE id = ?");
            ps.setInt(1, idHistoriaClinica);
            rs = ps.executeQuery();

            if (rs.next()) {
                historiaClinica = mapearHistoriaClinica(rs);
            }

            cx.desconectar();
        } catch (SQLException e) {
            manejarError("Error al buscar historia clinica por ID: " + e.getMessage());
        }

        return historiaClinica;
    }

    // Metodo privado para mapear una fila de resultados de la base de datos a un objeto HistoriaClinicaPaciente
    private HistoriaClinicaPaciente mapearHistoriaClinica(ResultSet rs) throws SQLException {
        HistoriaClinicaPaciente historiaClinica = new HistoriaClinicaPaciente();
        historiaClinica.setId(rs.getInt("id"));
        historiaClinica.setPacienteId(rs.getInt("PacienteId"));
        historiaClinica.setFecha(rs.getString("Fecha"));
        historiaClinica.setHora(rs.getString("Hora"));
        historiaClinica.setLugarDeAtencion(rs.getString("LugarDeAtencion"));
        historiaClinica.setTextoMedico(rs.getString("TextoMedico"));
        historiaClinica.setHistorialDiagnostico(rs.getString("HistorialDiagnostico"));
        return historiaClinica;
    }

    // Metodo privado para manejar errores
    private void manejarError(String mensaje) {
        System.err.println(mensaje);
    }

    // Metodo privado para cerrar recursos de base de datos
    private void cerrarRecursos(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            manejarError("Error al cerrar recursos: " + e.getMessage());
        }
    }

    // Metodo privado para obtener el ID de un paciente
    private int obtenerPacienteId(int pacienteId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idPaciente = -1;

        try {
            conn = cx.conectar();
            ps = conn.prepareStatement("SELECT id FROM Pacientes WHERE id = ?");
            ps.setInt(1, pacienteId);
            rs = ps.executeQuery();

            if (rs.next()) {
                idPaciente = rs.getInt("id");
            }
        } catch (SQLException e) {
            manejarError("Error al obtener el PacienteId: " + e.getMessage());
        } finally {
            cerrarRecursos(rs, ps, conn);
        }

        return idPaciente;
    }
    
    public ArrayList<HistoriaClinicaPaciente> buscarHistorialPorPaciente(int idPaciente) {
        ArrayList<HistoriaClinicaPaciente> lista = new ArrayList<HistoriaClinicaPaciente>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = cx.conectar();
            String sql = "SELECT * FROM HistoriaClinica WHERE PacienteId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            rs = ps.executeQuery();
            while (rs.next()) {
                HistoriaClinicaPaciente historial = new HistoriaClinicaPaciente();
                historial.setId(rs.getInt("id"));
                historial.setPacienteId(rs.getInt("PacienteId"));
                historial.setFecha(rs.getString("Fecha"));
                historial.setHora(rs.getString("Hora"));
                historial.setLugarDeAtencion(rs.getString("LugarDeAtencion"));
                historial.setTextoMedico(rs.getString("TextoMedico"));
                historial.setHistorialDiagnostico(rs.getString("HistorialDiagnostico"));
                lista.add(historial);
            }
        } catch (SQLException e) {
            manejarError("Error al buscar historial clinico por paciente: " + e.getMessage());
        } finally {
            cerrarRecursos(rs, ps, conn);
        }
        return lista;
    }
    
    public boolean actualizarHistorial(HistoriaClinicaPaciente historial) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = cx.conectar();
            String sql = "UPDATE HistoriaClinica SET Fecha=?, Hora=?, LugarDeAtencion=?, TextoMedico=?, HistorialDiagnostico=? WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, historial.getFecha());
            ps.setString(2, historial.getHora());
            ps.setString(3, historial.getLugarDeAtencion());
            ps.setString(4, historial.getTextoMedico());
            ps.setString(5, historial.getHistorialDiagnostico());
            ps.setInt(6, historial.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            manejarError("Error al actualizar historial clinico: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos(null, ps, conn);
        }
    }

}
