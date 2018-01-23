package com.gm.mundopc;

public class Raton extends DispositivoEntrada{
	
	private final int idRaton;
	private static int contadorRaton;
	
	
	
	public Raton(String tipoEntrada, String marca) {
		super(tipoEntrada, marca);
		idRaton = ++contadorRaton;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "Raton: {" + "idRaton: " + '}';
	}	
}
