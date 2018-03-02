package cs;

import java.sql.Connection;
import java.sql.SQLException;

import datos.Conexion;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

public class Main {

	public static void main(String[] args) {
		OracleCallableStatement oraCallStmt;
		OracleResultSet deptResultSet;
		try {
			Connection con = Conexion.getConnection();
			oraCallStmt = (OracleCallableStatement) con.prepareCall("{? = call ref_cursor_"
					+ "package.get_dept_ref_cursor(?)}");
			oraCallStmt.registerOutParameter(1, OracleTypes.CURSOR);
			oraCallStmt.setInt(2, 200);
			oraCallStmt.execute();
			deptResultSet = (OracleResultSet) oraCallStmt.getCursor(1);
			while(deptResultSet.next()) {
				System.out.println("Id_departamento: " + deptResultSet.getInt(1));
				System.out.println("Nombre_departamento: " + deptResultSet.getString(2));
				System.out.println("Ubicacion_id: " + deptResultSet.getString(3) + "\n");
			}
			deptResultSet.close();
			oraCallStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
