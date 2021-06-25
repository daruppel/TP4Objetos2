package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import dominio.Empleado;
import dominio.EmpleadoConEmpleadosACargo;
import dominio.EmpleadoRegular;

class EmpleadoTests {

	@Test
	void calculoDeSalarioDeTodosLosEmpleadosDeLaEmpresa() {
		// Creación de los empleados
		Empleado director = new EmpleadoConEmpleadosACargo(200000);

		Empleado gerente1 = new EmpleadoConEmpleadosACargo(150000);
		Empleado gerente2 = new EmpleadoConEmpleadosACargo(150000);

		Empleado mandoMedio1 = new EmpleadoConEmpleadosACargo(100000);
		Empleado mandoMedio2 = new EmpleadoConEmpleadosACargo(100000);
		Empleado mandoMedio3 = new EmpleadoConEmpleadosACargo(100000);
		Empleado mandoMedio4 = new EmpleadoConEmpleadosACargo(100000);

		Empleado liderDeProyecto1 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto2 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto3 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto4 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto5 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto6 = new EmpleadoConEmpleadosACargo(90000);

		Empleado empleadoRegular1 = new EmpleadoRegular(80000);
		Empleado empleadoRegular2 = new EmpleadoRegular(80000);
		Empleado empleadoRegular3 = new EmpleadoRegular(80000);
		Empleado empleadoRegular4 = new EmpleadoRegular(80000);
		Empleado empleadoRegular5 = new EmpleadoRegular(80000);
		Empleado empleadoRegular6 = new EmpleadoRegular(80000);
		Empleado empleadoRegular7 = new EmpleadoRegular(80000);
		Empleado empleadoRegular8 = new EmpleadoRegular(80000);
		Empleado empleadoRegular9 = new EmpleadoRegular(80000);
		Empleado empleadoRegular10 = new EmpleadoRegular(80000);

		// Asignación de empleados
		director.agregarEmpleadoACargo(gerente1);
		director.agregarEmpleadoACargo(gerente2);

		gerente1.agregarEmpleadoACargo(mandoMedio1);
		gerente1.agregarEmpleadoACargo(mandoMedio2);
		gerente2.agregarEmpleadoACargo(mandoMedio3);
		gerente2.agregarEmpleadoACargo(mandoMedio4);

		mandoMedio1.agregarEmpleadoACargo(liderDeProyecto1);
		mandoMedio1.agregarEmpleadoACargo(liderDeProyecto2);
		mandoMedio2.agregarEmpleadoACargo(liderDeProyecto3);
		mandoMedio2.agregarEmpleadoACargo(liderDeProyecto4);
		mandoMedio3.agregarEmpleadoACargo(liderDeProyecto5);
		mandoMedio4.agregarEmpleadoACargo(liderDeProyecto6);

		liderDeProyecto1.agregarEmpleadoACargo(empleadoRegular1);
		liderDeProyecto1.agregarEmpleadoACargo(empleadoRegular2);
		liderDeProyecto2.agregarEmpleadoACargo(empleadoRegular3);
		liderDeProyecto2.agregarEmpleadoACargo(empleadoRegular4);
		liderDeProyecto3.agregarEmpleadoACargo(empleadoRegular5);
		liderDeProyecto3.agregarEmpleadoACargo(empleadoRegular6);
		liderDeProyecto4.agregarEmpleadoACargo(empleadoRegular7);
		liderDeProyecto4.agregarEmpleadoACargo(empleadoRegular8);
		liderDeProyecto5.agregarEmpleadoACargo(empleadoRegular9);
		liderDeProyecto6.agregarEmpleadoACargo(empleadoRegular10);

		assertEquals(2240000, director.montoSalarialTotal(), 0);
	}

	@Test
	void calculoDeSalarioDeUnEmpleadoRegularDeLaEmpresa() {
		// Creación de los empleados
		Empleado director = new EmpleadoConEmpleadosACargo(200000);

		Empleado gerente1 = new EmpleadoConEmpleadosACargo(150000);
		Empleado gerente2 = new EmpleadoConEmpleadosACargo(150000);

		Empleado mandoMedio1 = new EmpleadoConEmpleadosACargo(100000);
		Empleado mandoMedio2 = new EmpleadoConEmpleadosACargo(100000);
		Empleado mandoMedio3 = new EmpleadoConEmpleadosACargo(100000);
		Empleado mandoMedio4 = new EmpleadoConEmpleadosACargo(100000);

		Empleado liderDeProyecto1 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto2 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto3 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto4 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto5 = new EmpleadoConEmpleadosACargo(90000);
		Empleado liderDeProyecto6 = new EmpleadoConEmpleadosACargo(90000);

		Empleado empleadoRegular1 = new EmpleadoRegular(80000);
		Empleado empleadoRegular2 = new EmpleadoRegular(80000);
		Empleado empleadoRegular3 = new EmpleadoRegular(80000);
		Empleado empleadoRegular4 = new EmpleadoRegular(80000);
		Empleado empleadoRegular5 = new EmpleadoRegular(80000);
		Empleado empleadoRegular6 = new EmpleadoRegular(80000);
		Empleado empleadoRegular7 = new EmpleadoRegular(80000);
		Empleado empleadoRegular8 = new EmpleadoRegular(80000);
		Empleado empleadoRegular9 = new EmpleadoRegular(80000);
		Empleado empleadoRegular10 = new EmpleadoRegular(80000);

		// Asignación de empleados
		director.agregarEmpleadoACargo(gerente1);
		director.agregarEmpleadoACargo(gerente2);

		gerente1.agregarEmpleadoACargo(mandoMedio1);
		gerente1.agregarEmpleadoACargo(mandoMedio2);
		gerente2.agregarEmpleadoACargo(mandoMedio3);
		gerente2.agregarEmpleadoACargo(mandoMedio4);

		mandoMedio1.agregarEmpleadoACargo(liderDeProyecto1);
		mandoMedio1.agregarEmpleadoACargo(liderDeProyecto2);
		mandoMedio2.agregarEmpleadoACargo(liderDeProyecto3);
		mandoMedio2.agregarEmpleadoACargo(liderDeProyecto4);
		mandoMedio3.agregarEmpleadoACargo(liderDeProyecto5);
		mandoMedio4.agregarEmpleadoACargo(liderDeProyecto6);

		liderDeProyecto1.agregarEmpleadoACargo(empleadoRegular1);
		liderDeProyecto1.agregarEmpleadoACargo(empleadoRegular2);
		liderDeProyecto2.agregarEmpleadoACargo(empleadoRegular3);
		liderDeProyecto2.agregarEmpleadoACargo(empleadoRegular4);
		liderDeProyecto3.agregarEmpleadoACargo(empleadoRegular5);
		liderDeProyecto3.agregarEmpleadoACargo(empleadoRegular6);
		liderDeProyecto4.agregarEmpleadoACargo(empleadoRegular7);
		liderDeProyecto4.agregarEmpleadoACargo(empleadoRegular8);
		liderDeProyecto5.agregarEmpleadoACargo(empleadoRegular9);
		liderDeProyecto6.agregarEmpleadoACargo(empleadoRegular10);

		assertEquals(80000, empleadoRegular8.montoSalarialTotal(), 0);
	}

}
