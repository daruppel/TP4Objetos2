package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RestCallEnBD implements Rest {
	private Connection dbConn;
	private String url;
	private String user;
	private String password;
	private Rest rest;

	public RestCallEnBD(Rest rest, String urlBD, String user, String password) {
		this.url = urlBD;
		this.password = password;
		this.user = user;
		this.rest = rest;
	}

	private void setupBaseDeDatos() throws SQLException {
		this.dbConn = DriverManager.getConnection(url, user, password);
	}

	@Override
	public String run() {
		String cadena = this.rest.run();

		PreparedStatement st = null;
		try {
			this.setupBaseDeDatos();
			st = dbConn.prepareStatement("insert into datos(cadena)values(?)");
			st.setString(1, cadena);
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
		return cadena;
	}
}
