package dominio;

public class Tarea implements ItemDeTrabajo {
	private int tiempoResolucion;

	public Tarea(int tiempoDeResolucion) {
		this.tiempoResolucion = tiempoDeResolucion;
	}

	public int tiempoDeResolucion() {
		return this.tiempoResolucion;
	}

	public void agregarItemDeTrabajo(ItemDeTrabajo item) {
	}

}
