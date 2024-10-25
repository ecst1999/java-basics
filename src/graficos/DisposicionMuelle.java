package graficos;

import javax.swing.*;

public class DisposicionMuelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMuelle mimarco = new MarcoMuelle();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoMuelle extends JFrame{
	
	public MarcoMuelle() {
		setBounds(300, 400, 1000, 350);
		
		add(new LaminaMuelle());
	}
	
}


class LaminaMuelle extends JPanel{

	public LaminaMuelle() {
	
		JButton boton1 = new JButton("Boton 1");
		
		JButton boton2 = new JButton("Boton 2");
		
		JButton boton3 = new JButton("Boton 3");
		
		SpringLayout dispo = new SpringLayout();
		
		setLayout(dispo);
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		Spring miMuelle = Spring.constant(0, 10, 100);
		
		dispo.putConstraint(SpringLayout.WEST, boton1, miMuelle, SpringLayout.WEST, this);
		
		dispo.putConstraint(SpringLayout.WEST, boton2, miMuelle, SpringLayout.EAST, boton1);
		
		dispo.putConstraint(SpringLayout.WEST, boton3, miMuelle, SpringLayout.EAST, boton2);
		
		dispo.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, boton3);
		
	}
}


