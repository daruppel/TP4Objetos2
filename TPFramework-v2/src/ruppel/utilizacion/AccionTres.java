package ruppel.utilizacion;

import ruppel.framework.Accion;

public class AccionTres implements Accion {
	private String descripcion;
	private String nombre;

	public AccionTres() {
		this.descripcion = "Descripcion de accion numero 3";
		this.nombre = "Acción Tres";
	}

	@Override
	public void ejecutar() {
		System.out.println("Ejecutando la acción tres...\n");

	}

	@Override
	public String nombreItemMenu() {
		return this.nombre;
	}

	@Override
	public String descripcionItemMenu() {
		return this.descripcion;
	}

}
