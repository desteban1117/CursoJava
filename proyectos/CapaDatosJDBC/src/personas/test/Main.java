package personas.test;

import java.sql.SQLException;
import java.util.List;

import personas.dto.PersonaDTO;
import personas.jdbc.PersonaDao;
import personas.jdbc.PersonaDaoJDBC;

public class Main {

	public static void main(String[] args) {
		
		PersonaDao personaDao = new PersonaDaoJDBC();
		List<PersonaDTO> personas;
		
		try {
			personas = personaDao.select();
			for(PersonaDTO persona : personas) {
				System.out.println(persona.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
