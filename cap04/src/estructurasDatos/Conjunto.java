package estructurasDatos;

import java.util.HashSet;
import java.util.Set;

public class Conjunto {
	private static final String REPE = "repe";

	public static void main(String[] args) {
		Set<String> conjunto = new HashSet<>(4);
		
		// Inserción
		for (int i = 0; i < 10; i++) {
			conjunto.add("elem_" + i);
		}
		
		// Repeticiones
		System.out.println("Tamaño del conjunto antes de añadir repetidos: " + conjunto.size());
		conjunto.add(REPE);
		conjunto.add(REPE);
		System.out.println("Tamaño del conjunto después de añadir repetidos: " + conjunto.size());
		System.out.println();
		
		// Nulos
		System.out.println("Tamaño del conjunto antes de añadir null: " + conjunto.size());
		conjunto.add(null);
		System.out.println("Tamaño del conjunto después de añadir null: " + conjunto.size());

		// Recorrido
		System.out.println("Recorrido del conjunto");
		for (String string : conjunto) {
			System.out.println("*" + string + "*");
		}
		System.out.println();
		
		// Comprobaciones
		boolean contiene = conjunto.contains(REPE);
		if (contiene) {
			System.out.println("El conjunto contiene " + REPE);
		} else {
			System.out.println("El conjunto no contiene " + REPE);
		}
		System.out.println();

		// Supresión
		System.out.println("Tamaño original del conjunto: " + conjunto.size());
		conjunto.remove(REPE);
		System.out.println("Nuevo tamaño del conjunto: " + conjunto.size());
	}
}
