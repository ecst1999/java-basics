package graficos;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class TrabajandoFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoFuentes mimarco = new MarcoFuentes();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}


class MarcoFuentes extends JFrame {
	
	public MarcoFuentes(){
		
		setTitle("Prueba con fuentes");
		
		setSize(400, 400);
		
		setLocation(500, 350);
		
		LaminaFuentes milamina = new LaminaFuentes();
		
		add(milamina);
		
		milamina.setForeground(Color.MAGENTA);
	}
	
}

class LaminaFuentes extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Font mifuente = new Font("Lato", Font.BOLD, 26);
		
		g2.setFont(mifuente);
		
		// g2.setColor(Color.blue);
		
		g2.drawString("Steve", 100, 100);
		
		g2.setFont(new Font("Old English Text MT", Font.ITALIC, 25));
		
		// g2.setColor(new Color(128, 90, 50).brighter());
		
		g2.drawString("Curso de Java", 190, 100);
		
	}
}