package poo;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleados trabajador1 = new Empleados("Juan Pérez");
		Empleados trabajador2 = new Empleados("Ana Martinez");		
		Empleados trabajador3 = new Empleados("Antonio");
		Empleados trabajador4 = new Empleados("Maria");
		
		trabajador1.setSeccion("RRHH");
		
		System.out.println(trabajador1.getData() + "\n" + trabajador2.getData() + "\n" +
				trabajador3.getData() + "\n" + trabajador4.getData());
		
		System.out.println(Empleados.getIdSiguiente());
	}

}


class Empleados {

	private final String nombre;
	
	private String seccion;
	
	private int Id;
	
	private static int IdSiguiente = 1;
	
	public Empleados(String nom) {
		this.nombre = nom;
		this.seccion = "Administación";		
		Id = IdSiguiente;
		
		IdSiguiente++;
	}
	
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public String getData() {
		return "El nombre es " + nombre + " y la seccion donde trabaja es: " + seccion + 
				" y el Id es: " + Id;
	}
	
	public static String getIdSiguiente() {
		return "El IdSiguiente es: " + IdSiguiente;
	}
}