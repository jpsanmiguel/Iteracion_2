package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Reserva;

public class DAOTablaReserva 
{
	//TODO completar con los atributos
	public DAOTablaReserva()
	{
		
	}
	
	public void agregarReserva(Connection conn, Reserva reserva)
	{
		String sql = "INSERT INTO RESERVA VALUES (?,?,?,?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, reserva.getIdReserva());
			preStat.setDate(1, reserva.getFecha());
			preStat.setInt(2, reserva.getNumComensales());
			preStat.setLong(3, reserva.getIdCliente());
			preStat.setLong(4, reserva.getIdZona());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Reserva darReservaPorId(Connection conn, Long id)
	{
		Reserva reserva = null;
		String sql = "SELECT * FROM RESERVA WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, id);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idReserva = rs.getLong("ID");
				Date fecha = rs.getDate("FECHA");
				int numComensales = rs.getInt("NUM_COMENSALES");
				Long idCliente = rs.getLong("ID_CLIENTE");
				Long idZona = rs.getLong("ID_ZONA");
				reserva = new Reserva(idReserva, fecha, numComensales, idCliente, idZona);
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return reserva;
	}
	
	public ArrayList<Reserva> darReservasPorCliente(Connection conn, Long idCliente)
	{
		ArrayList<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT * FROM RESERVA WHERE ID_CLIENTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, idCliente);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idReserva = rs.getLong("ID");
				Date fecha = rs.getDate("FECHA");
				int numComensales = rs.getInt("NUM_COMENSALES");
				Long id = rs.getLong("ID_CLIENTE");
				Long idZona = rs.getLong("ID_ZONA");
				reservas.add(new Reserva(idReserva, fecha, numComensales, id, idZona));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return reservas;
	}
	
	public ArrayList<Reserva> darReservasPorZona(Connection conn, Long idZona)
	{
		ArrayList<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT * FROM RESERVA WHERE ID_CLIENTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, idZona);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idReserva = rs.getLong("ID");
				Date fecha = rs.getDate("FECHA");
				int numComensales = rs.getInt("NUM_COMENSALES");
				Long idCliente = rs.getLong("ID_CLIENTE");
				Long id = rs.getLong("ID_ZONA");
				reservas.add(new Reserva(idReserva, fecha, numComensales, idCliente, id));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return reservas;
	}
	
	public ArrayList<Reserva> darReservas(Connection conn)
	{
		ArrayList<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT * FROM RESERVA";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idReserva = rs.getLong("ID");
				Date fecha = rs.getDate("FECHA");
				int numComensales = rs.getInt("NUM_COMENSALES");
				Long idCliente = rs.getLong("ID_CLIENTE");
				Long idZona = rs.getLong("ID_ZONA");
				reservas.add(new Reserva(idReserva, fecha, numComensales, idCliente, idZona));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return reservas;
	}
	
	public void actualizarReserva(Connection conn, Reserva reserva)
	{
		String sql = "UPDATE RESERVA SET FECHA = ?, NUM_COMENSALES = ?, ID_CLIENTE = ?, ID_ZONA = ? WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setDate(0, reserva.getFecha());
			preStat.setInt(1, reserva.getNumComensales());
			preStat.setLong(2, reserva.getIdCliente());
			preStat.setLong(3, reserva.getIdZona());
			preStat.setLong(4, reserva.getIdReserva());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void eliminarReserva(Connection conn, Reserva reserva)
	{
		String sql = "DELETE FROM RESERVA WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, reserva.getIdReserva());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
