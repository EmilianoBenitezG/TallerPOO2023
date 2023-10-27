package modelo;

// Clase que representa el rol de un usuario
public class Rol {
    int id;             // Identificador �nico del rol
    String nombreRol;   // Nombre del rol, como "administrador", "m�dico", "enfermero", etc.

    // Constructor de la clase con par�metros
    public Rol(int id, String nombreRol) {
        this.id = id;
        this.nombreRol = nombreRol;
    }

    // Constructor por defecto de la clase
    public Rol() {
    }

    // Getter para obtener el identificador (id) del rol
    public int getId() {
        return id;
    }

    // Setter para establecer el identificador (id) del rol
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener el nombre del rol
    public String getNombreRol() {
        return nombreRol;
    }

    // Setter para establecer el nombre del rol
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
