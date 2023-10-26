package modelo;

public class Funcionario extends Persona{
	private int id;
	private String Puesto;

	public Funcionario() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPuesto() {
		return Puesto;
	}

	public void setPuesto(String puesto) {
		Puesto = puesto;
	}
}
