package modelo;

import java.util.List;

public class Paciente extends Persona{
	
	private int id;
	private String personaContacto;
	private boolean estado;
	private List<ResultadosEstudios> resultadosEstudios;
	
	public Paciente(String nombre, String apellido, 
            		String fechaNacimiento, String domicilio, 
            		String DNI, String telFijo, 
            		String telCelular, String estadoCivil, String email,
            		String personaContacto, boolean estado, List<ResultadosEstudios> resultadosEstudios) {
		super(nombre, apellido, fechaNacimiento, 
			  domicilio, DNI, telFijo, telCelular, 
			  estadoCivil, email);
		this.id = -1;
		this.personaContacto = personaContacto;
		this.setEstado(estado);
		this.resultadosEstudios = resultadosEstudios;
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
	
	public List<ResultadosEstudios> getResultadosEstudios() {
		return resultadosEstudios;
	}

	public void setResultadosEstudios(List<ResultadosEstudios> resultadosEstudios) {
		this.resultadosEstudios = resultadosEstudios;
	}
}
