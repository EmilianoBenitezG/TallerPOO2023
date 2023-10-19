package modelo;

public class Admision {
    private int id;
    private Paciente paciente;
    private String motivoConsulta;
    private String fecha;
    private String hora;

    public Admision() {
    }

    public Admision(Paciente paciente, String motivoConsulta, String fecha, String hora) {
        this.paciente = paciente;
        this.motivoConsulta = motivoConsulta;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
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
}
