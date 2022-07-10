package estructurasDatos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Mapa {
	private static final String REPE = "repe";

	public static void main(String[] args) {
		Map<String, String> mapa = new HashMap<>(4);
		
		// Inserción
		for (int i = 0; i < 5; i++) {
			mapa.put("A" + i, "valor_a" + i);
			mapa.put(i + "B", "valor_b" + i); // A2 colisiona con 1B
		}
		mapa.put("amigo", "valor_amigo");
		mapa.put("arte", "valor_arte");
		
		// Repeticiones
		System.out.println("Tamaño del mapa antes de añadir repetidos: " + mapa.size());
		mapa.put(REPE, REPE);
		mapa.put(REPE, REPE + "2");
		System.out.println("Tamaño del mapa después de añadir repetidos: " + mapa.size());
		System.out.println(mapa.get(REPE));
		System.out.println();

		// Recorridos
		System.out.println("Recorrido de claves:");
		Set<String> claves = mapa.keySet();
		for (String clave : claves) {
			System.out.println(clave);
		}
		System.out.println();

		System.out.println("Recorrido de valores:");
		Collection<String> valores = mapa.values();
		for (String valor : valores) {
			System.out.println(valor);
		}
		System.out.println();

		System.out.println("Recorrido de entradas:");
		Set<Entry<String, String>> entradas = mapa.entrySet();
		for (Entry<String, String> entrada : entradas) {
			System.out.println(entrada.getKey() + ": " + entrada.getValue());
		}
		System.out.println();

		// Comprobaciones
		boolean contieneClave = mapa.containsKey(REPE);
		if (contieneClave) {
			System.out.println("El mapa contiene la clave " + REPE);
		} else {
			System.out.println("El mapa no contiene la clave " + REPE);
		}
		
		boolean contieneValor = mapa.containsValue(REPE);
		if (contieneValor) {
			System.out.println("El mapa contiene el valor " + REPE);
		} else {
			System.out.println("El mapa no contiene el valor " + REPE);
		}
		System.out.println();
		
		// Recuperaciones
		String a1 = mapa.get("A1");
		System.out.println("La clave A1 contiene " + a1);

		String b2 = mapa.get("2B");
		System.out.println("La clave 2B contiene " + b2);
		System.out.println();
		
		// Supresiones
		System.out.println("Tamaño del mapa antes de borrar 1B: " + mapa.size());
		System.out.println("Borrando 1B");
		String borrado = mapa.remove("1B");
		System.out.println(borrado + " borrado");
		System.out.println("Tamaño del mapa después de borrar 1B: " + mapa.size());
	}
}
