package interfaces;

public class ImplementacionMysql implements AccesoDatos{

	@Override
	public void insertar() {
		System.out.println("Insertar en base de datos mysql");
		
	}

	@Override
	public void listar() {
		System.out.println("Listar en base de datos mysql");
		
	}

}
