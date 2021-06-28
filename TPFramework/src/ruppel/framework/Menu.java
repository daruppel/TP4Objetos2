package ruppel.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Menu {
	private List<Accion> acciones;

	public Menu(String pathProperties) {
		acciones = new ArrayList<>();
		AccionesDelMenu a = new AccionesDelMenu(pathProperties);
		acciones = a.acciones();
	}

	public void verMenu() {
		Scanner scanner;
		boolean condition = true;
		int opcion;
		int salir = acciones.size() + 1;

		// loop mientras no se seleccione salir
		while (condition) {
			System.out.println("\nBienvenido, estas son sus opciones:\n");
			int i = 0;
			for (Accion a : acciones) {
				System.out.println((i + 1) + ". " + a.nombreItemMenu() + " (" + a.descripcionItemMenu() + ")" + "\n");
				i++;
			}
			System.out.println(salir + ". Salir");

			if (!acciones.isEmpty())
				System.out.println("\nIngrese su opcion: ");
			else
				System.out.println("El menu no tiene opciones\n");

			// Se lee la opcion
			scanner = new Scanner(System.in);
			opcion = scanner.nextInt();

			if ((opcion) != salir)
				this.ejecutarOpcion(opcion - 1);
			else {
				System.out.println("Fin del programa\n");
				condition = false;
			}
		}
	}

	private void ejecutarOpcion(int opcion) {
		try {
			Accion a = acciones.get(opcion);
			a.ejecutar();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La opcion ingresada no es valida");
		}
	}
}
