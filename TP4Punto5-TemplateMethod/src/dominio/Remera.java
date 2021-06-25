package dominio;

public abstract class Remera {
	float precioUnitario;

	public Remera(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public float calculoDelPrecioDeVenta() {
		float precioVenta = precioUnitario + (this.recargo(precioUnitario)) - (this.beneficio(precioUnitario));
		return (this.ganancia(precioVenta) + precioUnitario);
	}

	protected abstract float recargo(float precioUnitario);

	protected abstract float beneficio(float precioUnitario);

	protected abstract float ganancia(float precioUnitario);

}
