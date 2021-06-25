package mailPunto2TP6;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dominio.Combustible;
import dominio.EstacionDeServicio;
import dominio.Venta;

public class VentasObservable {
	private EstacionDeServicio estacion;
	private List<Observador> observadores;

	public VentasObservable(EstacionDeServicio estacion) {
		this.estacion = estacion;
		this.observadores = new ArrayList<>();
	}

	public void suscribir(Observador observador) {
		this.observadores.add(observador);
	}

	public void generarVenta(LocalDateTime fecha, int litros, Combustible combustible, String mailDestinatario) {
		Venta v = this.estacion.generarVenta(fecha, litros, combustible);
		this.notificar(v, mailDestinatario);
	}

	private void notificar(Venta venta, String destinatario) {
		for (Observador o : this.observadores) {
			o.actualizar(venta, destinatario);
		}
	}
}
