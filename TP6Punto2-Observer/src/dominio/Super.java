package dominio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Super extends Combustible {
	private float precioLitro;
	private int id;

	public Super(float precioLitro) {
		if (precioLitro <= 0)
			throw new RuntimeException("El precio debe ser mayor a 0");
		this.precioLitro = precioLitro;
	}

	public String toString() {
		return "Super";
	}

	public float calcularMonto(int litros, LocalDateTime fecha) {
		float montoTotal = this.precioLitro * litros;
		if (fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			montoTotal = montoTotal - ((montoTotal * 10) / 100);
		}
		if ((fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY)) && litros > 20) {
			montoTotal = montoTotal - ((montoTotal * 12) / 100);
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
