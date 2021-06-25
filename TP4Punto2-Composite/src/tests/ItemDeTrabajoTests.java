package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import dominio.HistoriaDeUsuario;
import dominio.ItemDeTrabajo;
import dominio.Spike;
import dominio.Tarea;

class ItemDeTrabajoTests {

	@Test
	void calculoDeCantidadDeDiasNecesariosParaTerminarUnaHistoriaDeUsuario() {
		ItemDeTrabajo historiaDeUsuario = new HistoriaDeUsuario();

		ItemDeTrabajo tarea1 = new Tarea(3);
		ItemDeTrabajo tarea2 = new Tarea(1);
		ItemDeTrabajo tarea3 = new Tarea(5);
		ItemDeTrabajo tarea4 = new Tarea(2);
		ItemDeTrabajo spike = new Spike(1);

		historiaDeUsuario.agregarItemDeTrabajo(spike);
		historiaDeUsuario.agregarItemDeTrabajo(tarea1);
		historiaDeUsuario.agregarItemDeTrabajo(tarea2);
		historiaDeUsuario.agregarItemDeTrabajo(tarea3);
		historiaDeUsuario.agregarItemDeTrabajo(tarea4);

		assertEquals(12, historiaDeUsuario.tiempoDeResolucion());
	}

	@Test
	void calculoDeCantidadDeDiasNecesariosParaTerminarUnaTarea() {
		ItemDeTrabajo historiaDeUsuario = new HistoriaDeUsuario();

		ItemDeTrabajo tarea1 = new Tarea(3);
		ItemDeTrabajo tarea2 = new Tarea(1);
		ItemDeTrabajo tarea3 = new Tarea(5);
		ItemDeTrabajo tarea4 = new Tarea(2);
		ItemDeTrabajo spike = new Spike(1);

		historiaDeUsuario.agregarItemDeTrabajo(spike);
		historiaDeUsuario.agregarItemDeTrabajo(tarea1);
		historiaDeUsuario.agregarItemDeTrabajo(tarea2);
		historiaDeUsuario.agregarItemDeTrabajo(tarea3);
		historiaDeUsuario.agregarItemDeTrabajo(tarea4);

		assertEquals(3, tarea1.tiempoDeResolucion());
	}
}
