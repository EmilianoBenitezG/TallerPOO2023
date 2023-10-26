package modelo;

public class DetallesEspecialidad {
	
	

	private int id;
    private int medicoId;
    private int especialidadId;
    private String fechaObtencion;
    private String universidad;
    private String especialidad;
    
	public DetallesEspecialidad(int id, int medicoId, int especialidadId, 
								String fechaObtencion, String universidad) {
		this.id = id;
		this.medicoId = medicoId;
		this.especialidadId = especialidadId;
		this.fechaObtencion = fechaObtencion;
		this.universidad = universidad;
	}
	
	public DetallesEspecialidad() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(int medicoId) {
		this.medicoId = medicoId;
	}

	public int getEspecialidadId() {
		return especialidadId;
	}

	public void setEspecialidadId(int especialidadId) {
		this.especialidadId = especialidadId;
	}

	public String getFechaObtencion() {
		return fechaObtencion;
	}

	public void setFechaObtencion(String fechaObtencion) {
		this.fechaObtencion = fechaObtencion;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}
