package vo;

public class Ingrediente 
{

	private Long idIngrediente;
	
	private String nombre;
	
	private String descripcionEsp;
	
	private String descripcionIng;
	
		
	
	
	public Ingrediente(Long idIngrediente, String nombre, String descripcionEsp, String descripcionIng) {
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
		this.descripcionEsp = descripcionEsp;
		this.descripcionIng = descripcionIng;
	}

	public Long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	

}
