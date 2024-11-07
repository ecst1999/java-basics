package programacion_generica.clases_propias;

public class Empleado {
	
	public Empleado(String n, int e, double s) {
		nombre = n;
		
		edad = e;
		
		sueldo = s;
	}
	
	public String toString() {
		return "El empleado se llama " + nombre + ". Tiene " + edad + " años de edad y un salario de: " + sueldo + " dolares.";
	}
	
	String nombre;
	
	int edad;
	
	double sueldo;
	
}
