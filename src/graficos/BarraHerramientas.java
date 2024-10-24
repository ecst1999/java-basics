package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class BarraHerramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoHerramientas mimarco = new MarcoHerramientas();
				
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoHerramientas extends JFrame{
	
	public MarcoHerramientas() {
		
		setTitle("Marco Herramientas");
		
		setBounds(500, 300, 600, 450);
		
		lamina = new JPanel();
		
		add(lamina);
		
		Action accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/volcan.jpg"), Color.BLUE);
		
		Action accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/volcan.jpg"), Color.YELLOW);
		
		Action accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/volcan.jpg"), Color.RED);
		
		Action accionSalir = new AbstractAction("Salir", new ImageIcon("src/graficos/cortar.gif")) {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		};
		
		
		JMenu menu = new JMenu("Color");
		
		menu.add(accionAzul);
		
		menu.add(accionAmarillo);
		
		menu.add(accionRojo);
				
		
		JMenuBar barraMenu = new JMenuBar();
		
		barraMenu.add(menu);
		
		setJMenuBar(barraMenu);		
		
		//Construcción de barra de herramientas
		
		JToolBar barra = new JToolBar();
		
		barra.add(accionAzul);
		
		barra.add(accionAmarillo);
		
		barra.add(accionRojo);
		
		barra.addSeparator();
		
		barra.add(accionSalir);
		
		add(barra, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	private class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre, Icon icono, Color c) {
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo ... " + nombre);
			
			putValue("Color", c);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Color c = (Color) getValue("Color");
			
			lamina.setBackground(c);
		}
		
	}
	
	JPanel lamina;
}



