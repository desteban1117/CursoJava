package mx.com.gm.peliculas.datos;

import java.io.File;
import java.util.List;

import mx.com.gm.peliculas.domain.Pelicula;

public interface AccesoDatos {
	
	public File getArchivo(String nombreArchivo);
	
	public List<Pelicula> getListPeliculas(String nombre);
	
	public void setPelicula(Pelicula pelicula, String nombreArchivo,
			boolean anexar);
	
	public String getPelicula(String nombreArchivo, String buscar);
	
	public void crear(String nombreArchivo);
	
	public void borrar(String nombreArchivo);
	
	
}
