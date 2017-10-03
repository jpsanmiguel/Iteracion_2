package vo;

import org.codehaus.jackson.annotate.JsonProperty;

public class Menu {

	@JsonProperty(value="idMenu")
	private Long idMenu;
		
	@JsonProperty(value="costo")
	private double costo;
	
	@JsonProperty(value="precio")
	private double precio;
	
	@JsonProperty(value="nombreRestaurante")
	private String nombreRestaurante;

	
	
	public Menu(@JsonProperty(value="idMenu")Long idMenu,
				@JsonProperty(value="costo") double costo, 
				@JsonProperty(value="precio")double precio, 
				@JsonProperty(value= "nombreRestaurante")String nombreRestaurante) {
		this.idMenu = idMenu;
		this.costo = costo;
		this.precio = precio;
		this.nombreRestaurante = nombreRestaurante;
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	

	public String getNombreRestaurante() {
		return nombreRestaurante;
	}

	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
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
