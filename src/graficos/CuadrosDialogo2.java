package graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CuadrosDialogo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCuadrosDialogo2 marco = new MarcoCuadrosDialogo2();
		
		marco.setVisible(true);
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoCuadrosDialogo2 extends JFrame{
	
	public MarcoCuadrosDialogo2() {
		
		setBounds(250, 250, 750, 550);
		
		setTitle("Prueba de dialogos");
		
		setLayout(new BorderLayout());
				
		Box fila1 = Box.createHorizontalBox();			
		Box fila2 = Box.createHorizontalBox();
		
		//CREACIÓN DE Columnas
		columna1 = Box.createVerticalBox();
		
		columna2 = Box.createVerticalBox();
		
		columna3 = Box.createVerticalBox();
		
		columna4 = Box.createVerticalBox();
		
		columna5 = Box.createVerticalBox();
		
		columna6 = Box.createVerticalBox();

		initClases();
		
		// Caja de opciones tipo de dialogo
		CrearOpciones(tipo, "Mensaje", 1, t_r_mensaje, columna1, true, 1);
		
		CrearOpciones(tipo, "Confirmar", 2, t_r_confirmar, columna1, false, 1);
		
		CrearOpciones(tipo, "Opcion", 3, t_r_opcion, columna1, false, 1);
		
		CrearOpciones(tipo, "Entrada", 4, t_r_entrada, columna1, false, 1);		
		//----------------------------------------------
		
		// Caja de opciones tipo de dialogo
		CrearOpciones(tipo_mensaje, "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE, t_m_error_message, columna2, true, 2);
		
		CrearOpciones(tipo_mensaje, "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE, t_m_information_message, columna2, false, 2);
		
		CrearOpciones(tipo_mensaje, "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE, t_m_warning_message, columna2, false, 2);
		
		CrearOpciones(tipo_mensaje, "QUESTION_MESSAGE", JOptionPane.QUESTION_MESSAGE, t_m_question_message, columna2, false, 2);
		
		CrearOpciones(tipo_mensaje, "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE, t_m_plain_message, columna2, false, 2);
		//----------------------------------------------
		
		// Caja de opciones tipo de dialogo
		CrearOpciones(mensaje, "Cadena", 1, t_cadena, columna3, true, 3);
		
		CrearOpciones(mensaje, "Icono", 2, t_icono, columna3, false, 3);
		
		CrearOpciones(mensaje, "Componente", 3, t_componente, columna3, false, 3);
		
		CrearOpciones(mensaje, "Otros", 4, t_otros, columna3, false, 3);
		
		CrearOpciones(mensaje, "Object[]", 5, t_objeto, columna3, false, 3);
		//----------------------------------------------
		
		// Caja de opciones tipo de dialogo		
		CrearOpciones(confirmar, "DEFAULT_OPTION", JOptionPane.DEFAULT_OPTION, t_default, columna4, true, 4);
		
		CrearOpciones(confirmar, "YES_NO_OPTION", JOptionPane.YES_NO_OPTION, t_yes_no, columna4, false, 4);
		
		CrearOpciones(confirmar, "YES_NO_CANCEL_OPTION", JOptionPane.YES_NO_CANCEL_OPTION, t_yes_no_cancel, columna4, false, 4);
		
		CrearOpciones(confirmar, "OK_CANCEL_OPTION", JOptionPane.OK_CANCEL_OPTION, t_ok_cancel, columna4, false, 4);
		//----------------------------------------------
		
		// Caja de opciones opciones
		CrearOpciones(opcion, "String[]", 1, t_string_arr, columna5, true, 5);
		
		CrearOpciones(opcion, "Icon[]", 2, t_icon_arr, columna5, false, 5);
		
		CrearOpciones(opcion, "Object[]", 3, t_object_arr, columna5, false, 5);
		//----------------------------------------------
		
		// Caja de opciones entrada
		CrearOpciones(entrada, "Campo de texto", 1, t_campo_texto, columna6, true, 6);
		
		CrearOpciones(entrada, "Combo", 2, t_combo, columna6, false, 6);
	
		//----------------------------------------------
		fila1.add(columna1);
		
		fila1.add(columna2);
		
		fila1.add(columna3);
		
		fila2.add(columna4);
		
		fila2.add(columna5);
		
		fila2.add(columna6);
		
		fila1.add(fila2);
		
		add(fila1, BorderLayout.CENTER);
				
		JButton mostrar = new JButton("Mostrar");
		
		mostrar.addActionListener(new MostrarDialogoListener());
		
		add(mostrar, BorderLayout.SOUTH);
		
	}
	
	private void CrearOpciones(ButtonGroup grupo, String rotulo, int opcion, JRadioButton radio, Box caja, boolean selected, int dialogo) {
						
		radio.setText(rotulo);
		
		radio.setSelected(selected);
		
		switch (dialogo) {
			case 1: 				
				if(radio.isSelected())
					v_tipo_dialogo = opcion;				
				break;
			case 2:
				if(radio.isSelected())
					v_tipo_mensaje = opcion;
				break;
			case 3:
				if(radio.isSelected())						
					v_mensaje = opcion;
				break;
			case 4:
				if(radio.isSelected())
					v_confirmar = opcion;
				break;
			case 5:
				if(radio.isSelected())
					v_opcion = opcion;
				break;
			case 6:
				if(radio.isSelected())
					v_entrada = opcion;
				break;
		
		}
		
		
		grupo.add(radio);
				
		caja.add(radio);
		
		radio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
							
				switch (dialogo) {
					case 1: 
						v_tipo_dialogo = opcion;	
						break;
					case 2:
						v_tipo_mensaje = opcion;
						break;
					case 3:
						v_mensaje = opcion;
						break;
					case 4:
						v_confirmar = opcion;
						break;
					case 5:
						v_opcion = opcion;
						break;
					case 6:
						v_entrada = opcion;
						break;
				}
			}
		});
		
	}
	
	private void initClases() {
		
		//INSTANCIA GRUPO TIPO
		tipo = new ButtonGroup();
		tipo_mensaje = new ButtonGroup();
		mensaje = new ButtonGroup();
		confirmar = new ButtonGroup();
		opcion = new ButtonGroup();
		entrada = new ButtonGroup();
		
		//INSTANCIA 1ER GRUPO
		t_r_mensaje = new JRadioButton();		
		t_r_confirmar = new JRadioButton(); 		
		t_r_opcion = new JRadioButton();
		t_r_entrada = new JRadioButton();
		
		//INSTANCIA 2DO GRUPO
		t_m_error_message = new JRadioButton();
		t_m_information_message = new JRadioButton();
		t_m_warning_message = new JRadioButton();
		t_m_question_message = new JRadioButton();
		t_m_plain_message = new JRadioButton();
		
		//INSTANCIA 3ER GRUPO 
		t_cadena = new JRadioButton();
		t_icono = new JRadioButton();
		t_componente = new JRadioButton();
		t_otros = new JRadioButton();
		t_objeto = new JRadioButton();
		
		//INSTANCIA 4TO GRUPO
		t_default = new JRadioButton();
		t_yes_no = new JRadioButton();
		t_yes_no_cancel = new JRadioButton();
		t_ok_cancel = new JRadioButton();
		
		//INSTANCIA 5TO GRUPO
		t_string_arr = new JRadioButton();
		t_icon_arr = new JRadioButton();
		t_object_arr = new JRadioButton();	
		
		//INSTANCIA 6TO GRUPO
		t_campo_texto = new JRadioButton();
		t_combo = new JRadioButton();
	}
	
	
	private class MostrarDialogoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub			
			
			switch(v_mensaje) {
				case 1:
					mensajeObject = "Mensaje de prueba";
					break;
				case 2:
					mensajeObject = new ImageIcon("src/graficos/volcan.jpg");
					break;
				case 3:
					mensajeObject = new JButton("Boton");
					break;
				case 4:
					mensajeObject = new JTextField(10);
					break;
				case 5:
					String[] meses = {"Enero", "Febrero", "Marzo"};
					mensajeObject = meses;
					break;
			}
			
			switch (v_opcion) {
				case 1: 
					String[] meses = {"Enero", "Febrero", "Marzo"};
					opcionObject = meses;
					break;
				case 2:
					Icon[] iconos = { new ImageIcon("src/graficos/rojo.png"), new ImageIcon("src/graficos/azul.png"), new ImageIcon("src/graficos/volcan.jpg") };
					opcionObject = iconos;
					break;
				case 3:
					JRadioButton[] botones = {new JRadioButton("Boton1"), new JRadioButton("Boton2"), new JRadioButton("Boton3")};
					opcionObject = botones;
					break;
			}
			
			switch (v_entrada) {
				case 1:
					entradaObject = null;
					break;
				case 2:
					String[] meses = {"Enero", "Febrero", "Marzo"};
					entradaObject = meses;
					break;
			}
			
			switch(v_tipo_dialogo) {
				case 1:
					JOptionPane.showMessageDialog(MarcoCuadrosDialogo2.this, mensajeObject, "Prueba", v_tipo_mensaje);
					break;
				case 2:
					JOptionPane.showConfirmDialog(MarcoCuadrosDialogo2.this, "Confirmar dialogo", "Prueba", v_confirmar);
					break;
				case 3:
					JOptionPane.showOptionDialog(MarcoCuadrosDialogo2.this, "Elige", "V de opciones", JOptionPane.DEFAULT_OPTION, v_tipo_mensaje, null, opcionObject, null);
					break;
				case 4:
					JOptionPane.showInputDialog(MarcoCuadrosDialogo2.this, "Introduce nombre", "Formulario", v_tipo_mensaje, null, entradaObject, null);
					break;
			}
		}
		
	}
		
	
	//Grupo de botones
	private ButtonGroup tipo, tipo_mensaje, mensaje, confirmar, opcion, entrada;
	
	//tipo
	private JRadioButton t_r_mensaje, t_r_confirmar, t_r_opcion, t_r_entrada;
	
	//tipo de mensaje
	private JRadioButton t_m_error_message, t_m_information_message, t_m_warning_message, t_m_question_message, t_m_plain_message;
	
	//mensaje 
	private JRadioButton t_cadena, t_icono, t_componente, t_otros, t_objeto;
	
	//Confirmar
	private JRadioButton t_default, t_yes_no, t_yes_no_cancel, t_ok_cancel;
	
	//Opcion
	private JRadioButton t_string_arr, t_icon_arr, t_object_arr;
	
	//Entrada
	private JRadioButton t_campo_texto, t_combo;
	
	private Box columna1, columna2, columna3, columna4, columna5, columna6;
	
	private int v_tipo_dialogo, v_tipo_mensaje, v_mensaje, v_confirmar, v_opcion, v_entrada;
	
	private Object mensajeObject;
	
	private Object[] opcionObject, entradaObject;
}

















