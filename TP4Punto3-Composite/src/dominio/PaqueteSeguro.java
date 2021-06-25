package dominio;

import java.util.ArrayList;

public class PaqueteSeguro implements ServicioAseguradora {
	private ArrayList<ServicioAseguradora> listaDeServicios = new ArrayList<>();
	private String nombre;

	public PaqueteSeguro(String nombre) {
		this.nombre = nombre;
	}

	public float costo() {
		float costoTotal = 0;
		int cantDescuento = 0;
		for (ServicioAseguradora servicio : this.listaDeServicios) {
			costoTotal += servicio.costo();
			cantDescuento++;
		}
		costoTotal = costoTotal * (1 - cantDescuento * 0.05f);
		return costoTotal;
	}

	public void agregarServicio(ServicioAseguradora servicio) {
		this.listaDeServicios.add(servicio);
	}
}
