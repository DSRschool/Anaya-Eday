package algoritmos;

public class CifradoCesar {

	private static final int BASE_MAY = (int)'A';
	private static final int BASE_MIN = (int)'a';
	private static final int LONG_ABC = 26;

	public static String cifrar(String texto, int despl) {
		String cifrado = "";
		for (char letra : texto.toCharArray()) {
			cifrado += cifrar(letra, despl);
		}
		return cifrado;
	}
	
	private static char cifrar(char letra, int despl) {
		int base;
		if (Character.isUpperCase(letra)) {
			base = BASE_MAY;
		} else if (Character.isLowerCase(letra)) {
			base = BASE_MIN;
		} else {
			return letra;
		}
		return (char)(((int)letra - base + despl) % LONG_ABC + base);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 27; i++) {
			System.out.println(i + "> " + cifrar("Buenos dias", i));
		}

		System.out.println(cifrar("Buenos dias", 13));
		System.out.println(cifrar(cifrar("Buenos dias", 13), 13));
	}
}