package dominio;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoConEmpleadosACargo implements Empleado {
	private float salario;
	private List<Empleado> empleadosACargo = new ArrayList<Empleado>();

	public EmpleadoConEmpleadosACargo(float salario) {
		this.salario = salario;
	}

	public float montoSalarialTotal() {
		float salarioTotal = this.salario;
		for (Empleado empleado : this.empleadosACargo) {
			salarioTotal = salarioTotal + empleado.montoSalarialTotal();
		}
		return salarioTotal;
	}

	public void agregarEmpleadoACargo(Empleado empleado) {
		this.empleadosACargo.add(empleado);
	}

}
