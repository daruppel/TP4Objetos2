package persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dominio.Combustible;
import dominio.Comun;
import dominio.PersistenciaVentas;
import dominio.Super;
import dominio.Venta;

public class ArchivoTextoPlanoDeVentas implements PersistenciaVentas {
	private String pathArchivo;

	public ArchivoTextoPlanoDeVentas(String pathDelArchivo) {
		this.pathArchivo = pathDelArchivo;
	}

	@Override
	public void cargarVenta(LocalDateTime fecha, int litros, float monto, Combustible combustible)
			throws RuntimeException {
		try {
			String venta = fecha + ";" + litros + ";" + monto + ";" + combustible.toString() + "\n";
			Files.write(Paths.get(this.pathArchivo), venta.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("Error al cargar la venta", e);
		}
	}

	@Override
	public List<Venta> listarVentas(LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws RuntimeException {
		// C:\Users\Denis\Documents\ArchivosPrueba\"tiposDeCombustibles.txt"
		List<Venta> lisVentas = new ArrayList<>();
		Venta v = null;
		try {
			ArrayList<String> contenido = new ArrayList(Files.readAllLines(Paths.get(this.pathArchivo)));
			int i = 0;
			for (String s : contenido) {
				String[] as = contenido.get(i).split(";");
				Combustible c = null;
				if (LocalDateTime.parse(as[0]).isAfter(fechaDesde) && LocalDateTime.parse(as[0]).isBefore(fechaHasta)) {
					for (int j = 0; j < as.length; j++) {
						if (as[3].equals("Super"))
							c = new Super(1);
						if (as[3].equals("Comun"))
							c = new Comun(1);
						v = new Venta(LocalDateTime.parse(as[0]), Integer.parseInt(as[1]), c);
						v.setMonto(Float.parseFloat(as[2]));
					}
					lisVentas.add(v);
					i++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lisVentas;
	}

	@Override
	public List<Combustible> listarTiposDeCombustibles() throws RuntimeException {
		List<Combustible> lisCombustible = new ArrayList<>();
		Combustible c = null;
		try {
			ArrayList<String> contenido = new ArrayList(Files
					.readAllLines(Paths.get("C:\\Users\\Denis\\Documents\\ArchivosPrueba\\tiposDeCombustibles.txt")));
			int i = 0;
			for (String s : contenido) {
				String[] as = contenido.get(i).split(";");
				for (int j = 0; j < as.length; j++) {
					if (as[0].equals("Super"))
						c = new Super(Integer.parseInt(as[1]));
					if (as[0].equals("Comun"))
						c = new Comun(Integer.parseInt(as[1]));
				}
				lisCombustible.add(c);
				i++;
			}
		} catch (IOException e) {
			throw new RuntimeException("No se pueden obtener los combustibles", e);
		}
		return lisCombustible;
	}

}
