package graficos;

import java.awt.BorderLayout;

import javax.swing.*;

public class PruebaEmergente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEmergente1 mimarco = new MarcoEmergente1();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoEmergente1 extends JFrame{
	
	public MarcoEmergente1() {
		
		setBounds(100, 100, 250, 250);

		add(new LaminaEmergente());
		
		setVisible(true);
	}
	
}


class LaminaEmergente extends JPanel{
	
	public LaminaEmergente() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar mibarra = new JMenuBar();
		
		JMenu fuente = new JMenu("Fuente");
		
		JMenu estilo = new JMenu("Estilo");
		
		JMenu tamanio = new JMenu("Tamaño");
		
		mibarra.add(fuente);
		
		mibarra.add(estilo);
		
		mibarra.add(tamanio);
		
		laminaMenu.add(mibarra);
		
		add(laminaMenu, BorderLayout.NORTH);
		
		JTextPane miarea = new JTextPane();
		
		add(miarea, BorderLayout.CENTER);
		
		//------------------------------------------------------
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem opcion1 = new JMenuItem("Opcion 1");
		
		JMenuItem opcion2 = new JMenuItem("Opcion 2");
		
		JMenuItem opcion3 = new JMenuItem("Opcion 3");
		
		emergente.add(opcion1);
		
		emergente.add(opcion2);
		
		emergente.add(opcion3);
		
		//setComponentPopupMenu(emergente);
		
		miarea.setComponentPopupMenu(emergente);
		
	}
	
}

