package main;

import dominio.Persona;
import dominio.PersonaDao;
import dominio.Telefono;

public class main {

	public static void main(String[] args) {
		PersonaDao dao = new PersonaDao("jdbc:mysql://localhost:3306/tp7punto1proxy", "root", "");
		Persona p = dao.personaPorId(1);
		System.out.println(p.nombre());
		for (Telefono telefono : p.telefonos()) {
			System.out.println(telefono);
		}

	}

}
