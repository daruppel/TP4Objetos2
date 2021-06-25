package main;

import dominio.Motor;
import dominio.MotorElectrico;
import dominio.MotorElectricoAdapter;

public class main {

	public static void main(String[] args) {
		MotorElectrico motorElectrico = new MotorElectrico();
		Motor motorElectronicoAdapter = new MotorElectricoAdapter(motorElectrico);
		motorElectronicoAdapter.arrancar();
		motorElectronicoAdapter.acelerar();
		motorElectronicoAdapter.apagar();

	}

}
