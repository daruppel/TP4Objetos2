package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dominio.Remera;
import dominio.RemeraImportada;
import dominio.RemeraNacional;

class VentaDeRemerasTests {

	@Test
	void ventaDeRemeraImportada() {
		Remera remera = new RemeraImportada(600);
		assertEquals(762f, remera.calculoDelPrecioDeVenta(), 0.01f);
	}

	@Test
	void ventaDeRemeraNacional() {
		Remera remera = new RemeraNacional(600);
		assertEquals(673.35f, remera.calculoDelPrecioDeVenta(), 0.01f);
	}
}
