package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivo {

	public static void main(String[] args) {
		File archivo = new File("/home/david/prueba.txt");
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String lectura;
			lectura = entrada.readLine();
			while(lectura != null) {
				System.out.println(lectura);
				lectura = entrada.readLine();
			}
			entrada.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
