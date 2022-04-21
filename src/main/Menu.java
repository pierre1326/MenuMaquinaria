package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import maquinaria.Equipo;
import maquinaria.Herramienta;
import maquinaria.Maquinaria;
import personal.Responsable;

public class Menu {

	ArrayList<Responsable> responsables = new ArrayList<>();
	ArrayList<Maquinaria> maquinarias = new ArrayList<>();
	
	public void ejecutar() {
		boolean continuar = true;
		while(continuar) {
			System.out.println("Indique la opcion que desea realizar:");
			System.out.println("1. Crear un responsable");
			System.out.println("2. Crear un equipo industrial");
			System.out.println("3. Crear una herramienta industrial");
			System.out.println("4. Ordenar lista de responsables");
			System.out.println("5. Ordenar lista de maquinarias");
			System.out.println("6. Asignar maquinaria a responsable");
			System.out.println("7. Asignar responsable a maquinaria");
			System.out.println("8. Crear mantenimiento a maquinaria");
			System.out.println("9. Informacion completa de un responsable");
			System.out.println("10. Informacion completa de una maquinaria");
			System.out.println("11. Tablas de depreciacion de maquinaria de un responsable");
			System.out.println("12. Tabla de depreciacion de maquinaria por id");
			System.out.println("13. Informacion de todos los responsables");
			System.out.println("14. Informacion de todas las maquinarias");
			System.out.println("15. Salir del programa");
			int opcion = obtenerEntero("Opcion: ");
			while(opcion < 1 || opcion > 15) {
				System.out.println("La opcion indicada no es valida. Intente nuevamente");
				opcion = obtenerEntero("Opcion: ");
			}
			switch(opcion) {
				case 1:
					crearResponsable();
					break;
				case 2:
					crearEquipoIndustrial();
					break;
				case 3:
					crearHerramientoIndustrial();
					break;
				case 4:
					ordenarResponsables();
					break;
				case 5:
					ordenarMaquinaria();
					break;
				case 6:
					asignarMaquinaria();
					break;
				case 7:
					asignarResponsable();
					break;
				case 8:
					crearMantenimiento();
					break;
				case 9:
					informacionCompletaResponsable();
					break;
				case 10:
					informacionCompletaMaquinaria();
					break;
				case 11:
					tablaResponsable();
					break;
				case 12:
					tablaMaquinaria();
					break;
				case 13:
					informacionResponsables();
					break;
				case 14:
					informacionMaquinarias();
					break;
				default:
					continuar = false;
					break;
			}
		}
		System.out.println("Gracias por utilizar el programa");
	}
	
	private void informacionMaquinarias() {
		if(this.maquinarias.size() == 0) {
			System.out.println("\nNo hay maquinarias creadas\n");
		}
		else {
			for(int i = 0; i < this.maquinarias.size(); i++) {
				System.out.println(this.maquinarias.get(i).toString());
				System.out.println();
			}
		}
	}
	
	private void informacionResponsables() {
		if(this.responsables.size() == 0) {
			System.out.println("\nNo hay responsables creados\n");
		}
		else {
			for(int i = 0; i < this.responsables.size(); i++) {
				System.out.println(this.responsables.get(i).toString());
				System.out.println();
			}
		}
	}
	
	private void tablaMaquinaria() {
		if(this.maquinarias.size() == 0) {
			System.out.println("\nNo hay maquinarias creadas\n");
		}
		else {
			Maquinaria maquinaria = obtenerMaquinaria();
			System.out.println(maquinaria.obtenerTablaDepreciacion());
			System.out.println();
		}
	}
	
	private void tablaResponsable() {
		if(this.responsables.size() == 0) {
			System.out.println("\nNo hay responsables creadas\n");
		}
		else {
			Responsable responsable = obtenerResponsable();
			System.out.println(responsable.obtenerTablasDepreciacion());
			System.out.println();
		}
	}
	
	private void informacionCompletaMaquinaria() {
		if(this.maquinarias.size() == 0) {
			System.out.println("\nNo hay maquinarias creadas\n");
		}
		else {
			Maquinaria maquinaria = obtenerMaquinaria();
			System.out.println(maquinaria.toString());
			System.out.println();
		}
	}
	
	private void informacionCompletaResponsable() {
		if(this.responsables.size() == 0) {
			System.out.println("\nNo hay responsables creadas\n");
		}
		else {
			Responsable responsable = obtenerResponsable();
			System.out.println(responsable.toString());
			System.out.println();
		}
	}
	
	private void crearMantenimiento() {
		if(maquinarias.size() == 0) {
			System.out.println("\nNo hay maquinarias creadas\n");
		}
		else {
			Maquinaria maquinaria = obtenerMaquinaria();
			int costo = obtenerEntero("Ingrese el costo: ");
			String fecha = obtenerRespuesta("Ingrese la fecha del mantenimiento: ");
			String descripcion = obtenerRespuesta("Ingrese el motivo del mantenimiento: ");
			maquinaria.agregarMantenimiento(costo, fecha, descripcion);
			System.out.println("\nManteimiento agregado con exito\n");
		}
	}
	
	private void asignarMaquinaria() {
		if(maquinarias.size() == 0 || responsables.size() == 0) {
			System.out.println("\nNo hay maquinarias o responsables creados\n");
		}
		else {
			Maquinaria maquinaria = obtenerMaquinaria();
			Responsable responsable = obtenerResponsable();
			responsable.agregarMaquinaria(maquinaria);
			System.out.println("\nMaquinaria agregada con exito\n");
		}
	}
	

