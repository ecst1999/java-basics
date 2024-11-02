package excepciones;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("¿Qué deseas hacer?");
		System.out.println("1. Introducir datos");
		System.out.println("2. Salir del programa");
		
		Scanner entrada = new Scanner(System.in);
		
		int decision = entrada.nextInt();
		
		if(decision == 1) {
			
			try {
				pedirDatos();	
			}catch(Exception e) {
				System.out.println("No se introdujo un número como edad");
			}
			
		}
			
		else{
			System.out.println("Adios");
			
			System.exit(0);
		}
		
		entrada.close();
		
	}
	
	static void pedirDatos() throws IOException {
		
		//try {
			
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("Introduce tu nombre por favor");
			
			String nombre = entrada.nextLine();
			
			System.out.println("Introduce tu edad por favor");
			
			int edad = entrada.nextInt();
			
			System.out.println("Hola " + nombre + ". El año que viene tendrás " + (edad + 1) + " años");
			
			entrada.close();
			
		//}catch (InputMismatchException e) {
			System.out.println("Los datos de la edad se encuentran mal carrgados revisa por favor");
		//}
		
		
		
		System.out.println("Hemos terminado");
	}

}
