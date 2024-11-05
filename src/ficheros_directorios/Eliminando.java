package ficheros_directorios;

import java.io.File;

public class Eliminando {

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
		
		ruta.delete();
		
		System.out.println("Se elimino el archivo de forma correcta");
	}

}
