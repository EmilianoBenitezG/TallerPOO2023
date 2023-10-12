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
                String lugarAtencionString = rs.getString("LugarDeAtencion");
                LugarDeAtencion lugarAtencion = LugarDeAtencion.valueOf(lugarAtencionString);
                historial.setLugarDeAtencion(lugarAtencion);
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
}