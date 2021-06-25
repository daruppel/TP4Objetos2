package dominio;

public class ComboEspecial implements Combo{
	private String descripcion;
	private float precio;
	
	public ComboEspecial(String descripcion, float valor) {
		this.descripcion=descripcion;
		this.precio=valor;
	}
	
	
	public String descripcion() {
		return this.descripcion;
	}

	
	public float costo() {
		return this.precio;
	}
	
}
