package programacion_generica.clases_propias;

import java.util.GregorianCalendar;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombres[] = {"Raul", "Jose", "Maria", "Pepe", "Juan"};
		/*
		System.out.println(MisMatrices.getElementos(nombres));
		
		Persona listaPersonas[] = {new Persona("Juan"), 
				new Persona("Juan"),
				new Persona("Juan"),
				new Persona("Juan"),
				new Persona("Juan"),
				new Persona("Juan")};
		
		System.out.println(MisMatrices.getElementos(listaPersonas));*/
		
		System.out.println(MisMatrices.getMenor(nombres));
		
		/*
		Persona misEmpleados[] = {new Persona("Paco"), new Persona("Ana"), new Persona("Maria")};			
		
		System.out.println(MisMatrices.getMenor(misEmpleados));
		*/
		
		GregorianCalendar fechas[] = {new GregorianCalendar(2015, 07, 12), 
				new GregorianCalendar(2025, 07, 12),
				new GregorianCalendar(2035, 07, 12),
				new GregorianCalendar(2024, 07, 12),
				new GregorianCalendar(2015, 05, 12),
				new GregorianCalendar(2013, 06, 12),
				new GregorianCalendar(2012, 05, 12)};
		
		System.out.println(MisMatrices.getMenor(fechas));
	}
	
}


class MisMatrices {
	
	public static <T> String getElementos(T[] a) {
		return "El array tiene " + a.length + " elementos.";
	}
	
	public static <T extends Comparable> T getMenor(T[] a) {
		
		if(a == null || a.length==0)
			return null;
		
		T elementoMenor = a[0];
		
		for(int i = 1; i< a.length; i++) {
			
			if(elementoMenor.compareTo(a[i])>0) 
				elementoMenor=a[i];			
			
		}
		
		return elementoMenor;
		
	}
	
}

