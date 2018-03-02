package cs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datos.Conexion;
import oracle.jdbc.OracleResultSetMetaData;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = Conexion.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees");
			OracleResultSetMetaData rsOracle = (OracleResultSetMetaData) rs.getMetaData();
			
			if(rsOracle == null) {
				System.out.println("No se encuentran metadatos");
			}else {
				int columCount = rsOracle.getColumnCount();
				System.out.println("Numero de columnas: " + columCount);
				
				for(int i = 1; i < columCount; i++) {
					System.out.print("Nombre de columna: " + 
							rsOracle.getColumnName(i));
					System.out.print(", Tipo de columna: " + 
							rsOracle.getColumnType(i));
					switch (rsOracle.isNullable(i)) {
					case OracleResultSetMetaData.columnNoNulls:
						System.out.println(", No acepta nulos");
						break;
						
					case OracleResultSetMetaData.columnNullable:
						System.out.println(", Acepta nulos");
						break;
					
					case OracleResultSetMetaData.columnNullableUnknown:
						System.out.println(", Valor nulo desconocido");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(rs);
			Conexion.close(con);
		}
	}

}
