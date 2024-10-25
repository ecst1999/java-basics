package graficos;

import java.awt.BorderLayout;

import javax.swing.*;

public class PruebaDisposiciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCaja mimarco = new MarcoCaja();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoCaja extends JFrame{
	
	public MarcoCaja() {
		
		setTitle("Marco en la caja");
		
		setBounds(600, 350, 200, 200);
		
		JLabel rotulo1 = new JLabel("Nombre");
		
		JTextField texto1 = new JTextField(10);
		
		texto1.setMaximumSize(texto1.getPreferredSize());
		
		
		Box cajah1 = Box.createHorizontalBox();
		
		cajah1.add(rotulo1);
		
		cajah1.add(Box.createHorizontalStrut(10));
		
		cajah1.add(texto1);
		
		JLabel rotulo2 = new JLabel("Contraseña");
		
		JTextField texto2 = new JTextField(10);
		
		texto2.setMaximumSize(texto2.getPreferredSize());
		
		
		Box cajah2 = Box.createHorizontalBox();
		
		cajah2.add(rotulo2);
		
		cajah2.add(Box.createHorizontalStrut(10));
		
		cajah2.add(texto2);
		
		
		JButton boton1 = new JButton("Ok");
		
		JButton boton2 = new JButton("Cancelar");		
		
		Box cajah3 = Box.createHorizontalBox();
		
		cajah3.add(boton1);
		
		cajah3.add(Box.createGlue());
		
		cajah3.add(boton2);
		
		Box cajaVertical = Box.createVerticalBox();
		
		cajaVertical.add(cajah1);
		
		cajaVertical.add(cajah2);
		
		cajaVertical.add(cajah3);
		
		add(cajaVertical, BorderLayout.CENTER);
		
	}
}