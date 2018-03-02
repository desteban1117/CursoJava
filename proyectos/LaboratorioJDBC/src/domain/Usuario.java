package domain;

public class Usuario {
	private int idusuario;
	private String usuario;
	private String password;
		
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Usuario{idusuario:"+ idusuario + ", usuario:"
				+ usuario + ", password:" + password +"}";
	}
}
