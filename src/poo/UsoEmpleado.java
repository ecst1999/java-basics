package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Empleado empleado1 = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		
		Empleado empleado2 = new Empleado("Ana Lopez", 95000, 1995, 06, 2);
		
		Empleado empleado3 = new Empleado("María Martín", 105000, 2002, 03, 15);	
		
		empleado1.subirSueldo(5);
		
		empleado2.subirSueldo(5);
		
		empleado3.subirSueldo(5);
		
		System.out.println("Nombre " + empleado1.getNombre() + " sueldo: " + empleado1.getSueldo()
				+ " fecha de alta: " + empleado1.getAltaContrato());
		
		System.out.println("Nombre " + empleado2.getNombre() + " sueldo: " + empleado2.getSueldo()
		+ " fecha de alta: " + empleado2.getAltaContrato());
		
		System.out.println("Nombre " + empleado3.getNombre() + " sueldo: " + empleado3.getSueldo()
		+ " fecha de alta: " + empleado3.getAltaContrato());
		 */
		
		Empleado[] misEmpleados = new Empleado[3]; 
		
		
		misEmpleados[0] = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		
		misEmpleados[1] = new Empleado("Ana Lopez", 95000, 1995, 06, 2);
		
		misEmpleados[2] = new Empleado("María Martín", 105000, 2002, 03, 15);
		
		
		for(Empleado empl: misEmpleados) {
			empl.subirSueldo(5);					
		}
		
		for(Empleado empl: misEmpleados) {
			System.out.println("Nombre " + empl.getNombre() + " sueldo: " + empl.getSueldo()
		     + " fecha de alta: " + empl.getAltaContrato());					
		}
	}

}



class Empleado {
		
	public Empleado(String nom, double sueld, int anio, int mes, int dia) {
		
		nombre = nom;
		
		sueldo = sueld;
		
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
		
		altaContrato = calendario.getTime(); 
				
	}
	
	public String getNombre() {
		return nombre;
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


	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	
}