package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dominio.Calculador;
import dominio.CalculadorJubilado;
import dominio.CalculadorNoJubilado;

class CalculadorTest {

	@Test
	void calculaIVAParaNoJubiladoEnMesDePromocion() {
		Calculador calculadorNoJubilado = new CalculadorNoJubilado(LocalDate.now().getMonthValue());
		assertEquals(172.5f, calculadorNoJubilado.calcularPrecio(150), 0.01f);
	}

	@Test
	void calculaIVAParaNoJubiladoFueraDeMesDePromocion() {
		Calculador calculadorNoJubilado = new CalculadorNoJubilado(LocalDate.now().getMonthValue() - 1);
		assertEquals(181.5f, calculadorNoJubilado.calcularPrecio(150), 0.01f);
	}

	@Test
	void calculaIVAParaJubiladoEnMesDePromocion() {
		Calculador calculadorJubilado = new CalculadorJubilado(LocalDate.now().getMonthValue());
		assertEquals(150, calculadorJubilado.calcularPrecio(150), 0.01f);
	}

	@Test
	void calculaIVAParaJubiladoFueraDeMesDePromocion() {
		Calculador calculadorJubilado = new CalculadorJubilado(LocalDate.now().getMonthValue() - 1);
		assertEquals(165, calculadorJubilado.calcularPrecio(150), 0.01f);
	}

}
