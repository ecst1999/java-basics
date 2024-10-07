package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VariosOyentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoPrincipal mimarco = new MarcoPrincipal();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}


class MarcoPrincipal extends JFrame{
	
	public MarcoPrincipal() {
		setTitle("Prueba Varios");
		
		setBounds(1000, 100, 300, 200);			
		
		add(new LaminaPrincipal());
	}
}

class LaminaPrincipal extends JPanel{
	
	public LaminaPrincipal() {
		
		JButton botonNuevo = new JButton("Nuevo");
		
		add(botonNuevo);
		
		botonCerrarTodo = new JButton("Cerrar todo");
		
		add(botonCerrarTodo);
		
		botonNuevo.addActionListener(new OyenteNuevo());
		
	}
	
	private class OyenteNuevo implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			MarcoEmergente marcoEmergente = new MarcoEmergente(botonCerrarTodo);
			
			marcoEmergente.setVisible(true);
			
		}
		
		
	}
	
	JButton botonCerrarTodo;
}

class MarcoEmergente extends JFrame{
	
	public MarcoEmergente(JButton botonCerrar) {
		
		contador ++;
		
		setTitle("Ventana " + contador);
		
		setBounds(40*contador, 40*contador, 300, 150);
		
		botonCerrar.addActionListener(new CierraTodos());
		
	}
	
	private class CierraTodos implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {

			dispose();
			
		}
		
	}
	
	private static int contador = 0;
	
}



