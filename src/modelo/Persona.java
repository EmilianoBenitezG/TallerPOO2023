package modelo;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String domicilio;
	private String DNI;
	private String telFijo;
	private String telCelular;
	private String estadoCivil;
	private String email;
	
	
	public Persona() {
	}

	public Persona(String nombre, String apellido, 
				   String fechaNacimiento, String domicilio, 
				   String nroDNI, String telFijo, 
				   String telCelular, String estadoCivil, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.DNI = nroDNI;
		this.telFijo = telFijo;
		this.telCelular = telCelular;
		this.estadoCivil = estadoCivil;
		this.email = email;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getTelFijo() {
		return telFijo;
	}

	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
