package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Producto;

public class DAOTablaProducto {

	public DAOTablaProducto()
	{

	}

	

	public void agregarProducto(Connection conn, Producto producto)
	{
		String sql = "INSERT INTO PRODUCTO VALUES (?,?,?,?,?,?,?,?)";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, producto.getIdProducto());
			preStat.setString(1, producto.getNombre());
			preStat.setLong(2, producto.getCategoria());
			preStat.setString(3, producto.getDescripcionEsp());
			preStat.setString(4, producto.getDescripcionIng());
			preStat.setInt(5, producto.getTiempo());
			preStat.setDouble(6, producto.getCosto());
			preStat.setDouble(7, producto.getPrecio());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}				
	}
	
	public Producto darProductoPorId(Connection conn, Long id)
	{
		Producto producto = null;
		String sql = "SELECT * FROM PRODUCTO WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, id);
			ResultSet rs = preStat.executeQuery();
			
			while(rs.next())
			{
				Long idProducto = rs.getLong("ID");
				String nombre = rs.getString("NOMBRE");
				Long idCategoria = rs.getLong("ID_CATEGORIA");
				String descripcionEsp = rs.getString("DESCRIPCION_ESP");
				String descripcionIng = rs.getString("DESCRIPCION_ING");
				int tiempo = rs.getInt("TIEMPO");
				double costo = rs.getDouble("COSTO");
				double precio = rs.getDouble("PRECIO");
				producto = new Producto(idProducto, nombre, idCategoria, descripcionEsp, descripcionIng, tiempo, costo, precio);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}
	
	public ArrayList<Producto> darProductosPorNombre(Connection conn, String nombre)
	{
		ArrayList<Producto> productos = new ArrayList<Producto>();

		String sql = "SELECT * FROM PRODUCTO WHERE NOMBRE = ?";

		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(0, nombre);
			ResultSet rs = preStat.executeQuery();

			while (rs.next()) {
				String nombres = rs.getString("NOMBRE");
				Long id = rs.getLong("ID");
				Long idCategoria = rs.getLong("ID_CATEGORIA");
				String descripcionEsp = rs.getString("DESCRIPCION_ESP");
				String descripcionIng = rs.getString("DESCRIPCION_ING");
				int tiempo = rs.getInt("TIEMPO");
				double costo = rs.getDouble("COSTO");
				double precio = rs.getDouble("PRECIO");
				productos.add( new Producto(id, nombres, idCategoria, descripcionEsp, descripcionIng, tiempo, costo, precio));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productos;
	}
	
	public ArrayList<Producto> darProductos(Connection conn) throws SQLException, Exception {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		String sql = "SELECT * FROM PRODUCTO";

		PreparedStatement preStat = conn.prepareStatement(sql);
		ResultSet rs = preStat.executeQuery();

		while (rs.next()) {
			Long id = rs.getLong("ID");
			String nombre = rs.getString("NOMBRE");
			Long idCategoria = rs.getLong("ID_CATEGORIA");
			String descripcionEsp = rs.getString("DESCRIPCION_ESP");
			String descripcionIng = rs.getString("DESCRIPCION_ING");
			int tiempo = rs.getInt("TIEMPO");
			double costo = rs.getDouble("COSTO");
			double precio = rs.getDouble("PRECIO");
			productos.add(new Producto(id, nombre, idCategoria, descripcionEsp, descripcionIng, tiempo, costo, precio));
		}
		return productos;
	}	
	
	public void actualizarProducto(Connection conn, Producto producto)
	{
		String sql = "UPDATE PRODUCTO SET NOMBRE = ?, ID_CATEGORIA = ?, DESCRIPCION_ESP = ?, DESCRIPCION_ING = ?, TIEMPO = ?, COSTO = ?, PRECIO = ? WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setString(0, producto.getNombre());
			preStat.setLong(1, producto.getCategoria());
			preStat.setString(2, producto.getDescripcionEsp());
			preStat.setString(3, producto.getDescripcionIng());
			preStat.setInt(4, producto.getTiempo());
			preStat.setDouble(5, producto.getCosto());
			preStat.setDouble(6, producto.getPrecio());		
			preStat.setLong(7, producto.getIdProducto());	
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void eliminarProducto(Connection conn, Producto producto)
	{
		String sql = "DELETE FROM PRODUCTO WHERE ID = ?";
		try(PreparedStatement preStat = conn.prepareStatement(sql))
		{
			preStat.setLong(0, producto.getIdProducto());
			preStat.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
