package leyendo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccesoFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeerFichero accediendo = new LeerFichero();
		
		accediendo.lee();
	}

}


class LeerFichero {
	
	public void lee() {
		
		try {
			FileReader entrada = new FileReader("C:/Users/javie/Desktop/nuevo2.txt");
			
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			//int c = 0;
			String linea = "";
			
			//while(c != -1) {
				
			while(linea != null) {
				
				//c = entrada.read();
				
				//char letra = (char) c;
				
				linea = miBuffer.readLine();
				
				if(linea != null) 
					System.out.print(linea);	
				
				
			}
			
			entrada.close();
			
		} catch (IOException e) {
			
			System.out.println("No se ha encontrado el archivosi no");
		}
	}
}