package manejopersonas.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manejopersonas.domain.Persona;;


public class PersonaJDBC {
	
	private Connection conn;
	private final String SQL_INSERT = "INSERT INTO Personas(nombre,apellido) "
			+ "VALUES(?,?)";
	private final String SQL_UPDATE = "UPDATE Personas SET nombre=?, "
			+ "apellido=? WHERE id_persona=?";
	private final String SQL_DELETE = "DELETE FROM Personas where "
			+ "id_persona=?";
	private final String SQL_SELECT = "SELECT * FROM Personas ORDER BY "
			+ "id_persona";
	
	public PersonaJDBC(){}
	
	public PersonaJDBC(Connection conn){
		this.conn = conn;
	}
	public int insert(String nombre, String apellido) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = (this.conn != null) ? this.conn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			System.out.println("Ejecutando query insert");
			rows = stmt.executeUpdate();
			System.out.println("Registros afectados: " + rows);
		} finally {
			Conexion.close(stmt);
			if(this.conn == null) {
				Conexion.close(conn);
			}
		}
		return rows;
	}

	public int update(String nombre, String apellido, int id_persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = (this.conn != null) ? this.conn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setInt(3, id_persona);
			System.out.println("Ejecutando query update");
			rows = stmt.executeUpdate();
			System.out.println("Registros afectados: " + rows);
		} finally {
			Conexion.close(stmt);
			if(this.conn == null) {
				Conexion.close(conn);
			}
		}
		return rows;
	}
	
	public int delete(int id_persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = (this.conn != null) ? this.conn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id_persona);
			System.out.println("Ejecutando query delete");
			rows = stmt.executeUpdate();
			System.out.println("Registros afectados: " + rows);
		} finally {
			Conexion.close(stmt);
			if(this.conn == null) {
				Conexion.close(conn);
			}
		}
		return rows;
	}
	
	public List<Persona> select() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			conn = (this.conn != null) ? this.conn : Conexion.getConnection();
			
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				Persona persona = new Persona();
				persona.setId_persona(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				persona.setApellido(rs.getString(3));
				personas.add(persona);
			}
		} finally {
			Conexion.close(rs);
			Conexion.close(stmt);
			if(this.conn == null) {
				Conexion.close(conn);
			}
			
		}
		
		return personas;
	}
}
