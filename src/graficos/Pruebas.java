package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fuente = JOptionPane.showInputDialog("Introduce fuente");
		
		boolean estaFuente = false;

		String [] nombreFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String nombreFuente : nombreFuentes) {
			System.out.println(nombreFuente);
			if(fuente.equalsIgnoreCase(nombreFuente))
				estaFuente = true;			
		}
		
		if(estaFuente)
			System.out.println("Fuente instalada");
		else
			System.out.println("Fuente NO instalada");
	}

}
