package main;

import dominio.ClimaOnline;
import dominio.EscribirEnArchivoObservador;
import dominio.Medidor;
import dominio.MedidorTemperatura;
import dominio.MostrarTempEnConsolaObservador;
import dominio.ObservadorClima;
import dominio.WeatherChannelService;

public class main {

	public static void main(String[] args) {
		ObservadorClima pantalla = new MostrarTempEnConsolaObservador();
		ObservadorClima archivo = new EscribirEnArchivoObservador("C:\\Users\\Denis\\Desktop\\tp6\\temperatura.txt");

		ClimaOnline wcs = new WeatherChannelService();
		Medidor medidor = new Medidor(wcs);
		MedidorTemperatura medTemperatura = new MedidorTemperatura(medidor);

		medTemperatura.suscribir(archivo);
		medTemperatura.suscribir(pantalla);

		medTemperatura.leerTemperatura();
	}

}
