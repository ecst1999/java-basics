package sockets;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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

class LaminaMarcoCliente extends JPanel implements Runnable{

	public LaminaMarcoCliente() {
		
		nick = new JTextField(5);
		
		add(nick);
		
		JLabel texto = new JLabel("- Chat- ");
		
		add(texto);
		
		ip = new JTextField(8);
		
		add(ip);
		
		campoChat = new JTextArea(12, 20);
		
		add(campoChat);
		
		campo1 = new JTextField(20);
		
		add(campo1);
		
		miboton = new JButton("Enviar");
		
		miboton.addActionListener(new EnviaTexto());
		
		add(miboton);
		
		Thread mihilo = new Thread(this);
		
		mihilo.start();
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			try {
				Socket miSocket = new Socket("192.168.100.20", 4000);
				
				PaqueteEnvio datos = new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				
				datos.setIp(ip.getText());
				
				datos.setMensaje(campo1.getText());
				
				ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
				
				paqueteDatos.writeObject(datos);
				
				miSocket.close();
				
				/*DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
				
				flujoSalida.writeUTF(campo1.getText());
				
				flujoSalida.close();*/
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}

		}
		
	}
	
	private JTextField campo1, nick, ip;
	
	private JButton miboton;
	
	private JTextArea campoChat;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			ServerSocket servidorCliente = new ServerSocket(8000);
			
			Socket cliente;
			
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
				
				cliente = servidorCliente.accept();
				
				ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
				
				paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();
				
				campoChat.append("\n " + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje() );
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
}


class PaqueteEnvio implements Serializable {
		
	private static final long serialVersionUID = -8400872870842477865L;
	
	private String nick, ip, mensaje;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}





