package maquinaria;

import java.util.ArrayList;

import personal.Responsable;

public abstract class Maquinaria implements Comparable<Maquinaria> {

	private static int ID = 1;
	
	protected int id = 0;
	protected float valor;
	protected int vidaUtil;
	protected String marca;
	protected String descripcion;
	protected ArrayList<Mantenimiento> mantenimientos;
	protected Responsable responsable;
	
	public Maquinaria(float valor, int vidaUtil, String marca, String descripcion) {
		this.valor = valor;
		this.vidaUtil = vidaUtil;
		this.marca = marca;
		this.descripcion = descripcion;
		this.mantenimientos = new ArrayList<>();
		this.id = ID;
		ID++;
	}

	public abstract String obtenerTablaDepreciacion();
	
	public String obtenerTablaMantenimientos() {
		if(mantenimientos.size() == 0) {
			return "No se han realizado mantenimientos";
		}
		String resultado = "Mantenimientos: \n\nFecha -> Costo -> Descripcion \n";
		for(int i = 0; i < mantenimientos.size(); i++) {
			Mantenimiento mantenimiento = mantenimientos.get(i);
			resultado += mantenimiento.toString() + "\n";
		}
		return resultado;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public ArrayList<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}
	
	public void agregarMantenimiento(int costo, String fecha, String descripcion) {
		Mantenimiento mantenimiento = new Mantenimiento(costo, fecha, descripcion);
		mantenimientos.add(mantenimiento);
	}
	
	@Override
	public int compareTo(Maquinaria o) {
		return Float.compare(valor, o.valor);
	}
	
}
