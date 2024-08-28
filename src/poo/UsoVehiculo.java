package poo;
import javax.swing.*;

public class UsoVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
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
		*/
		
		Carro miCarro1 = new Carro();
		
		miCarro1.establece_color("Rojo");
		
		Furgoneta miFurgoneta1 = new Furgoneta(7, 580);
		
		miFurgoneta1.establece_color("Azul");
		
		miFurgoneta1.configura_asientos("si");
		
		miFurgoneta1.configura_climatizador("si");
		
		System.out.println(miCarro1.dime_datos_generales() + " " + miCarro1.dime_color());
		
		System.out.println(miFurgoneta1.dime_datos_generales() + " " + miFurgoneta1.getDatosFurgoneta());
		
	}

}
