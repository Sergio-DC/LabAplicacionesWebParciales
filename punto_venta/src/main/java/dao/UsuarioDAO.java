package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Usuarios;

public class UsuarioDAO {

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
	
	// Insertar Usuario
	public static boolean insertUsuario(String user_id, String user_password, String user_name, String user_rol, String user_status) throws SQLException, Exception
	{
		String sql = "INSERT INTO USUARIOS (user_id, user_password, user_name, user_rol, user_status)";
		sql += "VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_password);
			ps.setString(3, user_name);
			ps.setString(4, user_rol);
			ps.setString(5, user_status);
			
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
	public static boolean updateUsuario(String user_id, String user_password, String user_name, String user_rol, String user_status) throws SQLException, Exception
	{
		String sql = "UPDATE USUARIOS SET user_password = ?, user_name = ?, user_rol = ?, user_status = ? ";
		sql += "WHERE user_id = ?";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			
			ps.setString(1, user_password);
			ps.setString(2, user_name);
			ps.setString(3, user_rol);
			ps.setString(4, user_status);
			ps.setString(5, user_id);
			ps.execute();			
			
			conn().close();
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			conn().close();
			return false;
		}
	}
	
	// Lista de usuarios (solo usuario_id y nombre)
	public static List<Usuarios> listUsuarios() throws SQLException, Exception
	{
		ResultSet rs = null;
		List<Usuarios> list_all_users = new ArrayList<Usuarios>();
		try {
			Statement stmt = conn().createStatement();
			rs = stmt.executeQuery("SELECT user_id, user_name FROM USUARIOS");
			
			if(rs != null)
			{
				while(rs.next())
				{
					Usuarios usuario = new Usuarios();
					usuario.setUser_id(rs.getString(1));
					usuario.setUser_name(rs.getString(2));
					list_all_users.add(usuario);
				}
				conn().close();
				return list_all_users;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			conn().close();
		}
		
		return null;
	}
	
	// Buscar usuario mediante el id y regresar el id y nombre Para la tabla
	// REVISAR SI FUNCIONA CORRECTAMENTE EL STATEMENT
	public static List<Usuarios> searchListUsuario(String user_id) throws SQLException, Exception
	{
		String sql = "SELECT user_id, user_name FROM USUARIOS WHERE user_id = ?";
		ResultSet rs = null;
		List<Usuarios> list_all_users = new ArrayList<Usuarios>();
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, user_id);
			Statement stmt = conn().createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null)
			{
				while(rs.next())
				{
					Usuarios usuario = new Usuarios();
					usuario.setUser_id(rs.getString(1));
					usuario.setUser_name(rs.getString(2));
					list_all_users.add(usuario);
				}
				conn().close();
				return list_all_users;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			conn().close();
		}
		
		return null;
	}
	
	// Buscar usuario mediante el id
	public static Usuarios searchUsuario(String user_id) throws SQLException, Exception
	{
		ResultSet rs = null;
		Usuarios usuario = new Usuarios();
		String sql = "SELECT * FROM USUARIOS WHERE user_id = ?";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			if(rs != null) {
				while (rs.next()) {
					usuario.setUser_id(rs.getString(1));
					usuario.setUser_password(rs.getString(2));
					usuario.setUser_name(rs.getString(3));
					usuario.setUser_rol(rs.getString(4));
					usuario.setUser_status(rs.getString(5));
				}
				return usuario;
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
}
