package modelo;

// Clase que representa la información de un triaje
public class Triage {
    int id;                 // Identificador único del triaje
    String nombre_paciente; // Nombre del paciente evaluado en el triaje
    String resultado_triage; // Resultado del triaje, como "Leve", "Moderado", "Grave", etc.
    String fecha_triage;    // Fecha en la que se realizó el triaje
    String hora_triage;     // Hora en la que se realizó el triaje
    String motivo_cambio;   // Motivo de cambio en el triaje, si se actualiza
    String color_final;     // Color final asignado al paciente

    public Triage() {
    }

    // Getter y Setter para obtener y establecer el motivo de cambio del triaje
    public String getMotivo_cambio() {
        return motivo_cambio;
    }

    public void setMotivo_cambio(String motivo_cambio) {
        this.motivo_cambio = motivo_cambio;
    }

    // Getter y Setter para obtener y establecer el color final asignado al paciente
    public String getColor_final() {
        return color_final;
    }

    public void setColor_final(String color_final) {
        this.color_final = color_final;
    }

    // Getter y Setter para obtener y establecer el identificador (id) del triaje
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para obtener y establecer la fecha del triaje
    public String getFecha_triage() {
        return fecha_triage;
    }

    public void setFecha_triage(String fecha_triage) {
        this.fecha_triage = fecha_triage;
    }

    // Getter y Setter para obtener y establecer la hora del triaje
    public String getHora_triage() {
        return hora_triage;
    }

    public void setHora_triage(String hora_triage) {
        this.hora_triage = hora_triage;
    }

    // Getter y Setter para obtener y establecer el nombre del paciente
    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    // Getter y Setter para obtener y establecer el resultado del triaje
    public String getResultado_triage() {
        return resultado_triage;
    }

    public void setResultado_triage(String resultado_triage) {
        this.resultado_triage = resultado_triage;
    }

    private String colorResultado; // Color específico del resultado de triaje

    // Getter y Setter para obtener y establecer el color específico del resultado de triaje
    public String getColorResultado() {
        return colorResultado;
    }

    public void setColorResultado(String colorResultado) {
        this.colorResultado = colorResultado;
    }
}
