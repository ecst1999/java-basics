package bbdd_jdbc.conectabd.mvc.modelo;

import java.sql.*;
import bbdd_jdbc.conectabd.mvc.controlador.*;

public class CargaMenus {
	
	public CargaMenus() {
		
		miConexion = new ConectorDB();
		
	}
	
	public String ejecutaConsultas() {
		
		Productos miProducto = null;
		
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
			Statement secciones = accesoBBDD.createStatement();
			
			Statement paises = accesoBBDD.createStatement();
			
			rs = secciones.executeQuery("SELECT DISTINCT(seccion) FROM productos");
			
			rs2 = paises.executeQuery("SELECT DISTINCT(pais_origen) FROM productos");
			
			//while(rs.next()) {		
								
				
				miProducto = new Productos();
				
				miProducto.setSeccion(rs.getString(1));
				
				miProducto.setpOrigen(rs2.getString(1));
				
				
			//}
			
			rs.close();
			
			rs2.close();
			
			accesoBBDD.close();
			
		}catch(Exception e) {
			//e.printStackTrace();
		}
		
		return miProducto.getSeccion();
		
		
	}
	
	ConectorDB miConexion;
	
	public ResultSet rs, rs2;
	

}
