package bbdd_jdbc.conectabd.mvc.modelo;

import java.sql.*;

public class EjecutaConsultas {

	public String filtrarBBDD(String seccion, String pais) {
		
		pruebas = "";
		
		if(!seccion.equals("Todos") && pais.equals("Todos")) {
			pruebas = "Has escogido sección";
		}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
			pruebas = "Has escogido país";
		}else {
			pruebas = "Has escogido ambas ";
		}
		
		return pruebas;
	}
	
	private String pruebas;
	
}
