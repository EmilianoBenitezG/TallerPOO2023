package modelo;

public class Admision {
    private int id;               // Atributo: Identificador unico de la admision
    private Paciente paciente;    // Atributo: Paciente asociado a la admision
    private String motivoConsulta; // Atributo: Motivo de la consulta
    private String fecha;         // Atributo: Fecha de la admision
    private String hora;          // Atributo: Hora de la admision

    public Admision() {
    }

    // Constructor que recibe informacion sobre la admision
    public Admision(Paciente paciente, String motivoConsulta, String fecha, String hora) {
        this.paciente = paciente;
        this.motivoConsulta = motivoConsulta;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getter para obtener el valor del atributo "id"
    public int getId() {
        return id;
    }

    // Setter para establecer el valor del atributo "id"
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener el valor del atributo "paciente"
    public Paciente getPaciente() {
        return paciente;
    }

    // Setter para establecer el valor del atributo "paciente"
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Getter para obtener el valor del atributo "motivoConsulta"
    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    // Setter para establecer el valor del atributo "motivoConsulta"
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    // Getter para obtener el valor del atributo "fecha"
    public String getFecha() {
        return fecha;
    }

    // Setter para establecer el valor del atributo "fecha"
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Getter para obtener el valor del atributo "hora"
    public String getHora() {
        return hora;
    }

    // Setter para establecer el valor del atributo "hora"
    public void setHora(String hora) {
        this.hora = hora;
    }
}
