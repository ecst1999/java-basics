package bbdd_jdbc.conectabd;

import java.sql.*;

public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			//1. Crear la conexión 
			Connection mi_conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			
			//2. Preparar la consulta
			PreparedStatement mi_sentencia = mi_conexion.prepareStatement("SELECT seccion, nombre_articulo, pais_origen, importado FROM productos"
					+ " WHERE seccion = ? AND importado = ?");
			
			//3. Establecer parametros de consulta 
			mi_sentencia.setString(1, "textil");
			
			mi_sentencia.setInt(2, 1);
			
			//4. Ejecutar y recorrer la consulta
			ResultSet rs = mi_sentencia.executeQuery();
			
			while(rs.next()) 
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));								
						
			rs.close();
			
			//Reutilización de consulta SQL
			
			System.out.println("EJECUCIÓN DE 2DA CONSULTA");
			System.out.println();
			
			
			mi_sentencia.setString(1, "cuidado");
			
			mi_sentencia.setInt(2, 0);
			
			//4. Ejecutar y recorrer la consulta
			ResultSet rs2 = mi_sentencia.executeQuery();
			
			while(rs2.next()) 
				System.out.println(rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4));								
						
			rs2.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
