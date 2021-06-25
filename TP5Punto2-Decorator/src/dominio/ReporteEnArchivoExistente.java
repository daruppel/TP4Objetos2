package dominio;

import java.io.File;

public class ReporteEnArchivoExistente implements Report {
	private Report report;

	public ReporteEnArchivoExistente(Report report) {
		this.report = report;
	}

	public void exportar(File file) {
		if (file.exists())
			throw new IllegalArgumentException("El archivo ya existe...");
		report.exportar(file);
	}
}
