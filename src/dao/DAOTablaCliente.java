package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Cliente;

public class DAOTablaCliente 
{
	public DAOTablaCliente()
	{
		
	}
	
	public void agregarCliente(Connection conn, Cliente cliente)
	{
		String sql = "INSERT INTO CLIENTE VALUES (?,?,?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, cliente.getCedula());
			preStat.setString(1, cliente.getNombre());
			preStat.setString(2, cliente.getCorreo());
			preStat.setLong(3, cliente.getIdRotonda());
			preStat.executeQuery();
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar rollback
			e.printStackTrace();
		}
	}
	
	public Cliente darClientePorCedula(Connection conn, Long cedula)
	{
		Cliente cliente = null;
		String sql = "SELECT * FROM CLIENTE WHERE CEDULA = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, cedula);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long cedula1 = rs.getLong("CEDULA");
				String nombre = rs.getString("NOMBRE");
				String correo = rs.getString("CORREO");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				cliente = new Cliente(cedula1, nombre, correo, idRotonda);
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cliente;
	}
	
	
	public Cliente darClientePorCorreo(Connection conn, String correo)
	{
		Cliente cliente = null;
		String sql = "SELECT * FROM CLIENTE WHERE CORREO = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(0, correo);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long cedula1 = rs.getLong("CEDULA");
				String nombre = rs.getString("NOMBRE");
				String correo1 = rs.getString("CORREO");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				cliente = new Cliente(cedula1, nombre, correo1, idRotonda);
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cliente;
	}
	
	
	public ArrayList<Cliente> darClientesPorNombre(Connection conn, String nombre)
	{
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM CLIENTE WHERE NOMBRE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(0, nombre);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long cedula = rs.getLong("CEDULA");
				String nombre1 = rs.getString("NOMBRE");
				String correo = rs.getString("CORREO");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				clientes.add(new Cliente(cedula, nombre1, correo, idRotonda));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return clientes;
	}
	
	public ArrayList<Cliente> darClientes(Connection conn)
	{
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM CLIENTE";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long cedula = rs.getLong("CEDULA");
				String nombre1 = rs.getString("NOMBRE");
				String correo = rs.getString("CORREO");
				Long idRotonda = rs.getLong("ID_ROTONDA");
				clientes.add(new Cliente(cedula, nombre1, correo, idRotonda));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return clientes;
	}
	
	public void actualizarCliente(Connection conn, Cliente cliente)
	{
		String sql = "UPDATE CLIENTE SET NOMBRE = ?, CORREO = ?, ID_ROTONDA = ? WHERE CEDULA = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(0,  cliente.getNombre());
			preStat.setString(1, cliente.getCorreo());
			preStat.setLong(2, cliente.getIdRotonda());
			preStat.setLong(3, cliente.getCedula());
			preStat.executeQuery();
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar rollback
			e.printStackTrace();
		}
	}
	
	public void eliminarCliente(Connection conn, Cliente cliente)
	{
		String sql = "DELETE FROM CLIENTE WHERE CEDULA = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, cliente.getCedula());
			preStat.executeQuery();
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar rollback
			e.printStackTrace();
		}
	}

}
