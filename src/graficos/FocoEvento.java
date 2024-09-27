package graficos;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class FocoEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoFoco mimarco = new MarcoFoco();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoFoco extends JFrame {

	public MarcoFoco() {
		
		setVisible(true);
		
		setBounds(300, 300, 600, 450);
		
		add(new LaminaFoco());
		
	}
}


class LaminaFoco extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		setLayout(null);
		
		cuadro1 = new JTextField();
		
		cuadro2 = new JTextField();
		
		cuadro1.setBounds(120, 10, 150, 20);
		
		cuadro2.setBounds(120, 50, 150, 20);
		
		add(cuadro1);
		
		add(cuadro2);		
		
		cuadro1.addFocusListener(new LanzaFocos());
	}
	
	private class LanzaFocos implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			System.out.println("He perdido el foco");
		}
		
	}
	
	
	JTextField cuadro1;
	
	JTextField cuadro2;
	
}




