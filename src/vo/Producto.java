package vo;

public class Producto {
	
	private Long idProducto;
	
	private String nombre;
	
	private Long idCategoria;
	
	private String descripcionEsp;
	
	private String descripcionIng;
	
	private int tiempo;
	
	private double costo;
	
	private double precio;

	
	
	public Producto(Long idProducto, String nombre, Long idCategoria, String descripcionEsp, String descripcionIng, int tiempo, double costo, double precio) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.idCategoria = idCategoria;
		this.descripcionEsp = descripcionEsp;
		this.descripcionIng = descripcionIng;
		this.tiempo = tiempo;
		this.costo = costo;
		this.precio = precio;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCategoria() {
		return idCategoria;
	}

	public void setCategoria(Long categoria) {
		this.idCategoria = categoria;
	}

	public String getDescripcionEsp() {
		return descripcionEsp;
	}

	public void setDescripcionEsp(String descripcionEsp) {
		this.descripcionEsp = descripcionEsp;
	}

	public String getDescripcionIng() {
		return descripcionIng;
	}

	public void setDescripcionIng(String descripcionIng) {
		this.descripcionIng = descripcionIng;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
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
