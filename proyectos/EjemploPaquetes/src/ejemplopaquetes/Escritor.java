package ejemplopaquetes;

public class Escritor extends Empleado{

	final TipoEscritura tipoEscritura;
	
	public Escritor(String nombre, double sueldo, TipoEscritura tipoEscritura) {
		super(nombre, sueldo);
		this.tipoEscritura = tipoEscritura;
	}
	
	public String obtenerDetalle() {
		return super.obtenerDetalle() + "\n" + 
				"tipoEscritura: " + tipoEscritura;
	}

	public TipoEscritura getTipoEscritura() {
		return tipoEscritura;
	}

	public String getTipoEscrituraEnTexto() {
		return tipoEscritura.getDescripcion();
	}
	
}
