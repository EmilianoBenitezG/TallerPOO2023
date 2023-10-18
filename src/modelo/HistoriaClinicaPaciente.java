package modelo;

public class HistoriaClinicaPaciente {
	
    private int id;
    private String fecha;
    private String hora;
    private String historialDiagnostico;
    private LugarDeAtencion lugarDeAtencion;
    private String ultimoDiagnostico;
    private String resEstudios;

    public HistoriaClinicaPaciente() {
    }

    public enum LugarDeAtencion {
        CONSULTORIO,
        EMERGENCIA,
        INTERNACIONES
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHistorialDiagnostico() {
        return historialDiagnostico;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setHistorialDiagnostico(String historialDiagnostico) {
        this.historialDiagnostico = historialDiagnostico;
    }

    public LugarDeAtencion getLugarDeAtencion() {
        return lugarDeAtencion;
    }

    public void setLugarDeAtencion(LugarDeAtencion lugarDeAtencion) {
        this.lugarDeAtencion = lugarDeAtencion;
    }

    public String getUltimoDiagnostico() {
        return ultimoDiagnostico;
    }

    public void setUltimoDiagnostico(String ultimoDiagnostico) {
        this.ultimoDiagnostico = ultimoDiagnostico;
    }

    public String getResEstudios() {
        return resEstudios;
    }

    public void setResEstudios(String resEstudios) {
        this.resEstudios = resEstudios;
    }
}