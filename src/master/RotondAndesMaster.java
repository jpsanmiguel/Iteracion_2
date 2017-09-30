package master;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.DAOTablaCategoria;
import dao.DAOTablaCliente;
import dao.DAOTablaIngrediente;
import dao.DAOTablaIngredienteProducto;
import dao.DAOTablaMenu;
import dao.DAOTablaProducto;
import vo.Categoria;
import vo.Cliente;
import vo.Ingrediente;
import vo.IngredienteProducto;
import vo.Producto;
import vo.Menu;

public class RotondAndesMaster 
{
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "\\conexion.properties";
	
	private String url;
	
	private String user;
	
	private String password;
	
	private String driver;
	
	public RotondAndesMaster(String path)
	{
		connectionData(path);
	}

	private Connection crearConexion() throws SQLException
	{
		return DriverManager.getConnection(url, user, password);
	}

	private void connectionData(String path) 
	{
		File arch = new File(path + CONNECTION_DATA_FILE_NAME_REMOTE);
		Properties prop = new Properties();
		try(FileInputStream in = new FileInputStream(arch))
		{
			prop.load(in);
			url = prop.getProperty("url");
			user = prop.getProperty("usuario");
			password = prop.getProperty("clave");
			driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  Inicio metodos Categoria	----------------------------------
	
	//TODO metodos categoria
	
	// ----------------------------------   Fin metodos Categoria	----------------------------------
	
	public void crearCategoria(Categoria categoria)
	{
		DAOTablaCategoria dao = new DAOTablaCategoria();
		try(Connection conn = crearConexion())
		{
			dao.agregarCategoria(conn, categoria);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}

	public Categoria darCategoriaPorId(Long id)
	{
		Categoria categoria = null;
		DAOTablaCategoria dao = new DAOTablaCategoria();
		try(Connection conn = crearConexion())
		{
			categoria = dao.darCategoriaPorId(conn, id);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return categoria;		
	}
	
	public ArrayList<Categoria> darCategoriaPorNombre(String nombre)
	{
		ArrayList<Categoria> categorias = new ArrayList<>();
		DAOTablaCategoria dao = new DAOTablaCategoria();
		try(Connection conn = crearConexion())
		{
			categorias = dao.darCategoriasPorNombre(conn, nombre);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return categorias;		
	}
	
	public ArrayList<Categoria> darCategorias()
	{
		ArrayList<Categoria> categorias = new ArrayList<>();
		DAOTablaCategoria dao = new DAOTablaCategoria();
		try(Connection conn = crearConexion())
		{
			categorias = dao.darCategorias(conn);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return categorias;
	}
	
	public void actualizarCategoria(Categoria categoria)
	{
		DAOTablaCategoria dao = new DAOTablaCategoria();
		try(Connection conn = crearConexion())
		{
			dao.actualizarCategoria(conn, categoria);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public void eliminarCategoria(Categoria categoria)
	{
		DAOTablaCategoria dao = new DAOTablaCategoria();
		try(Connection conn = crearConexion())
		{
			dao.eliminarCategoria(conn, categoria);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	// ----------------------------------	Inicio metodos Cliente	----------------------------------
	
	public void crearCliente(Cliente cliente)
	{
		DAOTablaCliente dao = new DAOTablaCliente();
		try(Connection conn = crearConexion())
		{
			dao.agregarCliente(conn, cliente);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public Cliente darClientePorCedula(Long cedula)
	{
		Cliente cliente = null;
		DAOTablaCliente dao = new DAOTablaCliente();
		try(Connection conn = crearConexion())
		{
			cliente = dao.darClientePorCedula(conn, cedula);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return cliente;
	}
	
	public Cliente darClientePorCorreo(String correo)
	{
		Cliente cliente = null;
		DAOTablaCliente dao = new DAOTablaCliente();
		try(Connection conn = crearConexion())
		{
			cliente = dao.darClientePorCorreo(conn, correo);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return cliente;
	}
	
	public ArrayList<Cliente> darClientePorNombre(String nombre)
	{
		ArrayList<Cliente> cliente = null;
		DAOTablaCliente dao = new DAOTablaCliente();
		try(Connection conn = crearConexion())
		{
			cliente = dao.darClientesPorNombre(conn, nombre);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return cliente;
	}
	
	public ArrayList<Cliente> darClientes()
	{
		ArrayList<Cliente> cliente = null;
		DAOTablaCliente dao = new DAOTablaCliente();
		try(Connection conn = crearConexion())
		{
			cliente = dao.darClientes(conn);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return cliente;
	}
	
	public void actualizarCliente(Cliente cliente)
	{
		DAOTablaCliente dao = new DAOTablaCliente();
		try(Connection conn = crearConexion())
		{
			dao.actualizarCliente(conn, cliente);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public void eliminarCliente(Cliente cliente)
	{
		DAOTablaCliente dao = new DAOTablaCliente();
		try(Connection conn = crearConexion())
		{
			dao.eliminarCliente(conn, cliente);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	// ----------------------------------	 Fin metodos Cliente	----------------------------------
	
	// ---------------------------------- Inicio metodos Ingrediente ----------------------------------
	
	public void crearIngrediente(Ingrediente ingrediente)
	{
		DAOTablaIngrediente dao = new DAOTablaIngrediente();
		try(Connection conn = crearConexion())
		{
			dao.agregarIngrediente(conn, ingrediente);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}

	public Ingrediente darIngredientePorId(Long id)
	{
		Ingrediente ingrediente = null;
		DAOTablaIngrediente dao = new DAOTablaIngrediente();
		try(Connection conn = crearConexion())
		{
			ingrediente = dao.darIngredientePorId(conn, id);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return ingrediente;		
	}
	
	public ArrayList<Ingrediente> darIngredientePorNombre(String nombre)
	{
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		DAOTablaIngrediente dao = new DAOTablaIngrediente();
		try(Connection conn = crearConexion())
		{
			ingredientes = dao.darIngredientesPorNombre(conn, nombre);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return ingredientes;		
	}
	
	public ArrayList<Ingrediente> darIngredientes()
	{
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		DAOTablaIngrediente dao = new DAOTablaIngrediente();
		try(Connection conn = crearConexion())
		{
			ingredientes = dao.darIngredientes(conn);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return ingredientes;
	}
	
	public void actualizarIngrediente(Ingrediente ingrediente)
	{
		DAOTablaIngrediente dao = new DAOTablaIngrediente();
		try(Connection conn = crearConexion())
		{
			dao.actualizarIngrediente(conn, ingrediente);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public void eliminarIngrediente(Ingrediente ingrediente)
	{
		DAOTablaIngrediente dao = new DAOTablaIngrediente();
		try(Connection conn = crearConexion())
		{
			dao.eliminarIngrediente(conn, ingrediente);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  Fin metodos Ingrediente	----------------------------------
	
	
	// ----------------------------------Inicio metodos IngredienteProducto	----------------------------------
	
	public void crearIngredienteProducto(IngredienteProducto ingredienteProducto)
	{
		DAOTablaIngredienteProducto dao = new DAOTablaIngredienteProducto();
		try(Connection conn = crearConexion())
		{
			dao.agregarIngredienteProducto(conn, ingredienteProducto);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public ArrayList<IngredienteProducto> darIngredientesProductoPorIdIngrediente(Long idIngrediente)
	{
		ArrayList<IngredienteProducto> ingredientesProductos = new ArrayList<>();
		DAOTablaIngredienteProducto dao = new DAOTablaIngredienteProducto();
		try(Connection conn = crearConexion())
		{
			ingredientesProductos = dao.darIngredientesProductosPorIdIngrediente(conn, idIngrediente);
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return ingredientesProductos;
	}
	
	public ArrayList<IngredienteProducto> darIngredientesProductoPorIdProducto(Long idProducto)
	{
		ArrayList<IngredienteProducto> ingredientesProductos = new ArrayList<>();
		DAOTablaIngredienteProducto dao = new DAOTablaIngredienteProducto();
		try(Connection conn = crearConexion())
		{
			ingredientesProductos = dao.darIngredientesProductosPorIdProducto(conn, idProducto);
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return ingredientesProductos;
	}
	
	public ArrayList<IngredienteProducto> darIngredientesProductos()
	{
		ArrayList<IngredienteProducto> ingredientesProductos = new ArrayList<>();
		DAOTablaIngredienteProducto dao = new DAOTablaIngredienteProducto();
		try(Connection conn = crearConexion())
		{
			ingredientesProductos = dao.darIngredientesProductos(conn);
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return ingredientesProductos;
	}
	
	public void actualizarProductoDeIngredienteProducto(IngredienteProducto ingredienteProducto)
	{
		DAOTablaIngredienteProducto dao = new DAOTablaIngredienteProducto();
		try(Connection conn = crearConexion())
		{
			dao.actualizarProductoDeIngredienteProducto(conn, ingredienteProducto);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public void actualizarIngredienteDeIngredienteProducto(IngredienteProducto ingredienteProducto)
	{
		DAOTablaIngredienteProducto dao = new DAOTablaIngredienteProducto();
		try(Connection conn = crearConexion())
		{
			dao.actualizarIngredienteDeIngredienteProducto(conn, ingredienteProducto);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public void eliminarIngredienteProducto(IngredienteProducto ingredienteProducto)
	{
		DAOTablaIngredienteProducto dao = new DAOTablaIngredienteProducto();
		try(Connection conn = crearConexion())
		{
			dao.eliminarIngredienteProducto(conn, ingredienteProducto);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  Fin metodos IngredienteProducto	----------------------------------
	
	// ----------------------------------	   Inicio metodos Menu		----------------------------------
	
	public void crearMenu(Menu menu)
	{
		DAOTablaMenu dao = new DAOTablaMenu();
		try(Connection conn = crearConexion())
		{
			dao.agregarMenu(conn, menu);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public Menu darMenuPorId(Long id)
	{
		Menu menu = null;
		DAOTablaMenu dao = new DAOTablaMenu();
		try(Connection conn = crearConexion())
		{
			menu = dao.darMenuPorId(conn, id);
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return menu;
	}
	
	public ArrayList<Menu> darMenusPorRestaurante(Long idRestaurante)
	{
		ArrayList<Menu> menus = null;
		DAOTablaMenu dao = new DAOTablaMenu();
		try(Connection conn = crearConexion())
		{
			menus = dao.darMenusPorRestaurante(conn, idRestaurante);
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return menus;
	}
	
	public ArrayList<Menu> darMenus()
	{
		ArrayList<Menu> menus = null;
		DAOTablaMenu dao = new DAOTablaMenu();
		try(Connection conn = crearConexion())
		{
			menus = dao.darMenus(conn);
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return menus;
	}
	
	public void actualizarMenu(Menu menu)
	{
		DAOTablaMenu dao = new DAOTablaMenu();
		try(Connection conn = crearConexion())
		{
			dao.actualizarMenu(conn, menu);
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public void eliminarMenu(Menu menu)
	{
		DAOTablaMenu dao = new DAOTablaMenu();
		try(Connection conn = crearConexion())
		{
			dao.eliminarMenu(conn, menu);
		} 
		catch (SQLException e) 
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  		 Fin metodos Menu		----------------------------------
	
	// ----------------------------------Inicio metodos OrdenRestaurante	----------------------------------
	
	
	
	// ----------------------------------  Fin metodos OrdenRestaurante	----------------------------------
	
	// ----------------------------------Inicio metodos Producto	----------------------------------
	
	// ----------------------------------  Fin metodos Producto	----------------------------------
	
	// ----------------------------------Inicio metodos Reserva	----------------------------------
	
	// ----------------------------------  Fin metodos Reserva	----------------------------------
	
	// ----------------------------------Inicio metodos Restaurante	----------------------------------
	
	// ----------------------------------  Fin metodos Restaurante	----------------------------------
	
	// ----------------------------------Inicio metodos Tipo	----------------------------------
	
	// ----------------------------------  Fin metodos Tipo	----------------------------------
	
	// ----------------------------------Inicio metodos TipoProducto	----------------------------------
	
	// ----------------------------------  Fin metodos TipoProducto	----------------------------------
	
	// ----------------------------------Inicio metodos Zona	----------------------------------
	
	// ----------------------------------  Fin metodos Zona	----------------------------------
	
	// ----------------------------------	Inicio metodos Producto	----------------------------------

	public void crearProducto(Producto producto)
	{
		DAOTablaProducto dao = new DAOTablaProducto();
		try(Connection conn = crearConexion())
		{
			dao.agregarProducto(conn, producto);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}

	public Producto darProductoPorId(Long id)
	{
		Producto producto = null;
		DAOTablaProducto dao = new DAOTablaProducto();
		try(Connection conn = crearConexion())
		{
			producto = dao.darProductoPorId(conn, id);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return producto;
	}

	public ArrayList<Producto> darProductosPorNombre(String nombre)
	{
		ArrayList<Producto> productos = new ArrayList<>();
		DAOTablaProducto dao = new DAOTablaProducto();
		try(Connection conn = crearConexion())
		{
			productos = dao.darProductosPorNombre(conn, nombre);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		return productos;
	}
	
	public ArrayList<Producto> darProductos()
	{
		ArrayList<Producto> productos = new ArrayList<>();
		DAOTablaProducto dao = new DAOTablaProducto();
		try(Connection conn = crearConexion())
		{
			productos = dao.darProductos(conn);
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return productos;
	}
	
	public void actualizarProducto(Producto producto)
	{
		DAOTablaProducto dao = new DAOTablaProducto();
		try(Connection conn = crearConexion())
		{
			dao.actualizarProducto(conn, producto);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	public void eliminarProducto(Producto producto)
	{
		DAOTablaProducto dao = new DAOTablaProducto();
		try(Connection conn = crearConexion())
		{
			dao.eliminarProducto(conn, producto);
			conn.commit();
		}
		catch(SQLException e)
		{
			//TODO preguntar sobre rollback
			e.printStackTrace();
		}
	}
	
	// ----------------------------------	 Fin metodos Producto	----------------------------------
	
	

	
}
