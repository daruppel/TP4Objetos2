package dominio;

public class MostrarTempEnConsolaObservador implements ObservadorClima{
	
	
	public MostrarTempEnConsolaObservador() {
		
	}
	
	private int obtenerGrados(String temperatura) {
		String temp="";
		char [] cadena = temperatura.toCharArray();
		for(int i=0;i<cadena.length;i++) {
			if(Character.isDigit(cadena[i]))
				temp=temp+cadena[i];
		}
		int tempEnNumero = Integer.parseInt(temp);
		return tempEnNumero;
	}
	
	@Override
	public void actualizarTemperatura(String temperatura) {
		int grados = this.obtenerGrados(temperatura);
		if(grados<12)
			System.out.println("Hace frio se encenderá la caldera");
		if(grados>17)
			System.out.println("Hace calor, se encenderá el aire acondicionado");
	}
	
	
}
