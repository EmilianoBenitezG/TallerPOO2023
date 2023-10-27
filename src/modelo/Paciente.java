package modelo;

// Clase que representa a un paciente, hereda de Persona
public class Paciente extends Persona {
    
    // Atributos de la clase Paciente
    private int id;
    private String personaContacto;
    private boolean estado;

    // Constructor de la clase Paciente
    public Paciente(String nombre, String apellido, String fechaNacimiento, 
                    String domicilio, String DNI, String telFijo, String telCelular, 
                    String estadoCivil, String email, String personaContacto, boolean estado) {
        // Llama al constructor de la clase base (Persona) y establece valores adicionales
        super(nombre, apellido, fechaNacimiento, domicilio, DNI, telFijo, telCelular, estadoCivil, email);
        this.id = -1; // Inicializa el ID en -1, se espera que se asigne uno válido
        this.personaContacto = personaContacto;
        this.setEstado(estado);
    }

    // Constructor vacío
    public Paciente() {
    }

    // Getter y Setter para el atributo 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Getter y Setter para el atributo 'personaContacto'
    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    // Getter y Setter para el atributo 'estado'
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Método para obtener el nombre y apellido del paciente
    public String getNombreApellido() {
        return this.getNombre() + " " + this.getApellido();
    }

    // Método para representar al paciente como una cadena de texto
    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " - DNI: " + getDNI();
    }
}
