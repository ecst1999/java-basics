package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;

public class TrabajandoColores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoColor mimarco = new MarcoColor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoColor extends JFrame{
	
	public MarcoColor() {
		setTitle("Prueba con colores");
		
		setSize(400, 400);
		
		setLocation(500, 350);
		
		LaminaConColor miLamina = new LaminaConColor();
		
		add(miLamina);
		
		//miLamina.setBackground(Color.PINK);
		
		miLamina.setBackground(SystemColor.window);
				
	}
}

class LaminaConColor extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		//Rectangulo 
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		
		g2.setPaint(Color.RED);
		g2.draw(rectangulo);
		g2.setPaint(Color.CYAN);
		
		g2.fill(rectangulo);
		
		//Elipse
		
		Ellipse2D ellipse = new Ellipse2D.Double();
		
		ellipse.setFrame(rectangulo);
		
		Color micolor = new Color(125, 189, 200);
		
		//g2.setPaint(new Color(109,172,79).darker().darker());
		
		g2.setPaint(micolor);
		
		g2.fill(ellipse);
		
	}
}



