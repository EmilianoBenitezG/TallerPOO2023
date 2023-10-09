package modelo;

import java.util.Date;

public class DetallesEspecialidad {
	
	private Date fechasTitulo;
	private String universidad;
	
	public DetallesEspecialidad(Date fechasTitulo, String universidad) {
		
		this.fechasTitulo = fechasTitulo;
		this.universidad = universidad;
		
	}

	public Date getFechasTitulo() {
		return fechasTitulo;
	}

	public void setFechasTitulo(Date fechasTitulo) {
		this.fechasTitulo = fechasTitulo;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
}
