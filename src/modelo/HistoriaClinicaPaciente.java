package modelo;

public class HistoriaClinicaPaciente {
    private int id; // Identificador de la historia clínica
    private int pacienteId; // Identificador del paciente asociado
    private String fecha; // Fecha de la historia clínica
    private String hora; // Hora de la historia clínica
    private String lugarDeAtencion; // Lugar de atención donde se creó la historia clínica
    private String textoMedico; // Texto generado por el médico
    private String historialDiagnostico; // Historial de diagnósticos y observaciones

    public HistoriaClinicaPaciente() {
    }

    // Getter para el atributo 'id'
    public int getId() {
        return id;
    }

    // Setter para el atributo 'id'
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter para el atributo 'pacienteId'
    public int getPacienteId() {
        return pacienteId;
    }

    // Setter para el atributo 'pacienteId'
    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    // Getter para el atributo 'fecha'
    public String getFecha() {
        return fecha;
    }

    // Setter para el atributo 'fecha'
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Getter para el atributo 'hora'
    public String getHora() {
        return hora;
    }

    // Setter para el atributo 'hora'
    public void setHora(String hora) {
        this.hora = hora;
    }

    // Getter para el atributo 'lugarDeAtencion'
    public String getLugarDeAtencion() {
        return lugarDeAtencion;
    }

    // Setter para el atributo 'lugarDeAtencion'
    public void setLugarDeAtencion(String lugarDeAtencion) {
        this.lugarDeAtencion = lugarDeAtencion;
    }

    // Getter para el atributo 'textoMedico'
    public String getTextoMedico() {
        return textoMedico;
    }

    // Setter para el atributo 'textoMedico'
    public void setTextoMedico(String textoMedico) {
        this.textoMedico = textoMedico;
    }

    // Getter para el atributo 'historialDiagnostico'
    public String getHistorialDiagnostico() {
        return historialDiagnostico;
    }

    // Setter para el atributo 'historialDiagnostico'
    public void setHistorialDiagnostico(String historialDiagnostico) {
        this.historialDiagnostico = historialDiagnostico;
    }
}
