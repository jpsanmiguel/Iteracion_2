package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.OrdenRestaurante;

public class DAOTablaOrdenRestaurante 
{
	public DAOTablaOrdenRestaurante()
	{
		
	}
	
	public void agregarOrdenRestaurante(Connection conn, OrdenRestaurante ordenRestaurante)
	{
		String sql = "INSERT INTO ORDEN_RESTAURANTE VALUES (?,?,?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, ordenRestaurante.getIdOrdenRestaurante());
			preStat.setDate(1, ordenRestaurante.getFecha());
			preStat.setLong(2, ordenRestaurante.getIdMenu());
			preStat.setLong(3, ordenRestaurante.getIdRotonda());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public OrdenRestaurante darOrdenRestaurantePorId(Connection conn, Long id)
	{
		OrdenRestaurante ordenRestaurante = null;
		String sql = "SELECT * FROM ORDEN_RESTAURANTE WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, id);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idOrdenRestaurante = rs.getLong("ID");
				Date fecha = rs.getDate("FECHA");
				Long idMenu = rs.getLong("ID_MENU");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				ordenRestaurante = new OrdenRestaurante(idOrdenRestaurante, fecha, idMenu, idRotonda);
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ordenRestaurante;
	}
	
	
	public ArrayList<OrdenRestaurante> darOrdenRestaurantesPorMenu(Connection conn, Long idMenu)
	{
		ArrayList<OrdenRestaurante> ordenRestaurantes = new ArrayList<>();
		String sql = "SELECT * FROM ORDEN_RESTAURANTE WHERE ID_RESTAURANTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, idMenu);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long id = rs.getLong("ID");
				Date fecha = rs.getDate("FECHA");
				Long idMenu1 = rs.getLong("ID_MENU");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				ordenRestaurantes.add(new OrdenRestaurante(id, fecha, idMenu1, idRotonda));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ordenRestaurantes;
	}
	
	public ArrayList<OrdenRestaurante> darOrdenRestaurantes(Connection conn)
	{
		ArrayList<OrdenRestaurante> ordenRestaurantes = new ArrayList<>();
		String sql = "SELECT * FROM ORDEN_RESTAURANTE";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long id = rs.getLong("ID");
				Date fecha = rs.getDate("FECHA");
				Long idMenu = rs.getLong("ID_MENU");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				ordenRestaurantes.add(new OrdenRestaurante(id, fecha, idMenu, idRotonda));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ordenRestaurantes;
	}
	
	public void actualizarOrdenRestaurante(Connection conn, OrdenRestaurante ordenRestaurante)
	{
		String sql = "UPDATE ORDEN_RESTAURANTE SET FECHA = ?, ID_MENU = ?, ID_ROTONDA = ? WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setDate(0, ordenRestaurante.getFecha());
			preStat.setLong(1, ordenRestaurante.getIdMenu());
			preStat.setLong(2, ordenRestaurante.getIdRotonda());
			preStat.setLong(3, ordenRestaurante.getIdOrdenRestaurante());
			preStat.executeQuery();
			conn.commit();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void eliminarOrdenRestaurante(Connection conn, OrdenRestaurante ordenRestaurante)
	{
		String sql = "DELETE FROM ORDEN_RESTAURANTE WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, ordenRestaurante.getIdOrdenRestaurante());
			preStat.executeQuery();
			conn.commit();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}