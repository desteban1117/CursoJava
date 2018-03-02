package cs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import datos.Conexion;

public class Main {

	public static void main(String[] args) {
		
		int idempleado = 100;
		try {
			Connection con = Conexion.getConnection();
			CallableStatement cstmt = null;
			double salario;
			cstmt = con.prepareCall("{ ? = call get_employee_salary(?) }");
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.setInt(2, idempleado);
			cstmt.execute();
			salario = cstmt.getDouble(1);
			cstmt.close();
			System.out.println("Empleado: " + idempleado);
			System.out.println("Salario: " + salario);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
