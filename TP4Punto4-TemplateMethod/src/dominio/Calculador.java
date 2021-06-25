package dominio;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public abstract class Calculador {
	private int mesEnPromocion;
	private LogTransaction log;

	public Calculador(int mesEnPromocion) {
		this.mesEnPromocion = mesEnPromocion;
		this.log = new LogTransaction();
	}

	public double calcularPrecio(double precioProducto) {
		double precioTotal = precioProducto;
		if (of(mesEnPromocion).equals(now().getMonth())) {
			precioTotal = this.mesEnPromocion(precioProducto);
		} else {
			precioTotal = this.mesSinPromocion(precioProducto);
		}
		log.log(this.getClass().getName());
		return precioTotal;
	}

	protected abstract double mesEnPromocion(double precioProducto);

	protected abstract double mesSinPromocion(double precioProducto);
}
