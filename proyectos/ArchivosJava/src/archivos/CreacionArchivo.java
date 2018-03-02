package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreacionArchivo {

	public static void main(String[] args) {
		File archivo = new File("/home/david/prueba.txt");
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
			salida.println("Información dentro del archivo");
			salida.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("El archivo se ha creado correctamente");
	}
}
