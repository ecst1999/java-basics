package colecciones;

import java.util.Objects;

public class Libro {

	public Libro(String titulo, String autor, int ISBN) {
		this.titulo = titulo;
		
		this.autor = autor;
		
		this.ISBN = ISBN;
	}
	
	public String toString() {
		return "El titulo del libro es: " + titulo + " el autor es: " + autor + " el ISBN es: " + ISBN;
	}
	
	/*
	public boolean equals(Object obj) {
		
		if(obj instanceof Libro) {
			
			Libro otro = (Libro) obj;
			
			return this.ISBN==otro.ISBN;
		}else
			return false;
		
	}
	*/
	
	
	
	private String titulo;
	
	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return ISBN == other.ISBN;
	}

	private String autor;
	
	private int ISBN;
	
}
