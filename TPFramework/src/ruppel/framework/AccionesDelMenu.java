package ruppel.framework;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public final class AccionesDelMenu {
	private Properties properties;

	public AccionesDelMenu(String urlProperties) {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(urlProperties));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Accion> acciones() {

		List<Accion> acciones = new ArrayList<>();
		for (Enumeration<Object> e = properties.keys(); e.hasMoreElements();) {
			Object objeto = e.nextElement();
			String ac = properties.getProperty(objeto.toString());

			Accion accion = null;
			try {
				accion = (Accion) Class.forName(ac).getDeclaredConstructor().newInstance();
			} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			acciones.add(accion);
		}
		Collections.reverse(acciones);
		return acciones;
	}
}
