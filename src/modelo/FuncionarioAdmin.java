package modelo;

public class FuncionarioAdmin {
    private String funcionarioAsociado;  // Atributo: Funcionario asociado al administrador
    private Sector sector;               // Atributo: Sector al que pertenece el administrador

    // Constructor que recibe el funcionario asociado y el sector
    public FuncionarioAdmin(String funcionarioAsociado, Sector sector) {       
        this.funcionarioAsociado = funcionarioAsociado;
        this.sector = sector;
    }

    // Getter para obtener el valor del atributo "funcionarioAsociado"
    public String getFuncionarioAsociado() {
        return funcionarioAsociado;
    }

    // Setter para establecer el valor del atributo "funcionarioAsociado"
    public void setFuncionarioAsociado(String funcionarioAsociado) {
        this.funcionarioAsociado = funcionarioAsociado;
    }

    // Getter para obtener el valor del atributo "sector"
    public Sector getSector() {
        return sector;
    }

    // Setter para establecer el valor del atributo "sector"
    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
