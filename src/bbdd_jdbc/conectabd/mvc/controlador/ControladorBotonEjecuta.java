package bbdd_jdbc.conectabd.mvc.controlador;

import java.awt.event.*;
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
		
		elMarco.resultado.append(obj.filtrarBBDD(seleccionSeccion, seleccionPais));
		
		elMarco.resultado.append("\n");
	}
	
	private MarcoAplicacion elMarco;
	
	private EjecutaConsultas obj = new EjecutaConsultas();

}
