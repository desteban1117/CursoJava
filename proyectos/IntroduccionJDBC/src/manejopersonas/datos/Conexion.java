package manejopersonas.datos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexion {
	
	private static String JDBC_DIRVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost/sga?useSSL=false";
	private static String JDBC_USER = "root";
	private static String JDBC_PASS = "root";
	private static Driver driver = null;
	
	public static synchronized Connection getConnection() 
			throws SQLException {
		
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DIRVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			}catch (Exception e) {
				
				System.out.println("Fallo en cargar el Driver JDBC");
			}
		}
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
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
