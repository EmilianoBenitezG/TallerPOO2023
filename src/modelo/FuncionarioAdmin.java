package modelo;

public class FuncionarioAdmin {
    private String funcionarioAsociado;
    private Sector sector;

    public FuncionarioAdmin(String funcionarioAsociado, Sector sector) {       
        this.funcionarioAsociado = funcionarioAsociado;
        this.sector = sector;
    }

	public String getFuncionarioAsociado() {
		return funcionarioAsociado;
	}

	public void setFuncionarioAsociado(String funcionarioAsociado) {
		this.funcionarioAsociado = funcionarioAsociado;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	

}