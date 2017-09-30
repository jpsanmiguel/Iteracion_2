package vo;

public class Cliente {
	
	private Long cedula;
	
	private String nombre;
	
	private String correo;
	
	private Long idRotonda;
	
	public Cliente(Long cedula, String nombre, String correo, Long idRotonda)
	{
		this.cedula = cedula;
		this.nombre = nombre;
		this.correo = correo;
		this.idRotonda = idRotonda;
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Long getIdRotonda() {
		return idRotonda;
	}

	public void setIdRotonda(Long idRotonda) {
		this.idRotonda = idRotonda;
	}
}
