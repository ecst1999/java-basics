package bbdd_jdbc.aplicacion_final;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AplicacionUniversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBBDD marco = new MarcoBBDD();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}


class MarcoBBDD extends JFrame{
	public MarcoBBDD() {
		setBounds(-800, 250, 700, 700);
		
		add(new LaminaBBDD());
	}
}

class LaminaBBDD extends JPanel{
	
	private final String ruta_archivo = "C:/Users/javie/Desktop/datos_configs.txt";
	
	public LaminaBBDD() {
		
		setLayout(new BorderLayout());
		
		comboTablas = new JComboBox();
		
		areaInformacion = new JTextArea();
		
		add(areaInformacion, BorderLayout.CENTER);
		
		add(comboTablas, BorderLayout.NORTH);
		
		conectarBBDD();
		
		obtenerTablas();
		
		comboTablas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombreTabla = (String) comboTablas.getSelectedItem();
				
				mostrarInfoTabla(nombreTabla);
			}
		});		
		
	}
	
	public void conectarBBDD() {
		mi_conexion = null;
		
		String datos[] = new String[4];
		
		try {
			
			entrada = new FileReader(ruta_archivo);
		}catch(IOException e) {
			
			JFileChooser chooser = new JFileChooser();
			
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Archivos de texto", "txt");
		    
		    chooser.setFileFilter(filter);
		    
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	
		       try {
					entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       
		    }
		}
		
		
		try {
			BufferedReader mibuffer = new BufferedReader(entrada);
			
			for(int i = 0; i <= 3; i++) {
				datos[i] = mibuffer.readLine();
			}
			
			mi_conexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);
			
			entrada.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
			
			
		
	}
	
	public void obtenerTablas() {
		ResultSet mi_result_set = null;
		
		String datos[] = new String[4];
		
		try {
			
			entrada = new FileReader(ruta_archivo);
		}catch(IOException e) {
			JFileChooser chooser = new JFileChooser();
			
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Archivos de texto", "txt");
		    
		    chooser.setFileFilter(filter);
		    
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	
		       try {
					entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       
		    }
		}
			
		try {
			BufferedReader mibuffer = new BufferedReader(entrada);
			
			for(int i = 0; i <= 3; i++) {
				datos[i] = mibuffer.readLine();
			}
			
			DatabaseMetaData datosBBDD = mi_conexion.getMetaData();
			
			mi_result_set = datosBBDD.getTables(datos[3], null, null, null);
			
			entrada.close();
			
			while(mi_result_set.next()) {
				comboTablas.addItem(mi_result_set.getString("TABLE_NAME"));
			}
			
			mi_result_set.close();
			
		}catch(Exception e) {
			
		}
	}
	
	public void mostrarInfoTabla(String tabla) {
		ArrayList<String> campos = new ArrayList<String>();

		String consulta = "SELECT * FROM " + tabla;
		
		try {
			
			areaInformacion.setText("");
			
			Statement miStatement = mi_conexion.createStatement();
			
			ResultSet miResult = miStatement.executeQuery(consulta);
			
			ResultSetMetaData rsBBDD = miResult.getMetaData();
			
			for(int i= 1; i <= rsBBDD.getColumnCount(); i++) 				
				campos.add(rsBBDD.getColumnLabel(i));
			
			while(miResult.next()) {
				
				for(String nombreCampo: campos) {
					areaInformacion.append(miResult.getString(nombreCampo) + " ");
				}
				
				areaInformacion.append("\n");
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private JComboBox comboTablas;
	
	private JTextArea areaInformacion;
	
	private Connection mi_conexion;
	
	private FileReader entrada;
	
}