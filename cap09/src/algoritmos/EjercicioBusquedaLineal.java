package algoritmos;

public class EjercicioBusquedaLineal {

	private static boolean busquedaLineal(char[] lista, char elemento) {
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == elemento) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(busquedaLineal("pelota".toCharArray(), 'i'));
	}
}
