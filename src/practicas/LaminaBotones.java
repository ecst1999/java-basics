package practicas;

import javax.swing.*;

public class LaminaBotones extends JPanel {

	public LaminaBotones(String titulo) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}
