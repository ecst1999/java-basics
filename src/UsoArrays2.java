public class UsoArrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] matriz_aleatorios = new int[150];
		
		for(int i = 0; i < matriz_aleatorios.length; i++) 			
			matriz_aleatorios[i] = (int) Math.round(Math.random()*100);
			
		for(int mat:matriz_aleatorios) 
			System.out.print(mat + " ");
		
		
	}

}
