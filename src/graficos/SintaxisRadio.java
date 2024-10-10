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
		
		setBounds(500, 300, 500, 500);
		
		add(new LaminaRadioSintaxis());
		
		setVisible(true);
	}
}

class LaminaRadioSintaxis extends JPanel{
	
	public LaminaRadioSintaxis() {
		
	}
	
}