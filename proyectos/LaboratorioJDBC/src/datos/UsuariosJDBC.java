package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuariosJDBC {
	
	private Connection useConn;
	private final String SQL_INSERT = "INSERT INTO usuarios(usuario, password)"
			+ "VALUES(?,MD5(?))";
	private final String SQL_UPDATE = "UPDATE usuarios SET usuario=?,"
			+ "password=MD5(?) WHERE idusuario = ?";
	private final String SQL_DELETE = "DELETE FROM usuarios WHERE idusuario=?";
	private final String SQL_SELECT = "SELECT * FROM usuarios";
	
	public UsuariosJDBC(){
		useConn = Conexion.getConnection();
	}
	
	public UsuariosJDBC(Connection conn){
		useConn = conn;
	}
	
	public int insert(String usuario, String password) {
		int resultado = 0;
		PreparedStatement stmt = null;
		
		
		try {
			if(useConn.isClosed()) {
				useConn = Conexion.getConnection();
			}
			stmt = useConn.prepareStatement(SQL_INSERT);
			stmt.setString(1, usuario);
			stmt.setString(2, password);
			resultado = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error al ejecuatar el metodo insert()");
			e.printStackTrace();
		}finally {
			Conexion.close(stmt);
			Conexion.close(useConn);
		}
		return resultado;
	}
	
	public int update(String usuario, String password, int idusuario) {
		int resultado = 0;
		PreparedStatement stmt = null;
		
		try {
			if(useConn.isClosed()) {
				useConn = Conexion.getConnection();
			}
			stmt = useConn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, usuario);
			stmt.setString(2, usuario);
			stmt.setInt(3, idusuario);
			resultado = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar el método update()");
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(useConn);
		}
		
		return resultado;
	}
	
	public int delete(int idusuario) {
		int resultado = 0;
		PreparedStatement stmt = null;
	
		try {
			if(useConn.isClosed()) {
				useConn = Conexion.getConnection();
			}
			stmt = useConn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, idusuario);
			resultado = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar el método delete()");
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(useConn);
		}
		return resultado;
	}
	
	public List<Usuario> select() {
		List usuarios = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			if(useConn.isClosed()) {
				useConn = Conexion.getConnection();
			}
			stmt = useConn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Usuario persona = new Usuario();
				persona.setIdusuario(rs.getInt(1));
				persona.setUsuario(rs.getString(2));
				persona.setPassword(rs.getString(3));
				usuarios.add(persona);
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar el método select()");
			e.printStackTrace();
			e.getStackTrace();
		}
		
		return usuarios;
	}
	
}
