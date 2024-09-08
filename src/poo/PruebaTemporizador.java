package poo;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class PruebaTemporizador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DameHora oyente = new DameHora();
		
		Timer mitemporizador = new Timer(5000, oyente);
		
		mitemporizador.start();
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		
		System.exit(0);

	}

}



class DameHora implements ActionListener { 
	
	public void actionPerformed(ActionEvent e) {
		
		Date ahora = new Date();
		
		System.out.println("Te pongo la hora cada 5 seg: " + ahora);
		
		Toolkit.getDefaultToolkit().beep();
	}
}



