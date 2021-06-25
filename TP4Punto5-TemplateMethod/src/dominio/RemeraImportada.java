package dominio;

public class RemeraImportada extends Remera {

	public RemeraImportada(float precioUnitario) {
		super(precioUnitario);
	}

	protected float recargo(float precioUnitario) {
		return (precioUnitario * 0.03f) + (precioUnitario * 0.05f);
	}

	protected float beneficio(float precioUnitario) {
		return 0;
	}

	protected float ganancia(float precioUnitario) {
		return precioUnitario * 0.25f;
	}

}
