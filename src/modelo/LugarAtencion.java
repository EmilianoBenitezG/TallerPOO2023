package modelo;

public enum LugarAtencion { 
	
	CONSULTORIO ("Consultorio"),
	EMERGENCIA ("Emergencia"),
	INTERNACIONALES ("Internacionales");
	
	private String lugarAtencion;

	private LugarAtencion(String lugarAtencion) {
		this.lugarAtencion = lugarAtencion;
	}

	public String getLugarAtencion() {
		return lugarAtencion;
	}

	public void setLugarAtencion(String lugarAtencion) {
		this.lugarAtencion = lugarAtencion;
	}

}