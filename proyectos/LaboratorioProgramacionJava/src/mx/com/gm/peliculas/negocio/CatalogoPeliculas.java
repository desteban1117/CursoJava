package mx.com.gm.peliculas.negocio;

public interface CatalogoPeliculas {
	
	public void agregarPelicula(String nombrePelicula, String nombreArchivo);
	
	public void listarPeliculas(String nombreArchivo);
	
	public void buscarPelicula(String nombreArchivo, String buscar);
	
	public void iniciarArchivo(String nombreArchivo);
}
