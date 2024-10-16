package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EjemploSliders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_slider mimarco = new Marco_slider();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class Marco_slider extends JFrame{
	
	public Marco_slider() {
		
		setBounds(500, 400, 550, 350);
		
		add(new Lamina_slider());
		
		setVisible(true);
	}
}


class Lamina_slider extends JPanel{
	
	public Lamina_slider() {
		
		setLayout(new BorderLayout());
		
		rotulo = new JLabel("En un lugar de la Mancha de cuyo nombre...");
		
		add(rotulo, BorderLayout.CENTER);
		
		control = new JSlider(8, 50, 12);
		
		control.setMajorTickSpacing(20);
		control.setMinorTickSpacing(5);
		
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		
		control.setFont(new Font("Serif", Font.ITALIC, 10));
		
		control.addChangeListener(new EventoSlider());
		
		JPanel laminaSlider = new JPanel();
		
		laminaSlider.add(control);
		
		add(laminaSlider, BorderLayout.NORTH);
		
	}
	
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			//contador ++;
			//System.out.println("Estas manipulando el deslizante: " + control.getValue());
			
			rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
		}
		
	}
	
	private JLabel rotulo;
	
	private JSlider control;
	
	private static int contador; 
	
}
