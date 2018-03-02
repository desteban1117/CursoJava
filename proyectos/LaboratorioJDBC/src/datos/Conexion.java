package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private static final String JDBC_DIRVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/sga?useSSL=false";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "root";
	
	public static synchronized Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DIRVER);
		} catch (Exception e) {
			System.out.println("Error al cargar el driver");	
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la db");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(ResultSet rs) {
		  try {
			  if (rs != null) {
				  rs.close();
			  }
		  }catch (SQLException e) {
				e.printStackTrace();
		  }
	}
	
	public static void close(PreparedStatement stmt) {
		  try {
			  if (stmt != null) {
				  stmt.close();
			  }
		  }catch (SQLException e) {
				e.printStackTrace();
		  }
	}
	
	public static void close(Connection con) {
		  try {
			  if (con != null) {
				  con.close();
			  }
		  }catch (SQLException e) {
				e.printStackTrace();
		  }
	}
}
