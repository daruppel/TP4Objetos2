package ruppel.utilizacion;

import ruppel.framework.Accion;

public class AccionDos implements Accion {
	private String descripcion;
	private String nombre;

	public AccionDos() {
		this.descripcion = "Descripcion de accion numero 2";
		this.nombre = "Acción Dos";
	}

	@Override
	public void ejecutar() {
		System.out.println("Ejecutando la acción dos...\n");

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
