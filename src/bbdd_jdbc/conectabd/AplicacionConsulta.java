package bbdd_jdbc.conectabd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class AplicacionConsulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Aplicacion marco = new Marco_Aplicacion();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}


class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");
		
		botonConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ejecutaConsulta();
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		
		/* --------------------------CONEXIÓN CON BASE DE DATOS--------------------------------*/
		
		try {
						
			
			mi_conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			
			Statement sentencia = mi_conexion.createStatement();
			
			//Carga de jcombobox Secciones
			
			String consulta = "SELECT DISTINCT(seccion) FROM productos";
			
			ResultSet rs = sentencia.executeQuery(consulta);
			
			while(rs.next())
				secciones.addItem(rs.getString(1));
			
			rs.close();
			
			//Carga de jcombobox Paises
			
			consulta = "SELECT DISTINCT(pais_origen) FROM productos";
			
			rs = sentencia.executeQuery(consulta);
			
			while(rs.next())
				paises.addItem(rs.getString(1));
			
			rs.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	private void ejecutaConsulta() {
		
		ResultSet rs = null;
		
		try {
			
			resultado.setText("");
			
			String seccion = (String) secciones.getSelectedItem();
			
			String pais = (String) paises.getSelectedItem();
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
				
				enviaConsultaSeccion = mi_conexion.prepareStatement(consultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
				
				rs = enviaConsultaSeccion.executeQuery();
				
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaPais = mi_conexion.prepareStatement(consultaPais);
				
				enviaConsultaPais.setString(1, pais);
				
				rs = enviaConsultaPais.executeQuery();
				
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaTodos = mi_conexion.prepareStatement(consultaTodos);
				
				enviaConsultaTodos.setString(1, seccion);
				
				enviaConsultaTodos.setString(2, pais);
				
				rs = enviaConsultaTodos.executeQuery();
			}
			
			
			
			while(rs.next()) {
				resultado.append(rs.getString(1));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(2));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(3));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(4));
				
				resultado.append("\n");
			}
				
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	private Connection mi_conexion;

	private PreparedStatement enviaConsultaSeccion, enviaConsultaPais, enviaConsultaTodos;		
	
	private final String consultaSeccion = "SELECT seccion, nombre_articulo, precio, pais_origen FROM productos WHERE seccion = ?";
	
	private final String consultaPais = "SELECT seccion, nombre_articulo, precio, pais_origen FROM productos WHERE pais_origen = ?";
	
	private final String consultaTodos = "SELECT seccion, nombre_articulo, precio, pais_origen FROM productos WHERE seccion = ? "
			+ "AND pais_origen = ?";
	
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	

	
}
