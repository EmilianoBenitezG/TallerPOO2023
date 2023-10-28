package modelo;

// Clase que representa un usuario del sistema
public class Usuario {
    int id;          // Identificador unico del usuario
    String usuario;  // Nombre de usuario
    String contrasenia; // Contrasenia del usuario
    private Rol rol;  // Rol asociado al usuario

    public Usuario() {
    }

    // Getter y Setter para obtener y establecer el identificador (id) del usuario
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para obtener y establecer el nombre de usuario
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter para obtener y establecer la contrasenia del usuario
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // Getter y Setter para obtener y establecer el rol asociado al usuario
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
