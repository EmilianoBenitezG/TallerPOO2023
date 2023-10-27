package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ResultEstudios;
import conexion.Conexion;

public class daoResEstudios {
    private Conexion cx;

    // Constructor de la clase daoResEstudios, inicializa la conexión a la base de datos.
    public daoResEstudios() {
        cx = new Conexion();
    }

    // Consulta y retorna la lista de todos los resultados de estudios.
    public ArrayList<ResultEstudios> consultarResultados() {
        ArrayList<ResultEstudios> lista = new ArrayList<ResultEstudios>();
        Connection conn = cx.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM ResultadoEstudios");
            rs = ps.executeQuery();

            while (rs.next()) {
                ResultEstudios resultado = new ResultEstudios();
                resultado.setId(rs.getInt("id"));
                resultado.setFecha(rs.getString("Fecha"));
                resultado.setHora(rs.getString("Hora"));
                resultado.setTipoEstudio(rs.getString("TipoEstudio"));
                resultado.setInformeEstudios(rs.getString("InformeEstudios"));

                lista.add(resultado);
            }

            cx.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al consultar resultados de estudios: " + e.getMessage());
        }

        return lista;
    }

    // Modifica un resultado de estudios existente en la base de datos.
    public boolean modificarResultado(ResultEstudios resultado) {
        Connection conn = cx.conectar();
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE ResultadoEstudios SET Fecha = ?, Hora = ?, TipoDeEstudio = ?, InformeDeEstudios = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, resultado.getFecha());
            ps.setString(2, resultado.getHora());
            ps.setString(3, resultado.getTipoEstudio());
            ps.setString(4, resultado.getInformeEstudios());
            ps.setInt(5, resultado.getId());

            int rowsUpdated = ps.executeUpdate();
            cx.desconectar();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar resultado de estudios: " + e.getMessage());
            return false;
        }
    }

    // Inserta un nuevo resultado de estudios en la base de datos.
    public boolean insertarResultado(ResultEstudios resultado) {
        Connection conn = cx.conectar();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO ResultadoEstudios (Fecha, Hora, TipoDeEstudio, InformeDeEstudios) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, resultado.getFecha());
            ps.setString(2, resultado.getHora());
            ps.setString(3, resultado.getTipoEstudio());
            ps.setString(4, resultado.getInformeEstudios());

            int rowsInserted = ps.executeUpdate();
            cx.desconectar();

            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar resultado de estudios: " + e.getMessage());
            return false;
        }
    }
}
