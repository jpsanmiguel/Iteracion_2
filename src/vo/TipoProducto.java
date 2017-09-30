package vo;

public class TipoProducto 
{
	private Long idProducto;
	
	private Long idTipo;

	public TipoProducto(Long idProducto, Long idTipo) {
		this.idProducto = idProducto;
		this.idTipo = idTipo;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}
	
	
}
