package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import dominio.Combustible;
import dominio.Comun;
import dominio.Super;
import dominio.Venta;

class CargaCombustibleTest {

	@Test
	void cargarCombustibleSuperEnDiaDomingo() {
		Combustible combustibleSuper = new Super(90);
		LocalTime horaVenta = LocalTime.of(11, 0);
		LocalDate diaVenta = LocalDate.parse("2021-05-02");
		Venta venta1 = new Venta(LocalDateTime.of(diaVenta, horaVenta), 20, combustibleSuper);
		assertEquals(1620, venta1.monto());
	}

	@Test
	void cargarCombustibleSuperEnDiaSabado() {
		Combustible combustibleSuper = new Super(90);
		LocalTime horaVenta = LocalTime.of(11, 0);
		LocalDate diaVenta = LocalDate.parse("2021-05-01");
		Venta venta1 = new Venta(LocalDateTime.of(diaVenta, horaVenta), 30, combustibleSuper);

		assertEquals(2376, venta1.monto());
	}

	@Test
	void cargarCombustibleComunALasNueveDeLaMañana() {
		Combustible combustibleComun = new Comun(70);
		LocalTime horaVenta = LocalTime.of(9, 0);
		LocalDate diaVenta = LocalDate.parse("2021-05-01");
		Venta venta1 = new Venta(LocalDateTime.of(diaVenta, horaVenta), 30, combustibleComun);

		assertEquals(1995, venta1.monto());
	}

}
