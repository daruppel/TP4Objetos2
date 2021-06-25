package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import dominio.EstacionDeServicio;
import mailPunto2TP6.VentasObservable;

public class VentanaPrincipal {
	private EstacionDeServicio estacionDeServicio;
	private VentasObservable observable;
	private JFrame frame;

	public VentanaPrincipal(EstacionDeServicio estacion, VentasObservable observable) {
		this.estacionDeServicio = estacion;
		this.observable = observable;
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Ventana Principal");
		frame.setBounds(100, 100, 235, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JButton btnCargaCombustible = new JButton("Cargar combustible");
		btnCargaCombustible.setBounds(24, 40, 161, 23);
		frame.getContentPane().add(btnCargaCombustible);

		btnCargaCombustible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaDeVentas cc = new CargaDeVentas(estacionDeServicio, observable);
				cc.setVisible(true);
			}
		});

		JButton btnListarVentas = new JButton("Listar ventas");
		btnListarVentas.setBounds(24, 100, 161, 23);
		frame.getContentPane().add(btnListarVentas);

		btnListarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeVentas listado = new ListadoDeVentas(estacionDeServicio);
				listado.setVisible(true);
			}
		});

	}
}
