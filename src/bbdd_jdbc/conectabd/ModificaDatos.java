package bbdd_jdbc.conectabd;

import java.sql.*;

public class ModificaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//1. Crear conexión
			Connection mi_coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			
			//2. Crear objeto Statement			
			Statement mi_statement = mi_coneccion.createStatement();
			
			// String instruccion_sql = "INSERT INTO productos values (null, 'cuidado', 'desodorante AXE', 4.95, '2024-02-21', 1,'Peru');";
			
			// String instruccion_sql = "UPDATE productos SET precio= precio*2 WHERE codigo = 7 ";
			String instruccion_sql = "DELETE FROM productos WHERE codigo = 5;";
			
			mi_statement.executeUpdate(instruccion_sql);
			
			System.out.println("Datos eliminados correctamente");
			
		}catch(Exception e) {			
			e.printStackTrace();
		}
	}

}
