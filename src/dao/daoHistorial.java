package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.HistoriaClinicaPaciente;

public class daoHistorial {
    private Conexion cx;

    public daoHistorial() {
        cx = new Conexion();
    }

    public ArrayList<HistoriaClinicaPaciente> ConsultaHistorial() {
        ArrayList<HistoriaClinicaPaciente> lista = new ArrayList<HistoriaClinicaPaciente>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cx.conectar().prepareStatement("SELECT * FROM HistoriaClinica");
            rs = ps.executeQuery();
            while (rs.next()) {
                HistoriaClinicaPaciente historial = new HistoriaClinicaPaciente();
                historial.setId(rs.getInt("id"));
                historial.setFecha(rs.getString("Fecha"));
                historial.setHistorialDiagnostico(rs.getString("HistorialDiagnostico"));
                
                String lugarAtencionString = rs.getString("LugarAtencion");
                HistoriaClinicaPaciente.LugarAtencion lugarAtencion = HistoriaClinicaPaciente.LugarAtencion.valueOf(lugarAtencionString);
                historial.setLugarAtencion(lugarAtencion);
                
                historial.setUltimoDiagnostico(rs.getString("UltimoDiagnostico"));
                historial.setResEstudios(rs.getString("ResEstudios"));
                historial.setHora(rs.getString("Hora"));

                lista.add(historial);
            }
            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al consultar pacientes: " + e.getMessage());
        }
        return lista;
    }
}
