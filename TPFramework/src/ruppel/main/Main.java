package ruppel.main;

import ruppel.framework.Menu;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu("{ruta del archivo properties}\\configuracion.properties");

		menu.verMenu();

	}

}
