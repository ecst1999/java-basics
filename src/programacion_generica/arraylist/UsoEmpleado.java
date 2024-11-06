package programacion_generica.arraylist;

import java.util.*;

public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Empleado listaEmpleados[] = new Empleado[3];
		
		listaEmpleados[0] = new Empleado("Ana", 45, 2500);
		
		listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
		
		listaEmpleados[2] = new Empleado("María", 25, 2600);
		*/
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		//listaEmpleados.ensureCapacity(11);
		
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		
		listaEmpleados.add(new Empleado("María", 25, 2600));
		
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		
		listaEmpleados.add(new Empleado("María", 25, 2600));
		
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		
		listaEmpleados.add(new Empleado("Raul", 22, 180));
		
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		
		//listaEmpleados.trimToSize();
		
		//listaEmpleados.add(new Empleado("Olga", 22, 3000));
		/*
		listaEmpleados.set(1, new Empleado("Olga", 22, 3000));
		
		System.out.println(listaEmpleados.size());	
		
		System.out.println(listaEmpleados.get(4));
		
		for(int i = 0; i< listaEmpleados.size(); i++) {
			
			Empleado e = listaEmpleados.get(i);
			
			System.out.println(e);
			
		}*/
		
		/*				
		for(Empleado e : listaEmpleados) {
			System.out.println(e);
		}*/
		
		Empleado arrayEmpleado[] = new Empleado[listaEmpleados.size()];
		
		listaEmpleados.toArray(arrayEmpleado);
		
		for(Empleado e: arrayEmpleado) {
			System.out.println(e);
		}
		
	}

}


class Empleado{
	
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
