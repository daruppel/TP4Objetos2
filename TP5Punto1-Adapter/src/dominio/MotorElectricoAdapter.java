package dominio;

public class MotorElectricoAdapter implements Motor {
	private MotorElectrico motor;

	public MotorElectricoAdapter(MotorElectrico motor) {
		this.motor = motor;
	}

	@Override
	public void arrancar() {
		this.motor.conectar();
		this.motor.activar();
		System.out.println("Arrancando motor electrico adapter");
	}

	@Override
	public void acelerar() {
		this.motor.moverMasRapido();
		System.out.println("Acelerando motor electrico adapter");
	}

	@Override
	public void apagar() {
		this.motor.detener();
		this.motor.desconectar();
		System.out.println("Apagando motor electrico adapter");
	}
}
