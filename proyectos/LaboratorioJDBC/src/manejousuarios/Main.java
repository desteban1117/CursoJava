package manejousuarios;

import java.util.List;

import datos.UsuariosJDBC;
import domain.Usuario;

public class Main {

	public static void main(String[] args) {
		
		UsuariosJDBC usuariosJDBC = new UsuariosJDBC();
		
		List<Usuario> users = usuariosJDBC.select();
		
		printUsuarios(users);
		
		usuariosJDBC.delete(9);
		usuariosJDBC.insert("more", "more");
		usuariosJDBC.update("more2", "more2", 6);
		
		
		users = usuariosJDBC.select();
		
		printUsuarios(users);
		
		
	}
	
	public static void printUsuarios(List<Usuario> users) {
		for(Usuario user : users) {
			System.out.println(user.toString());
		}
	}

}
