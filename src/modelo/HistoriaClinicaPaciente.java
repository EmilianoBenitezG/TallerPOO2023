package modelo;

public class HistoriaClinicaPaciente {
    private int id;
    private String fecha;
    private String historialDiagnostico;
    private LugarDeAtencion lugarDeAtencion;
    private String ultimoDiagnostico;
    private String resEstudios;
    private String hora;

    // Constructor
    public HistoriaClinicaPaciente() {
    }
    
    public enum LugarDeAtencion {
        CONSULTORIO,
        EMERGENCIA,
        INTERNACIONES
    }

    // Getters y setters para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Getters y setters para fecha
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    // Getters y setters para historial de diagnostico
    public String getHistorialDiagnostico() {
        return historialDiagnostico;
    }

    public void setHistorialDiagnostico(String historialDiagnostico) {
        this.historialDiagnostico = historialDiagnostico;
    }
    
    
    // Getters y setters para lugar de atencion
    public LugarDeAtencion getLugarDeAtencion() {
        return lugarDeAtencion;
    }

    public void setLugarDeAtencion(LugarDeAtencion lugarDeAtencion) {
        this.lugarDeAtencion = lugarDeAtencion;
    }
    
    // Getters y setters para ultimo diagnostico
    public String getUltimoDiagnostico() {
        return ultimoDiagnostico;
    }

    public void setUltimoDiagnostico(String ultimoDiagnostico) {
        this.ultimoDiagnostico = ultimoDiagnostico;
    }
    
    // Getters y setters para resultados de estudios
    public String getResEstudios() {
        return resEstudios;
    }

    public void setResEstudios(String resEstudios) {
        this.resEstudios = resEstudios;
    }
    
    // Getters y setters para hora
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}