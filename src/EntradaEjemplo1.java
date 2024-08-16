import java.util.Scanner;

public class EntradaEjemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre:");
		
		String nombreUsuario = entrada.nextLine();
		
		System.out.println("Introduce tu edad:");
		
		int edad = entrada.nextInt();
		
		System.out.println("Hola " + nombreUsuario + " el año que viene tendras " + (edad +1) + " años.");

	}

}
