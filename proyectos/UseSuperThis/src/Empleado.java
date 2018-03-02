
public class Empleado extends Persona{

	private double sueldo;
	
	public Empleado(String nombre, double sueldo) {
		super(nombre);
		this.sueldo = sueldo;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + " Empleado{ " + "Sueldo: " + sueldo + '}';
	}
}
