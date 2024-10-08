package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PruebaTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoTexto marco = new MarcoTexto();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoTexto extends JFrame{
	
	public MarcoTexto() {
		setBounds(600, 300, 600, 350);
		
		add(new LaminaTexto());
		
		setVisible(true);
	}
}

class LaminaTexto extends JPanel{	
	
	public LaminaTexto() {
		
		setLayout(new BorderLayout());
		
		JPanel miLamina2 = new JPanel();
		
		miLamina2.setLayout(new FlowLayout());
		
		resultado = new JLabel("", JLabel.CENTER);
		
		JLabel texto1 = new JLabel("Email: ");
		
		miLamina2.add(texto1);
		
		campo1 = new JTextField(20);
		
		miLamina2.add(campo1);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton boton = new JButton("Comprobar");
		
		DameTexto miEvento = new DameTexto();
		
		boton.addActionListener(miEvento);
		
		miLamina2.add(boton);
		
		add(miLamina2, BorderLayout.NORTH);
				
	}
	
	private class DameTexto implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			int correcto = 0;
			
			String email = campo1.getText().trim();
			
			for(int i = 0; i < email.length(); i++) {
				
				if(email.charAt(i) == '@')
					correcto ++;
				
			}
			
			if(correcto != 1)
				resultado.setText("Incorrecto");
			else
				resultado.setText("Correcto");
			
			//System.out.println(campo1.getText());
						
		}
		
	}
	
	private JTextField campo1;
	
	private JLabel resultado;
	
}








