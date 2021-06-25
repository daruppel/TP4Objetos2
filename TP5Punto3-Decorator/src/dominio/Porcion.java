package dominio;

public class Porcion implements Combo{
	private String nombre;
	private float precio;
	private Combo combo;
	
	public Porcion(String nombre, float valor, Combo combo) {
		this.nombre=nombre;
		this.precio=valor;
		this.combo=combo;
	}
	
	public String descripcion() {
		return (this.nombre+", "+this.combo.descripcion());
	}
	
	public float costo() {
		return (this.precio+this.combo.costo());
	}
	
}
