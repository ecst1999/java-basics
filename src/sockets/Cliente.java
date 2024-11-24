package sockets;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCliente marco = new MarcoCliente();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente() {
		
		setBounds(600, 300, 280, 350);
		
		setTitle("Cliente");
		
		add(new LaminaMarcoCliente());
	}
	
}

class LaminaMarcoCliente extends JPanel{

	public LaminaMarcoCliente() {
		
		JLabel texto = new JLabel("Cliente");
		
		add(texto);
		
		campo1 = new JTextField(20);
		
		add(campo1);
		
		miboton = new JButton("Enviar");
		
		miboton.addActionListener(new EnviaTexto());
		
		add(miboton);
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			try {
				Socket miSocket = new Socket("192.168.100.20", 4000);
				
				DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
				
				flujoSalida.writeUTF(campo1.getText());
				
				flujoSalida.close();
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}

		}
		
	}
	
	private JTextField campo1;
	
	private JButton miboton;
}


