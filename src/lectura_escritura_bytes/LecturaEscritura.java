package lectura_escritura_bytes;

import java.io.*;

public class LecturaEscritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int contador = 0;
		
		int datos_entrada[] = new int[108536];
		
		try {
			FileInputStream archivoLectura = new FileInputStream("C:/Users/javie/Downloads/volcan.jpg");
			
			boolean final_ar = false;
			
			while(!final_ar) {
				
				
				
				int byte_entrada = archivoLectura.read();
				
				if(byte_entrada != -1)
					datos_entrada[contador] = byte_entrada;				
				else
					final_ar = true;
				
				System.out.println(datos_entrada[contador]);
				
				contador++;
				
			}			
			
			archivoLectura.close();
			
		}catch(IOException e) {
			System.out.println("No se encuentra la imagen");
		}
		
		crea_fichero(datos_entrada);

	}
	
	static void crea_fichero(int datos_nuevo_fichero[]) {
		
		try {
			FileOutputStream fichero_nuevo = new FileOutputStream("C:/Users/javie/Downloads/volcan_copia.jpg");
			
			for(int i = 0; i < datos_nuevo_fichero.length; i++) {
				fichero_nuevo.write(datos_nuevo_fichero[i]);
			}
			
		}catch(IOException e) {
			System.out.println("Error al crear el archivo");
		}
		
	}

}
