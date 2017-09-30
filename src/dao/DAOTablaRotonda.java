package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Rotonda;

public class DAOTablaRotonda 
{
	public DAOTablaRotonda()
	{

	}

	public void agregarRotonda(Connection conn, Rotonda rotonda)
	{
		String sql = "INSERT INTO ROTONDA VALUES (?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, rotonda.getId());
			preStat.setString(1, rotonda.getNombre());
			preStat.executeQuery();
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}

	public Rotonda darRotondaPorId(Connection conn, Long id)
	{
		Rotonda rotonda = null;
		String sql = "SELECT * FROM ROTONDA WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, id);
			ResultSet rs = preStat.executeQuery();
			while(rs.next())
			{
				Long id1 = rs.getLong("ID");
				String nombre = rs.getString("NOMBRE");
				rotonda = new Rotonda(id1, nombre);
			}
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return rotonda;
	}

	public ArrayList<Rotonda> darRotondasPorNombre(Connection conn, String nombre)
	{
		ArrayList<Rotonda> rotondas = new ArrayList<>();
		String sql = "SELECT * FROM ROTONDA WHERE NOMBRE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(0, nombre);
			ResultSet rs = preStat.executeQuery();
			while(rs.next())
			{
				Long id = rs.getLong("ID");
				String nombre1 = rs.getString("NOMBRE");
				rotondas.add(new Rotonda(id, nombre1));
			}
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return rotondas;
	}

	public ArrayList<Rotonda> darRotondas(Connection conn)
	{
		ArrayList<Rotonda> rotondas = new ArrayList<>();
		String sql = "SELECT * FROM ROTONDA";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			ResultSet rs = preStat.executeQuery();
			while(rs.next())
			{
				Long id = rs.getLong("ID");
				String nombre = rs.getString("NOMBRE");
				rotondas.add(new Rotonda(id, nombre));
			}
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return rotondas;
	}

	public void actualizarRotonda(Connection conn, Rotonda rotonda)
	{
		String sql = "UPDATE ROTONDA SET NOMBRE = ? WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(0, rotonda.getNombre());
			preStat.setLong(1, rotonda.getId());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public void eliminarRotonda(Connection conn, Rotonda rotonda)
	{
		String sql = "DELETE FROM ROTONDA WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, rotonda.getId());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
}
