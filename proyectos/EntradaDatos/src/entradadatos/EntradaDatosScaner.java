package entradadatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EntradaDatosScaner {

	public static void main(String[] args) {
		String captura = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un dato:");
		captura = scan.nextLine();
		while(captura != null) {
			System.out.println("Dato introducido: " + captura);
			captura = scan.nextLine();
		}
	}
}
