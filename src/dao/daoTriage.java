package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class daoTriage {
    private Conexion cx;

    public daoTriage() {
        cx = new Conexion();
    }

    // Método para almacenar el resultado de triaje en la base de datos
    public boolean almacenarResultadoTriage(String nombrePaciente, int resultadoTriage) {
        String sql = "INSERT INTO Triage (nombre_paciente, resultado_triage) VALUES (?, ?)";

        try (Connection connection = cx.conectar();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombrePaciente);
            pstmt.setInt(2, resultadoTriage);

            // Ejecutar la consulta
            pstmt.executeUpdate();

            return true; // Éxito al almacenar el resultado de triaje
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error al almacenar el resultado de triaje
        }
    }
 
        
        private int puntuacionRespiracion;
		private int puntuacionFiebre;
		private int puntuacionPulso;
		private int puntuacionDolorPecho;
		private int PuntuacionLesionesGraves;
		private int PuntuacionLesionesLeves;
		private int PuntuacionEstadoMental;
		private int PuntuacionSangrado;
		private int PuntuacionVomitos;
		private int SignosdeShock;
		private int Conciencia;

    // Métodos para establecer la puntuación de cada síntoma
    public void setPuntuacionRespiracion(int puntuacionRespiracion) {
        this.puntuacionRespiracion = puntuacionRespiracion;
    }
    
    public void setPuntuacionFiebre(int puntuacionFiebre) {
        this.puntuacionFiebre = puntuacionFiebre;
    }

    public void setPuntuacionPulso(int puntuacionPulso) {
        this.puntuacionPulso = puntuacionPulso;
    }

    public void setPuntuacionDolorPecho(int puntuacionDolorPecho) {
        this.puntuacionDolorPecho = puntuacionDolorPecho;
    }

    public void setPuntuacionLesionesGraves(int puntuacionLesionesGraves) {
    	this.PuntuacionLesionesGraves = puntuacionLesionesGraves;
    }
    
    public void setPuntuacionLesionesLeves(int puntuacionLesionesLeves) {
    	this.PuntuacionLesionesLeves = puntuacionLesionesLeves;
    }
    
    public void setPuntuacionEstadoMental(int puntuacionEstadoMental) {
    	this.PuntuacionEstadoMental = puntuacionEstadoMental;
    }
    
    public void setPuntuacionSangrado(int puntuacionSangrado) {
    	this.PuntuacionSangrado = puntuacionSangrado;
    }
    
    public void setPuntuacionVomitos(int puntuacionVomitos) {
    	this.PuntuacionVomitos = puntuacionVomitos;
    }
    
    public void setPuntuacionSignosdeShock(int puntuacionSignosdeShock) {
    	this.SignosdeShock = puntuacionSignosdeShock;
    }
    
    public void setPuntuacionConciencia(int puntuacionConciencia) {
    	this.Conciencia = puntuacionConciencia;
    }
    
}
