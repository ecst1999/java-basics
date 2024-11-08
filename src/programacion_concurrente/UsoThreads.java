package programacion_concurrente;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class PelotaHilos implements Runnable{
	
	public PelotaHilos(Pelota unaPelota, Component componente) {
		this.pelota = unaPelota;
		
		this.componente = componente;
	}
	
	public void run() {
		
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		
		//while(!Thread.interrupted()) {
			
		while(!Thread.currentThread().isInterrupted()) {
		
		//for (int i=1; i<=3000; i++){
			
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			
			
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			
		}
		
		System.out.println("Estado del hilo al finalizar: " + Thread.currentThread().isInterrupted());
	}
	
	private Pelota pelota;
	
	private Component componente;
	
}


class Pelota{
	
	// Mueve la pelota invirtiendo posición si choca con límites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}


class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(600,300,600,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		//Creación de botones
		
		arranca1 = new JButton("Hilo 1");
		
		arranca2 = new JButton("Hilo 2");
		
		arranca3 = new JButton("Hilo 3");
		
		detiene1 = new JButton("Detener 1");
		
		detiene2 = new JButton("Detener 2");
		
		detiene3 = new JButton("Detener 3");
		
		//Agregar listeners
		
		arranca1.addActionListener(new ActionListener() {
						
			public void actionPerformed(ActionEvent e) {
				
				comienza_el_juego(e);
				
			}
			
		});
		
		arranca2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				comienza_el_juego(e);
				
			}
			
		});
		
		arranca3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				comienza_el_juego(e);
				
			}
			
		});
		
		detiene1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				detener(e);
				
			}
			
		});
		
		
		detiene2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				detener(e);
				
			}
			
		});
		
		detiene3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				detener(e);
				
			}
			
		});


		
		//Agregar botones en la lamina 
		
		laminaBotones.add(arranca1);
		
		laminaBotones.add(arranca2);
		
		laminaBotones.add(arranca3);
		
		laminaBotones.add(detiene1);
		
		laminaBotones.add(detiene2);
		
		laminaBotones.add(detiene3);
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
		
	
	//Añade pelota y la bota 1000 veces
	
	public void comienza_el_juego (ActionEvent e){
							
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable r = new PelotaHilos(pelota, lamina);
			
			if(e.getSource().equals(arranca1)) {
				t1 = new Thread(r);
				
				t1.start();	
			}else if(e.getSource().equals(arranca2)) {
				t2 = new Thread(r);
				
				t2.start();
			}else if(e.getSource().equals(arranca3)) {
				t3 = new Thread(r);
				
				t3.start();
			}
			
			
		
	}
	
	// Detiene la ejecución del hilo
	public void detener(ActionEvent e) {
		
		//t.stop();
		
		//t.interrupt();
		
		if(e.getSource().equals(detiene1)) {
			t1.interrupt();
		}else if(e.getSource().equals(detiene2)) {
			t2.interrupt();
		}else if(e.getSource().equals(detiene3)) {
			t3.interrupt();
		}
		
		
	}
	
	private LaminaPelota lamina;
	
	Thread t1, t2, t3;
	
	JButton arranca1, arranca2, arranca3, detiene1, detiene2, detiene3;
}

