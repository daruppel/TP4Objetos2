package dominio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class EscribirEnArchivoObservador implements ObservadorClima {
	private String path;

	public EscribirEnArchivoObservador(String path) {
		this.path = path;
	}

	private void registrarTemperatura(String temperatura) {
		String tempConFecha = temperatura + LocalDate.now() + "\n";
		File archivoTemperatura = new File(this.path);
		if (!Files.exists(Paths.get(this.path))) {
			try {
				archivoTemperatura.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Files.write(Paths.get(this.path), tempConFecha.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo realizar la escritura en el archivo.", e);
		}
	}

	@Override
	public void actualizarTemperatura(String temperatura) {
		this.registrarTemperatura(temperatura);
	}

}
