package vo;

public class IngredienteProducto {
	
	private Long idIngrediente;
	
	private Long idProducto;

	public IngredienteProducto(Long idIngrediente, Long idProducto) {
		this.idIngrediente = idIngrediente;
		this.idProducto = idProducto;
	}

	public Long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}	

}
