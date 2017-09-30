package vo;

public class Tipo
{

	private Long idTipo;
	
	private String nombre;
	
	//TODO completar atributos
	
	public Tipo(Long idTipo, String nombre)
	{
		this.idTipo = idTipo;
		this.nombre = nombre;
	}
	
	public Long getIdTipo()
	{
		return idTipo;
	}
	
	public void setIdTipo(Long idTipo)
	{
		this.idTipo = idTipo;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
}
