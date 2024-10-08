package graficos;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPrueba marco = new MarcoPrueba();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoPrueba extends JFrame{
	
	public MarcoPrueba() {
		
		setBounds(500, 300, 500, 350);
		
		add(new LaminaPrueba());
		
		setVisible(true);
		
	}
}

class LaminaPrueba extends JPanel{
	
	public LaminaPrueba() {
		JTextField micampo = new JTextField(20);
		
		Document miDoc = micampo.getDocument();
		
		miDoc.addDocumentListener(new EscuchaTexto());
		
		add(micampo);
	}
	
	private class EscuchaTexto implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			System.out.println("Has insertado texto");
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			System.out.println("Has borrado texto");
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
 
			
		}
		
	}
	
}