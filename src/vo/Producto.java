package vo;

import org.codehaus.jackson.annotate.JsonProperty;

public class Producto {
	

	@JsonProperty(value="idProducto")
	private Long idProducto;
	

	@JsonProperty(value="nombre")
	private String nombre;
	

	@JsonProperty(value="idCategoria")
	private Long idCategoria;
	

	@JsonProperty(value="descripcionEsp")
	private String descripcionEsp;
	

	@JsonProperty(value="descripcionIng")
	private String descripcionIng;
	

	@JsonProperty(value="tiempo")
	private int tiempo;
	

	@JsonProperty(value="costo")
	private double costo;
	

	@JsonProperty(value="precio")
	private double precio;

	
	
	public Producto(@JsonProperty(value="idProducto")Long idProducto, 
					@JsonProperty(value="nombre")String nombre, 
					@JsonProperty(value="idCategoria")Long idCategoria, 
					@JsonProperty(value="descripcionEsp")String descripcionEsp, 
					@JsonProperty(value="descripcionIng")String descripcionIng, 
					@JsonProperty(value="tiempo")int tiempo, 
					@JsonProperty(value="costo")double costo, 
					@JsonProperty(value="precio")double precio) {
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
