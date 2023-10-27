package modelo;

public class ResultadosEstudios {
	
	private int id;
    private String fecha;
    private String hora;
    private String tipoEstudio;
    private String informe;
    private Paciente paciente;
    private HistoriaClinicaPaciente historiaClinica;

    public ResultadosEstudios(String fecha, String hora, String tipoEstudio, String informe, Paciente paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipoEstudio = tipoEstudio;
        this.informe = informe;
        this.paciente = paciente;
    }
    
	public ResultadosEstudios() {
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
