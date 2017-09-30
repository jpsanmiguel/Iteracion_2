package vo;

import org.codehaus.jackson.annotate.JsonProperty;

public class Menu {

	@JsonProperty(value="idMenu")
	private Long idMenu;
		
	@JsonProperty(value="costo")
	private double costo;
	
	@JsonProperty(value="precio")
	private double precio;
	
	@JsonProperty(value="idRestaurante")
	private Long idRestaurante;

	
	
	public Menu(@JsonProperty(value="idMenu")Long idMenu,
				@JsonProperty(value="costo") double costo, 
				@JsonProperty(value="precio")double precio, 
				@JsonProperty(value="idRestaurante")Long idRestaurante) {
		this.idMenu = idMenu;
		this.costo = costo;
		this.precio = precio;
		this.idRestaurante = idRestaurante;
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public Long getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}	
	
	
	
}
