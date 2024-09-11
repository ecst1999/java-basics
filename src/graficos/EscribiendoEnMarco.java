package graficos;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConTexto miMarco = new MarcoConTexto();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoConTexto extends JFrame {
	
	public MarcoConTexto() {
		setVisible(true);
		
		setSize(600, 450);
		
		setLocation(400, 200);
		
		setTitle("Primer texto");
		
		Lamina miLamina = new Lamina();
		
		add(miLamina);
	}
	
}

class Lamina extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		
		//g.drawString("Estamos aprendiendo swing", 100, 100);
		
		g2.draw(rectangulo);
		
		Ellipse2D ellipse = new Ellipse2D.Double();
		
		ellipse.setFrame(rectangulo);
		
		g2.draw(ellipse);
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		double CentroX = rectangulo.getCenterX();
		
		double CentroY = rectangulo.getCenterY();
		
		double radio = 150;
		
		Ellipse2D circulo = new Ellipse2D.Double();
		
		circulo.setFrameFromCenter(CentroX, CentroY, CentroX+radio, CentroY+radio);
		
		g2.draw(circulo);
	}
}



