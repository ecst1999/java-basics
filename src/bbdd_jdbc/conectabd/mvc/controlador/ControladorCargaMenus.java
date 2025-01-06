package bbdd_jdbc.conectabd.mvc.controlador;

import java.awt.event.*;

import bbdd_jdbc.conectabd.mvc.modelo.CargaMenus;
import bbdd_jdbc.conectabd.mvc.vista.MarcoAplicacion;

public class ControladorCargaMenus extends WindowAdapter{
	
	
	public ControladorCargaMenus(MarcoAplicacion marco) {
		
		elMarco = marco;
		
	}

	
	@Override
	public void windowOpened(WindowEvent e) {
		obj.ejecutaConsultas(); 		
		
		try {
			
			while(obj.rs.next()) 				
				elMarco.secciones.addItem(obj.rs.getString(1));
				
			
			
			while(obj.rs2.next()) 
				elMarco.paises.addItem(obj.rs2.getString(1));
			
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	CargaMenus obj = new CargaMenus();
	
	private MarcoAplicacion elMarco;

}
