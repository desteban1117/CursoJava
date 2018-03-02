package manejopersonas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import manejopersonas.datos.Conexion;
import manejopersonas.datos.PersonaJDBC;
import manejopersonas.domain.Persona;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
				
		try {
			conn = Conexion.getConnection();
			
			if(conn.getAutoCommit() == true) {
				conn.setAutoCommit(false);
			}
			
			PersonaJDBC personasJDBC = new PersonaJDBC(conn);
			
			personasJDBC.update("nombre2", "Apellido2", 2);
			
			personasJDBC.insert("nombre3", "vdfkmlkbmdklbsmkdlbdskbd"
					+ "gkdsfmglksfdmglsfdkmgñfdgmfdlgmfdñlgfdlgfdñlgmd");
			
			//personasJDBC.insert("nombre3", "nombre3");
			conn.commit();
			
			
		} catch (SQLException e) {
			try {
				System.out.println("Se hace rollback");
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}finally {
			Conexion.close(conn);
		}
	}

}
