package modelo;

//Clase que representa las variables utilizadas en el sistema de triage
public class VariablesTriage {
    
    private int respiracion;
    private int pulso;
    private int estadoMental;
    private int conciencia;
    private int dolorPecho;
    private int lesionesGraves;
    private int edad;
    private int fiebre;
    private int vomitos;
    private int dolorAbdominal;
    private int signosShock;
    private int lesionesLeves;
    private int sangrado;

    // Constructor que recibe los valores de las variables de triage
    public VariablesTriage(int respiracion, int pulso, int estadoMental, int conciencia, int dolorPechoRespirar, int lesionesGraves, int edad, int fiebre, int vomitos, int dolorAbdominal, int signosShock, int lesionesLeves, int sangrado) 
    {
    		// Asigna y valida cada valor de las variables
    		this.respiracion = validarPuntuacion(respiracion, 0, 2);
            this.pulso = validarPuntuacion(pulso, 0, 1);
            this.estadoMental = validarPuntuacion(estadoMental, 0, 2);
            this.conciencia = validarPuntuacion(conciencia, 0, 3);
            this.dolorPecho = validarPuntuacion(dolorPechoRespirar, 0, 1);
            this.lesionesGraves = validarPuntuacion(lesionesGraves, 0, 2);
            this.edad = validarPuntuacion(edad, 0, 1);
            this.fiebre = validarPuntuacion(fiebre, 0, 2);
            this.vomitos = validarPuntuacion(vomitos, 0, 2);
            this.dolorAbdominal = validarPuntuacion(dolorAbdominal, 0, 2);
            this.signosShock = validarPuntuacion(signosShock, 0, 3);
            this.lesionesLeves = validarPuntuacion(lesionesLeves, 0, 1);
            this.sangrado = validarPuntuacion(sangrado, 0, 2);
    }


 // Método privado para validar que una puntuación se encuentre dentro de un rango
private int validarPuntuacion(int sangrado2, int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

// Método para calcular la puntuación total del sistema de triage
public int calcularPuntuacionTriage() {
    
    int puntuacionTotal = respiracion + pulso + estadoMental + conciencia + dolorPecho + lesionesGraves + edad + fiebre + vomitos + dolorAbdominal + signosShock + lesionesLeves + sangrado;
    
    return puntuacionTotal;
}


// Método para obtener el color según la puntuación calculada    	
public String obtenerColorSegunPuntuacion() {
    int puntuacionTotal = calcularPuntuacionTriage();
    
    if (puntuacionTotal >= 15) {
        return "Rojo";
    } 
    else if (puntuacionTotal >= 10 && puntuacionTotal <= 14) {
        return "Naranja";
    } 
    else if (puntuacionTotal >= 5 && puntuacionTotal <= 9) {
        return "Amarillo";
    } 
    else if (puntuacionTotal >= 0 && puntuacionTotal <= 4) {
        return "Verde";
    } 
    else {
        return "Color no válido";
    	}
	}
}
  
