package ruppel.utilizacion;

import ruppel.framework.Accion;

public class AccionUno implements Accion {
	private String descripcion;
	private String nombre;

	public AccionUno() {
		this.descripcion = "Descripcion de accion numero 1";
		this.nombre = "Acción Uno";
	}

	@Override
	public void ejecutar() {
		System.out.println("Ejecutando la acción uno...\n");

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
