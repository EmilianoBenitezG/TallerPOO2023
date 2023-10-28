package modelo;

public class Funcionario extends Persona {
    private int id;        // Atributo: Identificador unico del funcionario
    private String Puesto;  // Atributo: Puesto del funcionario

    // Constructor vacio
    public Funcionario() {
    }

    // Getter para obtener el valor del atributo "id"
    public int getId() {
        return id;
    }

    // Setter para establecer el valor del atributo "id"
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener el valor del atributo "Puesto"
    public String getPuesto() {
        return Puesto;
    }

    // Setter para establecer el valor del atributo "Puesto"
    public void setPuesto(String puesto) {
        Puesto = puesto;
    }
}
