package bbdd_jdbc.conectabd;

import java.sql.*;


public class Conecta_prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			//1. Crear conexión
			Connection mi_coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/invitaciones", "root", "12345");
			
			//2. Crear objeto Statement			
			Statement mi_statement = mi_coneccion.createStatement();
			
			//3. Ejecutar SQL
			ResultSet mi_resultado = mi_statement.executeQuery("SELECT * FROM boletos;");
			
			//4. Recorrer o leer el ResultSet
			
			while(mi_resultado.next()) {
				
				System.out.println(mi_resultado.getString("bol_slug") + " " + mi_resultado.getString("bol_estado") + " "  + mi_resultado.getString("created_at"));
				
			}
			
		}catch(Exception e) {
			System.out.println("No se puede conectar");
			e.printStackTrace();
		}
		
	}

}
