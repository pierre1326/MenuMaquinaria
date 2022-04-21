package maquinaria;

public class Equipo extends Maquinaria {

	private float peso;
	private float volumen;
	
	public Equipo(float valor, int vidaUtil, String marca, String descripcion, float peso, float volumen) {
		super(valor, vidaUtil, marca, descripcion);
		this.peso = peso;
		this.volumen = volumen;
	}

	@Override
	public String toString() {
		String resultado = "ID: " + Integer.toString(id) + "\n" +
				"Valor: " + Float.toString(valor) + "\n" +
				"Vida util: " + Integer.toString(vidaUtil) + "\n" +
				"Marca: " + marca + "\n" +
				"Descripcion: " + descripcion + "\n" +
				"Peso: " + Float.toString(peso) + "kg \n" +
				"Volumen: " + Float.toString(volumen) + "\n" +
				"Responsable: " + (this.responsable == null ? "Sin responsable asiginado" : this.responsable.getNombreCompleto()) + "\n\n" +
				this.obtenerTablaDepreciacion() + "\n" +
				this.obtenerTablaMantenimientos(); 
		return resultado;
	}
	
	@Override
	public String obtenerTablaDepreciacion() {
		float cuotaDepreciacion = valor / (float)vidaUtil;
		float depreciacionAcumulada = cuotaDepreciacion;
		String resultado = "Año -> Cuota depreciacion -> Depreciacion acumulada -> Valor neto \n";
		for(int i = 1; i <= vidaUtil; i++) {
			float valorNeto = valor - depreciacionAcumulada;
			resultado += Integer.toString(i) + " -> " + Float.toString(cuotaDepreciacion) + " -> " + Float.toString(depreciacionAcumulada) + " -> " + Float.toString(valorNeto) + "\n";
			depreciacionAcumulada += cuotaDepreciacion;
		}
		return resultado;
	}
	
}
