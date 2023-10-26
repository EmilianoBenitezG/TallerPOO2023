package modelo;

public class Medico extends Funcionario{
	
	 	private int id;
	    private int funcionarioId;
	    private String matricula;
	    private DetallesEspecialidad detallesEspecialidad;
		
	    public Medico(int id, int funcionarioId, String matricula) {
			this.id = id;
			this.funcionarioId = funcionarioId;
			this.matricula = matricula;
		}

		public Medico() {
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getFuncionarioId() {
			return funcionarioId;
		}

		public void setFuncionarioId(int funcionarioId) {
			this.funcionarioId = funcionarioId;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		
		public DetallesEspecialidad getDetallesEspecialidad() {
			return detallesEspecialidad;
		}

		public void setDetallesEspecialidad(DetallesEspecialidad detallesEspecialidad) {
			this.detallesEspecialidad = detallesEspecialidad;
		}
		
		@Override
	    public String toString() {
	        return "Médico: " + getNombre() + " " + getApellido() +  ", Matrícula: " + matricula;
	    }
}