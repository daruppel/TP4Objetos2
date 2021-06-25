package dominio;

public interface ItemDeTrabajo {
	/**
	 * Retorna la cantidad de d�as que se necesitan para resolver el item de
	 * trabajo.
	 * 
	 * @return int
	 */
	public int tiempoDeResolucion();

	public void agregarItemDeTrabajo(ItemDeTrabajo item);
}
