package modelo;

public class Rol {
	int id;
	String nombreRol;
	
	public Rol(int id, String nombreRol) {
		this.id = id;
		this.nombreRol = nombreRol;
	}

	//constructor por defecto
	public Rol() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
}
