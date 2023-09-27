package modelo;

public class Paciente extends Persona{
	
	private int id;
	private String personaContacto;
	
	public Paciente(String nombre, String apellido, 
            		String fechaNacimiento, String domicilio, 
            		String DNI, String telFijo, 
            		String telCelular, String estadoCivil, String email,
            		String personaContacto) {
		super(nombre, apellido, fechaNacimiento, 
			  domicilio, DNI, telFijo, telCelular, 
			  estadoCivil, email);
		this.id = -1;
		this.personaContacto = personaContacto;
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

}
