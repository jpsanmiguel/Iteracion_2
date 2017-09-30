package vo;

public class Zona 
{

	private Long idZona;
	
	private String nombre;
	
	private boolean esZonaAbierta;
	
	private int capacidad;
	
	private boolean aptoParaTodos;
	
	private String condicionesTecnicas;

	private Long idRotonda;
	
	//TODO completar atributos

	public Zona(Long idZona, String nombre, boolean esZonaAbierta, int capacidad, boolean aptoParaTodos, String condicionesTecnicas, Long idRotonda) {
		this.idZona = idZona;
		this.nombre = nombre;
		this.esZonaAbierta = esZonaAbierta;
		this.capacidad = capacidad;
		this.aptoParaTodos = aptoParaTodos;
		this.condicionesTecnicas = condicionesTecnicas;
		this.idRotonda = idRotonda;
	}	

	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	public Long getIdRotonda() {
		return idRotonda;
	}

	public void setIdRotonda(Long idRotonda) {
		this.idRotonda = idRotonda;
	}

	public boolean isEsZonaAbierta() {
		return esZonaAbierta;
	}

	public void setEsZonaAbierta(boolean esZonaAbierta) {
		this.esZonaAbierta = esZonaAbierta;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isAptoParaTodos() {
		return aptoParaTodos;
	}

	public void setAptoParaTodos(boolean aptoParaTodos) {
		this.aptoParaTodos = aptoParaTodos;
	}

	public String getCondicionesTecnicas() {
		return condicionesTecnicas;
	}

	public void setCondicionesTecnicas(String condicionesTecnicas) {
		this.condicionesTecnicas = condicionesTecnicas;
	}
	
	
}
