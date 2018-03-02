package introduccionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion = (Connection) DriverManager.getConnection(url,
					"root","root");
			
			Statement instruccion = conexion.createStatement();
			
			String query = "select * from Personas";
			
			ResultSet resultado = instruccion.executeQuery(query);
			
			while(resultado.next()) {
				System.out.print(resultado.getInt(1) + " ");
				System.out.print(resultado.getString(2) + " ");
				System.out.println(resultado.getString(3));
			}
			resultado.close();
			instruccion.close();
			conexion.close();
		}catch (ClassNotFoundException | SQLException e) {
			e.getStackTrace();
		}
	}

}
