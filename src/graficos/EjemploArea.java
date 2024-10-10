package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EjemploArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoArea marco = new MarcoArea();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoArea extends JFrame{
	
	public MarcoArea() {
		
		setBounds(500, 300, 500, 350);
		
		add(new LaminaArea());
		
		setVisible(true);
	}
}

class LaminaArea extends JPanel{
	
	public LaminaArea() {
		
		miarea = new JTextArea(8, 20);
		
		JScrollPane laminaBarras = new JScrollPane(miarea);
		
		miarea.setLineWrap(true);
		
		add(laminaBarras);
		
		JButton miboton = new JButton("Aceptar");
		
		miboton.addActionListener(new GestionaArea());
		
		add(miboton);
		
	}
	
	private class GestionaArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println(miarea.getText());
		}
		
	}
	
	private JTextArea miarea;
	
}