package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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