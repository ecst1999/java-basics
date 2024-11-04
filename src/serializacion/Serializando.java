package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
		
		jefe.setIncentivo(5000);
		
		Empleado[] personal = new Empleado[3];
		
		personal[0] = jefe;
		
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		
		personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);
		
		try {
			
			/*ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("C:/Users/javie/Downloads/java_ser/empleado.dat"));
			
			escribiendo_fichero.writeObject(personal);
			
			escribiendo_fichero.close();*/
			
			ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("C:/Users/javie/Downloads/java_ser/empleado.dat"));
			
			Empleado[] personal_recuperado = (Empleado[]) recuperando_fichero.readObject();
			
			recuperando_fichero.close();
			
			for(Empleado e: personal_recuperado) {
				System.out.println(e);
			}
			
		}catch(Exception e) {
			
		}
		
	}

}


class Empleado implements Serializable {

	private static final long serialVersionUID = 3094084793466887860L;

	public Empleado(String n, double s, int a, int m, int d) {
		nombre = n;
		
		sueldos = s;
		
		GregorianCalendar calendario = new GregorianCalendar(a, m - 1, d);
		
		fechaContrato = calendario.getTime();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getSueldo() {
		return sueldos;
	}
	
	public Date getFechaContrato() {
		return fechaContrato;
	}
	
	public String toString() {
		return "Nombre: " + nombre + ", sueldo: " + sueldos + ", fecha de contrato: " + fechaContrato;
	}
	
	
	String nombre;
	
	double sueldos;
	
	Date fechaContrato;
}

class Administrador extends Empleado {

	private static final long serialVersionUID = 2047424698506340896L;

	public Administrador(String nombre, double sueldo, int anio, int mes, int dia) {
		super(nombre, sueldo, anio, mes, dia);
	}
	
	public double getSueldo() {
		return sueldos;
	}
	
	public void setIncentivo(double incentivo) {
		sueldos += incentivo;
	}
	
	
}


