package dominio;

public class EmpleadoRegular implements Empleado {
	private float salario;

	public EmpleadoRegular(float salario) {
		this.salario = salario;
	}

	public float montoSalarialTotal() {
		return this.salario;
	}

	public void agregarEmpleadoACargo(Empleado empleado) {
	}

}
