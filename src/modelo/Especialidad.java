package modelo;

public class Especialidad {
    private int id;                // Atributo: Identificador unico de la especialidad
    private String nombreEspecialidad; // Atributo: Nombre de la especialidad

    // Constructor que recibe todos los atributos
    public Especialidad(int id, String nombreEspecialidad) {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    // Constructor vacio
    public Especialidad() {
    }

    // Getter para obtener el valor del atributo "id"
    public int getId() {
        return id;
    }

    // Setter para establecer el valor del atributo "id"
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener el valor del atributo "nombreEspecialidad"
    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    // Setter para establecer el valor del atributo "nombreEspecialidad"
    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
}
