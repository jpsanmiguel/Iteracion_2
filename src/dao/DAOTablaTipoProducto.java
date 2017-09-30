package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.TipoProducto;
public class DAOTablaTipoProducto 
{

	public DAOTablaTipoProducto()
	{

	}

	public void agregarTipoProducto(Connection conn, TipoProducto tipoProducto)
	{
		String sql = "INSERT INTO INGREDIENTE_PRODUCTO VALUES (?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, tipoProducto.getIdTipo());
			preStat.setLong(1, tipoProducto.getIdProducto());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<TipoProducto> darTiposProductosPorIdTipo(Connection conn, Long idTipo)
	{
		ArrayList<TipoProducto> tiposProductos = new ArrayList<>();
		String sql = "SELECT * FROM INGREDIENTE_PRODUCTO WHERE ID_INGREDIENTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, idTipo);
			ResultSet rs = preStat.executeQuery();

			while(rs.next())
			{
				Long idTipo1 = rs.getLong("ID_INGREDIENTE");
				Long idProducto = rs.getLong("ID_PRODUCTO");
				tiposProductos.add(new TipoProducto(idTipo1, idProducto));
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tiposProductos;
	}
	
	public ArrayList<TipoProducto> darTiposProductosPorIdProducto(Connection conn, Long idProducto)
	{
		ArrayList<TipoProducto> tiposProductos = new ArrayList<>();
		String sql = "SELECT * FROM INGREDIENTE_PRODUCTO WHERE ID_PRODUCTO = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, idProducto);
			ResultSet rs = preStat.executeQuery();

			while(rs.next())
			{
				Long idTipo = rs.getLong("ID_INGREDIENTE");
				Long idProducto1 = rs.getLong("ID_PRODUCTO");
				tiposProductos.add(new TipoProducto(idTipo, idProducto1));
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tiposProductos;
	}

	public ArrayList<TipoProducto> darTiposProductos(Connection conn)
	{
		ArrayList<TipoProducto> tiposProductos = new ArrayList<>();
		String sql = "SELECT * FROM INGREDIENTE_PRODUCTO";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			ResultSet rs = preStat.executeQuery();

			while(rs.next())
			{
				Long idTipo = rs.getLong("ID_INGREDIENTE");
				Long idProducto = rs.getLong("ID_PRODUCTO");
				tiposProductos.add(new TipoProducto(idTipo, idProducto));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return tiposProductos;
	}

	public void actualizarTipoTipoProducto(Connection conn, TipoProducto tipoProducto)
	{
		String sql = "UPDATE INGREDIENTE_PRODUCTO SET ID_INGREDIENTE = ? WHERE ID_PRODUCTO = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, tipoProducto.getIdTipo());
			preStat.setLong(1, tipoProducto.getIdProducto());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void actualizarProductoTipoProducto(Connection conn, TipoProducto tipoProducto)
	{
		String sql = "UPDATE INGREDIENTE_PRODUCTO SET ID_PRODUCTO = ? WHERE ID_INGREDIENTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, tipoProducto.getIdProducto());
			preStat.setLong(1, tipoProducto.getIdTipo());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void eliminarTipoProducto(Connection conn, TipoProducto tipoProducto)
	{
		String sql = "DELETE FROM INGREDIENTE_PRODUCTO WHERE ID_PRODUCTO = ? AND ID_INGREDIENTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, tipoProducto.getIdProducto());
			preStat.setLong(1, tipoProducto.getIdTipo());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


}
