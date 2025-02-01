package bbdd_jdbc.procAlmacenado;

import java.sql.*;

public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			//1. Crear conexión
			Connection mi_coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			
			CallableStatement miSentencia = mi_coneccion.prepareCall("{call muestra_clientes}");
			
			ResultSet rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " "  + rs.getString(3));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
		}

	}

}
