package bbdd_jdbc.conectabd.mvc.principal;

import javax.swing.JFrame;

import bbdd_jdbc.conectabd.mvc.vista.MarcoAplicacion;

public class EjecutaMVC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoAplicacion miMarco = new MarcoAplicacion();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);
		
	}

}
