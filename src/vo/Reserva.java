package vo;

import java.sql.Date;

public class Reserva 
{
	
	private Long idReserva;
	
	private Date fecha;
	
	private int numComensales;
	
	private Long idCliente;
	
	private Long idZona;
	
	//TODO completar atributos


	public Reserva(Long idReserva, Date fecha, int numComensales, Long idCliente, Long idZona) {
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.numComensales = numComensales;
		this.idCliente = idCliente;
		this.idZona = idZona;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNumComensales() {
		return numComensales;
	}

	public void setNumComensales(int numComensales) {
		this.numComensales = numComensales;
	}
	
	
	
}
