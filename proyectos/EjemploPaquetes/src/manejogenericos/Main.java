package manejogenericos;

public class Main {

	public static void main(String[] args) {
		
		ClaseGenerica<Integer> objetoInt = new ClaseGenerica<Integer>(150);
		objetoInt.obtenerTipo();
		
		ClaseGenerica<String> objetoString = new ClaseGenerica<String>("Prueba");
		objetoString.obtenerTipo();
	}

}
