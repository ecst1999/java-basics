package metadatos;

import java.sql.*;

public class Info_MetaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mostrarInfoTablas();
	}
	
	static void mostarInfo_BBDD() {
		Connection miConexion = null;
		
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			
			//Obtención de metadatos
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			// Mostrar la información de la base de datos
			
			System.out.println("Gestor de BBDD " + datosBBDD.getDatabaseProductName());
			
			System.out.println("Versión del gestor " + datosBBDD.getDatabaseProductVersion());
			
			System.out.println("Nombre del driver " + datosBBDD.getDriverName());
			
			System.out.println("Versión del driver " + datosBBDD.getDriverVersion());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void mostrarInfoTablas() {
		
		Connection miConexion = null;
		ResultSet miResultSet = null;
		
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");			
			
			//Obtención de metadatos
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			// Lista de tablas
			
			System.out.println("Lista de tablas");
			
			miResultSet = datosBBDD.getTables(null, null, "p%", null);
			
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("TABLE_NAME"));
			}
			
			//Lista de columnas de Productos
			
			System.out.println("");
			
			System.out.println("Campos de productos");
			
			miResultSet = datosBBDD.getColumns(null, null, "productos", null);
			
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("COLUMN_NAME"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
