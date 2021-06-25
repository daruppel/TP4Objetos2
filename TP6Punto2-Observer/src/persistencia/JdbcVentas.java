package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dominio.Combustible;
import dominio.Comun;
import dominio.PersistenciaVentas;
import dominio.Super;
import dominio.Venta;

public class JdbcVentas implements PersistenciaVentas {
	private Connection dbConn;
	private String url;
	private String user;
	private String password;

	public JdbcVentas(String urlBD, String user, String password) {
		this.url = urlBD;
		this.password = password;
		this.user = user;
	}

	private void setupBaseDeDatos() throws SQLException {
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	public void cargarVenta(LocalDateTime fecha, int litros, float monto, Combustible combustible)
			throws RuntimeException {
		PreparedStatement st = null;
		try {
			this.setupBaseDeDatos();
			st = dbConn.prepareStatement("insert into venta(fecha,litros,monto,idCombustible)values(?,?,?,?)");
			st.setTimestamp(1, Timestamp.valueOf(fecha));
			st.setInt(2, litros);
			st.setFloat(3, monto);
			st.setInt(4, combustible.id());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error con la base de datos", e);
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				throw new RuntimeException("Error al cargar la venta en la base de datos", e);
			}
		}
	}

	public List<Venta> listarVentas(LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws RuntimeException {
		List<Venta> lisVentas = new ArrayList<>();
		PreparedStatement sent = null;
		try {
			this.setupBaseDeDatos();
			sent = this.dbConn.prepareStatement(
					"select * from venta v join combustible c on v.idCombustible=c.idCombustible where v.fecha BETWEEN ? AND ?");
			sent.setTimestamp(1, Timestamp.valueOf(fechaDesde));
			sent.setTimestamp(2, Timestamp.valueOf(fechaHasta));
			ResultSet res = sent.executeQuery();
			Venta venta;
			Combustible combustible = null;
			while (res.next()) {
				if (res.getString(7).equals("Super"))
					combustible = new Super(res.getFloat(8));
				if (res.getString(7).equals("Comun"))
					combustible = new Comun(res.getFloat(8));
				combustible.setId(res.getInt(6));
				venta = new Venta(res.getTimestamp(2).toLocalDateTime(), res.getInt(3), combustible);
				lisVentas.add(venta);
			}
		} catch (SQLException sql) {
			throw new RuntimeException("Error al cargar la venta en la base de datos", sql);
		} finally {
			try {
				sent.close();
				this.dbConn.close();
			} catch (SQLException sql2) {
				throw new RuntimeException("Error al cerrar las conexiones: " + sql2.getMessage());
			}
		}
		return lisVentas;
	}

	public List<Combustible> listarTiposDeCombustibles() throws RuntimeException {
		List<Combustible> lisCombustible = new ArrayList<>();
		PreparedStatement sent = null;
		try {
			this.setupBaseDeDatos();
			sent = this.dbConn.prepareStatement("select * from combustible");
			ResultSet res = sent.executeQuery();
			Combustible combustible = null;
			while (res.next()) {
				if (res.getString(2).equals("Super"))
					combustible = new Super(res.getFloat(3));
				if (res.getString(2).equals("Comun"))
					combustible = new Comun(res.getFloat(3));
				combustible.setId(res.getInt(1));
				lisCombustible.add(combustible);
			}
		} catch (SQLException sql) {
			throw new RuntimeException("Error al cargar la venta en la base de datos", sql);
		} finally {
			try {
				sent.close();
				this.dbConn.close();
			} catch (SQLException sql2) {
				throw new RuntimeException("Error al cerrar las conexiones: " + sql2.getMessage());
			}
		}
		return lisCombustible;
	}

}
