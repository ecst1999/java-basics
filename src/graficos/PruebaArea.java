package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PruebaArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPruebaArea marco = new MarcoPruebaArea();
			
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}


class MarcoPruebaArea extends JFrame{
	
	public MarcoPruebaArea() {
		
		setTitle("Probando Área de texto");
		
		setBounds(500, 300, 500, 350);
		
		setLayout(new BorderLayout());
		
		laminaBotones = new JPanel();
		
		botonInsertar = new JButton("Insertar");
		
		botonInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				areaTexto.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme");
			}
			
		});
		
		laminaBotones.add(botonInsertar);
		
		botonSaltoLinea = new JButton("Salto línea");
		
		botonSaltoLinea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				boolean saltar =!areaTexto.getLineWrap();
				
				areaTexto.setLineWrap(saltar);
				/*
				if(saltar)
					botonSaltoLinea.setText("Quitar Salto");
				else
					botonSaltoLinea.setText("Salto línea");
				*/
				
				botonSaltoLinea.setText(saltar ? "Quitar Salto" : "Salto línea");
			}
		});
		
		laminaBotones.add(botonSaltoLinea);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
		areaTexto = new JTextArea(8, 20);
		
		laminaScroll = new JScrollPane(areaTexto);
		
		add(laminaScroll, BorderLayout.CENTER);
		
	}
	
	private JPanel laminaBotones;
	
	private JButton botonInsertar;
	
	private JButton botonSaltoLinea;
	
	private JTextArea areaTexto;
	
	private JScrollPane laminaScroll;
	
}









