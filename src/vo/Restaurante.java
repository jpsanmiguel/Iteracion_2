package vo;

public class Restaurante 
{

	private Long idRestaurante;
	
	private String nombre;
	
	private String tipoComida;
	
	private String pagWeb;
	
	private String encargado;
	
	private Long idZona;
	
	private Long idRotonda;

	public Restaurante(Long idRestaurante, String nombre, String tipoComida, String pagWeb, String encargado, Long idZona, Long idRotonda) {
		this.idRestaurante = idRestaurante;
		this.nombre = nombre;
		this.tipoComida = tipoComida;
		this.pagWeb = pagWeb;
		this.encargado = encargado;
		this.idZona = idZona;
		this.idRotonda = idRotonda;
	}

	public Long getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	public Long getIdRotonda() {
		return idRotonda;
	}

	public void setIdRotonda(Long idRotonda) {
		this.idRotonda = idRotonda;
	}

	public String getTipoComida() {
		return tipoComida;
	}

	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	public String getPagWeb() {
		return pagWeb;
	}

	public void setPagWeb(String pagWeb) {
		this.pagWeb = pagWeb;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}	
	
}
