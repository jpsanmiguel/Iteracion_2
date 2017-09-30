package vo;

public class Menu {

	private Long idMenu;
		
	private double costo;
	
	private double precio;
	
	private Long idRestaurante;

	
	
	public Menu(Long idMenu, double costo, double precio, Long idRestaurante) {
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
