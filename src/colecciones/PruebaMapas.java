package colecciones;

import java.util.*;

public class PruebaMapas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Empleado> personal = new HashMap<String, Empleado>();
		
		personal.put("145", new Empleado("Juan"));
		
		personal.put("146", new Empleado("Maria"));
		
		personal.put("147", new Empleado("Ana"));
		
		personal.put("148", new Empleado("Selena"));
		
		System.out.println(personal);
		
		personal.remove("147");
		
		System.out.println(personal);
		
		personal.put("148", new Empleado("Natalia"));
		
		System.out.println(personal);
		
		//System.out.println(personal.entrySet());
		
		for(Map.Entry<String, Empleado> entrada: personal.entrySet()){
			
			String clave = entrada.getKey();
			
			Empleado valor = entrada.getValue();
			
			System.out.println("Clave=" + clave + ", Valor=" + valor);
			
		}
	}

}


class Empleado {
	
	public Empleado(String nombre) {
		this.nombre = nombre;
		
		sueldo = 2200;
	}
	
	public String toString() {
		return "[Nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}
	
	private String nombre;
	
	private double sueldo;
}
