package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class ProcesadorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador mimarco = new MenuProcesador();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MenuProcesador extends JFrame{
	
	public MenuProcesador() {
		
		setBounds(500, 300, 550, 450);
		
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
		
		configuraMenu("Arial", "fuente", "Arial", 9, 10, "");
		
		configuraMenu("Cascadia Code", "fuente", "Cascadia Code", 9, 10, "");
		
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10, "");
		
		
		//------------------------------------------------		
		
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 10, "src/graficos/negrita.png");
		
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 10, "src/graficos/cursiva.png");
		
		/*
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("src/graficos/cortar.gif"));
		
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/graficos/volcan.jpg"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		
		estilo.add(negrita);
		
		estilo.add(cursiva);*/
		
		/*
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 10, "src/graficos/cortar.gif");
		
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 10, "src/graficos/volcan.jpg");
		*/
		
		//------------------------------------------------		
		
		/*
		configuraMenu("12", "tamanio", "", 9, 12, "");
		
		configuraMenu("16", "tamanio", "", 9, 16, "");
		
		configuraMenu("20", "tamanio", "", 9, 20, "");
		
		configuraMenu("24", "tamanio", "", 9, 24, "");
		*/
		
		ButtonGroup tamanioLetra = new ButtonGroup();
		
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		
		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
		
		JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
		
		tamanioLetra.add(doce);
		
		tamanioLetra.add(dieciseis);
		
		tamanioLetra.add(veinte);
		
		tamanioLetra.add(veinticuatro);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", 12));
		
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", 16));
		
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", 20));
		
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamanio", 24));
		
		veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		tamanio.add(doce);
		tamanio.add(dieciseis);
		tamanio.add(veinte);
		tamanio.add(veinticuatro);
		
		// AGREGAR BARRA 
		
		mibarra.add(fuente);
		
		mibarra.add(estilo);
		
		mibarra.add(tamanio);
		
		laminamenu.add(mibarra);
		
		add(laminamenu, BorderLayout.NORTH);
		
		miarea = new JTextPane();
		
		add(miarea, BorderLayout.CENTER);
		
		// LISTA EMERGENTE CON CLIC DERECHO
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem negritaE = new JMenuItem("Negrita");
		
		JMenuItem cursivaE = new JMenuItem("Cursiva");
		
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		
		emergente.add(negritaE);
		
		emergente.add(cursivaE);
		
		miarea.setComponentPopupMenu(emergente);
		
		// AGREGAR BARRA DE HERRAMIENTAS
		
		/*JToolBar barraTool = new JToolBar();
		
		JButton negritaBarra = new JButton(new ImageIcon("src/graficos/negrita.png"));
		
		JButton cursivaBarra = new JButton(new ImageIcon("src/graficos/cursiva.png"));
		
		JButton subrayadoBarra = new JButton(new ImageIcon("src/graficos/subrayar.png"));
		
		JButton azulBarra = new JButton(new ImageIcon("src/graficos/azul.png"));
		
		JButton rojoBarra = new JButton(new ImageIcon("src/graficos/rojo.png"));
		
		JButton amarilloBarra = new JButton(new ImageIcon("src/graficos/amarillo.png"));
		
		JButton a_izquierda_barra = new JButton(new ImageIcon("src/graficos/a_izquierda.png"));
		
		JButton a_centrado_barra = new JButton(new ImageIcon("src/graficos/a_centrar.png"));
		
		JButton a_derecha_barra = new JButton(new ImageIcon("src/graficos/a_derecha.png"));
		
		JButton a_justificado_barra = new JButton(new ImageIcon("src/graficos/a_justificar.png"));
		
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		
		subrayadoBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Pone_azul", Color.BLUE));
		
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Pone_amarillo", Color.YELLOW));
		
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Pone_rojo", Color.RED));
		
		a_izquierda_barra.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		
		a_centrado_barra.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		
		a_derecha_barra.addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));				
		
		a_justificado_barra.addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		
		barraTool.add(negritaBarra);
		
		barraTool.add(cursivaBarra);
		
		barraTool.add(subrayadoBarra);
		
		barraTool.add(azulBarra);
		
		barraTool.add(rojoBarra);
		
		barraTool.add(amarilloBarra);		
		
		barraTool.add(a_izquierda_barra);
				
		barraTool.add(a_centrado_barra);
		
		barraTool.add(a_derecha_barra);
		
		barraTool.add(a_justificado_barra);
		*/
		
		barraTool = new JToolBar();
		
		configura_barra("src/graficos/negrita.png").addActionListener(new StyledEditorKit.BoldAction());
		
		configura_barra("src/graficos/cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
		
		configura_barra("src/graficos/subrayar.png").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barraTool.addSeparator();
		
		configura_barra("src/graficos/azul.png").addActionListener(new StyledEditorKit.ForegroundAction("azul", Color.BLUE));
		
		configura_barra("src/graficos/rojo.png").addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.RED));
		
		configura_barra("src/graficos/amarillo.png").addActionListener(new StyledEditorKit.ForegroundAction("amarillo", Color.YELLOW));
		
		barraTool.addSeparator();
		
		configura_barra("src/graficos/a_izquierda.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		
		configura_barra("src/graficos/a_centrar.png").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		
		configura_barra("src/graficos/a_derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		
		configura_barra("src/graficos/a_justificar.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		
		barraTool.setOrientation(1);
		
		add(barraTool, BorderLayout.WEST);
	}
	
	public JButton configura_barra(String ruta) {
		JButton boton = new JButton(new ImageIcon(ruta));  
		
		barraTool.add(boton);
		
		return boton;
	}
	
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam, String rutaArchivo) {
		
		JMenuItem elemMenu = new JMenuItem(rotulo, new ImageIcon(rutaArchivo));
		
		if(menu == "fuente") {
			fuente.add(elemMenu);
			
			if(tipoLetra == "Arial") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
			}
			else if(tipoLetra == "Cascadia Code") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Cascadia Code"));
			}
			else if(tipoLetra == "Verdana") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
			}
		}
			
		else if(menu == "estilo") {
			estilo.add(elemMenu);
			
			if(estilos == Font.BOLD) {
				elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				elemMenu.addActionListener(new StyledEditorKit.BoldAction());
			}else if(estilos == Font.ITALIC){
				elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
				elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		}
			
		else if(menu == "tamanio") {
			tamanio.add(elemMenu);
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
		}
			
		
		//elemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
	}
	
	/*
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
				if(letras.getStyle() == 1 || letras.getStyle() == 2)
					estiloLetra = 3;
				tipoTexto = letras.getFontName();
				tamanioLetra = letras.getSize();
			}else if(menu == "12" || menu == "16" || menu == "20" || menu == "24") {
				tipoTexto = letras.getFontName();
				estiloLetra = letras.getStyle();
			}
				
			
			miarea.setFont(new Font(tipoTexto, estiloLetra, tamanioLetra));
			
			System.out.println("Tipo " + tipoTexto + " estilo " + estiloLetra + " tamaño " + tamanioLetra);
			
			
		}
		
	}
	*/
	private JTextPane miarea;
	
	private JMenu fuente, estilo, tamanio;
	
	private Font letras;
	
	private JButton negritaBarra, cursivaBarra, subraBarra, azulBarra, rojoBarra, amarilloBarra, a_izquierda, a_centrado, a_derecha, a_justificado;
	
	private JToolBar barraTool;
}