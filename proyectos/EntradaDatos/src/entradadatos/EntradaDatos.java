package entradadatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntradaDatos {

	public static void main(String[] args) {
		String captura;
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bInput = new BufferedReader(input);
		try {
			System.out.println("Introduce un dato:");
			captura = bInput.readLine();
			while(captura != null) {
				System.out.println("Dato introducido: " + captura);
				captura = bInput.readLine();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
