package maquinaria;

public class Herramienta extends Maquinaria {
	
	private float valorSalvamento;
	private float tasaDepreciacion;
	
	public Herramienta(float valor, int vidaUtil, String marca, String descripcion, float valorSalvamento, float tasaDepreciacion) {
		super(valor, vidaUtil, marca, descripcion);
		this.valorSalvamento = valorSalvamento;
		this.tasaDepreciacion = tasaDepreciacion;
	}	

	@Override
	public String toString() {
		String resultado = "ID: " + Integer.toString(id) + "\n" +
				"Valor: " + Float.toString(valor) + "\n" +
				"Vida util: " + Integer.toString(vidaUtil) + "\n" +
				"Marca: " + marca + "\n" +
				"Descripcion: " + descripcion + "\n" +
				"Valor salvamento: " + Float.toString(valorSalvamento) + "\n" +
				"Tasa depreciacion: " + Float.toString(tasaDepreciacion) + "\n" +
				"Responsable: " + (this.responsable == null ? "Sin responsable asiginado" : this.responsable.getNombreCompleto()) + "\n\n" +
				this.obtenerTablaDepreciacion() + "\n" +
				this.obtenerTablaMantenimientos(); 
		return resultado;
	}
	
	@Override
	public String obtenerTablaDepreciacion() {
		String resultado = "Año -> Tasa depreciacion -> Valor sin depreciar -> Cuota depreciacion -> Depreciacion acumulada -> Valor neto \n";
		float valorSinDepreciar = valor;
		float depreciacionAcumulada = 0;
		for(int i = 1; i <= vidaUtil; i++) {
			float cuotaDepreciacion = valorSinDepreciar * tasaDepreciacion;
			depreciacionAcumulada += cuotaDepreciacion;
			float valorNeto = valorSinDepreciar - cuotaDepreciacion;
			float temporal = valorNeto;
			if(valorNeto < valorSalvamento) {
				temporal = valorSalvamento;
			}
			resultado += Integer.toString(i) + " -> " + Float.toString(tasaDepreciacion) + " -> " + Float.toString(valorSinDepreciar) + " -> " + Float.toString(cuotaDepreciacion) + " -> " + Float.toString(depreciacionAcumulada) + 
					" -> " + Float.toString(temporal) + "\n";
			valorSinDepreciar = valorNeto;
		}
		return resultado;
	}
	
}
