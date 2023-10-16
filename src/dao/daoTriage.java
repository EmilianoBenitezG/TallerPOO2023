package dao;

import conexion.Conexion;

public class daoTriage {
    private Conexion cx;
    private int puntuacionRespiracion; // Variable para almacenar la puntuación de Respiración
    private int puntuacionFiebre; // Variable para almacenar la puntuación de Fiebre
    private int puntuacionPulso; // Variable para almacenar la puntuación de Pulso
    private int puntuacionDolorPecho; // Variable para almacenar la puntuación de Dolor de Pecho
	private int PuntuacionLesionesGraves;
	private int PuntuacionLesionesLeves;
	private int PuntuacionEstadoMental;
	private int PuntuacionSangrado;
	private int PuntuacionVomitos;
	private int SignosdeShock;
	private int Conciencia;
	

    public daoTriage() {
        cx = new Conexion();
    }

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
    // Otros métodos y lógica que puedas necesitar.

}
