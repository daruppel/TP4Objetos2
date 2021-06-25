package dominio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Reporte implements Report {
	private String reporte;

	public Reporte(String reporte) {
		this.reporte = reporte;
	}

	public void exportar(File file) {
		try {
			Files.write(Paths.get(file.getPath()), this.reporte.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo realizar la exportación del archivo.", e);
		}
	}

}
