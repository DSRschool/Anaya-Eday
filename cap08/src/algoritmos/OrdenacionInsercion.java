package algoritmos;

import java.util.Arrays;

public class OrdenacionInsercion {
	public static int[] ordenacionInsercion(int[] lista) {
	    for (int i = 0; i < lista.length; i++) {
	        int numI = lista[i];
	        int j = i;
	        while (j > 0 && numI < lista[j-1]) {
	            lista[j] = lista[j-1];
	            j--;
	        }
	        lista[j] = numI;
	    }
	    return lista;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ordenacionInsercion(
				new int[] {6, 3, 7, 5})));
	}
}
