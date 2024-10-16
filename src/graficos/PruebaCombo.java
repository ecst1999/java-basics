package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PruebaCombo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCombo mimarco = new MarcoCombo();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoCombo extends JFrame{
	
	public MarcoCombo() {
		
		setBounds(550, 300, 550, 400);
		
		add(new LaminaCombo());
		
		setVisible(true);
	}
	
}


class LaminaCombo extends JPanel{
	
	public LaminaCombo() {
		
		setLayout(new BorderLayout());
		
		texto = new JLabel("En un lugar de la Mancha de cuyo nombre....");
		
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		
		add(texto, BorderLayout.CENTER);
		
		JPanel laminaNorte = new JPanel();
		
		micombo = new JComboBox();
		
		micombo.setEditable(true);
		
		micombo.addItem("Serif");
		
		micombo.addItem("SansSerif");
		
		micombo.addItem("Monospaced");
		
		micombo.addItem("Dialog");
		
		micombo.addActionListener(new EventoCombo());
		
		laminaNorte.add(micombo);
		
		add(laminaNorte, BorderLayout.NORTH);
		
	}
	
	private class EventoCombo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			texto.setFont(new Font((String)micombo.getSelectedItem(), Font.PLAIN, 18));
		}
		
		
		
	}
	
	private JLabel texto;
	
	private JComboBox micombo;
}


