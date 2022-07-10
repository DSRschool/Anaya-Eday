package algoritmos;

import java.util.ArrayList;
import java.util.List;

public class BusquedaBoyerMoore {
	private static final int NUM_CHARS = 256;

	public static int[] tablaUltimaPosicion(String patron) {
		int[] ultPos;
		ultPos = new int[NUM_CHARS];
		for (int c = 0; c < NUM_CHARS; c++) {
			ultPos[c] = -1;
		}
		for (int j = 0; j < patron.length(); j++) {
			ultPos[patron.charAt(j)] = j;
		}
		return ultPos;
	}

	public static List<Integer> buscar(String texto, String buscado) {
		List<Integer> sol = new ArrayList<>();
		int longTexto = texto.length();
		int longBusc = buscado.length();
		int[] ultPos = tablaUltimaPosicion(buscado);

		int i = 0;
		while (i <= longTexto - longBusc) {
			int j = longBusc - 1;
			while (j >= 0 && buscado.charAt(j) == texto.charAt(i + j)) {
				j--;
			}
			if (j < 0) {
				sol.add(i);
				if (i + longBusc < longTexto) {
					i += longBusc - ultPos[texto.charAt(i + longBusc)];
				} else {
					i++;
				}
			} else {
				if (j - ultPos[texto.charAt(i + j)] > 1) {
					i += j - ultPos[texto.charAt(i + j)];
				} else {
					i++;
				}
			}
		}
		return sol;
	}

	public static void main(String[] args) {
		System.out.println(buscar("abracadabra", "bra"));
	}
}
