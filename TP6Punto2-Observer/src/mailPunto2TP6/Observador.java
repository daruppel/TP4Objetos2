package mailPunto2TP6;

import dominio.Venta;

public interface Observador {
	public void actualizar(Venta venta, String destinatario);
}
