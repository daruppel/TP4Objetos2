package dominio;

public class MotorComun implements Motor {

	public MotorComun() {
		System.out.println("Creando motor com�n");
	}

	public void arrancar() {
		System.out.println("Arrancando motor com�n");
	}

	public void apagar() {
		System.out.println("Apagando motor com�n");
	}

	public void acelerar() {
		System.out.println("Acelerando motor com�n");
	}

}
