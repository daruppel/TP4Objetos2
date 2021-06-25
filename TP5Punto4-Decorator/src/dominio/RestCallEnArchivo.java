package dominio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RestCallEnArchivo implements Rest {
	private String path;
	private Rest rest;

	public RestCallEnArchivo(Rest rest, String path) {
		this.path = path;
		this.rest = rest;
	}

	@Override
	public String run() {
		String cadena = this.rest.run();
		File archivo = new File(this.path);
		if (!Files.exists(Paths.get(this.path))) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Files.write(Paths.get(this.path), cadena.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo realizar la escritura en el archivo.", e);
		}
		return cadena;
	}

}
