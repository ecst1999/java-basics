package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class EventosRaton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRaton mimarco = new MarcoRaton();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoRaton extends JFrame{
	public MarcoRaton() {
		setVisible(true);
		
		setBounds(700, 300, 600, 450);
		
		addMouseMotionListener(new EventoDeRaton());
	}
}

class EventoDeRaton implements MouseMotionListener{
	
	public void mouseDragged(MouseEvent e) {
		System.out.println("Estas arrastrando un elemento");
	}
	
	public void mouseMoved(MouseEvent e) {
		System.out.println("Estas moviendo el puntero");
	}
}

/*
class EventoDeRaton extends MouseAdapter { // implements MouseListener{
	
	public void mousePressed(MouseEvent e) {
		//System.out.println(e.getModifiersEx());
		
		if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) 
			System.out.println("Has pulsado el botón izquierdo");
		else if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK)
			System.out.println("Has pulsado la rueda del ratón");
		else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK)
			System.out.println("Has pulsado el botón derecho");
	}

	/*
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Coordenada X: " + e.getX() + " coordenada Y: " + e.getY());
		System.out.println(e.getClickCount());
	}*/
	
	/*
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Has hecho click");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de presionar");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de levantar");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de entrar");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de salir");
	}*/
//}

