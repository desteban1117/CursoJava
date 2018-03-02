package manejopersonas.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manejopersonas.domain.Persona;;


public class PersonaJDBC {
	
	private final String SQL_INSERT = "INSERT INTO Personas(nombre,apellido) "
			+ "VALUES(?,?)";
	private final String SQL_UPDATE = "UPDATE Personas SET nombre=?, "
			+ "apellido=? WHERE id_persona=?";
	private final String SQL_DELETE = "DELETE FROM Personas where "
			+ "id_persona=?";
	private final String SQL_SELECT = "SELECT * FROM Personas ORDER BY "
			+ "id_persona";
	
	public int insert(String nombre, String apellido) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		int rows = 0;
		
		try {
			con = Conexion.getConnection();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(con);
		}
		
		return rows;
	}

	public int update(String nombre, String apellido, int id_persona) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		int rows = 0;
		
		try {
			con = Conexion.getConnection();
			stmt = con.prepareStatement(SQL_UPDATE);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setInt(3, id_persona);
			rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(con);
		}
		
		return rows;
	}
	
	public int delete(int id_persona) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		int rows = 0;
		
		try {
			con = Conexion.getConnection();
			stmt = con.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id_persona);
			rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(con);
		}
		
		return rows;
	}
	
	public List<Persona> select() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			con = Conexion.getConnection();
			stmt = con.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				Persona persona = new Persona();
				persona.setId_persona(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				persona.setApellido(rs.getString(3));
				personas.add(persona);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(rs);
			Conexion.close(stmt);
			Conexion.close(con);
		}
		
		return personas;
	}
}
