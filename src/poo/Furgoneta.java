package poo;

public class Furgoneta extends Carro {

	private int capacidad_extra;
	
	private int plazas_extra;
	
	public Furgoneta(int plazas_extra, int capacidad_extra) {
		super();
		
		this.capacidad_extra = capacidad_extra;
		this.plazas_extra = plazas_extra;
	}
	
	public String getDatosFurgoneta() {
		return "La capacidad de carga es: " + capacidad_extra + " y las plazas son: " + plazas_extra;
	}
}
