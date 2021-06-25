package dominio;

import java.util.ArrayList;
import java.util.List;

public class HistoriaDeUsuario implements ItemDeTrabajo {
	private List<ItemDeTrabajo> listaDeItems = new ArrayList<ItemDeTrabajo>();

	public HistoriaDeUsuario() {
	}

	public int tiempoDeResolucion() {
		int tiempoTotalDeResolucion = 0;
		for (ItemDeTrabajo item : this.listaDeItems) {
			tiempoTotalDeResolucion = tiempoTotalDeResolucion + item.tiempoDeResolucion();
		}
		return tiempoTotalDeResolucion;
	}

	public void agregarItemDeTrabajo(ItemDeTrabajo item) {
		this.listaDeItems.add(item);
	}

}
