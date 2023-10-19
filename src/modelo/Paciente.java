package modelo;

import java.util.List;

public class Paciente extends Persona{
	
	private int id;
	private String personaContacto;
	private boolean estado;
	
	public Paciente(String nombre, String apellido, 
            		String fechaNacimiento, String domicilio, 
            		String DNI, String telFijo, 
            		String telCelular, String estadoCivil, String email,
            		String personaContacto, boolean estado) {
		super(nombre, apellido, fechaNacimiento, 
			  domicilio, DNI, telFijo, telCelular, 
			  estadoCivil, email);
		this.id = -1;
		this.personaContacto = personaContacto;
		this.setEstado(estado);
	}

	public Paciente() {
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String getNombreApellido() {
	    return this.getNombre() + " " + this.getApellido();
	}
	
	@Override
    public String toString() {
        return getNombre() + " " +getApellido() + " - DNI: " + getDNI();
    }
}
