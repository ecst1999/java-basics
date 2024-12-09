package sockets;

import java.awt.BorderLayout;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

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
			
			ArrayList<String> listaIps = new ArrayList<String>();
			
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
				
				if(!mensaje.equals("Online")) {
					
					areaTexto.append("\n" + nick + ": "  + mensaje + " para " + ip);
					
					Socket enviaDestinatario = new Socket(ip, 4020);
					
					ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
					
					paqueteReenvio.writeObject(paqueteRecibido);
					
					paqueteReenvio.close();
					
					enviaDestinatario.close();
					
					misocket.close();
					
				}else {
					//-----------------Detecta online----------------
					
					InetAddress localizacion = misocket.getInetAddress();
					
					String ipRemota = localizacion.getHostAddress();										
					
					listaIps.add(ipRemota);
					
					paqueteRecibido.setIps(listaIps);
					
					for(String z: listaIps) {
						System.out.println("Array: " + z);
					}
					
					//------------------------------------------------
				}
				
				
			}
						
					
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



