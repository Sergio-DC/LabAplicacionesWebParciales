package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Productos;

public class ProductoDAO {
	
	public static Connection conn() throws Exception
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/punto_venta?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&zerodatetimebehavior=Converttonull", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Insertar Producto
	public static boolean insertProducto(int clave, String descripcion, String unidad, int inventario, int precio) throws SQLException, Exception
	{
		String sql = "INSERT INTO PRODUCTOS (clave, descripcion, unidad, inventario, precio)";
		sql += "VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, Integer.toString(clave));
			ps.setString(2, descripcion);
			ps.setString(3, unidad);
			ps.setString(4, Integer.toString(inventario));
			ps.setString(5, Integer.toString(precio));
			
			ps.execute();
			conn().close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			conn().close();
			return false;
		}
	}
	
	// Modificar los datos de un producto
	public static boolean updateProducto(int clave, String descripcion, String unidad, int inventario, int precio) throws SQLException, Exception
	{
		String sql = "UPDATE PRODUCTOS SET descripcion = ?, unidad = ?, inventario = ?, precio = ? ";
		sql += "WHERE clave = ?";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, descripcion);
			ps.setString(2, unidad);
			ps.setString(3, Integer.toString(inventario));
			ps.setString(4, Integer.toString(precio));
			ps.setString(5, Integer.toString(clave));
			ps.execute();			
			
			conn().close();
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			conn().close();
			return false;
		}
	}
	// Lista de productos (Solo la clave y descripcion del producto
	public static List<Productos> listProductos() throws SQLException, Exception
	{
		ResultSet rs = null;
		List<Productos> list_all_products = new ArrayList<Productos>();
		try {
			Statement stmt = conn().createStatement();
			rs = stmt.executeQuery("SELECT clave, descripcion FROM PRODUCTOS");
			
			if(rs != null)
			{
				while(rs.next())
				{
					Productos producto = new Productos();
					producto.setClave(rs.getInt(1));
					producto.setDescripcion(rs.getString(2));
					list_all_products.add(producto);
				}
				conn().close();
				return list_all_products;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			conn().close();
		}
		
		return null;
	}
	
	// Buscar producto mediante la clave y regresar la clave y descripcion Para la tabla
	// REVISAR SI FUNCIONA CORRECTAMENTE EL STATEMENT
	public static List<Productos> searchListProducto(int clave) throws SQLException, Exception
	{
		String sql = "SELECT clave, descripcion FROM PRODUCTOS WHERE clave = ?";
		ResultSet rs = null;
		List<Productos> list_all_products = new ArrayList<Productos>();
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, Integer.toString(clave));
			Statement stmt = conn().createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null)
			{
				while(rs.next())
				{
					Productos producto = new Productos();
					producto.setClave(rs.getInt(1));
					producto.setDescripcion(rs.getString(2));
					list_all_products.add(producto);
				}
				conn().close();
				return list_all_products;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			conn().close();
		}
		
		return null;
	}
	
	// Buscar producto mediante la clave
	public static Productos searchProducto(int clave) throws SQLException, Exception
	{
		ResultSet rs = null;
		Productos producto = new Productos();
		String sql = "SELECT * FROM PRODUCTOS WHERE clave = ?";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, Integer.toString(clave));
			rs = ps.executeQuery();
			if(rs != null) {
				while (rs.next()) {
					producto.setClave(rs.getInt(1));
					producto.setDescripcion(rs.getString(2));
					producto.setUnidad(rs.getString(3));
					producto.setInventario(rs.getInt(4));
					producto.setPrecio(rs.getInt(5));
				}
				return producto;
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	// Update inventario
	public static boolean updateInventario(int clave, int inventario) throws SQLException, Exception
	{
		String sql = "UPDATE PRODUCTOS SET inventario = ?";
		sql += "WHERE clave = ?";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, Integer.toString(inventario));
			ps.setString(2, Integer.toString(clave));
			ps.execute();			
			
			conn().close();
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			conn().close();
			return false;
		}
	}
}
