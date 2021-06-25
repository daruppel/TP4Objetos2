package dominio;

import java.util.HashSet;

public class TelefonoProxy extends HashSet<Telefono> {
	private int idPersona;
	private PersonaDao personaDao;

	public TelefonoProxy(PersonaDao personaDao, int idPersona) {
		super();
		if (idPersona <= 0)
			throw new RuntimeException("ID persona no valido");
		this.idPersona = idPersona;
		this.personaDao = personaDao;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		super.addAll(personaDao.telefonosPorId(this.idPersona));
		return super.toArray(a);
	}
}
