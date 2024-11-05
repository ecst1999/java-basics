package ficheros_directorios;

import java.io.*;

public class AccesoFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "C:" + File.separator + "Users" + File.separator +"javie" + File.separator + "Downloads" + File.separator + "java_ser";

		File ruta = new File(path);
		
		System.out.println(ruta.getAbsolutePath());
		
		String[] nombres_archivos = ruta.list();
		
		for(String archivos : nombres_archivos) {
			System.out.println("-" + archivos);
			
			File f = new File(ruta.getAbsolutePath(), archivos);
			
			if(f.isDirectory()) {
				String[] archivos_subcarpeta = f.list();
				
				for(String arch_sub: archivos_subcarpeta) {
					System.out.println(" -" + arch_sub);
				}
			}
		}
	}

}
