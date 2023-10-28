package modelo;

public class DetallesEspecialidad {
    private int id;               // Atributo: Identificador �nico de los detalles de especialidad
    private int medicoId;         // Atributo: Identificador del medico asociado a estos detalles
    private int especialidadId;   // Atributo: Identificador de la especialidad asociada
    private String fechaObtencion; // Atributo: Fecha de obtencion de la especialidad
    private String universidad;    // Atributo: Universidad donde se obtuvo la especialidad
    private String especialidad;   // Atributo: Nombre de la especialidad (puede no estar presente en el constructor)

    // Constructor que recibe todos los atributos
    public DetallesEspecialidad(int id, int medicoId, int especialidadId, String fechaObtencion, String universidad) {
        this.id = id;
        this.medicoId = medicoId;
        this.especialidadId = especialidadId;
        this.fechaObtencion = fechaObtencion;
        this.universidad = universidad;
    }

    // Constructor vacio
    public DetallesEspecialidad() {
    }

    // Getter para obtener el valor del atributo "id"
    public int getId() {
        return id;
    }

    // Setter para establecer el valor del atributo "id"
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener el valor del atributo "medicoId"
    public int getMedicoId() {
        return medicoId;
    }

    // Setter para establecer el valor del atributo "medicoId"
    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    // Getter para obtener el valor del atributo "especialidadId"
    public int getEspecialidadId() {
        return especialidadId;
    }

    // Setter para establecer el valor del atributo "especialidadId"
    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }

    // Getter para obtener el valor del atributo "fechaObtencion"
    public String getFechaObtencion() {
        return fechaObtencion;
    }

    // Setter para establecer el valor del atributo "fechaObtencion"
    public void setFechaObtencion(String fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }

    // Getter para obtener el valor del atributo "universidad"
    public String getUniversidad() {
        return universidad;
    }

    // Setter para establecer el valor del atributo "universidad"
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    // Getter para obtener el valor del atributo "especialidad"
    public String getEspecialidad() {
        return especialidad;
    }

    // Setter para establecer el valor del atributo "especialidad"
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
