package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class EscribiendoFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escribiendo accedeEscritura = new Escribiendo();
		
		accedeEscritura.escribir();
	}

}


class Escribiendo{
	
	public void escribir() {
		
		String frase = "Esto es una prueba de escritura 2";
		
		try {
			FileWriter escritura = new FileWriter("C:/Users/javie/Desktop/nuevo.txt");
			
			for(int i = 0; i<frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

