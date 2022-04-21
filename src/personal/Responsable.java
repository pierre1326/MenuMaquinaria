package personal;

import java.util.ArrayList;

import maquinaria.Maquinaria;

public class Responsable implements Comparable<Responsable> {

	private String identificacion;
	private String fechaNacimiento;
	private String nombreCompleto;
	private ArrayList<Maquinaria> maquinarias;
	
	public Responsable(String identificacion, String fechaNacimiento, String nombreCompleto) {
		this.identificacion = identificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreCompleto = nombreCompleto;
		this.maquinarias = new ArrayList<>();
	}

	public void agregarMaquinaria(Maquinaria maquinaria) {
		this.maquinarias.add(maquinaria);
	}
	
	public ArrayList<Maquinaria> getMaquinarias() {
		return maquinarias;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	@Override
	public int compareTo(Responsable o) {
		return this.nombreCompleto.compareTo(o.getNombreCompleto());
	}
	
	@Override
	public String toString() {
		String resultado = 	"Identificacion: " + identificacion + "\n" +
				"Fecha nacimiento: " + fechaNacimiento + "\n" +
				"Nombre completo: " + nombreCompleto + "\n\n" +
				this.obtenerMaquinaria();
		return resultado;
	}
	
	private String obtenerMaquinaria() {
		if(maquinarias.size() == 0) {
			return "No hay maquinarias asignadas";
		}
		String resultado = "Maquinarias: \n\n";
		for(int i = 0; i < maquinarias.size(); i++) {
			resultado += maquinarias.get(i).toString() + "\n";
		}
		return resultado;
	}
	
	public String obtenerTablasDepreciacion() {
		if(maquinarias.size() == 0) {
			return "No hay maquinarias asignadas";
		}
		String resultado = "Tablas: \n\n";
		for(int i = 0; i < maquinarias.size(); i++) {
			resultado += maquinarias.get(i).obtenerTablaDepreciacion();
		}	
		return resultado;
	}
	
}
