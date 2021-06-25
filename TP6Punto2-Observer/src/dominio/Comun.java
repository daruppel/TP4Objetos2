package dominio;

import java.time.LocalDateTime;

public class Comun extends Combustible {
	private float precioLitro;
	private int id;

	public Comun(float precioLitro) {
		if (precioLitro <= 0)
			throw new RuntimeException("El precio debe ser mayor a 0");
		this.precioLitro = precioLitro;
	}

	public Comun() {
	}

	public String toString() {
		return "Comun";
	}

	public float calcularMonto(int litros, LocalDateTime fecha) {
		float montoTotal = this.precioLitro * litros;
		if ((fecha.getHour() > 8) && (fecha.getHour() < 10)) {
			montoTotal = montoTotal - ((montoTotal * 5) / 100);
		}
		return montoTotal;
	}

	@Override
	public int id() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
}
