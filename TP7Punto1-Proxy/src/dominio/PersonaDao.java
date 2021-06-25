package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {
	private String url;
	private String user;
	private String password;

	public PersonaDao(String urlBD, String user, String password) {
		this.url = urlBD;
		this.password = password;
		this.user = user;
	}

	private Connection obtenerConexion() throws SQLException {
		Connection dbConn = DriverManager.getConnection(url, user, password);
		return dbConn;
	}

	public Persona personaPorId(int id) {
		String sql = "select nombre from personas where id = ?;";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			String nombrePersona = null;
			while (result.next()) {
				nombrePersona = result.getString(1);
			}
			Set<Telefono> telefonos = new TelefonoProxy(this, id);
			return new Persona(id, nombrePersona, telefonos);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Telefono> telefonosPorId(int id) {
		String sql = "select numero " + "from telefonos " + "where idpersona = ?";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonos = new HashSet<Telefono>();
			while (result.next()) {
				telefonos.add(new Telefono(result.getString(1)));
			}
			return telefonos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
