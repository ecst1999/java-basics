package colecciones;

import java.util.*;

public class PruebaTreeSet {

	public static void main(String[] args) {
		/*
		TreeSet<String> ordenaPersonas = new TreeSet<String>();
		
		ordenaPersonas.add("Selen");
		
		ordenaPersonas.add("Amanda");
		
		ordenaPersonas.add("Diana");
		
		for(String s: ordenaPersonas) {
			System.out.println(s);
		}*/
		
		Articulo primero = new Articulo(1, "Primer artículo");
		
		Articulo segundo = new Articulo(2, "Segundo artículo");
		
		Articulo tercero = new Articulo(3, "Tercero artículo");
				
						
		TreeSet<Articulo> ordenaArticulo = new TreeSet<Articulo>();
		
		ordenaArticulo.add(tercero);
		
		ordenaArticulo.add(primero);
		
		ordenaArticulo.add(segundo);
		
		for(Articulo ar: ordenaArticulo) 
			System.out.println(ar.getDescripcion());
		
		//------------------------------------------------------------------------
		
		System.out.println("------------------------------------------------");
		
		Articulo comparadorArticulos = new Articulo();
		
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos); 
		
		ordenaArticulos2.add(tercero);
		
		ordenaArticulos2.add(primero);
		
		ordenaArticulos2.add(segundo);
		
		for(Articulo ar: ordenaArticulos2)
			System.out.println(ar.getDescripcion());
		
	}
	
	
}


class Articulo implements Comparable<Articulo>, Comparator<Articulo>{
	
	public Articulo() {
		
	}
	
	public Articulo(int num, String desc) {
		numero_articulo = num;
		descripcion = desc;
	}

	@Override
	public int compareTo(Articulo o) {
		// TODO Auto-generated method stub
		return numero_articulo - o.numero_articulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	private int numero_articulo;
	
	private String descripcion;

	@Override
	public int compare(Articulo a1, Articulo a2) {
		// TODO Auto-generated method stub
		String descripcionA = a1.descripcion;
		
		String descripcionB = a2.descripcion;
		
		return descripcionA.compareTo(descripcionB);
	}
	
}