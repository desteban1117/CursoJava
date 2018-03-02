package personas.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import personas.dto.PersonaDTO;

public class PersonaDaoJDBC implements PersonaDao {

	private Connection conn;
	private final String SQL_INSERT = "INSERT INTO Personas(nombre,apellido) "
			+ "VALUES(?,?)";
	private final String SQL_UPDATE = "UPDATE Personas SET nombre=?, "
			+ "apellido=? WHERE id_persona=?";
	private final String SQL_DELETE = "DELETE FROM Personas where "
			+ "id_persona=?";
	private final String SQL_SELECT = "SELECT * FROM Personas ORDER BY "
			+ "id_persona";
	
	public PersonaDaoJDBC() {}
	
	public PersonaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int insert(PersonaDTO personaDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = (this.conn != null) ? this.conn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, personaDTO.getNombre());
			stmt.setString(2, personaDTO.getApellido());
			rows = stmt.executeUpdate();
			
		} finally {
			Conexion.close(stmt);
			if(this.conn == null) {
				Conexion.close(conn);
			}
		}
		return rows;
	}

	@Override
	public int update(PersonaDTO personaDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = (this.conn != null) ? this.conn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, personaDTO.getNombre());
			stmt.setString(2, personaDTO.getApellido());
			stmt.setInt(3, personaDTO.getId_persona());
			rows = stmt.executeUpdate();
			
		} finally {
			Conexion.close(stmt);
			if(this.conn == null) {
				Conexion.close(conn);
			}
		}
		return rows;
	}

	@Override
	public int delete(PersonaDTO personaDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = (this.conn != null) ? this.conn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, personaDTO.getId_persona());
			rows = stmt.executeUpdate();
			
		} finally {
			Conexion.close(stmt);
			if(this.conn == null) {
				Conexion.close(conn);
			}
		}
		return rows;
	}

	@Override
	public List<PersonaDTO> select() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();
		try {
			conn = (this.conn != null) ? this.conn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				PersonaDTO personaDTO = new PersonaDTO();
				personaDTO.setId_persona(rs.getInt(1));
				personaDTO.setNombre(rs.getString(2));
				personaDTO.setApellido(rs.getString(3));
				personasDTO.add(personaDTO);
			}
		} finally {
			Conexion.close(stmt);
			Conexion.close(rs);
			if(this.conn == null) {
				Conexion.close(conn);
			}
		}
		return personasDTO;
	}
	


}
