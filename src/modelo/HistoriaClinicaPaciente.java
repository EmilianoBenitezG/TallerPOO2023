package modelo;

import java.util.Date;

public class HistoriaClinicaPaciente {
    private Date fecha;
    private String historialDiagnostico;
    private LugarAtencion lugarAtencion;
    private String ultimoDiagnostico;
    private String resEstudios;
    private String hora;
    
    public enum LugarAtencion {
        HOSPITAL,
        CLINICA,
        DOMICILIO
    }

    // Constructor
    public HistoriaClinicaPaciente(Date fecha, String historialDiagnostico, LugarAtencion lugarAtencion,
            String ultimoDiagnostico, String resEstudios, String hora) {
        this.fecha = fecha;
        this.historialDiagnostico = historialDiagnostico;
        this.lugarAtencion = lugarAtencion;
        this.ultimoDiagnostico = ultimoDiagnostico;
        this.resEstudios = resEstudios;
        this.hora = hora;
    }

    // Getter y Setter para fecha
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para historialDiagnostico
    public String getHistorialDiagnostico() {
        return historialDiagnostico;
    }

    public void setHistorialDiagnostico(String historialDiagnostico) {
        this.historialDiagnostico = historialDiagnostico;
    }

    // Getter y Setter para lugarDeAtencion
    public LugarAtencion getLugarAtencion() {
        return lugarAtencion;
    }

    public void setLugarAtencion(LugarAtencion lugarAtencion) {
        this.lugarAtencion = lugarAtencion;
    }
    
    // Getter y Setter para ultimoDiagnostico
    public String getUltimoDiagnostico() {
        return ultimoDiagnostico;
    }

    public void setUltimoDiagnostico(String ultimoDiagnostico) {
        this.ultimoDiagnostico = ultimoDiagnostico;
    }

    // Getter y Setter para resEstudios
    public String getResEstudios() {
        return resEstudios;
    }

    public void setResEstudios(String resEstudios) {
        this.resEstudios = resEstudios;
    }

    // Getter y Setter para hora
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}