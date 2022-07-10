package algoritmos;

public class ContadorFibonacci {
	public static int contadorFibonacci(int lim) {
		int penultimo = 0;
		int ultimo = 1;
		int i = 2;
		boolean alcanzado = false;
		while (!alcanzado) {
			int aux = penultimo + ultimo;
			alcanzado = aux > lim;
			if (!alcanzado) {
				penultimo = ultimo;
				ultimo = aux;
				i++;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		System.out.println(contadorFibonacci(1000));
	}
}
