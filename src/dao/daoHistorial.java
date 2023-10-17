package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.HistoriaClinicaPaciente;
import modelo.HistoriaClinicaPaciente.LugarDeAtencion;
import conexion.Conexion;

public class daoHistorial {
    private Conexion cx;

    public daoHistorial() {
        cx = new Conexion();
    }

    public ArrayList<HistoriaClinicaPaciente> ConsultaHistorial() {
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
                historial.setHistorialDiagnostico(rs.getString("HistorialDiagnostico"));

                // Obtener el valor del campo LugarDeAtencion desde la base de datos
                String lugarAtencionString = rs.getString("LugarDeAtencion");
                // Verificar si el valor coincide con un enum válido
                try {
                    HistoriaClinicaPaciente.LugarDeAtencion lugarAtencion = HistoriaClinicaPaciente.LugarDeAtencion.valueOf(lugarAtencionString);
                    historial.setLugarDeAtencion(lugarAtencion);
                } catch (IllegalArgumentException e) {
                    // Manejar el caso en el que el valor no coincide con un enum
                    historial.setLugarDeAtencion(HistoriaClinicaPaciente.LugarDeAtencion.CONSULTORIO); // Puedes asignar un valor predeterminado
                }

                historial.setUltimoDiagnostico(rs.getString("UltimoDiagnostico"));
                historial.setResEstudios(rs.getString("ResEstudios"));
                historial.setHora(rs.getString("Hora"));
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
            String sql = "UPDATE HistoriaClinica SET Fecha = ?, HistorialDiagnostico = ?, " +
                         "LugarDeAtencion = ?, UltimoDiagnostico = ?, ResEstudios = ?, Hora = ? " +
                         "WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, historial.getFecha());
            ps.setString(2, historial.getHistorialDiagnostico());
            ps.setString(3, historial.getLugarDeAtencion().name());
            ps.setString(4, historial.getUltimoDiagnostico());
            ps.setString(5, historial.getResEstudios());
            ps.setString(6, historial.getHora());
            ps.setInt(7, historial.getId());

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
            String sql = "INSERT INTO HistoriaClinica (Fecha, HistorialDiagnostico, LugarDeAtencion, UltimoDiagnostico, ResEstudios, Hora) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, historial.getFecha());
            ps.setString(2, historial.getHistorialDiagnostico());
            ps.setString(3, historial.getLugarDeAtencion().name());
            ps.setString(4, historial.getUltimoDiagnostico());
            ps.setString(5, historial.getResEstudios());
            ps.setString(6, historial.getHora());

            int rowsInserted = ps.executeUpdate();
            cx.desconectar();

            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar historial clínico: " + e.getMessage());
            return false;
        }
    }

	public boolean eliminarHistorial(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}