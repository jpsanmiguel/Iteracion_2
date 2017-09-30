package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.IngredienteProducto;
public class DAOTablaIngredienteProducto 
{

	public DAOTablaIngredienteProducto()
	{

	}

	public void agregarIngredienteProducto(Connection conn, IngredienteProducto ingredienteProducto)
	{
		String sql = "INSERT INTO INGREDIENTE_PRODUCTO VALUES (?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, ingredienteProducto.getIdIngrediente());
			preStat.setLong(1, ingredienteProducto.getIdProducto());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<IngredienteProducto> darIngredientesProductosPorIdIngrediente(Connection conn, Long idIngrediente)
	{
		ArrayList<IngredienteProducto> ingredientesProductos = new ArrayList<>();
		String sql = "SELECT * FROM INGREDIENTE_PRODUCTO WHERE ID_INGREDIENTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, idIngrediente);
			ResultSet rs = preStat.executeQuery();

			while(rs.next())
			{
				Long idIngrediente1 = rs.getLong("ID_INGREDIENTE");
				Long idProducto = rs.getLong("ID_PRODUCTO");
				ingredientesProductos.add(new IngredienteProducto(idIngrediente1, idProducto));
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ingredientesProductos;
	}
	
	public ArrayList<IngredienteProducto> darIngredientesProductosPorIdProducto(Connection conn, Long idProducto)
	{
		ArrayList<IngredienteProducto> ingredientesProductos = new ArrayList<>();
		String sql = "SELECT * FROM INGREDIENTE_PRODUCTO WHERE ID_PRODUCTO = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, idProducto);
			ResultSet rs = preStat.executeQuery();

			while(rs.next())
			{
				Long idIngrediente = rs.getLong("ID_INGREDIENTE");
				Long idProducto1 = rs.getLong("ID_PRODUCTO");
				ingredientesProductos.add(new IngredienteProducto(idIngrediente, idProducto1));
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ingredientesProductos;
	}

	public ArrayList<IngredienteProducto> darIngredientesProductos(Connection conn)
	{
		ArrayList<IngredienteProducto> ingredientesProductos = new ArrayList<>();
		String sql = "SELECT * FROM INGREDIENTE_PRODUCTO";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			ResultSet rs = preStat.executeQuery();

			while(rs.next())
			{
				Long idIngrediente = rs.getLong("ID_INGREDIENTE");
				Long idProducto = rs.getLong("ID_PRODUCTO");
				ingredientesProductos.add(new IngredienteProducto(idIngrediente, idProducto));
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ingredientesProductos;
	}

	public void actualizarIngredienteDeIngredienteProducto(Connection conn, IngredienteProducto ingredienteProducto)
	{
		String sql = "UPDATE INGREDIENTE_PRODUCTO SET ID_INGREDIENTE = ? WHERE ID_PRODUCTO = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, ingredienteProducto.getIdIngrediente());
			preStat.setLong(1, ingredienteProducto.getIdProducto());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void actualizarProductoDeIngredienteProducto(Connection conn, IngredienteProducto ingredienteProducto)
	{
		String sql = "UPDATE INGREDIENTE_PRODUCTO SET ID_PRODUCTO = ? WHERE ID_INGREDIENTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, ingredienteProducto.getIdProducto());
			preStat.setLong(1, ingredienteProducto.getIdIngrediente());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void eliminarIngredienteProducto(Connection conn, IngredienteProducto ingredienteProducto)
	{
		String sql = "DELETE FROM INGREDIENTE_PRODUCTO WHERE ID_PRODUCTO = ? AND ID_INGREDIENTE = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, ingredienteProducto.getIdProducto());
			preStat.setLong(1, ingredienteProducto.getIdIngrediente());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


}
