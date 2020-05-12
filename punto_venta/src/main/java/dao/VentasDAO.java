package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentasDAO {

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
	
	// Registrar nuevo recibo
	public static boolean insertVenta(int clave, int folio, int cantidad, int precio_final) throws SQLException, Exception
	{
		String sql = "INSERT INTO VENTAS (clave, folio, cantidad, precio_final)";
		sql += "VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, Integer.toString(clave));
			ps.setString(2, Integer.toString(folio));
			ps.setString(3, Integer.toString(cantidad));
			ps.setString(4, Integer.toString(precio_final));
			
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
