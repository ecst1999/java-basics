import javax.swing.*;

public class PesoIdeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String genero = "";
		
		do {
			
			genero = JOptionPane.showInputDialog("Introduce tu género (H/M)");
			
		} while(!genero.equalsIgnoreCase("H") && !genero.equalsIgnoreCase("M"));
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
		
		int pesoIdeal = 0;
		
		if(genero.equalsIgnoreCase("h")) {
			pesoIdeal = altura - 110;
		}else if(genero.equalsIgnoreCase("m")) {
			pesoIdeal = altura - 120;
		}
		
		System.out.println("Tu peso ideal es: " + pesoIdeal + "kg");

	}

}
