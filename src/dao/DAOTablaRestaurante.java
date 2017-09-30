package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Restaurante;

public class DAOTablaRestaurante 
{
	public DAOTablaRestaurante()
	{
		
	}
	
	public void agregarRestaurante(Connection conn, Restaurante restaurante)
	{
		String sql = "INSERT INTO RESTAURANTE VALUES (?,?,?,?,?,?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(1, restaurante.getIdRestaurante());
			preStat.setString(2, restaurante.getNombre());
			preStat.setString(3, restaurante.getTipoComida());
			preStat.setString(4, restaurante.getPagWeb());
			preStat.setString(5, restaurante.getEncargado());
			preStat.setLong(6, restaurante.getIdZona());
			preStat.setLong(7, restaurante.getIdRotonda());
			preStat.executeQuery();
			conn.commit();
		}
		catch(SQLException e)
		{
			try 
			{
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}
	
	public Restaurante darRestaurantePorId(Connection conn, Long id)
	{
		Restaurante restaurante = null;
		String sql = "SELECT * FROM RESTAURANTE WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(1, id);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idRestaurante = rs.getLong("ID");
				String nombre = rs.getString("NOMBRE");
				String tipoComida = rs.getString("TIPO_COMIDA");
				String pagWeb = rs.getString("PAGINA_WEB");
				String encargado = rs.getString("ENCARGADO");
				Long idZona = rs.getLong("ID_ZONA");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				restaurante = new Restaurante(idRestaurante, nombre, tipoComida, pagWeb, encargado, idZona, idRotonda);
			}				
			conn.commit();
		}
		catch(SQLException e)
		{
			try 
			{
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
		return restaurante;
	}
	
	public ArrayList<Restaurante> darRestaurantesPorNombre(Connection conn, String nombre)
	{
		ArrayList<Restaurante> restaurantes = new ArrayList<>();
		String sql = "SELECT * FROM RESTAURANTE WHERE NOMBRE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(1, nombre);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idRestaurante = rs.getLong("ID");
				String nombre1 = rs.getString("NOMBRE");
				String tipoComida = rs.getString("TIPO_COMIDA");
				String pagWeb = rs.getString("PAGINA_WEB");
				String encargado = rs.getString("ENCARGADO");
				Long idZona = rs.getLong("ID_ZONA");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				restaurantes.add(new Restaurante(idRestaurante, nombre1, tipoComida, pagWeb, encargado, idZona, idRotonda));
			}	
			conn.commit();
		}
		catch(SQLException e)
		{
			try 
			{
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
		return restaurantes;
	}
	
	public ArrayList<Restaurante> darRestaurantes(Connection conn)
	{
		ArrayList<Restaurante> restaurantes = new ArrayList<>();
		String sql = "SELECT * FROM RESTAURANTE";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idRestaurante = rs.getLong("ID");
				String nombre = rs.getString("NOMBRE");
				String tipoComida = rs.getString("TIPO_COMIDA");
				String pagWeb = rs.getString("PAGINA_WEB");
				String encargado = rs.getString("ENCARGADO");
				Long idZona = rs.getLong("ID_ZONA");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				restaurantes.add(new Restaurante(idRestaurante, nombre, tipoComida, pagWeb, encargado, idZona, idRotonda));
			}	
			conn.commit();
		}
		catch(SQLException e)
		{
			try 
			{
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
		return restaurantes;
	}
	
	public void actualizarRestaurante(Connection conn, Restaurante restaurante)
	{
		String sql = "UPDATE RESTAURANTE SET NOMBRE = ?, ID_ZONA = ?, ID_ROTONDA = ? WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(1, restaurante.getNombre());
			preStat.setLong(2, restaurante.getIdZona());
			preStat.setLong(3, restaurante.getIdRotonda());
			preStat.setLong(4, restaurante.getIdRestaurante());
			preStat.executeQuery();
			conn.commit();
		}
		catch(SQLException e)
		{
			try 
			{
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}
	
	public void eliminarRestaurante(Connection conn, Restaurante restaurante)
	{
		String sql = "DELETE FROM RESTAURANTE WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(1, restaurante.getIdRestaurante());
			preStat.executeQuery();
			conn.commit();
			conn.commit();
		}
		catch(SQLException e)
		{
			try 
			{
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}

}
