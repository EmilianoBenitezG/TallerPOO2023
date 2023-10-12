package modelo;

public class HistoriaClinicaPaciente {
    private String fecha;
    private Integer id;
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

    public HistoriaClinicaPaciente(String fecha, Integer id, String historialDiagnostico, LugarAtencion lugarAtencion,
            String ultimoDiagnostico, String resEstudios, String hora) {
        this.fecha = fecha;
        this.id = id;
        this.historialDiagnostico = historialDiagnostico;
        this.lugarAtencion = lugarAtencion;
        this.ultimoDiagnostico = ultimoDiagnostico;
        this.resEstudios = resEstudios;
        this.hora = hora;
    }
    
    

    public HistoriaClinicaPaciente() {
	}



	public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHistorialDiagnostico() {
        return historialDiagnostico;
    }

    public void setHistorialDiagnostico(String historialDiagnostico) {
        this.historialDiagnostico = historialDiagnostico;
    }

    public LugarAtencion getLugarAtencion() {
        return lugarAtencion;
    }

    public void setLugarAtencion(LugarAtencion lugarAtencion) {
        this.lugarAtencion = lugarAtencion;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
