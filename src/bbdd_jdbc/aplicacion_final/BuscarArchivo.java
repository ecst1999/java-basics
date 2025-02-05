package bbdd_jdbc.aplicacion_final;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BuscarArchivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marco marco = new Marco();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JFileChooser chooser = new JFileChooser();
		
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Archivos de texto", "txt");
	    
	    chooser.setFileFilter(filter);
	    
	    int returnVal = chooser.showOpenDialog(marco);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getAbsolutePath());
	       
	    }
	}

}


class Marco extends JFrame{
	
	public Marco() {
		setBounds(300, 300, 300, 300);
		
		setVisible(true);
	}
	
}