package poo;
import javax.swing.*;

public class UsoCarro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Carro micarro = new Carro();		
		
		micarro.establece_color(JOptionPane.showInputDialog("Ingrese el color"));
		
		System.out.println(micarro.dime_datos_generales());
				
		System.out.println(micarro.dime_color());
		
		micarro.configura_asientos(JOptionPane.showInputDialog("Tiene asientos de cuero"));

		
		System.out.println(micarro.dime_asientos());
		
		micarro.configura_climatizador(JOptionPane.showInputDialog("Tiene climatizador"));
		
		System.out.println(micarro.dime_climatizador());
		
		System.out.println(micarro.dime_peso_carro());
		
		System.out.println("El precio final del carro es: " + micarro.precio_carro());
	}

}
