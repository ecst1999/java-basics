package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PruebaChecks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCheck mimarco = new MarcoCheck();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoCheck extends JFrame{
	
	public MarcoCheck() {
		setBounds(550, 300, 550, 350);
			
		add(new LaminaCheck());
		
		setVisible(true);
	}
	
}

class LaminaCheck extends JPanel{
	
	public LaminaCheck() {			
		
		setLayout(new BorderLayout());
		
		Font mifuente = new Font("Serif", Font.PLAIN, 24); 
		
		texto = new JLabel("En un lugar de la Mancha de cuyo nombre....");
		
		texto.setFont(mifuente);
		
		JPanel laminaTexto = new JPanel();
		
		laminaTexto.add(texto);
		
		add(laminaTexto, BorderLayout.CENTER);
		
		check1 = new JCheckBox("Negrilla");
		
		check2 = new JCheckBox("Cursiva");
		
		check1.addActionListener(new ManejaChecks());
		
		check2.addActionListener(new ManejaChecks());
		
		JPanel laminaChecks = new JPanel();
		
		laminaChecks.add(check1);
		
		laminaChecks.add(check2);
		
		add(laminaChecks, BorderLayout.SOUTH);
		
	}
	
	private class ManejaChecks implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int tipo = 0;
			
			if(check1.isSelected()) tipo+=Font.BOLD;
			
			if(check2.isSelected()) tipo+=Font.ITALIC; 
			
			texto.setFont(new Font("Serif", tipo, 24));
				
			
		}
		
	}
	
	private JLabel texto;
	
	private JCheckBox check1, check2;
	
}



