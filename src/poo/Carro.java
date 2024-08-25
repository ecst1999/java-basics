package poo;

public class Carro {
	
	private int ruedas;
	
	private int largo;
	
	private int ancho;
	
	private int motor;
	
	private int peso_plataforma;
	
	private String color;
	
	private int peso_total;
	
	private boolean asientos_cuero, climatizador;
	
	public Carro() {
		
		ruedas = 4;
		
		largo = 2000;
		
		ancho = 300;
		
		motor = 1600;
		
		peso_plataforma = 500;
	}
	
	public String dime_datos_generales() {
		return "La plataforma del vehiculo tiene " + ruedas + " ruedas " + 
				". Mide " + largo/1000 + " metros con un ancho de " + ancho + 
				" cm y un peso de plataforma de " + peso_plataforma + " kg";
	}
	
	public void establece_color(String color_carro) {
		this.color = color_carro;
	}
	
	public String dime_color() {
		return "El color del carro es: " + color;
	}
	
	public void configura_asientos(String asientos_cuero) {
		if(asientos_cuero.equalsIgnoreCase("si"))
			this.asientos_cuero = true;	
		else 
			this.asientos_cuero = false;
				
	}
	
	public String dime_asientos() {
		if(asientos_cuero) 
			return "El carro tiene asientos de cuero";
		else 
			return "El carro tiene asientos de serie";
		
	}
	
	public void configura_climatizador(String climatizador) {
		if(climatizador.equalsIgnoreCase("si"))
			this.climatizador = true;
		else
			this.climatizador = false;
	}
	
	public String dime_climatizador() {
		if(climatizador)
			return "El carro tiene climatizador";
		else
			return "El carro tiene aire acondicionado";
	}
	
	public String dime_peso_carro() {
		int peso_carroceria = 500;
		
		peso_total = peso_plataforma + peso_carroceria;
		
		if(asientos_cuero)
			peso_total += 50;
		
		if(climatizador)
			peso_total += 20;
		
		return "El peso del carro es: " + peso_total;
	}
	
	public int precio_carro() {
		int precio_final = 10000;
		
		if(asientos_cuero)
			precio_final += 2000;
		
		if(climatizador)
			precio_final += 1500;
		
		return precio_final;
	}

}
