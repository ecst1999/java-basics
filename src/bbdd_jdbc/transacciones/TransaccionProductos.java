package bbdd_jdbc.transacciones;

import java.sql.*;

import javax.swing.JOptionPane;

public class TransaccionProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection mi_coneccion = null;
		try {
			mi_coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			
			mi_coneccion.setAutoCommit(false);
			
			Statement miStatement = mi_coneccion.createStatement(); 
			
			
			String instruccion_sql = "DELETE FROM productos WHERE pais_origen =  'Italia' ";
			
			String instruccion_sql_2 = "DELETE FROM productos WHERE precio > 300";					
			
			String instruccion_sql_3 = "UPDATE productos SET precio = precio * 1.15";
			
			boolean ejecutar = ejecutar_transaccion();
			
			
			if(ejecutar) {
				
				miStatement.executeUpdate(instruccion_sql);
				
				miStatement.executeUpdate(instruccion_sql_2);
				
				miStatement.executeUpdate(instruccion_sql_3);
				
				mi_coneccion.commit();
				
				System.out.println("Se ejecuto la transacción correctamente");
			}else {
				System.out.println("No se realizo cambio alguno en base de datos");
			}
			
			
			System.out.println("Datos insertados correctamente");
			
		}catch(Exception e) {		
			
			try {
				mi_coneccion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
	}
	
	static boolean ejecutar_transaccion() {
		
		String ejecucion = JOptionPane.showInputDialog("¿Ejecutamos transacción?");
		
		if(ejecucion.equals("si")) return true;
		else return false;
	}

}
