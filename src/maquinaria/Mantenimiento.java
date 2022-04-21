package maquinaria;

public class Mantenimiento {

	private int costo;
	private String fecha;
	private String descripcion;
	
	public Mantenimiento(int costo, String fecha, String descripcion) {
		this.costo = costo;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return fecha + " -> " + Integer.toString(costo) + " -> " + descripcion;
	}
	
}
