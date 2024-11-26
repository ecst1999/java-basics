package sockets;

import java.awt.BorderLayout;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoServidor marco = new MarcoServidor();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}


class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor() {
		
		setBounds(1200, 300, 280, 350);
		
		setTitle("Servidor");
		
		JPanel miLamina = new JPanel();
		
		miLamina.setLayout(new BorderLayout());
		
		areaTexto = new JTextArea();
		
		miLamina.add(areaTexto, BorderLayout.CENTER);
		
		add(miLamina);
		
		Thread hilo = new Thread(this);
		
		hilo.start();
	}
	
	private JTextArea areaTexto;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket servidor = new ServerSocket(4000);
			
			String nick, ip, mensaje;
			
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
				
				Socket misocket = servidor.accept(); 
				
				ObjectInputStream paqueteDatos = new ObjectInputStream(misocket.getInputStream());
				
				paqueteRecibido = (PaqueteEnvio)  paqueteDatos.readObject();
				
				nick = paqueteRecibido.getNick();
				
				ip = paqueteRecibido.getIp();
				
				mensaje = paqueteRecibido.getMensaje();
				
				/*DataInputStream flujoEntrada = new DataInputStream(misocket.getInputStream());
				
				String mensajeTexto = flujoEntrada.readUTF();
				
				areaTexto.append("\n" + mensajeTexto);*/
				
				areaTexto.append("\n" + nick + ": "  + mensaje + " para " + ip);
				
				Socket enviaDestinatario = new Socket("192.168.100.20", 8000);
				
				ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
				
				paqueteReenvio.writeObject(paqueteRecibido);
				
				enviaDestinatario.close();
				
				misocket.close();
			}
						
					
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



