package dominio;

public class Seguro implements ServicioAseguradora {
	private String tipo;
	private float costo;

	public Seguro(String tipo, float costo) {
		this.costo = costo;
		this.tipo = tipo;
	}

	public float costo() {
		return this.costo;
	}

	public void agregarServicio(ServicioAseguradora servicio) {

	}
}
