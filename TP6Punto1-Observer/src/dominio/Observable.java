package dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	private List<ObservadorClima> observadores;
	
	
	public Observable() {
		this.observadores=new ArrayList<>();
	}
	
	public void suscribir(ObservadorClima observador) {
		this.observadores.add(observador);
	}
	
	protected void notificar(String temperatura) {
		for(ObservadorClima o : this.observadores) {
			o.actualizarTemperatura(temperatura);
		}
	}

}
