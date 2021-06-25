package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.EstacionDeServicio;
import dominio.Venta;

public class ListadoDeVentas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private EstacionDeServicio estacionDeServicio;
	private JTextField textFieldDesde;
	private JTextField textFieldHasta;

	public ListadoDeVentas(EstacionDeServicio estacionDeServicio) {
		this.estacionDeServicio = estacionDeServicio;
		setTitle("Listado de ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 565, 266);
		contentPane.add(scrollPane);

		String[] nombreColumnas = { "Fecha", "Litros", "Combustible", "Monto total" };
		DefaultTableModel modelo = new DefaultTableModel(nombreColumnas, 0);
		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnListar = new JButton("Listar ventas");
		btnListar.setBounds(403, 17, 172, 23);
		contentPane.add(btnListar);

		textFieldDesde = new JTextField();
		textFieldDesde.setToolTipText("yyyy-MM-dd");
		textFieldDesde.setBounds(105, 20, 86, 20);
		contentPane.add(textFieldDesde);
		textFieldDesde.setColumns(10);

		textFieldHasta = new JTextField();
		textFieldHasta.setToolTipText("yyyy-MM-dd");
		textFieldHasta.setColumns(10);
		textFieldHasta.setBounds(307, 20, 86, 20);
		contentPane.add(textFieldHasta);

		JLabel lblFechaDesde = new JLabel("Fecha desde");
		lblFechaDesde.setBounds(10, 26, 86, 14);
		contentPane.add(lblFechaDesde);

		JLabel lblFechaHasta = new JLabel("Fecha hasta");
		lblFechaHasta.setBounds(201, 26, 96, 14);
		contentPane.add(lblFechaHasta);

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime fechaDesde = LocalDateTime.parse(textFieldDesde.getText() + " 00:00:00", formato);
				LocalDateTime fechaHasta = LocalDateTime.parse(textFieldHasta.getText() + " 00:00:00", formato);
				Iterator<Venta> iterador = estacionDeServicio.listarVentas(fechaDesde, fechaHasta).iterator();
				Venta venta;
				while (iterador.hasNext()) {
					venta = iterador.next();
					Object[] fila = { venta.fecha(), venta.litros(), venta.combustible(), venta.monto() };
					modelo.addRow(fila);
				}
				table.setModel(modelo);

			}
		});
	}
}
