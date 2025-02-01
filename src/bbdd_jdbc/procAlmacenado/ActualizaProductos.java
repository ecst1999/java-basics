package bbdd_jdbc.procAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

public class ActualizaProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nPrecio = Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
		
		String nArticulo = JOptionPane.showInputDialog("Introduce nombre artículo");

		try {
			
			Connection mi_coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			
			CallableStatement miSentencia = mi_coneccion.prepareCall("{call actualiza_prod(? , ?)}");
			
			miSentencia.setInt(1, nPrecio);
			
			miSentencia.setString(2, nArticulo);
			
			miSentencia.execute();
			
			System.out.println("Actualización OK");
			
		}catch(Exception e) {
			
		}
	}

}
