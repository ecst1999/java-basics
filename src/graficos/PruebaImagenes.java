package graficos;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.imageio.*;

public class PruebaImagenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoImagen mimarco = new MarcoImagen();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoImagen extends JFrame{
	
	public MarcoImagen(){
		
		setTitle("Marco con imagen");
		
		setBounds(750, 300, 600, 600);
		
		LaminaImagen milamina = new LaminaImagen();
		
		add(milamina);
	}
}

class LaminaImagen extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		File miImagen = new File("src/graficos/carro.png");
		
		try {
			imagen = ImageIO.read(miImagen);	
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		g.drawImage(imagen, 5, 5, null);
		
	}
	
	private Image imagen; 
}


