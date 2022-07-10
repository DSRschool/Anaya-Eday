package algoritmos;

import java.util.Arrays;

public class OrdenacionBurbuja {
	public static int[] ordenacionBurbuja(int[] lista) {
	    for (int i = 1; i < lista.length; i++) {
	    	for (int j = 0; j < lista.length - i; j++) {
	    		if (lista[j] > lista[j+1]) {
	    			int aux = lista[j];
	    			lista[j] = lista[j+1];
	    			lista[j+1] = aux;
	    		}
	    	}
	    }
	    return lista;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ordenacionBurbuja(
				new int[] {5, 3, 8, 4, 2})));
	}
}
