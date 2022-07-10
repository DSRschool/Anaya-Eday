package algoritmos;

import java.util.Arrays;

public class OrdenacionMezcla {
	
	public static int[] ordenacionMezcla(int[] lista) {
		if (lista.length <= 1) {
			return lista;
		}
		int centro = lista.length / 2;
		int[] izquierda = Arrays.copyOfRange(lista, 0, centro);
		int[] derecha = Arrays.copyOfRange(lista, centro, lista.length);
		izquierda = ordenacionMezcla(izquierda);
		derecha = ordenacionMezcla(derecha);
		return mezcla(izquierda, derecha);
	}

	private static int[] mezcla(int[] izquierda, int[] derecha) {
		int indexIz = 0;
		int indexDr = 0;
		int indexSol = 0;
		int[] sol = new int[izquierda.length + derecha.length]; 
		while (indexIz < izquierda.length && indexDr < derecha.length) {
			// el siguiente elemento será el más pequeño de cada mitad
			if (izquierda[indexIz] < derecha[indexDr]) {
				sol[indexSol++] = izquierda[indexIz++];
			} else {
				sol[indexSol++] = derecha[indexDr++];
			}
		}
		// copiamos los elementos que faltan de cada cadena
		while (indexIz < izquierda.length) {
			sol[indexSol++] = izquierda[indexIz++];			
		}
		while (indexDr < derecha.length) {
			sol[indexSol++] = derecha[indexDr++];
		}
		return sol;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ordenacionMezcla(
				new int[] { 7, 5, 4, 1, 9, 8, 2, 3 })));
	}
}
