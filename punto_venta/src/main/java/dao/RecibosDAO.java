package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecibosDAO {
	
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
	public static boolean insertRecibo(int folio, String user_id, String fecha, String hora, int monto, String tipo_pago) throws SQLException, Exception
	{
		String sql = "INSERT INTO RECIBOS (folio, user_id, fecha, hora, monto, tipo_pago)";
		sql += "VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn().prepareStatement(sql);
			ps.setString(1, Integer.toString(folio));
			ps.setString(2, user_id);
			ps.setString(3, fecha);
			ps.setString(4, hora);
			ps.setString(5, Integer.toString(monto));
			ps.setString(6, tipo_pago);
			
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
