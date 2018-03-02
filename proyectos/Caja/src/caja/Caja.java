package caja;

public class Caja {
	
	private int alto;
	private int ancho;
	private int largo;
	
	Caja(){
		
	}
	
	Caja(int alto, int ancho, int largo ){
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
	}

    
	
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int volumen() {
		return alto * ancho * largo;
	}
	
	

}
