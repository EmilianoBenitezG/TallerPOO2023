package modelo;

public class Triage {
	int id;
	String nombre_paciente,resultado_triage,fecha_triage,hora_triage,motivo_cambio,color_final;
	
	public Triage() {
	}
	
	public String getMotivo_cambio() {
		return motivo_cambio;
	}

	public void setMotivo_cambio(String motivo_consulta) {
		this.motivo_cambio = motivo_consulta;
	}

	public String getColor_final() {
		return color_final;
	}

	public void setColor_final(String color_final) {
		this.color_final = color_final;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha_triage() {
		return fecha_triage;
	}

	public void setFecha_triage(String fecha_triage) {
		this.fecha_triage = fecha_triage;
	}

	public String getHora_triage() {
		return hora_triage;
	}

	public void setHora_triage(String hora_triage) {
		this.hora_triage = hora_triage;
	}

	public String getNombre_paciente() {
		return nombre_paciente;
	}
	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}
	public String getResultado_triage() {
		return resultado_triage;
	}
	public void setResultado_triage(String resultado_triage) {
		this.resultado_triage = resultado_triage;
	}
	private String colorResultado;

	public String getColorResultado() {
	    return colorResultado;
	}

	public void setColorResultado(String colorResultado) {
	    this.colorResultado = colorResultado;
	}

}
