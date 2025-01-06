package bbdd_jdbc.conectabd.mvc.controlador;

import java.sql.*;

public class ConectorDB {

	Connection miConexion = null;
	
	public ConectorDB() {
		
	}
	
	public Connection dameConexion() {
		
		try {
			miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return miConexion;
		
	}
}
