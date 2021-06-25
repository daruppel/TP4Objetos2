package dominio;

public class ComboFamiliar implements Combo{
	private String descripcion;
	private float precio;
	
	public ComboFamiliar(String descripcion, float valor) {
		this.descripcion=descripcion;
		this.precio=valor;
	}
	
	@Override
	public String descripcion() {
		return this.descripcion;
	}

	@Override
	public float costo() {
		return this.precio;
	}

}
