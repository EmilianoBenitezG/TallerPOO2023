package modelo;

public class Especialidad {
	
	private int id;
    private String nombreEspecialidad;
	
	public Especialidad(int id, String nombreEspecialidad) {
		super();
		this.id = id;
		this.nombreEspecialidad = nombreEspecialidad;
	}
	
	public Especialidad() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
}