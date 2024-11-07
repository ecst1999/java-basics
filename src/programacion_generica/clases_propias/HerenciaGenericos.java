package programacion_generica.clases_propias;

public class HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Empleado Administrativa = new Empleado("Elena", 35, 1500);
		
		Jefe DirectorComercial = new Jefe("Ana", 27, 3550);
		
		Empleado nuevoEmpleado = DirectorComercial;*/
		
		Pareja<Empleado> Administrativo = new Pareja<Empleado>();
		
		Pareja<Jefe> DirectorComercial = new Pareja<Jefe>();
		
		Pareja.imprimirTrabajador(Administrativo);
		
		Pareja.imprimirTrabajador(DirectorComercial);
		
		//Pareja<Empleado> nuevoEmpleado = DirectorComercial;
	}

}
