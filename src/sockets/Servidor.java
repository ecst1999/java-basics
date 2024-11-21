package sockets;

import javax.swing.*;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoServidor marco = new MarcoServidor();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}


class MarcoServidor extends JFrame{
	
	public MarcoServidor() {
		
		setBounds(600, 300, 280, 350);
		
		setTitle("Servidor");
		
		add(new LaminaMarcoServidor());
	}
}

class LaminaMarcoServidor extends JPanel{
	
}