package bbdd_jdbc.conectabd;

import java.sql.*;

public class InsertaClientesPedido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection mi_coneccion = null;
		try {
			mi_coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			
			mi_coneccion.setAutoCommit(false);
			
			Statement miStatement = mi_coneccion.createStatement(); 
			
			String instruccion_sql = "INSERT INTO clientes (codigo_cliente, empresa, direccion, poblacion, telefono, responsable) VALUES (51, 'EJEMPLO', 'CIUDAD DE EJEMPLO', 'POBLACION DE EJEMPLO', '(09X) - XXXXXXXX', 'NOMBRE DE EJEMPLO')";
			
			miStatement.executeUpdate(instruccion_sql);
			
			String instruccion_sql_2 = "INSERT INTO pedidos (codigo_cliente, fecha_pedido, forma_pago, descuento, enviado) VALUES (51, '2022-03-15', 'EJEMPLO PAGO', 0.02, 1)";
			
			miStatement.executeUpdate(instruccion_sql_2);
			
			mi_coneccion.commit();
			
			System.out.println("Datos insertados correctamente");
			
		}catch(Exception e) {
			
			try {
				mi_coneccion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
	}

}
