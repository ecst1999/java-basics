package bbdd_jdbc.conectabd.mvc.modelo;

import java.sql.*;

import bbdd_jdbc.conectabd.mvc.controlador.ConectorDB;

public class EjecutaConsultas {
	
	public EjecutaConsultas() {
		miConexion = new ConectorDB();
	}

	public ResultSet filtrarBBDD(String seccion, String pais) {
		
		Connection conecta = miConexion.dameConexion();
		
		rs = null;
		
		try {
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
				
				enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
				
				rs = enviaConsultaSeccion.executeQuery();
			
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaPais = conecta.prepareStatement(consultaPais);
				
				enviaConsultaPais.setString(1, pais);
				
				rs = enviaConsultaPais.executeQuery();
			
			}else {
			
				enviaConsultaTodos = conecta.prepareStatement(consultaTodos);
				
				enviaConsultaTodos.setString(1, seccion);
				
				enviaConsultaTodos.setString(2, pais);
				
				rs = enviaConsultaTodos.executeQuery();
				
			}
			
		}catch(Exception e) {
			
		}
		
		
		return rs;
		
	}
	
	private ConectorDB miConexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaSeccion, enviaConsultaPais, enviaConsultaTodos;
	
	private final String consultaSeccion = "SELECT seccion, nombre_articulo, precio, pais_origen FROM productos WHERE seccion = ?";
	
	private final String consultaPais = "SELECT seccion, nombre_articulo, precio, pais_origen FROM productos WHERE pais_origen = ?";
	
	private final String consultaTodos = "SELECT seccion, nombre_articulo, precio, pais_origen FROM productos WHERE seccion = ? AND pais_origen = ?";
	
}
