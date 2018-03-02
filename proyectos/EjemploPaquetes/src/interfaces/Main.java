package interfaces;

public class Main {

	public static void main(String[] args) {
		AccesoDatos datos = new ImplementacionOracle();
		ejecutar(datos, "listar");
		
		datos = new ImplementacionMysql();
		ejecutar(datos, "insertar");
		
	}
	
	public static void ejecutar(AccesoDatos datos, String accion) {
		if("listar".equals(accion)) {
			datos.listar();
		}else if("insertar".equals(accion)) {
			datos.insertar();
		}
	}
}
