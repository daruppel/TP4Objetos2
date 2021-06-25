package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dominio.PaqueteSeguro;
import dominio.Seguro;
import dominio.ServicioAseguradora;

class AseguradoraTest {

	@Test
	void calculoPaqueteSeguro() {
		ServicioAseguradora seguro1 = new Seguro("seguro basico", 1000);
		ServicioAseguradora seguro2 = new Seguro("seguro medio", 1500);
		ServicioAseguradora seguro3 = new Seguro("seguro completo", 2000);
		ServicioAseguradora paqueteSeguro1 = new PaqueteSeguro("paquete standar");
		ServicioAseguradora paqueteSeguro2 = new PaqueteSeguro("paquete avanzado");
		paqueteSeguro1.agregarServicio(seguro1);
		paqueteSeguro2.agregarServicio(seguro2);
		paqueteSeguro2.agregarServicio(seguro3);

		assertEquals(3150, paqueteSeguro2.costo());

	}

	@Test
	void calculoSeguro() {
		ServicioAseguradora seguro1 = new Seguro("seguro basico", 1000);
		ServicioAseguradora seguro2 = new Seguro("seguro medio", 1500);
		ServicioAseguradora seguro3 = new Seguro("seguro completo", 2000);
		ServicioAseguradora paqueteSeguro1 = new PaqueteSeguro("paquete standar");
		ServicioAseguradora paqueteSeguro2 = new PaqueteSeguro("paquete avanzado");
		paqueteSeguro1.agregarServicio(seguro1);
		paqueteSeguro2.agregarServicio(seguro2);
		paqueteSeguro2.agregarServicio(seguro3);

		assertEquals(1500, seguro2.costo());

	}

}
