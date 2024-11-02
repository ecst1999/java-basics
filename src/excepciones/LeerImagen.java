package excepciones;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LeerImagen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoImagen marco = new MarcoImagen();
		
		marco.setVisible(true);
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoImagen extends JFrame{
	
	public MarcoImagen() {
		
		setBounds(750, 300, 300, 200);
		
		add(new LaminaConImagen());
	}
	
}


class LaminaConImagen extends JPanel{
	
	public LaminaConImagen() {
		try {
			image = ImageIO.read(new File("src/excepciones/volcaJn.jpg"));	
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void paintComponent(Graphics g) throws NullPointerException {
		
		super.paintComponent(g);
	
		try {
			
		
			int anchuraImagen = image.getWidth(this);
			
			int alturaImagen = image.getHeight(this);
			
			g.drawImage(image, 0, 0, null);
			
			for(int i = 0; i < 300; i++) {
				
				for(int j = 0; j < 200; j++) {
					if(i+j>0)
						g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
				}
			}
		}catch (NullPointerException e) {
			
			g.drawString("No se ha podido cargar la imagen", 10, 10);
			
		}
		
		
	}
	
	private Image image;
	
}





