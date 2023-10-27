package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.HistoriaClinicaPaciente;
import conexion.Conexion;

public class daoHistorial {
    private Conexion cx;

    public daoHistorial() {
        cx = new Conexion();
    }

    public ArrayList<HistoriaClinicaPaciente> buscarHistorialPorPaciente(int pacienteId) {
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
                HistoriaClinicaPaciente historial = mapearHistorial(rs);
                lista.add(historial);
            }
        } catch (SQLException e) {
            manejarError("Error al buscar historiales clínicos por paciente: " + e.getMessage());
        } finally {
            cerrarRecursos(rs, ps, conn);
        }

        return lista;
    }

    public boolean modificarHistorial(HistoriaClinicaPaciente historial) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = cx.conectar();
            String sql = "UPDATE HistoriaClinica SET Fecha = ?, Hora = ?, LugarDeAtencion = ?, TextoMedico = ?, HistorialDiagnostico = ? WHERE id = ?";
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
            manejarError("Error al modificar historial clínico: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos(null, ps, conn);
        }
    }

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
            manejarError("Error al insertar historial clínico: " + e.getMessage());
            return false;
        } finally {
            cerrarRecursos(null, ps, conn);
        }
    }

    private void manejarError(String mensaje) {
        System.err.println(mensaje);
    }

    private HistoriaClinicaPaciente mapearHistorial(ResultSet rs) throws SQLException {
        HistoriaClinicaPaciente historial = new HistoriaClinicaPaciente();
        historial.setId(rs.getInt("id"));
        historial.setPacienteId(rs.getInt("PacienteId"));
        historial.setFecha(rs.getString("Fecha"));
        historial.setHora(rs.getString("Hora"));
        historial.setLugarDeAtencion(rs.getString("LugarDeAtencion"));
        historial.setTextoMedico(rs.getString("TextoMedico"));
        historial.setHistorialDiagnostico(rs.getString("HistorialDiagnostico"));
        return historial;
    }

    private void cerrarRecursos(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            manejarError("Error al cerrar recursos: " + e.getMessage());
        }
    }
    
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
                historiaClinica = new HistoriaClinicaPaciente();
                historiaClinica.setId(rs.getInt("id"));
                historiaClinica.setPacienteId(rs.getInt("PacienteId"));  // Agregar PacienteId
                historiaClinica.setFecha(rs.getString("Fecha"));
                historiaClinica.setHora(rs.getString("Hora"));
                historiaClinica.setLugarDeAtencion(rs.getString("LugarDeAtencion"));
                historiaClinica.setTextoMedico(rs.getString("TextoMedico"));
                historiaClinica.setHistorialDiagnostico(rs.getString("HistorialDiagnostico"));
            }

            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al buscar historia clínica por ID: " + e.getMessage());
        }

        return historiaClinica;
    }
}
