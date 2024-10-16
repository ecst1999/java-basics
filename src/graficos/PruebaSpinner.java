package graficos;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class PruebaSpinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoSpinner mimarco = new MarcoSpinner();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoSpinner extends JFrame{
	
	public MarcoSpinner() {
		
		setBounds(550, 350, 550, 350);
		
		add(new LaminaSpinner());
		
		setVisible(true);
	}
	
}


class LaminaSpinner extends JPanel{
	
	public LaminaSpinner() {
		
		//String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		//JSpinner control = new JSpinner(new SpinnerDateModel());
		
		// JSpinner control = new JSpinner(new SpinnerListModel(lista));
		
		JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1) {
			
			public Object getNextValue() {
				return super.getPreviousValue();
			}
			
			public Object getPreviousValue() {
				return super.getNextValue();
			}
			
		});
		
		Dimension d = new Dimension(200, 20);
		
		control.setPreferredSize(d);
		
		add(control);
		
	}
	/*
	private class MiModeloSpinner extends SpinnerNumberModel {
		
		public MiModeloSpinner() {
			
			super(5, 0, 10, 1);
			
		}
		
		public Object getNextValue() {
			return super.getPreviousValue();
		}
		
		public Object getPreviousValue() {
			return super.getNextValue();
		}
		
	}
	*/
	
}