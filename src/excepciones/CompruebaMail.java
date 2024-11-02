package excepciones;

import java.io.EOFException;

import javax.swing.JOptionPane;

public class CompruebaMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = JOptionPane.showInputDialog("Introduce email");
				
		
		try {
			introduceEmail(email);	
		}catch(LongitudMailError e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	static void introduceEmail(String email) throws LongitudMailError {
		
		int arroba = 0;
		
		boolean punto = false;
		
		if(email.length() <= 3) {
			
			// ArrayIndexOutOfBoundsException miexcepcion = new ArrayIndexOutOfBoundsException();
			
			//throw new EOFException();
			
			throw new LongitudMailError("El mail es demasiado corto");
			
			
		}else {			
				
			for(int i = 0; i < email.length(); i++) {
				if(email.charAt(i) == '@') 
					arroba ++;
				
				if(email.charAt(i) == '.')
					punto = true;
				
			}
			
			if(arroba==1 && punto)
				System.out.println("Es correcto");
			else
				System.out.println("No es correcto");
		
		}
		
	}

}

class LongitudMailError extends Exception {
	
	public LongitudMailError() {
		
	}
	
	public LongitudMailError(String msj_error) {
		
		super(msj_error);
		
	}
}














