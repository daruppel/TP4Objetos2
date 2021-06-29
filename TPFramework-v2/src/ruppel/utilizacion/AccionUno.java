package ruppel.utilizacion;

import ruppel.framework.Accion;

public class AccionUno implements Accion {
	private String descripcion;
	private String nombre;

	public AccionUno() {
		this.descripcion = "Descripcion de accion numero 1";
		this.nombre = "Acci�n Uno";
	}

	@Override
	public void ejecutar() {
		System.out.println("Ejecutando la acci�n uno...\n");

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
