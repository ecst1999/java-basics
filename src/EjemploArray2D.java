
public class EjemploArray2D {
	public static void main(String[] args) {
		
		double acumulado;
		double interes = 0.10;
		
		double [][] saldo = new double[6][5];
		
		for(int i = 0; i < saldo.length; i++) {
			
			saldo[i][0] = 10000;
			acumulado = 10000;
			
			for(int j = 1; j <5; j++) {
				acumulado = acumulado + acumulado * interes;
				saldo[i][j] = acumulado;
			}
			interes += 0.01;
		}
		
		for(double[] puntero: saldo) {
			System.out.println();
			for(double punt: puntero) {
				System.out.printf("%1.2f", punt);
				System.out.print(" ");
			}
		}
	}
}
