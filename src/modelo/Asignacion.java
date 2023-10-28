package modelo;

public class Asignacion {
    private int id;            // Atributo: Identificador unico de la asignacion
    private Paciente paciente; // Atributo: Paciente asociado a la asignacion
    private Medico medico;     // Atributo: Modico asociado a la asignacion
    private String box;        // Atributo: Ubicacion del box para la asignacion
    private String fecha;      // Atributo: Fecha de la asignacion
    private String hora;       // Atributo: Hora de la asignacion

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
