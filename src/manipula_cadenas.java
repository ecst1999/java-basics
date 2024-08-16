
public class manipula_cadenas {

	public static void main(String[] args) {

		String nombre = "Felipe";
		
		System.out.println("Mi nombre es: " + nombre);
		
		System.out.println("Mi nombre tiene: " + nombre.length());
		
		System.out.println("La primera letra de " + nombre + " es la " + nombre.charAt(0));
		
		int ultima_letra;
		
		ultima_letra = nombre.length() - 1;
		
		System.out.println("Y la ultima letra es la " + nombre.charAt(ultima_letra));

	}

}
