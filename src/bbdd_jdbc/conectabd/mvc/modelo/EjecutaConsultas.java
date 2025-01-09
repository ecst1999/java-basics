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
			
			}else {
			
			}
			
		}catch(Exception e) {
			
		}
		
		
		return rs;
		
	}
	
	private ConectorDB miConexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaSeccion;
	
	private final String consultaSeccion = "SELECT seccion, nombre_articulo, precio, pais_origen FROM productos WHERE seccion = ?";
	
}
