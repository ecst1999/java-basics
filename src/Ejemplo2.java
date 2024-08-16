import javax.swing.JOptionPane;

public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombreUsuario = JOptionPane.showInputDialog("Introduce tu nombre por favor");
		
		String edad = JOptionPane.showInputDialog("Introduce tu edad por favor");
		
		int edad_usuario = Integer.parseInt(edad);
		
		edad_usuario ++;
		
		System.out.println("Hola " + nombreUsuario + " el año que viene tendrás " + edad_usuario   + " años.");

	}

}
