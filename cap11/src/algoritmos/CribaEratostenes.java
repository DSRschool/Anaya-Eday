package algoritmos;

import java.util.ArrayList;
import java.util.List;

public class CribaEratostenes {

	public static List<Integer> cribaEratostenes(int limite) {
		List<Integer> primos = new ArrayList<>();
		boolean[] tachados = new boolean[limite + 1];
		tachados[0] = true;
		tachados[1] = true;
		for (int i = 2; i * i < limite; i++) {
//			System.out.println("primo " + i);
			if (!tachados[i]) {
				for (int j = i * 2; j <= limite; j += i) {
//					System.out.println("tachamos " + j);
					tachados[j] = true;
				}
			}
		}
		for (int i = 0; i < tachados.length; i++) {
			if (!tachados[i]) {
				primos.add(i);
			}
		}
		return primos;
	}

	public static void main(String[] args) {
		System.out.println(cribaEratostenes(100));
		List<Integer> primos = cribaEratostenes(100000000);
		System.out.println("Hay " + primos.size());
	}
}
