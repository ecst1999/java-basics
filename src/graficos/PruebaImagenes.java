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
	
	public LaminaImagen() {
		try {
			imagen = ImageIO.read(new File("src/graficos/volcan.jpg"));	
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//File miImagen = new File("src/graficos/volcan.jpg");				
		
		int anchuraImagen = imagen.getWidth(this);
		
		int alturaImagen = imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0, null);
		
		for(int i = 0;i<300; i++) {
			
			for(int j = 0; j < 200; j++) {
				
				if(i+j>0) {
					g.copyArea(0, 0, anchuraImagen, alturaImagen, i*15, j*15);	
				}
									
			}
			
		}
		
		
		
	}
	
	private Image imagen; 
}


