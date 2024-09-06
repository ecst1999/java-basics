package poo;

import java.util.Arrays;
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
		
		Jefatura jefe_RRHH = new Jefatura("Steve", 55000, 2006, 9, 25);
		
		jefe_RRHH.setIncentivo(2570);
				
		Empleado[] misEmpleados = new Empleado[6]; 
		
		
		misEmpleados[0] = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
		
		misEmpleados[1] = new Empleado("Ana Lopez", 95000, 1995, 06, 2);
		
		misEmpleados[2] = new Empleado("María Martín", 105000, 2002, 03, 15);
		
		misEmpleados[3] = new Empleado("Fernando Fernández");
		
		misEmpleados[4] = jefe_RRHH;
		
		misEmpleados[5] = new Jefatura("Maria Becerra", 95000, 1999, 5, 26);
		
		Jefatura jefe_Finanzas = (Jefatura) misEmpleados[5];
		
		jefe_Finanzas.setIncentivo(500);				
		
		System.out.println(jefe_Finanzas.tomar_desisiones("Dar más días de vacaciones a los empleados"));
		
		System.out.println("El Jefe " + jefe_Finanzas.getNombre() + " tiene un bonus de " + 
				jefe_Finanzas.estableceBonos(500));
		
		System.out.println(misEmpleados[3].getNombre() + " tiene un bonus de " + 
				misEmpleados[3].estableceBonos(200));
		
		for(Empleado empl: misEmpleados) {
			empl.subirSueldo(5); 
		}
		
		Arrays.sort(misEmpleados);
		
		for(Empleado empl: misEmpleados) {
			System.out.println("Nombre " + empl.getNombre() + " sueldo: " + empl.getSueldo()
		     + " fecha de alta: " + empl.getAltaContrato());					
		}
	}

}


class Empleado implements Comparable, Trabajadores {
		
	public Empleado(String nom, double sueld, int anio, int mes, int dia) {
		
		nombre = nom;
		
		sueldo = sueld;
		
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
		
		altaContrato = calendario.getTime(); 
		
		Id = IdSiguiente;
		
		IdSiguiente++;
				
	}
	
	public Empleado(String nom) {
		this(nom, 30000, 2000, 01, 01);
	}
	
	public double estableceBonos(double gratificacion) {
		return Trabajadores.bonus_base + gratificacion;
	}
	
	public String getNombre() {
		return nombre + " Id: " + Id;
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
	
	public int compareTo(Object miObjeto) {
		Empleado otroEmpleado =(Empleado) miObjeto;
		
		if(this.sueldo < otroEmpleado.sueldo)
			return -1;
		if(this.sueldo > otroEmpleado.sueldo)
			return 1;
		
		return 0;
	}	


	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	private int Id;
	
	private static int IdSiguiente = 1;

	
		
}

class Jefatura extends Empleado implements Jefes {
	
	public Jefatura(String nom, double sueld, int anio, int mes, int dia) {
		super(nom, sueld, anio, mes, dia);
	}
	
	public String tomar_desisiones(String decision) {
		return "Un miembro de la dirección a tomado la decisión: " + decision;
	}
	
	public double estableceBonos(double gratificacion) {
		double prima = 2000;
		
		return Trabajadores.bonus_base + gratificacion + prima;
	}
	
	public void setIncentivo(double b) {
		incentivo = b;
	}
	
	public double getSueldo() {
		double sueldoJefe = super.getSueldo();
		
		return sueldoJefe + incentivo;
	}
	
	private double incentivo;
		
}



