package dominio;

public class RemeraNacional extends Remera {

	public RemeraNacional(float precioUnitario) {
		super(precioUnitario);
	}

	protected float recargo(float precioUnitario) {
		return precioUnitario * 0.015f;
	}

	protected float beneficio(float precioUnitario) {
		return precioUnitario * 0.20f;
	}

	protected float ganancia(float precioUnitario) {
		return precioUnitario * 0.15f;
	}

}
