package ejemplopaquetes;

import static com.gm.Utileria.imprimir;;

public class Main {

	public static void main(String[] args) {
		
		Empleado empleado;
		
		empleado = new Escritor("Roy",1500,TipoEscritura.CLASICO);
		
		
		imprimirDetalle(empleado);
		
		empleado = new Gerente("Laura", 1800, "sistemas");
		
		imprimirDetalle(empleado);
	}
	
	public static void determinarFigura(FiguraGeometrica figura) {
		
		if(figura instanceof FiguraGeometrica) {
			System.out.println("Es una figura geometrica");
		}
		
		if(figura instanceof Circulo) {
			System.out.println("Es un circulo");
		}
		
		if(figura instanceof Elipse) {
			System.out.println("Es una elipse");
		}
		
		if(figura instanceof Triangulo) {
			System.out.println("Es un triangulo");
		}
		
		if(figura instanceof Rectangulo) {
			System.out.println("Es un rectangulo");
		}
	}
	
	public static void imprimirDetalle(Empleado empleado) {
		String resultado = null;
		
		System.out.println(empleado.obtenerDetalle());
		
		if (empleado instanceof Escritor) {
			Escritor escritor = (Escritor) empleado;
			resultado = escritor.getTipoEscrituraEnTexto();
			
			resultado = ((Escritor) empleado).getTipoEscritura().getDescripcion();
			
			System.out.println(resultado);
		}else if(empleado instanceof Gerente) {
			
			resultado = ((Gerente) empleado).getDepartamento();
			System.out.println(resultado);
		}
	}
	public static void imprimirNumerosForeach(int... numeros) {
		
		for(int numero : numeros) {
			System.out.println(numero);
		}
	}
	
	public static void imprimirContinentes() {
		
		for(Continentes c: Continentes.values()) {
			System.out.println(c + ": " + c.getPaises());
		}
	}

}

	
