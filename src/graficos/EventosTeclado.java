package graficos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class EventosTeclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoTeclado mimarco = new MarcoTeclado();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoTeclado extends JFrame {
	public MarcoTeclado(){
		
		setVisible(true);
		
		setBounds(700, 300, 600, 450);
		
		addKeyListener(new EventoDeTeclado());
	}
}


class EventoDeTeclado implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char letra = e.getKeyChar();
		
		System.out.println(letra);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/*
		int codigo = e.getKeyCode();
		
		System.out.println(codigo);
		*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}