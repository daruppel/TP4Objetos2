package dominio;

import java.io.File;

public class ReporteArchivoVacio implements Report {
	private Report report;

	public ReporteArchivoVacio(Report report) {
		this.report = report;
	}

	public void exportar(File file) {
		if (file == null)
			throw new IllegalArgumentException("File es NULL; no puedo exportar...");
		this.report.exportar(file);
	}
}
