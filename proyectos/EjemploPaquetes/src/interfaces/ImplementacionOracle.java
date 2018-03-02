package interfaces;

public class ImplementacionOracle implements AccesoDatos{

	@Override
	public void insertar() {
		System.out.println("Insertar en base de datos oracle");
		
	}

	@Override
	public void listar() {
		System.out.println("Listar en base de datos oracle");
		
	}

}
