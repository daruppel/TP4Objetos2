package dominio;

public class MotorComun implements Motor {

	public MotorComun() {
		System.out.println("Creando motor común");
	}

	public void arrancar() {
		System.out.println("Arrancando motor común");
	}

	public void apagar() {
		System.out.println("Apagando motor común");
	}

	public void acelerar() {
		System.out.println("Acelerando motor común");
	}

}
