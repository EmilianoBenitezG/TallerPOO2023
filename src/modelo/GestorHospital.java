package modelo;

import java.util.ArrayList;

public class GestorHospital {
    
    // Consultar cantidad de pacientes en fechas específicas
    public ArrayList<String> cantPacFechas(int ID) {
        ArrayList<String> cantidad = null; // Variable para almacenar la cantidad de pacientes
        return cantidad;
    }
    
    // Consultar cantidad de pacientes en fechas específicas con edades
    public ArrayList<String> cantPacFechasEdades(int ID) {
        ArrayList<String> cantidad = null; // Variable para almacenar la cantidad de pacientes con edades
        return cantidad;
    }
    
    // Consultar pacientes en fechas específicas
    public ArrayList<String> consultaPacFechas(int ID) {
        ArrayList<String> pacientes = null; // Variable para almacenar la información de pacientes
        return pacientes;
    }
    
    // Consultar médicos que atendieron a pacientes en fechas específicas
    public ArrayList<String> medicoAtendioPacFechas(int ID) {
        ArrayList<String> medicos = null; // Variable para almacenar la información de médicos
        return medicos;
    }
    
    // Consultar triajes con colores en fechas específicas
    public ArrayList<String> triageFechasConColores(int ID) {
        ArrayList<String> triajes = null; // Variable para almacenar la información de triajes con colores
        return triajes;
    }
    
    // Consultar cantidad de triajes con colores y propiedades específicas
    public ArrayList<String> cantTriageConColorPropSistColorAsignadoFunc(int ID) {
        ArrayList<String> cantidad = null; // Variable para almacenar la cantidad de triajes con ciertas propiedades
        return cantidad;
    }
}
