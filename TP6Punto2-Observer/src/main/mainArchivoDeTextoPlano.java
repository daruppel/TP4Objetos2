package main;

import dominio.EstacionDeServicio;
import mailPunto2TP6.Observador;
import mailPunto2TP6.VentasObservable;
import mailPunto2TP6.mailMain;
import persistencia.ArchivoTextoPlanoDeVentas;
import ui.VentanaPrincipal;

public class mainArchivoDeTextoPlano {

	public static void main(String[] args) {
		Observador mail = new mailMain();
		VentasObservable vo = new VentasObservable(new EstacionDeServicio(
				new ArchivoTextoPlanoDeVentas("C:\\Users\\Denis\\Documents\\ArchivosPrueba\\ventas.txt")));
		vo.suscribir(mail);

		VentanaPrincipal vp = new VentanaPrincipal(new EstacionDeServicio(
				new ArchivoTextoPlanoDeVentas("C:\\Users\\Denis\\Documents\\ArchivosPrueba\\ventas.txt")), vo);

	}

}
