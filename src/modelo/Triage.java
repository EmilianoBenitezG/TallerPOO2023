package modelo;

public class Triage {
	int id;
	String nombre_paciente,resultado_triage;
	
	public Triage() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
