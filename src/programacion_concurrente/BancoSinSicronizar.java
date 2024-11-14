package programacion_concurrente;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSicronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco b = new Banco();
		
		for (int i = 0; i<100;i++) {
			EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
			Thread t = new Thread(r);
			
			t.start();
		}
	}

}


class Banco {
	
	public Banco() {
		
		cuentas = new double[100];
		
		for(int i = 0; i < cuentas.length; i++) {
						
			cuentas[i] = 2000;
		}		
		
		saldoSuficiente = cierreBanco.newCondition();
		
	}
	
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
		
		cierreBanco.lock();
		
		try {
							
			while(cuentas[cuentaOrigen]<cantidad) {//Evalua el saldo no sea menor a la cantidad
				
				saldoSuficiente.await(); // pone en espera los hilos donde no hay suficiente saldo para hacer transferencia
				
				//return; 
			}
			
			System.out.println(Thread.currentThread());
			
			cuentas[cuentaOrigen] -= cantidad; // dinero que sale de la cuenta origen
			
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
			
			cuentas[cuentaDestino] += cantidad;
			
			System.out.printf(" Saldo total %10.2f%n", getSaldoTotal());
			
			saldoSuficiente.signalAll(); // a los hilos en espera los quita para evaluar siempre y cuando se pueda hacer la transferencia
		
		}finally {
			cierreBanco.unlock();
		}
	}
	
	public double getSaldoTotal() {
		
		double sumaCuentas = 0;
		
		for(double a: cuentas) {
			sumaCuentas += a;
		}
		
		return sumaCuentas;
		
	}
	
	
	private final double[] cuentas;
	
	private Lock cierreBanco = new ReentrantLock();
	
	private Condition saldoSuficiente; 
}

class EjecucionTransferencias implements Runnable{

	public EjecucionTransferencias(Banco b, int de, double max) {
		banco = b;
		delaCuenta = de;
		cantidadMax = max;
	}
	
	@Override
	public void run() {		
		
		try {
			while(true) {
				int paraLaCuenta = (int) (100 * Math.random());
				
				double cantidad = cantidadMax * Math.random();
				
				banco.transferencia(delaCuenta, paraLaCuenta, cantidad);
				Thread.sleep((int) (Math.random()*10));
				
					
				
							
			}
		} catch (InterruptedException e) { }
	}
	
	private Banco banco;
	
	private int delaCuenta;
	
	private double cantidadMax;
	
}







