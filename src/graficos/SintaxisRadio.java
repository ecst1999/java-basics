package graficos;

import javax.swing.*;

public class SintaxisRadio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRadioSintaxis mimarco = new MarcoRadioSintaxis();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoRadioSintaxis extends JFrame{
	
	public MarcoRadioSintaxis() {
		
		setBounds(500, 300, 500, 300);
		
		add(new LaminaRadioSintaxis());
		
		setVisible(true);
	}
}

class LaminaRadioSintaxis extends JPanel{
	
	public LaminaRadioSintaxis() {
		
		ButtonGroup migrupo = new ButtonGroup();
		
		ButtonGroup migrupo2 = new ButtonGroup();
		
		JRadioButton boton1 = new JRadioButton("Azul", false);
		
		JRadioButton boton2 = new JRadioButton("Rojo", true);
		
		JRadioButton boton3 = new JRadioButton("Verde", false);
		
		JRadioButton boton4 = new JRadioButton("Masculino", false);
		
		JRadioButton boton5 = new JRadioButton("Femenino", false);
		
		migrupo.add(boton1);
		
		migrupo.add(boton2);
		
		migrupo.add(boton3);
		
		migrupo2.add(boton4);
		
		migrupo2.add(boton5);
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		add(boton4);
		
		add(boton5);
		
	}
	
}