package vo;

public class Categoria {

	private Long idCategoria;

	private String nombre;

	public Categoria(Long id, String nombre) {
		this.idCategoria = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return idCategoria;
	}

	public void setId(Long id) {
		this.idCategoria = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
