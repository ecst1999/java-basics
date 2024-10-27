package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.*;

public class LibreDisposicion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLibre mimarco = new MarcoLibre();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoLibre extends JFrame{
	
	public MarcoLibre() {
		setBounds(250, 150, 600, 400);
		
		add(new LaminaLibre());
	}
	
}



class LaminaLibre extends JPanel{
	
	public LaminaLibre() {
		
		setLayout(new EnColumnas());
		
		JLabel nombre = new JLabel("Nombre: ");
		
		JLabel apellido = new JLabel("Apellido: ");
		
		JLabel edad = new JLabel("Edad: ");
		
		JTextField c_nombre = new JTextField(10);
		
		JTextField c_apellido = new JTextField(10);
		
		JTextField c_edad = new JTextField(10);
		
		/*nombre.setBounds(20, 20, 80, 10);
		
		c_nombre.setBounds(100, 20, 100, 20);
		
		apellido.setBounds(20, 60, 80, 15);
		
		c_apellido.setBounds(100, 55, 100, 20);*/
		
		add(nombre);
				
		add(c_nombre);
		
		add(apellido);
				
		add(c_apellido);
		
		add(edad);
		
		add(c_edad);
		
	}
	
}

class EnColumnas implements LayoutManager{

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container miContenedor) {
		// TODO Auto-generated method stub
		
		int contador = 0;
		
		int n = miContenedor.getComponentCount();
		
		for(int i = 0; i<n; i++) {
			
			contador++;
			
			Component c = miContenedor.getComponent(i);
			
			c.setBounds(x, y, 100, 20);
			
			x += 100;
			
			if(contador %2 == 0) {
				x = 20;
				y += 40;
			}
		}
		
	}
	
	private int x = 20;
	private int y = 20;
	
}






