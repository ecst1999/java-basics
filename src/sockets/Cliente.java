package sockets;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;
import java.net.*;
import java.util.ArrayList;

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
		
		addWindowListener(new EnvioOnline());
	}
	
}

//-------------------ENVIO DE SEÑAL ONLINE---------------------
class EnvioOnline extends WindowAdapter{
	
	public void windowOpened(WindowEvent e) {
		
		try {
			
			Socket miSocket = new Socket("192.168.100.20", 4000);
			
			PaqueteEnvio datos = new PaqueteEnvio();
			
			datos.setMensaje("Online");
			
			ObjectOutputStream par = new ObjectOutputStream(miSocket.getOutputStream());
			
			par.writeObject(datos);
			
			par.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}

class LaminaMarcoCliente extends JPanel implements Runnable{

	public LaminaMarcoCliente() {
		
		String nick_usuario = JOptionPane.showInputDialog("Nick: ");
		
		JLabel n_nick = new JLabel("Nick: ");
		
		add(n_nick);
		
		nick = new JLabel();
		
		nick.setText(nick_usuario);
		
		add(nick);
		
		JLabel texto = new JLabel(" Online: ");
		
		add(texto);
		
		ip = new JComboBox();
		/*
		ip.addItem("Usuario 1");
		
		ip.addItem("Usuario 2");
		
		ip.addItem("Usuario 3");		
		
		ip.addItem("192.168.100.42");
		
		ip.addItem("192.168.100.20");
		*/
		
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
			
			campoChat.append("\n" + campo1.getText());
			// TODO Auto-generated method stub

			try {
				Socket miSocket = new Socket("192.168.100.20", 4000);
				
				PaqueteEnvio datos = new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				
				datos.setIp(ip.getSelectedItem().toString());
				
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
	
	private JTextField campo1;
	
	private JLabel nick;
	
	private JComboBox ip;
	
	private JButton miboton;
	
	private JTextArea campoChat;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			ServerSocket servidorCliente = new ServerSocket(4020);
			
			Socket cliente;
			
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
				
				cliente = servidorCliente.accept();
				
				ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
				
				paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();
				
				if(!paqueteRecibido.getMensaje().equals("Online")) {
					
					campoChat.append("\n " + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
					
				}else {
					//campoChat.append("\n" + paqueteRecibido.getIps());
					
					ArrayList<String> ipsMenu = new ArrayList<String>();
					
					ipsMenu = paqueteRecibido.getIps();
					
					ip.removeAllItems();
					
					for(String z : ipsMenu) {
						ip.addItem(z);
					}
					
				}
				
				
				
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
}


class PaqueteEnvio implements Serializable {
		
	private static final long serialVersionUID = -8400872870842477865L;
	
	private String nick, ip, mensaje;
	
	private ArrayList<String> Ips;

	public ArrayList<String> getIps() {
		return Ips;
	}

	public void setIps(ArrayList<String> ips) {
		Ips = ips;
	}

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





