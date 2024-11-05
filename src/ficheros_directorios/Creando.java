package ficheros_directorios;

import java.io.*;

public class Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:" + 
				File.separator + 
				"Users" + 
				File.separator +
				"javie" + 
				File.separator + 
				"Downloads" + 
				File.separator + 
				"java_ser" + 
				File.separator + 
				"prueba_texto.txt";

		File ruta = new File(path);
		
		//ruta.mkdir(); -> Crear ruta
		
		String archivo_destino = ruta.getAbsolutePath();
		
		try {
			ruta.createNewFile();	
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
		Escribiendo accede_es = new Escribiendo();
		
		accede_es.escribir(archivo_destino);
		
		System.out.println("Se escribio el archivo de forma correcta");
		
	}

}

class Escribiendo{
	
	public void escribir(String ruta_archivo) {
		
		String frase = "Hola quería ante todo agradecer  a Juan por todo su esfuerzo con el canal ya que gracias a el estoy aprendiendo muchísimo ,luego quería simplemente hacer un apunte y es que he comprobado que al borrar el fichero con delete,se borra definitivamente sin pasar por la papelera de reciclaje,simplemente para que los demás usuarios del canal vayan con cuidado no vaya ser que borren algún archivo importante y luego no puedan recuperarlo.Muchas gracias y a seguir aprendiendo :D";
		
		try {
			FileWriter escritura = new FileWriter(ruta_archivo);
			
			for(int i = 0; i< frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
}
