package bbdd_jdbc.conectabd.mvc.controlador;

import java.awt.event.*;
import java.sql.ResultSet;

import bbdd_jdbc.conectabd.mvc.modelo.*;
import bbdd_jdbc.conectabd.mvc.vista.*;

public class ControladorBotonEjecuta implements ActionListener {

	
	public ControladorBotonEjecuta(MarcoAplicacion marco) {
		elMarco = marco;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String seleccionSeccion = (String) elMarco.secciones.getSelectedItem();
		
		String seleccionPais = (String) elMarco.paises.getSelectedItem();
		
		resultadoConsulta = obj.filtrarBBDD(seleccionSeccion, seleccionPais);
		
		try {
			
			elMarco.resultado.setText("");
			
			while(resultadoConsulta.next()) {
				
				elMarco.resultado.append(resultadoConsulta.getString(1));
				
				elMarco.resultado.append(" | ");
				
				elMarco.resultado.append(resultadoConsulta.getString(2));	
				
				elMarco.resultado.append(" | ");
				
				elMarco.resultado.append(resultadoConsulta.getString(3));
				
				elMarco.resultado.append(" | ");
				
				elMarco.resultado.append(resultadoConsulta.getString(4));
				
				elMarco.resultado.append("\n");
				
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	private MarcoAplicacion elMarco;
	
	private EjecutaConsultas obj = new EjecutaConsultas();
	
	private ResultSet resultadoConsulta;

}
