package com.gm.mundopc;

public class Orden {
	
	private final int idOrden;
	private Computadora computadoras[];
	private static int contadorOrdenes;
	private int contadorComputadoras;
	private int MAXCOMPUTADORAS = 10;
	
	public Orden(){
		idOrden = ++contadorOrdenes;
		computadoras = new Computadora[MAXCOMPUTADORAS];
	}
	
	public void agregarComputadoras(Computadora computadora){
		if (contadorComputadoras < MAXCOMPUTADORAS) {
			computadoras[contadorComputadoras] = computadora;
			contadorComputadoras++;	 
		}
	}
	
	public void mostrarOrden() {
		for(int i = 0; i < contadorComputadoras; i++) {
			System.out.println("Orden: ");
			System.out.println(computadoras[i].toString());
		}
	}
}
