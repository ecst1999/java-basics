package graficos;

import javax.swing.*;

public class PruebaMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuFrame mimarco = new MenuFrame();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}



class MenuFrame extends JFrame{
	
	public MenuFrame() {
		
		setBounds(500, 300, 550, 400);
		
		add(new MenuLamina());
		
		setVisible(true);

	}
	
}

class MenuLamina extends JPanel{
	
	public MenuLamina() {
		
		JMenuBar mibarra = new JMenuBar();
		
		JMenu archivo = new JMenu("Archivo");
		
		JMenu edicion = new JMenu("Edición");
		
		JMenu herramientas = new JMenu("Herramientas");
		
		JMenu opciones = new JMenu("Opciones");
		
		JMenuItem guardar = new JMenuItem("Guardar");
		
		JMenuItem guardarComo = new JMenuItem("Guardar como");
		
		JMenuItem cortar = new JMenuItem("Cortar");
		
		JMenuItem copiar = new JMenuItem("Copiar");
		
		JMenuItem pegar = new JMenuItem("Pegar");
		
		JMenuItem generales = new JMenuItem("Generales");
		
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		
		//Agregar items de menu
		
		opciones.add(opcion1);
		
		opciones.add(opcion2);
		
		archivo.add(guardar);
		
		archivo.add(guardarComo);
		
		edicion.add(cortar);
		
		edicion.add(copiar);
		
		edicion.add(pegar);
		
		edicion.addSeparator();
		
		edicion.add(opciones);
		
		herramientas.add(generales);
		
		//Barra de herramientas		
		mibarra.add(archivo);
		
		mibarra.add(edicion);
		
		mibarra.add(herramientas);
		
		add(mibarra);
		
	}
}