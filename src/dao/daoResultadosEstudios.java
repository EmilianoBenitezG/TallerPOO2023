package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.HistoriaClinicaPaciente;
import modelo.ResultadosEstudios;

public class daoResultadosEstudios {
    private Conexion cx;

    public daoResultadosEstudios() {
        cx = new Conexion();
    }

    // Funcion para cerrar los recursos (ResultSet, PreparedStatement, Connection).
    private void cerrarRecursos(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    // Inserta un resultado de estudios en la base de datos y lo asocia con una historia clinica.
    public boolean insertarResultado(ResultadosEstudios resultadoEstudios, int idHistoriaClinica) {
        PreparedStatement ps = null;
        boolean salida = false;
        Connection conn = cx.conectar();

        try {
            ps = conn.prepareStatement("INSERT INTO ResultadosEstudios (fecha, hora, tipoEstudio, informe, id_historia_clinica) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, resultadoEstudios.getFecha());
            ps.setString(2, resultadoEstudios.getHora());
            ps.setString(3, resultadoEstudios.getTipoEstudio());
            ps.setString(4, resultadoEstudios.getInforme());
            ps.setInt(5, idHistoriaClinica);

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                salida = true;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar resultado de estudio: " + e.getMessage());
        } finally {
            cerrarRecursos(null, ps, conn);
        }
        return salida;
    }

    // Obtiene una lista de resultados de estudios asociados a un paciente a traves de su ID.
    public ArrayList<ResultadosEstudios> obtenerResultadosPorPaciente(int idPaciente) {
        ArrayList<ResultadosEstudios> resultadosEstudios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conn = cx.conectar();

        try {
            ps = conn.prepareStatement("SELECT * FROM ResultadosEstudios WHERE id_historia_clinica IN (SELECT id FROM HistoriaClinica WHERE PacienteId = ?)");
            ps.setInt(1, idPaciente);
            rs = ps.executeQuery();

            while (rs.next()) {
                ResultadosEstudios resultado = new ResultadosEstudios();
                resultado.setId(rs.getInt("id"));
                resultado.setFecha(rs.getString("fecha"));
                resultado.setHora(rs.getString("hora"));
                resultado.setTipoEstudio(rs.getString("tipoEstudio"));
                resultado.setInforme(rs.getString("informe"));
                int idHistoriaClinica = rs.getInt("id_historia_clinica");
                resultadosEstudios.add(resultado);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener resultados de estudios: " + e.getMessage());
        } finally {
            cerrarRecursos(rs, ps, conn);
        }
        return resultadosEstudios;
    }

    // Esta funcion busca resultados de estudios por paciente.
    public ArrayList<ResultadosEstudios> buscarResultadosEstudiosPorPaciente(int pacienteId) {
        ArrayList<ResultadosEstudios> resultados = new ArrayList<>();
        return resultados;
    }
    
    // Obtiene una lista de resultados de estudios asociados a una consulta de historial clinico.
    public ArrayList<ResultadosEstudios> buscarResultadosEstudiosPorConsulta(int historialId) {
        ArrayList<ResultadosEstudios> resultados = new ArrayList<>();
        Connection conn = cx.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM ResultadosEstudios WHERE id_historia_clinica = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, historialId);
            rs = ps.executeQuery();

            while (rs.next()) {
                ResultadosEstudios resultado = new ResultadosEstudios();
                resultado.setId(rs.getInt("id"));
                resultado.setFecha(rs.getString("fecha"));
                resultado.setHora(rs.getString("hora"));
                resultado.setTipoEstudio(rs.getString("tipoEstudio"));
                resultado.setInforme(rs.getString("informe"));
                resultados.add(resultado);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener resultados de estudios: " + e.getMessage());
        } finally {
            cerrarRecursos(rs, ps, conn);
        }

        return resultados;
    }
}
