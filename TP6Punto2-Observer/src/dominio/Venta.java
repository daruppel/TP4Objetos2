package dominio;

import java.time.LocalDateTime;

public class Venta {
	private LocalDateTime fecha;
	private int litros;
	private Combustible combustible;
	private float monto;

	public Venta(LocalDateTime fecha, int litros, Combustible combustible) {
		if (fecha.isAfter(LocalDateTime.now())) { // Se permiten crear ventas anterior a la fecha de carga
			throw new RuntimeException("La fecha de la venta no puede ser mayor al día actual");
		}
		if (litros < 0) {
			throw new RuntimeException("Los litros vendidos deben ser mayor a 0");
		}
		this.combustible = combustible;
		this.fecha = fecha;
		this.litros = litros;
		this.monto = this.combustible.calcularMonto(this.litros, this.fecha);
	}

	public String toString() {
		return (this.fecha + " , " + litros + " , " + monto + " , " + combustible.toString());
	}

	public float monto() {
		return this.monto;
	}

	public LocalDateTime fecha() {
		return this.fecha;
	}

	public int litros() {
		return this.litros;
	}

	public Combustible combustible() {
		return this.combustible;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
}
