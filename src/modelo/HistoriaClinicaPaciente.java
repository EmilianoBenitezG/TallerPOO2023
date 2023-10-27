package modelo;

public class HistoriaClinicaPaciente {
    private int id;
    private int pacienteId;
    private String fecha;
    private String hora;
    private String lugarDeAtencion;
    private String textoMedico;
    private String historialDiagnostico;

    public HistoriaClinicaPaciente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugarDeAtencion() {
        return lugarDeAtencion;
    }

    public void setLugarDeAtencion(String lugarDeAtencion) {
        this.lugarDeAtencion = lugarDeAtencion;
    }

    public String getTextoMedico() {
        return textoMedico;
    }

    public void setTextoMedico(String textoMedico) {
        this.textoMedico = textoMedico;
    }

    public String getHistorialDiagnostico() {
        return historialDiagnostico;
    }

    public void setHistorialDiagnostico(String historialDiagnostico) {
        this.historialDiagnostico = historialDiagnostico;
    }
}