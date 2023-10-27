package modelo;

// Clase que representa los resultados de estudios médicos
public class ResultadosEstudios {
    private int id;                 // Identificador único del resultado
    private String fecha;           // Fecha en la que se realizó el estudio
    private String hora;            // Hora en la que se realizó el estudio
    private String tipoEstudio;     // Tipo de estudio médico realizado
    private String informe;         // Informe o resultados del estudio
    private Paciente paciente;      // Paciente asociado a los resultados
    private HistoriaClinicaPaciente historiaClinica;  // Historia clínica relacionada a los resultados

    // Constructor de la clase con parámetros
    public ResultadosEstudios(String fecha, String hora, String tipoEstudio, String informe, Paciente paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipoEstudio = tipoEstudio;
        this.informe = informe;
        this.paciente = paciente;
    }

    // Constructor vacío de la clase
    public ResultadosEstudios() {
    }

    // Getter y setter para el identificador (id)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters y setters para los atributos de la clase
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

    public String getTipoEstudio() {
        return tipoEstudio;
    }

    public void setTipoEstudio(String tipoEstudio) {
        this.tipoEstudio = tipoEstudio;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public HistoriaClinicaPaciente getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinicaPaciente historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
}
