package estructurasDatos;

import java.util.SortedSet;
import java.util.TreeSet;

public class Arbol {
	public static void main(String[] args) {
		SortedSet<Integer> arbol = new TreeSet<>();
		arbol.add(3);
		System.out.println(arbol);
		arbol.add(9);
		System.out.println(arbol);
		arbol.add(2);
		System.out.println(arbol);
		arbol.add(7);
		System.out.println(arbol);
		arbol.add(4);
		System.out.println(arbol);
		arbol.add(1);
		System.out.println(arbol);
		arbol.add(5);
		System.out.println(arbol);
		System.out.println();
		
		Integer primero = arbol.first();
		Integer ultimo = arbol.last();
		System.out.println("Primero: " + primero + ". Último: " + ultimo);
		
		SortedSet<Integer> cabecera3 = arbol.headSet(3);
		System.out.println("Cabecera de 3: " + cabecera3);
		
		SortedSet<Integer> cola3 = arbol.tailSet(3);
		System.out.println("Cola de 3: " + cola3);
		
		SortedSet<Integer> de3a7 = arbol.subSet(3, 7);
		System.out.println("Subconjunto de 3 a 7: " + de3a7);
		System.out.println();
		
		arbol.remove(3);
		System.out.println(arbol);
	}
}
