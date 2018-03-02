
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona = new Persona("Carlos");
		Persona p1 = persona;
		
		persona = null;
		imprimePersona(p1);
		imprimePersona(persona);
		
		
		
	}
	
	private static void imprimePersona(Persona persona) {
		System.out.println(persona.getName());
	}
	
	private static void cambiarNombre(Persona persona) {
		persona.setName("juan");
	}
	
	private static void imprimeNumero(int i) {
		System.out.println(i);
	}
	
	private static void cambiarNumero(int i) {
		i = 5;
	}
	
}
