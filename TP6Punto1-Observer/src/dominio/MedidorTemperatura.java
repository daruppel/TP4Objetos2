package dominio;

public class MedidorTemperatura extends Observable{
	private Medidor medidor;
	
	public MedidorTemperatura(Medidor medidor) {
		super();
		this.medidor=medidor;
	}
	
	public void leerTemperatura() {
		this.notificar(this.medidor.leerTemperatura());
	}
}
