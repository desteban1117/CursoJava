package poolconexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import capadatos.pool.PoolConexionesMySql;
import capadatos.pool.PoolConexionesOracle;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = PoolConexionesMySql.getConnetion();
			stmt = con.prepareStatement("Select * from Personas");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(" " + rs.getInt(1));
				System.out.print(" " + rs.getString(2));
				System.out.println(" " + rs.getString(3));
			}
			
			con = PoolConexionesOracle.getConexion();
			stmt = con.prepareStatement("select * from employees where "
					+ "employee_id in ('100','101','102')");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(" " + rs.getInt(1));
				System.out.print(" " + rs.getString(2));
				System.out.println(" " + rs.getString(3));
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
