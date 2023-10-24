package modelo;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Funcionario{
	
	private String matricula;
	private List<DetallesEspecialidad> especialidades;
	 
	public Medico() {
		especialidades = new ArrayList<>();
	}
	
	public Medico(String matricula) {
		this.matricula = matricula;
		especialidades = new ArrayList<>();
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public List<DetallesEspecialidad> getEspecialidades() {
        return especialidades;
    }
	
	public void agregarEspecialidad(DetallesEspecialidad especialidad) {
        especialidades.add(especialidad);
    }
}
