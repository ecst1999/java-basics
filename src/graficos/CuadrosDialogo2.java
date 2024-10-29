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
		
		setBounds(250, 250, 600, 500);
		
		setTitle("Prueba de dialogos");
		
		setLayout(new BorderLayout());
				
		Box fila1 = Box.createHorizontalBox();			
		
		columna1 = Box.createVerticalBox();
		
		columna2 = Box.createVerticalBox();

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
		
		fila1.add(columna1);
		
		fila1.add(columna2);
		
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
				
	}
	
	
	private class MostrarDialogoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub			
			
			switch(v_tipo_dialogo) {
				case 1:
					JOptionPane.showMessageDialog(MarcoCuadrosDialogo2.this, "Mensaje de prueba", "Prueba", v_tipo_mensaje);
					break;
				case 2:
					JOptionPane.showConfirmDialog(MarcoCuadrosDialogo2.this, "Confirmar dialogo");
					break;
				case 3:
					JOptionPane.showOptionDialog(MarcoCuadrosDialogo2.this, "Elige", "V de opciones", 1, v_tipo_mensaje, null, null, null);
					break;
				case 4:
					JOptionPane.showInputDialog(MarcoCuadrosDialogo2.this, "Introduce nombre", "Formulario", v_tipo_mensaje);
					break;
			}
		}
		
	}
		
	
	private ButtonGroup tipo, tipo_mensaje, mensaje, confirmar, opcion, entrada;
	
	//tipo
	private JRadioButton t_r_mensaje, t_r_confirmar, t_r_opcion, t_r_entrada;
	
	//tipo de mensaje
	private JRadioButton t_m_error_message, t_m_information_message, t_m_warning_message, t_m_question_message, t_m_plain_message;
	
	private Box columna1, columna2, columna3;
	
	private int v_tipo_dialogo, v_tipo_mensaje, v_mensaje, v_confirmar, v_opcion, v_entrada;
}

















