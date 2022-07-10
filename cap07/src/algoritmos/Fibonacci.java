package algoritmos;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
	public static List<Integer> fib(int lim) {
		List<Integer> serie = new ArrayList<Integer>();
		serie.add(0);
		serie.add(1);
		int i = 2;
		boolean alcanzado = false;
		while (!alcanzado) {
			int aux = serie.get(i-2) + serie.get(i-1);
			alcanzado = aux > lim;
			if (!alcanzado) {
				serie.add(aux);
			}
			i++;
		}
		return serie;
	}
	
	public static void main(String[] args) {
		System.out.println(fib(1000));
	}
}
