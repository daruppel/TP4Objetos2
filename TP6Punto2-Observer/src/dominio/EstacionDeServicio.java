package dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EstacionDeServicio {
	private PersistenciaVentas ventas;
	private List<Combustible> listaCombustibles = new ArrayList<>();

	public EstacionDeServicio(PersistenciaVentas persistenciaVentas) {
		if (persistenciaVentas == null)
			throw new RuntimeException("Se debe ingresar una forma de persistir las ventas");
		this.ventas = persistenciaVentas;
		this.listaCombustibles = ventas.listarTiposDeCombustibles();
		Iterator<Combustible> iterador = listaCombustibles.iterator();
		while (iterador.hasNext()) {
			Combustible c = iterador.next();
		}
	}

	public Venta generarVenta(LocalDateTime fecha, int litros, Combustible combustible) {
		Venta v = new Venta(fecha, litros, combustible);
		this.ventas.cargarVenta(fecha, litros, v.monto(), combustible);
		return v;
	}

	public List<Combustible> tiposDeCombustibles() {
		return this.listaCombustibles;
	}

	public float montoTotalVenta(LocalDateTime fecha, int litros, Combustible combustible) {
		Venta v = new Venta(fecha, litros, combustible);
		return v.monto();
	}

	public void mostrarCombustibles() {
		Iterator<Combustible> iterador = listaCombustibles.iterator();
		while (iterador.hasNext()) {
			Combustible c = iterador.next();
			System.out.println(c);
		}
	}

	/**
	 * Lista todas las ventas realizadas desde "fechaDesde" a "fechaHasta"
	 * 
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 */
	public List<Venta> listarVentas(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		return this.ventas.listarVentas(fechaDesde, fechaHasta); // validar fechas
	}
}
