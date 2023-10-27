package modelo;

// Clase que representa un médico, hereda de Funcionario
public class Medico extends Funcionario {
    
    // Atributos de la clase Medico
    private int id;
    private int funcionarioId;
    private String matricula;
    private DetallesEspecialidad detallesEspecialidad;

    // Constructor de la clase Medico
    public Medico(int id, int funcionarioId, String matricula) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.matricula = matricula;
    }

    // Constructor vacío
    public Medico() {
    }

    // Getter y Setter para el atributo 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para el atributo 'funcionarioId'
    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    // Getter y Setter para el atributo 'matricula'
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Getter y Setter para el atributo 'detallesEspecialidad'
    public DetallesEspecialidad getDetallesEspecialidad() {
        return detallesEspecialidad;
    }

    public void setDetallesEspecialidad(DetallesEspecialidad detallesEspecialidad) {
        this.detallesEspecialidad = detallesEspecialidad;
    }

    // Método para representar al médico como una cadena de texto
    @Override
    public String toString() {
        return "Médico: " + getNombre() + " " + getApellido() + ", Matrícula: " + matricula;
    }
}
