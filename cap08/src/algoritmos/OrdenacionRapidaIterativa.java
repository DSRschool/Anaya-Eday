package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdenacionRapidaIterativa {
	public static List<Integer> ordenacionRapida(List<Integer> lista) {
		if (lista.size() <= 1)
			return lista;
		else {
			Integer pivote = elegirPivote(lista);

			List<Integer> menores = new ArrayList<Integer>();
			List<Integer> iguales = new ArrayList<Integer>();
			List<Integer> mayores = new ArrayList<Integer>();

			for (Integer n : lista) {
				if (n < pivote) {
					menores.add(n);
				} else if (n > pivote) {
					mayores.add(n);
				} else {
					iguales.add(n);
				}
			}

			menores = ordenacionRapida(menores);
			mayores = ordenacionRapida(mayores);

			menores.addAll(iguales);
			menores.addAll(mayores);
			return menores;
		}
	}

	private static Integer elegirPivote(List<Integer> lista) {
		int pos = (int) (Math.random() * lista.size());
		return lista.get(pos);
	}

	public static void main(String[] args) {
		System.out.println(ordenacionRapida(new ArrayList<Integer>(
				Arrays.asList(3, 8, 2, 5, 7, 4, 6, 1, 9))));
	}
}
