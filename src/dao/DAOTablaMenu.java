package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Menu;

public class DAOTablaMenu 
{
	public DAOTablaMenu()
	{
		
	}
	
	public void agregarMenu(Connection conn, Menu menu)
	{
		String sql = "INSERT INTO MENU VALUES (?,?,?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, menu.getIdMenu());
			preStat.setDouble(1, menu.getCosto());
			preStat.setDouble(2, menu.getPrecio());
			preStat.setLong(3, menu.getIdRestaurante());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Menu darMenuPorId(Connection conn, Long id)
	{
		Menu menu = null;
		String sql = "SELECT * FROM MENU WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, id);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idMenu = rs.getLong("ID");
				double costo = rs.getDouble("COSTO");
				double precio = rs.getDouble("PRECIO");
				Long idRestaurante = rs.getLong("ID_RESTAURANTE");
				menu = new Menu(idMenu, costo, precio, idRestaurante);
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return menu;
	}
	
	public ArrayList<Menu> darMenusPorRestaurante(Connection conn, Long idRestaurante)
	{
		ArrayList<Menu> menus = new ArrayList<>();
		String sql = "SELECT * FROM MENU WHERE ID_RESTAURANTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, idRestaurante);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idMenu = rs.getLong("ID");
				double costo = rs.getDouble("COSTO");
				double precio = rs.getDouble("PRECIO");
				Long id = rs.getLong("ID_RESTAURANTE");
				menus.add(new Menu(idMenu, costo, precio, id));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return menus;
	}
	
	public ArrayList<Menu> darMenus(Connection conn)
	{
		ArrayList<Menu> menus = new ArrayList<>();
		String sql = "SELECT * FROM MENU";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idMenu = rs.getLong("ID");
				double costo = rs.getDouble("COSTO");
				double precio = rs.getDouble("PRECIO");
				Long id = rs.getLong("ID_RESTAURANTE");
				menus.add(new Menu(idMenu, costo, precio, id));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return menus;
	}
	
	public void actualizarMenu(Connection conn, Menu menu)
	{
		String sql = "UPDATE MENU SET COSTO = ?, PRECIO = ?, ID_RESTAURANTE = ? WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setDouble(0, menu.getCosto());
			preStat.setDouble(1, menu.getPrecio());
			preStat.setLong(2, menu.getIdRestaurante());
			preStat.setLong(3, menu.getIdMenu());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void eliminarMenu(Connection conn, Menu menu)
	{
		String sql = "DELETE FROM MENU WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, menu.getIdMenu());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
