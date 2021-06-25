package dominio;

import java.time.LocalDateTime;
import java.util.List;

public interface PersistenciaVentas {
	public void cargarVenta(LocalDateTime fecha, int litros, float monto, Combustible combustible);

	public List<Venta> listarVentas(LocalDateTime fechaDesde, LocalDateTime fechaHasta);

	public List<Combustible> listarTiposDeCombustibles();
}
