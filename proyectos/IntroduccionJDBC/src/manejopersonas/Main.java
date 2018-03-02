package manejopersonas;

import java.util.List;

import manejopersonas.datos.PersonaJDBC;
import manejopersonas.domain.Persona;

public class Main {

	public static void main(String[] args) {
		
		PersonaJDBC personaJDBC = new PersonaJDBC();
		
		//int n1 = personaJDBC.delete(1);
		
		//int n2 = personaJDBC.insert("roberto", "Florez");
		
		//int n3 = personaJDBC.update("David", "Flores",5);
		
		List<Persona> personas = personaJDBC.select();
		
		for(Persona persona : personas) {
			System.out.println(persona.toString());
		}
	}

}
