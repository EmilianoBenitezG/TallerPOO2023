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

    public ArrayList<HistoriaClinicaPaciente> consultarHistorial() {
        ArrayList<HistoriaClinicaPaciente> lista = new ArrayList<HistoriaClinicaPaciente>();
        Connection conn = cx.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM HistoriaClinica");
            rs = ps.executeQuery();

            while (rs.next()) {
                HistoriaClinicaPaciente historial = new HistoriaClinicaPaciente();
                historial.setId(rs.getInt("id"));
                historial.setFecha(rs.getString("Fecha"));
                historial.setHora(rs.getString("Hora"));
                historial.setLugarDeAtencion(rs.getString("LugarDeAtencion"));
                historial.setTextoMedico(rs.getString("TextoMedico"));
                historial.setHistorialDiagnostico(rs.getString("HistorialDiagnostico"));

                lista.add(historial);
            }

            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al consultar historiales clínicos: " + e.getMessage());
        }

        return lista;
    }

    public boolean modificarHistorial(HistoriaClinicaPaciente historial) {
        Connection conn = cx.conectar();
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE HistoriaClinica SET Fecha = ?, Hora = ?, HistorialDiagnostico = ?, LugarDeAtencion = ?, TextoMedico = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, historial.getFecha());
            ps.setString(2, historial.getHora());
            ps.setString(3, historial.getLugarDeAtencion());
            ps.setString(4, historial.getTextoMedico());
            ps.setString(5, historial.getHistorialDiagnostico());
            ps.setInt(6, historial.getId());

            int rowsUpdated = ps.executeUpdate();
            cx.desconectar();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar historial clínico: " + e.getMessage());
            return false;
        }
    }

    public boolean insertarHistorial(HistoriaClinicaPaciente historial) {
        Connection conn = cx.conectar();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO HistoriaClinica (Fecha, Hora, HistorialDiagnostico, LugarDeAtencion, TextoMedico) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, historial.getFecha());
            ps.setString(2, historial.getHora());
            ps.setString(4, historial.getLugarDeAtencion());
            ps.setString(5, historial.getTextoMedico());
            ps.setString(3, historial.getHistorialDiagnostico());

            int rowsInserted = ps.executeUpdate();
            cx.desconectar();

            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar historial clínico: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarHistorial(int id) {
        // Implementa la lógica para eliminar un historial clínico por ID si es necesario
        return false;
    }

	public ArrayList<HistoriaClinicaPaciente> ConsultaHistorial() {
		// TODO Auto-generated method stub
		return null;
	}
}
