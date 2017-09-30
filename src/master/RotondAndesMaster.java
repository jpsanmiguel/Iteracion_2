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
import dao.DAOTablaOrdenRestaurante;
import dao.DAOTablaProducto;
import dao.DAOTablaReserva;
import dao.DAOTablaRestaurante;
import dao.DAOTablaRotonda;
import dao.DAOTablaTipo;
import dao.DAOTablaTipoProducto;
import dao.DAOTablaZona;
import vo.Categoria;
import vo.Cliente;
import vo.Ingrediente;
import vo.IngredienteProducto;
import vo.Producto;
import vo.Reserva;
import vo.Restaurante;
import vo.Rotonda;
import vo.Tipo;
import vo.TipoProducto;
import vo.Zona;
import vo.Menu;
import vo.OrdenRestaurante;

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
			 
			e.printStackTrace();
		}
	}
	

	// ----------------------------------   Fin metodos Categoria	----------------------------------
	
	
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
			 
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  		 Fin metodos Menu		----------------------------------
	
	// ----------------------------------Inicio metodos OrdenRestaurante	----------------------------------
	
	public void crearOrdenRestaurante(OrdenRestaurante ordenRestaurante)
	{
		DAOTablaOrdenRestaurante dao = new DAOTablaOrdenRestaurante();
		try(Connection conn = crearConexion())
		{
			dao.agregarOrdenRestaurante(conn, ordenRestaurante);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}

	public OrdenRestaurante darOrdenRestaurantePorId(Long id)
	{
		OrdenRestaurante ordenRestaurante = null;
		DAOTablaOrdenRestaurante dao = new DAOTablaOrdenRestaurante();
		try(Connection conn = crearConexion())
		{
			ordenRestaurante = dao.darOrdenRestaurantePorId(conn, id);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return ordenRestaurante;		
	}
	
	public ArrayList<OrdenRestaurante> darOrdenRestaurantePorMenu(Long idMenu)
	{
		ArrayList<OrdenRestaurante> ordenRestaurantes = new ArrayList<>();
		DAOTablaOrdenRestaurante dao = new DAOTablaOrdenRestaurante();
		try(Connection conn = crearConexion())
		{
			ordenRestaurantes = dao.darOrdenRestaurantesPorMenu(conn, idMenu);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return ordenRestaurantes;		
	}
	
	public ArrayList<OrdenRestaurante> darOrdenRestaurantes()
	{
		ArrayList<OrdenRestaurante> ordenRestaurantes = new ArrayList<>();
		DAOTablaOrdenRestaurante dao = new DAOTablaOrdenRestaurante();
		try(Connection conn = crearConexion())
		{
			ordenRestaurantes = dao.darOrdenRestaurantes(conn);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return ordenRestaurantes;
	}
	
	public void actualizarOrdenRestaurante(OrdenRestaurante ordenRestaurante)
	{
		DAOTablaOrdenRestaurante dao = new DAOTablaOrdenRestaurante();
		try(Connection conn = crearConexion())
		{
			dao.actualizarOrdenRestaurante(conn, ordenRestaurante);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	public void eliminarOrdenRestaurante(OrdenRestaurante ordenRestaurante)
	{
		DAOTablaOrdenRestaurante dao = new DAOTablaOrdenRestaurante();
		try(Connection conn = crearConexion())
		{
			dao.eliminarOrdenRestaurante(conn, ordenRestaurante);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  Fin metodos OrdenRestaurante	----------------------------------
	
	// ----------------------------------Inicio metodos Reserva	----------------------------------

	public void crearReserva(Reserva reserva)
	{
		DAOTablaReserva dao = new DAOTablaReserva();
		try(Connection conn = crearConexion())
		{
			dao.agregarReserva(conn, reserva);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	public Reserva darReservaPorId(Long id)
	{
		Reserva reserva = null;
		DAOTablaReserva dao = new DAOTablaReserva();
		try(Connection conn = crearConexion())
		{
			reserva = dao.darReservaPorId(conn, id);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return reserva;
	}
	
	public ArrayList<Reserva> darReservaPorIdCliente(Long idCliente)
	{
		ArrayList<Reserva> reservas = null;
		DAOTablaReserva dao = new DAOTablaReserva();
		try(Connection conn = crearConexion())
		{
			reservas = dao.darReservasPorCliente(conn, idCliente);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return reservas;
	}
	
	public ArrayList<Reserva> darReservaPorNombre(Long idZona)
	{
		ArrayList<Reserva> reserva = null;
		DAOTablaReserva dao = new DAOTablaReserva();
		try(Connection conn = crearConexion())
		{
			reserva = dao.darReservasPorZona(conn, idZona);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return reserva;
	}
	
	public ArrayList<Reserva> darReservas()
	{
		ArrayList<Reserva> reserva = null;
		DAOTablaReserva dao = new DAOTablaReserva();
		try(Connection conn = crearConexion())
		{
			reserva = dao.darReservas(conn);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return reserva;
	}
	
	public void actualizarReserva(Reserva reserva)
	{
		DAOTablaReserva dao = new DAOTablaReserva();
		try(Connection conn = crearConexion())
		{
			dao.actualizarReserva(conn, reserva);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	public void eliminarReserva(Reserva reserva)
	{
		DAOTablaReserva dao = new DAOTablaReserva();
		try(Connection conn = crearConexion())
		{
			dao.eliminarReserva(conn, reserva);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	
	// ----------------------------------  Fin metodos Reserva	----------------------------------
	
	// ----------------------------------Inicio metodos Restaurante	----------------------------------
	
	public void crearRestaurante(Restaurante restaurante)
	{
		DAOTablaRestaurante dao = new DAOTablaRestaurante();
		try(Connection conn = crearConexion())
		{
			dao.agregarRestaurante(conn, restaurante);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}

	public Restaurante darRestaurantePorId(Long id)
	{
		Restaurante restaurante = null;
		DAOTablaRestaurante dao = new DAOTablaRestaurante();
		try(Connection conn = crearConexion())
		{
			restaurante = dao.darRestaurantePorId(conn, id);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return restaurante;
	}

	public ArrayList<Restaurante> darRestaurantesPorNombre(String nombre)
	{
		ArrayList<Restaurante> restaurantes = new ArrayList<>();
		DAOTablaRestaurante dao = new DAOTablaRestaurante();
		try(Connection conn = crearConexion())
		{
			restaurantes = dao.darRestaurantesPorNombre(conn, nombre);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return restaurantes;
	}
	
	public ArrayList<Restaurante> darRestaurantes()
	{
		ArrayList<Restaurante> restaurantes = new ArrayList<>();
		DAOTablaRestaurante dao = new DAOTablaRestaurante();
		try(Connection conn = crearConexion())
		{
			restaurantes = dao.darRestaurantes(conn);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return restaurantes;
	}
	
	public void actualizarRestaurante(Restaurante restaurante)
	{
		DAOTablaRestaurante dao = new DAOTablaRestaurante();
		try(Connection conn = crearConexion())
		{
			dao.actualizarRestaurante(conn, restaurante);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	public void eliminarRestaurante(Restaurante restaurante)
	{
		DAOTablaRestaurante dao = new DAOTablaRestaurante();
		try(Connection conn = crearConexion())
		{
			dao.eliminarRestaurante(conn, restaurante);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  Fin metodos Restaurante	----------------------------------
	
	// ----------------------------------Inicio metodos Tipo	----------------------------------
	
	public void crearTipo(Tipo tipo)
	{
		DAOTablaTipo dao = new DAOTablaTipo();
		try(Connection conn = crearConexion())
		{
			dao.agregarTipo(conn, tipo);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}

	public Tipo darTipoPorId(Long id)
	{
		Tipo tipo = null;
		DAOTablaTipo dao = new DAOTablaTipo();
		try(Connection conn = crearConexion())
		{
			tipo = dao.darTipoPorId(conn, id);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return tipo;
	}

	public ArrayList<Tipo> darTiposPorNombre(String nombre)
	{
		ArrayList<Tipo> tipos = new ArrayList<>();
		DAOTablaTipo dao = new DAOTablaTipo();
		try(Connection conn = crearConexion())
		{
			tipos = dao.darTiposPorNombre(conn, nombre);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return tipos;
	}
	
	public ArrayList<Tipo> darTipos()
	{
		ArrayList<Tipo> tipos = new ArrayList<>();
		DAOTablaTipo dao = new DAOTablaTipo();
		try(Connection conn = crearConexion())
		{
			tipos = dao.darTipos(conn);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tipos;
	}
	
	public void actualizarTipo(Tipo tipo)
	{
		DAOTablaTipo dao = new DAOTablaTipo();
		try(Connection conn = crearConexion())
		{
			dao.actualizarTipo(conn, tipo);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	public void eliminarTipo(Tipo tipo)
	{
		DAOTablaTipo dao = new DAOTablaTipo();
		try(Connection conn = crearConexion())
		{
			dao.eliminarTipo(conn, tipo);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  Fin metodos Tipo	----------------------------------
	
	// ----------------------------------Inicio metodos TipoProducto	----------------------------------
	
	public void crearTipoProducto(TipoProducto tipoProducto)
	{
		DAOTablaTipoProducto dao = new DAOTablaTipoProducto();
		try(Connection conn = crearConexion())
		{
			dao.agregarTipoProducto(conn, tipoProducto);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}
	}
	
	public ArrayList<TipoProducto> darTiposProductoPorIdTipo(Long idTipo)
	{
		ArrayList<TipoProducto> tiposProductos = new ArrayList<>();
		DAOTablaTipoProducto dao = new DAOTablaTipoProducto();
		try(Connection conn = crearConexion())
		{
			tiposProductos = dao.darTiposProductosPorIdTipo(conn, idTipo);
		} 
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}
		return tiposProductos;
	}
	
	public ArrayList<TipoProducto> darTiposProductoPorIdProducto(Long idProducto)
	{
		ArrayList<TipoProducto> tiposProductos = new ArrayList<>();
		DAOTablaTipoProducto dao = new DAOTablaTipoProducto();
		try(Connection conn = crearConexion())
		{
			tiposProductos = dao.darTiposProductosPorIdProducto(conn, idProducto);
		} 
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}
		return tiposProductos;
	}
	
	public ArrayList<TipoProducto> darTiposProductos()
	{
		ArrayList<TipoProducto> tiposProductos = new ArrayList<>();
		DAOTablaTipoProducto dao = new DAOTablaTipoProducto();
		try(Connection conn = crearConexion())
		{
			tiposProductos = dao.darTiposProductos(conn);
		} 
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}
		return tiposProductos;
	}
	
	public void actualizarProductoDeTipoProducto(TipoProducto tipoProducto)
	{
		DAOTablaTipoProducto dao = new DAOTablaTipoProducto();
		try(Connection conn = crearConexion())
		{
			dao.actualizarProductoTipoProducto(conn, tipoProducto);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}
	}
	
	public void actualizarTipoDeTipoProducto(TipoProducto tipoProducto)
	{
		DAOTablaTipoProducto dao = new DAOTablaTipoProducto();
		try(Connection conn = crearConexion())
		{
			dao.actualizarTipoTipoProducto(conn, tipoProducto);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}
	}
	
	public void eliminarTipoProducto(TipoProducto tipoProducto)
	{
		DAOTablaTipoProducto dao = new DAOTablaTipoProducto();
		try(Connection conn = crearConexion())
		{
			dao.eliminarTipoProducto(conn, tipoProducto);
			conn.commit();
		} 
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  Fin metodos TipoProducto	----------------------------------
	
	// ----------------------------------Inicio metodos Zona	----------------------------------
	
	public void crearZona(Zona zona)
	{
		DAOTablaZona dao = new DAOTablaZona();
		try(Connection conn = crearConexion())
		{
			dao.agregarZona(conn, zona);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}

	public Zona darZonaPorId(Long id)
	{
		Zona zona = null;
		DAOTablaZona dao = new DAOTablaZona();
		try(Connection conn = crearConexion())
		{
			zona = dao.darZonaPorId(conn, id);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return zona;
	}

	public ArrayList<Zona> darZonasPorNombre(String nombre)
	{
		ArrayList<Zona> zonas = new ArrayList<>();
		DAOTablaZona dao = new DAOTablaZona();
		try(Connection conn = crearConexion())
		{
			zonas = dao.darZonasPorNombre(conn, nombre);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return zonas;
	}
	
	public ArrayList<Zona> darZonas()
	{
		ArrayList<Zona> zonas = new ArrayList<>();
		DAOTablaZona dao = new DAOTablaZona();
		try(Connection conn = crearConexion())
		{
			zonas = dao.darZonas(conn);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return zonas;
	}
	
	public void actualizarZona(Zona zona)
	{
		DAOTablaZona dao = new DAOTablaZona();
		try(Connection conn = crearConexion())
		{
			dao.actualizarZona(conn, zona);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	public void eliminarZona(Zona zona)
	{
		DAOTablaZona dao = new DAOTablaZona();
		try(Connection conn = crearConexion())
		{
			dao.eliminarZona(conn, zona);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	// ----------------------------------  Fin metodos Zona	----------------------------------

	
	// ----------------------------------	Inicio metodos Rotonda	----------------------------------
	
	public void crearRotonda(Rotonda rotonda)
	{
		DAOTablaRotonda dao = new DAOTablaRotonda();
		try(Connection conn = crearConexion())
		{
			dao.agregarRotonda(conn, rotonda);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}

	public Rotonda darRotondaPorId(Long id)
	{
		Rotonda rotonda = null;
		DAOTablaRotonda dao = new DAOTablaRotonda();
		try(Connection conn = crearConexion())
		{
			rotonda = dao.darRotondaPorId(conn, id);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return rotonda;
	}

	public ArrayList<Rotonda> darRotondasPorNombre(String nombre)
	{
		ArrayList<Rotonda> rotondas = new ArrayList<>();
		DAOTablaRotonda dao = new DAOTablaRotonda();
		try(Connection conn = crearConexion())
		{
			rotondas = dao.darRotondasPorNombre(conn, nombre);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		return rotondas;
	}
	
	public ArrayList<Rotonda> darRotondas()
	{
		ArrayList<Rotonda> rotondas = new ArrayList<>();
		DAOTablaRotonda dao = new DAOTablaRotonda();
		try(Connection conn = crearConexion())
		{
			rotondas = dao.darRotondas(conn);
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rotondas;
	}
	
	public void actualizarRotonda(Rotonda rotonda)
	{
		DAOTablaRotonda dao = new DAOTablaRotonda();
		try(Connection conn = crearConexion())
		{
			dao.actualizarRotonda(conn, rotonda);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	public void eliminarRotonda(Rotonda rotonda)
	{
		DAOTablaRotonda dao = new DAOTablaRotonda();
		try(Connection conn = crearConexion())
		{
			dao.eliminarRotonda(conn, rotonda);
			conn.commit();
		}
		catch(SQLException e)
		{
			 
			e.printStackTrace();
		}
	}
	
	// ----------------------------------	Fin metodos Producto	----------------------------------
	
	
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
			 
			e.printStackTrace();
		}
	}
	
	// ----------------------------------	 Fin metodos Producto	----------------------------------
	
	

	
}
