package vo;

import java.sql.Date;

public class OrdenRestaurante {
	
	private Long idOrdenRestaurante;
	
	private Date fecha;
	
	private Long idMenu;

	private Long idRotonda;

	public OrdenRestaurante(Long idOrdenRestaurante, Date fecha, Long idMenu, Long idRotonda) {
		this.idOrdenRestaurante = idOrdenRestaurante;
		this.fecha = fecha;
		this.idMenu = idMenu;
		this.idRotonda = idRotonda;
	}

	public Long getIdOrdenRestaurante() {
		return idOrdenRestaurante;
	}

	public void setIdOrdenRestaurante(Long idOrdenRestaurante) {
		this.idOrdenRestaurante = idOrdenRestaurante;
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}
	
	public Long getIdRotonda() {
		return idRotonda;
	}

	public void setIdRotonda(Long idRotonda) {
		this.idRotonda = idRotonda;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
	
	
}
