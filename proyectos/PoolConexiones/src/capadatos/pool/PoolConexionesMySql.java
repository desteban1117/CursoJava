package capadatos.pool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConexionesMySql {
	
	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");	
		ds.setPassword("root");
		ds.setUrl("jdbc:mysql://localhost:3306/sga?useSSL=false");
		ds.setInitialSize(5);
		return ds;
	}
	
	public static Connection getConnetion() throws SQLException{
		return getDataSource().getConnection();
	}
}

