package main;

import java.io.File;

import dominio.Report;
import dominio.Reporte;
import dominio.ReporteArchivoVacio;

public class main {

	public static void main(String[] args) {
		Report reporte = new ReporteArchivoVacio(new Reporte("Nuevo reporte"));
		reporte.exportar(new File("C:\\Users\\Denis\\Documents\\ArchivosPrueba\\reporte.txt"));

	}

}
