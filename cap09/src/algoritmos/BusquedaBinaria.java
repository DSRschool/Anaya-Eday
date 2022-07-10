package algoritmos;

public class BusquedaBinaria {
	public static final int NO_ENCONTRADO = -1;
	
	public static int busquedaBinaria(int[] lista, int elem) {
		return busquedaBinariaAux(lista, elem, 0, lista.length);
	}
	
	private static int busquedaBinariaAux(int[] lista, int elem, int ini, int fin) {
		int centro = Math.floorDiv(fin - ini, 2) + ini;
		int valorCentral = lista[centro];
		if (valorCentral == elem) {
			return centro;
		}
		if (fin - ini <= 1) {
			return NO_ENCONTRADO;
		}
		if (valorCentral < elem) {
			return busquedaBinariaAux(lista, elem, centro, fin);
		}
//		if (valorCentral > elem) {
		return busquedaBinariaAux(lista, elem, ini, centro);
//		}
	}
	
	public static void main(String[] args) {
		int[] test = {1, 3, 5, 7, 9};
		for (int i = 0; i <= 10; i++) {
			int res = busquedaBinaria(test, i);
		    if (res == NO_ENCONTRADO) {
		    	System.out.println("La lista no tiene " + i);
		    } else {
		    	System.out.println(i + " está en la posición " + res);
		    }
		}
	}
}
