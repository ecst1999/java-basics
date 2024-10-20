package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProcesadorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador mimarco = new MenuProcesador();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MenuProcesador extends JFrame{
	
	public MenuProcesador() {
		
		setBounds(500, 300, 550, 400);
		
		add(new LaminaProcesador());
		
		setVisible(true);
		
	}
	
}

class LaminaProcesador extends JPanel{
	
	public LaminaProcesador() {
		
		setLayout(new BorderLayout());
		
		JPanel laminamenu = new JPanel();
		
		JMenuBar mibarra = new JMenuBar();
		
		//------------------------------------------------
		
		fuente = new JMenu("Fuente");
		
		estilo = new JMenu("Estilo");
		
		tamanio = new JMenu("Tamaño");
		
		//------------------------------------------------
		
		configuraMenu("Arial", "fuente", "Arial", Font.PLAIN, 1);
		
		configuraMenu("Cascadia Code", "fuente", "Cascadia Code", Font.PLAIN, 1);
		
		configuraMenu("Verdana", "fuente", "Verdana", Font.PLAIN, 1);
		
		
		//------------------------------------------------		
		
		configuraMenu("Negrita", "estilo", "", Font.PLAIN, 1);
		
		configuraMenu("Cursiva", "estilo", "", Font.PLAIN, 1);
		
		//------------------------------------------------		
		
		configuraMenu("12", "tamanio", "", Font.PLAIN, 1);
		
		configuraMenu("16", "tamanio", "", Font.PLAIN, 1);
		
		configuraMenu("20", "tamanio", "", Font.PLAIN, 1);
		
		configuraMenu("24", "tamanio", "", Font.PLAIN, 1);
		
		//------------------------------------------------		
		
		mibarra.add(fuente);
		
		mibarra.add(estilo);
		
		mibarra.add(tamanio);
		
		laminamenu.add(mibarra);
		
		add(laminamenu, BorderLayout.NORTH);
		
		miarea = new JTextPane();
		
		add(miarea, BorderLayout.CENTER);
	}
	
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) {
		
		JMenuItem elemMenu = new JMenuItem(rotulo);
		
		if(menu == "fuente")
			fuente.add(elemMenu);
		else if(menu == "estilo")
			estilo.add(elemMenu);
		else if(menu == "tamanio")
			tamanio.add(elemMenu);
	}
	
	
	private JTextPane miarea;
	
	private JMenu fuente, estilo, tamanio;
	
	private Font letras;
	
}