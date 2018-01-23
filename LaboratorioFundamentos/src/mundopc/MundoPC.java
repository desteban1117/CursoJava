package mundopc;

import com.gm.mundopc.*;

public class MundoPC {

	public static void main(String[] args) {
		
		Raton raton1 = new Raton("Inhalambrico", "marca1");
		Raton raton2 = new Raton("alambrico", "marca2");
		Raton raton3 = new Raton("Inhalambrico", "marca1");
		
		Teclado teclado1 = new Teclado("Inhalambrico", "marca1");
		Teclado teclado2 = new Teclado("alambrico", "marca2");
		Teclado teclado3 = new Teclado("Inhalambrico", "marca1");
		
		Monitor monitor1 = new Monitor("marca3",40.5);
		Monitor monitor2 = new Monitor("marca4",55);
		Monitor monitor3 = new Monitor("marca3",40);
		
		Computadora computadora1 = new Computadora("nombre1",monitor1,teclado1,raton1);
		Computadora computadora2 = new Computadora("nombre2",monitor2,teclado2,raton2);
		Computadora computadora3 = new Computadora("nombre3",monitor3,teclado3,raton3);
		
		Orden orden = new Orden();
		orden.agregarComputadoras(computadora1);
		orden.agregarComputadoras(computadora2);
		orden.agregarComputadoras(computadora3);
		
		orden.mostrarOrden();
		
	}

}
