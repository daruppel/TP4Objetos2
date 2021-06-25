package dominio;

import java.time.LocalDateTime;

public abstract class Combustible {
	public abstract float calcularMonto(int litros, LocalDateTime fecha);

	public abstract int id();

	public abstract void setId(int id);
}