	private void asignarResponsable() {
		if(maquinarias.size() == 0 || responsables.size() == 0) {
			System.out.println("\nNo hay maquinarias o responsables creados\n");
		}
		else {
			Maquinaria maquinaria = obtenerMaquinaria();
			Responsable responsable = obtenerResponsable();
			maquinaria.setResponsable(responsable);
			System.out.println("\nResponsable asignado con exito\n");
		}
	}
	
	private Maquinaria obtenerMaquinaria() {
		System.out.println("Maquinarias: ");
		for(int i = 0; i < this.maquinarias.size(); i++) {
			System.out.println("Maquinaria ID: " + maquinarias.get(i).getId());
		}
		int id = obtenerEntero("Ingrese el id de la maquinaria: ");
		while(true) {
			for(int i = 0; i < this.responsables.size(); i++) {
				if(this.maquinarias.get(i).getId() == id) {
					return this.maquinarias.get(i);
				}
			}
			System.out.println("El id indicado no existe. Por favor intente nuevamente.");
			id = obtenerEntero("Ingrese el id de la maquinaria: ");
		}
	}
	
	private Responsable obtenerResponsable() {
		System.out.println("Responsables: ");
		for(int i = 0; i < this.responsables.size(); i++) {
			System.out.println("Identificacion: " + responsables.get(i).getIdentificacion());
		}
		String identificacion = obtenerRespuesta("Ingrese la identificacion del responsable: ");
		while(true) {
			for(int i = 0; i < this.responsables.size(); i++) {
				if(this.responsables.get(i).getIdentificacion().compareTo(identificacion) == 0) {
					return this.responsables.get(i);
				}
			}
			System.out.println("La identificacion indicada no existe. Por favor intente nuevamente.");
			identificacion = obtenerRespuesta("Ingrese la identificacion del responsable: ");
		}
	}
	
	private void crearResponsable() {
		String identificacion = obtenerRespuesta("Ingrese la identificacion: ");
		String fechaNacimiento = obtenerRespuesta("Ingrese fecha de nacimiento: ");
		String nombreCompleto = obtenerRespuesta("Ingrese nombre completo: ");
		Responsable responsable = new Responsable(identificacion, fechaNacimiento, nombreCompleto);
		responsables.add(responsable);
		System.out.println("\nResponsable agregado con exito\n");
	}
	
	private void crearEquipoIndustrial() {
		float valor = obtenerFlotante("Ingrese el valor: ");
		int vidaUtil = obtenerEntero("Ingrese la vida util: ");
		String marca = obtenerRespuesta("Ingrese la marca: ");
		String descripcion = obtenerRespuesta("Ingrese la descripcion: ");
		float peso = obtenerFlotante("Ingrese el peso: ");
		float volumen = obtenerFlotante("Ingrse el volumen: ");
		Maquinaria equipo = new Equipo(valor, vidaUtil, marca, descripcion, peso, volumen);
		maquinarias.add(equipo);
		System.out.println("\nMaquinaria agregada con exito\n");
	}
	
	private void crearHerramientoIndustrial() {
		float valor = obtenerFlotante("Ingrese el valor: ");
		int vidaUtil = obtenerEntero("Ingrese la vida util: ");
		String marca = obtenerRespuesta("Ingrese la marca: ");
		String descripcion = obtenerRespuesta("Ingrese la descripcion: ");
		float valorSalvamento = obtenerFlotante("Ingrese el valor del salvamento: ");
		float tasaDepreciacion = obtenerFlotante("Ingrse la tasa de depreciacion: ");
		Maquinaria equipo = new Herramienta(valor, vidaUtil, marca, descripcion, valorSalvamento, tasaDepreciacion);
		maquinarias.add(equipo);
		System.out.println("\nMaquinaria agregada con exito\n");
	}
	
	private void ordenarResponsables() {
		Collections.sort(this.responsables);
		System.out.println("\nResponsables ordenados exitosamente\n");
	}
	
	private void ordenarMaquinaria() {
		Collections.sort(this.maquinarias);
		System.out.println("\nMaquinarias ordenas con exito\n");
	}
	
	private int obtenerEntero(String pregunta) {
		String respuesta = obtenerRespuesta(pregunta);
		while(true) {
			try {
				int numero = Integer.parseInt(respuesta);
				return numero;
			}
			catch(Exception e) {
				System.out.println("Los datos ingresados no son un numero valido");
				respuesta = obtenerRespuesta(pregunta);
			}
		}	
	}
	
	private float obtenerFlotante(String pregunta) {
		String respuesta = obtenerRespuesta(pregunta);
		while(true) {
			try {
				float numero = Float.parseFloat(respuesta);
				return numero;
			}
			catch(Exception e) {
				System.out.println("Los datos ingresados no son un numero valido");
				respuesta = obtenerRespuesta(pregunta);
			}
		}	
	}
	
	private String obtenerRespuesta(String pregunta) {
		String respuesta = "";
		System.out.println(pregunta);
		respuesta = leerConsola();
		while(respuesta.compareTo("") == 0) {
			System.out.println("No puede ingresar una respuesta vacia. Intente nuevamente");
			System.out.println(pregunta);
			respuesta = leerConsola();
		}
		return respuesta;
	}

	private String leerConsola() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
	
}
