package programacion_generica.clases_propias;

public class Pareja<T> {
	
	public Pareja() {
		primero = null;
	}
	
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	
	public T getPrimero() {
		return primero;
	}

	private T primero;
	
}
