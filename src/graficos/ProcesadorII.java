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
		
		configuraMenu("Arial", "fuente", "Arial", 9, 10);
		
		configuraMenu("Cascadia Code", "fuente", "Cascadia Code", 9, 10);
		
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10);
		
		
		//------------------------------------------------		
		
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 10);
		
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 10);
		
		//------------------------------------------------		
		
		configuraMenu("12", "tamanio", "", 9, 12);
		
		configuraMenu("16", "tamanio", "", 9, 16);
		
		configuraMenu("20", "tamanio", "", 9, 20);
		
		configuraMenu("24", "tamanio", "", 9, 24);
		
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
		
		elemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
	}
	
	private class GestionaEventos implements ActionListener{
		
		String tipoTexto, menu;
		
		int estiloLetra, tamanioLetra;
		
		public GestionaEventos(String elemento, String texto2, int estilo2, int tamLetra) {
			tipoTexto = texto2;
			
			estiloLetra = estilo2;
			
			tamanioLetra = tamLetra;
			
			menu = elemento;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			letras = miarea.getFont();
			
			if(menu == "Arial" || menu == "Cascadia Code" || menu == "Verdana") {
				estiloLetra = letras.getStyle();
				tamanioLetra = letras.getSize();
			}else if(menu == "Negrita" || menu == "Cursiva") {
				tipoTexto = letras.getFontName();
				tamanioLetra = letras.getSize();
			}else if(menu == "12" || menu == "16" || menu == "20" || menu == "24") {
				tipoTexto = letras.getFontName();
				estiloLetra = letras.getStyle();
			}
				
			
			miarea.setFont(new Font(tipoTexto, estiloLetra, tamanioLetra));
			
			System.out.print("");
			
			
		}
		
	}
	
	private JTextPane miarea;
	
	private JMenu fuente, estilo, tamanio;
	
	private Font letras;
	
}