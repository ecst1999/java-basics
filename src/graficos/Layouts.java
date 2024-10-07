package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLayout marco = new MarcoLayout();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class MarcoLayout extends JFrame{
	
	public MarcoLayout() {
		setTitle("Prueba acciones");
		
		setBounds(600, 350, 600, 300);
		
		//FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);		
		
		add(new PanelLayout(), BorderLayout.NORTH);
		
		add(new PanelLayout2(), BorderLayout.SOUTH);
	}
}


class PanelLayout extends JPanel{
	
	public PanelLayout() {
		
		// setLayout(new FlowLayout(FlowLayout.CENTER, 75, 100));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JButton("Amarillo"), BorderLayout.NORTH);
		
		add(new JButton("Rojo"), BorderLayout.SOUTH);
		
		
		
	}
}


class PanelLayout2 extends JPanel{
	
	public PanelLayout2() {
		
		setLayout(new BorderLayout());
		
		add(new JButton("Azul"), BorderLayout.WEST);
		
		add(new JButton("Verde"), BorderLayout.EAST);
		
		add(new JButton("Negro"), BorderLayout.CENTER);
	}
	
}




