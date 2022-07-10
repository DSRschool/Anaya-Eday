package estructurasDatos;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	private static final String REPE = "repe";

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>(4);
		
		// Inserción
		for (int i = 0; i < 10; i++) {
			lista.add("elem_" + i);
		}
		
		// Repeticiones
		System.out.println("Tamaño de la lista antes de añadir repetidos: " + lista.size());
		lista.add(REPE);
		lista.add(REPE);
		lista.add(3, REPE);
		System.out.println("Tamaño de la lista después de añadir repetidos: " + lista.size());
		System.out.println();

		// Inserción por posición
		lista.add(3, "añadido");
		lista.set(8, "modificado");
		
		// Nulos
		System.out.println("Tamaño de la lista antes de añadir null: " + lista.size());
		lista.add(10, null);
		System.out.println("Tamaño de la lista después de añadir null: " + lista.size());
		
		// Recorrido por posición
		int tamano = lista.size();
		System.out.println("Tamaño de la lista: " + tamano);
		for (int i = 0; i < tamano; i++) {
			System.out.println("Posición " + i + ": " + lista.get(i));
		}
		System.out.println();
	
		System.out.println("Recorrido de la lista");
		for (String string : lista) {
			System.out.println(string);
		}
		System.out.println();
		
		// Comprobaciones
		boolean contiene = lista.contains(REPE);
		int primero = lista.indexOf(REPE);
		int ultimo = lista.lastIndexOf(REPE);
		if (contiene) {
			System.out.println("La lista contiene " + REPE + 
					". Primero: " + primero + ". Último: " + ultimo);
		} else {
			System.out.println("La lista no contiene " + REPE);
		}
		System.out.println();
		
		// Supresión
		System.out.println("*** SUPRESIÓN ***");
		System.out.println("Tamaño original de la lista: " + lista.size());
		for (int i = 0; i < lista.size(); i = i + 3) {
			System.out.print("Suprimimos " + lista.get(i) + " de posición " + i);
			String borrado = lista.remove(i);
			System.out.println(" [" + borrado + "]");
		}
		System.out.println("Nuevo tamaño de la lista: " + lista.size());
	}
}
