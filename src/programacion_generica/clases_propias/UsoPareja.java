package programacion_generica.clases_propias;

public class UsoPareja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pareja<String> una = new Pareja<String>(); 
		
		una.setPrimero("Juan");
		
		System.out.println(una.getPrimero());
		
		Persona pers1 = new Persona("Raul Santana");
		
		Pareja<Persona> dos = new Pareja<Persona>();
		
		dos.setPrimero(pers1);
		
		System.out.println(dos.getPrimero());
	}

}


class Persona{
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre;
	}

	private String nombre;
}

