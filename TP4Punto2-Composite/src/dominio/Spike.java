package dominio;

public class Spike implements ItemDeTrabajo {
	private int tiempoResolucion;

	public Spike(int tiempoDeResolucion) {
		this.tiempoResolucion = tiempoDeResolucion;
	}

	public int tiempoDeResolucion() {
		return this.tiempoResolucion;
	}

	public void agregarItemDeTrabajo(ItemDeTrabajo item) {
	}

}
