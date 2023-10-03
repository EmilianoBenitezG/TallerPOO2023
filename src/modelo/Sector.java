package modelo;

public class Sector {
    private int id;
    private String nombre;
    private String descripcion;
    private String tipo; // Nuevo atributo tipo

    // Constructor
    public Sector(int id, String nombre, String descripcion, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo; // Inicializa el atributo tipo
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Otros métodos específicos del sector

    @Override
    public String toString() {
        return "Sector [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + "]";
    }
}