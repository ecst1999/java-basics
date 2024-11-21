package sockets;

import javax.swing.*;

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
	
}