package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class PruebaAcciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoAccion marco = new MarcoAccion();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}


class MarcoAccion extends JFrame{
	
	public MarcoAccion() {
		
		setTitle("Prueba acciones");
		
		setBounds(600, 350, 600, 300);
		
		PanelAccion lamina = new PanelAccion();
		
		add(lamina);
		
	}
}

class PanelAccion extends JPanel{
	
	public PanelAccion() {
		
		AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/volcan.jpg"), Color.YELLOW);
		
		AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/volcan.jpg"), Color.BLUE);
		
		AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/volcan.jpg"), Color.RED);
		
		// JButton botonAmarillo = new JButton(accionAmarillo);
		
		add(new JButton(accionAmarillo));
		
		add(new JButton(accionAzul));
		
		add(new JButton(accionRojo));
		
		/*
		
		JButton botonAmarrillo = new JButton("Amarillo");
		JButton botonAzul = new JButton("Azul");
		JButton botonRojo = new JButton("Rojo");
		
		add(botonAmarrillo);
		add(botonAzul);
		add(botonRojo);
		*/
	}
	
	private class AccionColor extends AbstractAction{

		public AccionColor(String nombre, Icon icono, Color color_boton) {
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color "  + nombre);
			
			putValue("color_de_fondo", color_boton);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			 
			Color c = (Color) getValue("color_de_fondo");
			
			setBackground(c);	
			
			System.out.println("Nombre: " + getValue(Action.NAME) + " descripción " + getValue(Action.SHORT_DESCRIPTION));
		}
		
	}
}





