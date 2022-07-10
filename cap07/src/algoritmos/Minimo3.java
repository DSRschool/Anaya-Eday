package algoritmos;

public class Minimo3 {
	public static int minimo3(int a, int b, int c) {
		int min2;
		int min3;
		if (a < b) {
			min2 = a;
		} else {
			min2 = b;
		}
		if (min2 < c) {
			min3 = min2;
		} else {
			min3 = c;
		}
		return min3;
	}
	
	public static void main(String[] args) {
		System.out.println(minimo3(7, 4, 1));
	}
}
