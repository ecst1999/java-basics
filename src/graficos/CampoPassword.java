package graficos;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CampoPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPassword marco = new MarcoPassword();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoPassword extends JFrame{
	
	public MarcoPassword() {
		
		setBounds(400, 300, 550, 400);
		
		add(new LaminaPassword());
		
		setVisible(true);
		
	}
	
}


class LaminaPassword extends JPanel{
	
	public LaminaPassword() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina_superior = new JPanel();
		
		lamina_superior.setLayout(new GridLayout(2, 2));
		
		add(lamina_superior, BorderLayout.NORTH);
		
		JLabel etiqueta1 = new JLabel("Usuario");
		
		JLabel etiqueta2 = new JLabel("Contraseña");
		
		JTextField c_usuario = new JTextField(15);
		
		c_clave = new JPasswordField(15);
		
		c_clave.getDocument().addDocumentListener(new CompruebaPass());
		
		lamina_superior.add(etiqueta1);
		
		lamina_superior.add(c_usuario);

		lamina_superior.add(etiqueta2);
		
		lamina_superior.add(c_clave);
		
		JButton enviar = new JButton("Enviar");
		
		add(enviar, BorderLayout.SOUTH);
	}
	
	private class CompruebaPass implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			char[] contrasenia;
			
			contrasenia = c_clave.getPassword();
			
			if(contrasenia.length < 8 || contrasenia.length > 12)
				c_clave.setBackground(Color.RED);
			else
				c_clave.setBackground(Color.WHITE);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			
			
		}
		
	}
	
	private JPasswordField c_clave;
	
}

