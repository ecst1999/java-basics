package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona[] lasPersonas = new Persona[2];
		
		lasPersonas[0] = new Empleado2("Luis Conde ", 50000, 2009, 02, 25);
		lasPersonas[1] = new Alumno("Ana Lopez", "Biologia");
		
		for(Persona persona: lasPersonas) {
			System.out.println(persona.getNombre() + ", " +  persona.getDescripion());
		}
	}

}

abstract class Persona {
	
	public Persona(String nomb) {
		nombre = nomb;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public abstract String getDescripion();
	
	private String nombre;
	
}

class Empleado2 extends Persona {
	
	public Empleado2(String nom, double sueld, int anio, int mes, int dia) {
				
		super(nom);
		
		sueldo = sueld;
		
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
		
		altaContrato = calendario.getTime(); 
		
		Id = IdSiguiente;
		
		IdSiguiente++;
				
	}	 
	
	public String getDescripion() {
		return "Este empleado tiene un Id: " + Id + " con un sueldo = " + sueldo;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	
	public Date getAltaContrato() {
		return altaContrato;
	}
	
	public void subirSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		
		sueldo += aumento;
	}
	
	private double sueldo;
	
	private Date altaContrato;
	
	private int Id;
	
	private static int IdSiguiente = 1;
		
}


class Alumno extends Persona{
	
	public Alumno(String nombre, String car) {
		super(nombre);
		carrera = car;
	}
	
	public String getDescripion() {
		return "Este alumno esta estudiando la carrera de: " + carrera;
	}
	
	private String carrera;

}

