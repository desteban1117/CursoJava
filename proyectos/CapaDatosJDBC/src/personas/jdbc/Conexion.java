package personas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
	private static String JDBC_USER = "root";
	private static String JDBC_PASSWORD = "root";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
			
			
		} catch (SQLException e) {
			System.out.println("Problema al retornar la conexion");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontró Driver");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar el statement");
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar el resulset");
			e.printStackTrace();
		}
	}
}
