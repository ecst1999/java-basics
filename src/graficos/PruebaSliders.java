package graficos;

import java.awt.Font;

import javax.swing.*;

public class PruebaSliders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoSliders mimarco = new MarcoSliders();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoSliders extends JFrame{
	
	public MarcoSliders() {
		
		setBounds(550, 400, 550, 350);
		
		add(new LaminaSliders());
		
		setVisible(true);
	}
}

class LaminaSliders extends JPanel{
	
	public LaminaSliders() {
		
		JSlider control = new JSlider(0, 100, 25);
		
		control.setMajorTickSpacing(50);
		control.setMinorTickSpacing(25);
		
		control.setPaintTicks(true);
		
		control.setFont(new Font("Seif", Font.ITALIC, 12));
		
		control.setPaintLabels(true);
		
		control.setSnapToTicks(true);
		
		
		//control.setOrientation(SwingConstants.VERTICAL);
		
		add(control);
		
	}
	
}