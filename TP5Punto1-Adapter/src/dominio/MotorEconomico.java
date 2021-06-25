package dominio;

public class MotorEconomico implements Motor {

	public MotorEconomico() {
		System.out.println("Creando motor economico");
	}

	public void arrancar() {
		System.out.println("Arrancando motor economico");
	}

	public void apagar() {
		System.out.println("Apagando motor economico");
	}

	public void acelerar() {
		System.out.println("Acelerando motor economico");
	}

}
