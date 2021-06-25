package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCFachada implements DBFacade {
	String url = "jdbc:mysql://localhost:3306/tp7punto1proxy";
	String user = "root";
	String password = "";
	Connection dbConnection;

	@Override
	public void open() {
		try {
			this.dbConnection = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			throw new RuntimeException("Error al conectar la base de datos. " + e.getMessage());
		}

	}

	@Override
	public List<Map<String, String>> queryResultAsAsociation(String sql) {
		List<Map<String, String>> lista = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		open();
		try {
			PreparedStatement statement = this.dbConnection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			ResultSetMetaData metaData = resultado.getMetaData();
			while (resultado.next()) {
				for (int i = 1; i < metaData.getColumnCount(); i++) {
					map.put(metaData.getColumnName(i), resultado.getString(i));
					lista.add(map);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error con la consulta a la base de datos. " + e.getMessage());
		}
		return lista;
	}

	@Override
	public List<String[]> queryResultAsArray(String sql) {
		List<String[]> lista = new ArrayList<String[]>();
		open();
		try {
			PreparedStatement statement = this.dbConnection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			String[] registro = {};
			while (resultado.next()) {
				for (int i = 1; i < resultado.getMetaData().getColumnCount(); i++) {
					lista.add(new String[] { resultado.getString(i) });
				}
				lista.add(registro);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error con la consulta a la base de datos. " + e.getMessage());
		}
		return lista;
	}

	@Override
	public void close() {
		try {
			this.dbConnection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error al cerrar la conexión a la base de datos. " + e.getMessage());
		}
	}
}
