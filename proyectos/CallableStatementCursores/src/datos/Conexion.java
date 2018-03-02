package datos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class Conexion {
	
	private static String JDBC_DRIVER;
	private static String JDBC_URL;
	private static String JDBC_USER;
	private static String JDBC_PASS;
	private static Driver driver;
	private static String JDBC_FILE_NAME = "jdbc";
	
	public static Properties loadProperties(String file) {
		Properties prop = new Properties();
		ResourceBundle bundle = ResourceBundle.getBundle(file);
		Enumeration e = bundle.getKeys();
		String key = null;
		while(e.hasMoreElements()) {
			key = (String) e.nextElement();
			prop.put(key, bundle.getObject(key));
		}
		
		JDBC_DRIVER = prop.getProperty("driver");
		JDBC_URL = prop.getProperty("url");
		JDBC_USER = prop.getProperty("user");
		JDBC_PASS = prop.getProperty("pass");
		return prop;
	}
	
	public static synchronized Connection getConnection() throws SQLException {
		
		if(driver == null) {
			try {
				loadProperties(JDBC_FILE_NAME);
				Class jdbcDriver = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriver.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Fallo al cargar la clase");
				e.printStackTrace();
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
