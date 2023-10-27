package modelo;

public class Asignacion {
    private int id;            // Atributo: Identificador único de la asignación
    private Paciente paciente; // Atributo: Paciente asociado a la asignación
    private Medico medico;     // Atributo: Médico asociado a la asignación
    private String box;        // Atributo: Ubicación del box para la asignación
    private String fecha;      // Atributo: Fecha de la asignación
    private String hora;       // Atributo: Hora de la asignación

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

    // Getter para obtener el valor del atributo "medico"
    public Medico getMedico() {
        return medico;
    }

    // Setter para establecer el valor del atributo "medico"
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    // Getter para obtener el valor del atributo "box"
    public String getBox() {
        return box;
    }

    // Setter para establecer el valor del atributo "box"
    public void setBox(String box) {
        this.box = box;
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
