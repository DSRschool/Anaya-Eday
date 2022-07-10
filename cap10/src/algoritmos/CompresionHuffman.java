package algoritmos;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class CompresionHuffman {
	
	private static final Character FIN = Character.MIN_VALUE;
	
	private Map<Character, Float> frecuencias = new HashMap<>();
	private PriorityQueue<Nodo> cola = new PriorityQueue<>();
	private Nodo arbol;
	private Map<Character, String> diccionarioCompresion = new HashMap<>();
	private Map<String, Character> diccionarioDescompresion = new HashMap<>();
	
	public CompresionHuffman(String textoFrecuencias) {
		frecuencias(textoFrecuencias);
		cola();
		arbol();
		diccionario(arbol);
	}

	private void frecuencias(String textoFrecuencias) {
		float total = textoFrecuencias.length() + 1;
		Map<Character, Integer> contador = new HashMap<>();
		for (char c : textoFrecuencias.toCharArray()) {
			int cont = 0;
			if (contador.containsKey(c)) {
				cont = contador.get(c);
			}
			contador.put(c, ++cont);
		}
		for (Entry<Character, Integer> e : contador.entrySet()) {
			frecuencias.put(e.getKey(), e.getValue()/total);
		}
		frecuencias.put(FIN, 1/total);
	}
	
	private void cola() {
		for (Entry<Character, Float> e : frecuencias.entrySet()) {
			Nodo n = new Nodo(e.getKey(), e.getValue());
			cola.add(n);
		}
	}
	
	private void arbol() {
		while (cola.size() > 1) {
			Nodo nodo1 = cola.poll();
			Nodo nodo2 = cola.poll();
			Nodo nuevoNodo = new Nodo(nodo1.getProbabilidad() 
					+ nodo2.getProbabilidad(), nodo1, nodo2);
			cola.add(nuevoNodo);
		}
		arbol = cola.poll();
	}
	
	private void diccionario(Nodo nodo) {
		if (nodo.getSimbolo() != null) {
			diccionarioCompresion.put(nodo.getSimbolo(), nodo.getCodigo());
			diccionarioDescompresion.put(nodo.getCodigo(), nodo.getSimbolo());
		} else {
			diccionario(nodo.getDerecho());
			diccionario(nodo.getIzquierdo());
		}
	}
	 
	public BigInteger comprimir(String texto) {
		String s = "1"; // que empiece por 1 para no perder ceros a la izquierda
		for (Character c : texto.toCharArray()) {
			s += diccionarioCompresion.get(c);
		}
		s += diccionarioCompresion.get(FIN);
		while (s.length() % 8 != 0) {
			s += "0";
		}
		return new BigInteger(s, 2);
	}
	
	public String descomprimir(BigInteger binario) {
		String comprimido = binario.toString(2);
		String s = "";
		boolean hecho = false;
		int i = 1; // ignoramos el primer uno
		while (i < comprimido.length() && !hecho) {
			String codigo = comprimido.charAt(i) + "";
			while (!diccionarioDescompresion.containsKey(codigo)) {
				codigo += comprimido.charAt(++i);
			}
			Character letra = diccionarioDescompresion.get(codigo);
			if (letra.equals(FIN)) {
				hecho = true;
			} else {
				s += letra;
				i++;
			}
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		CompresionHuffman ch = new CompresionHuffman("ana anda y canta lalala.");
		BigInteger comprimido = ch.comprimir("ana anda y canta lalala.");
		System.out.println(comprimido);
		System.out.println(comprimido.toString(2));
		System.out.println(ch.descomprimir(comprimido));
		BigInteger comprimido2 = ch.comprimir("anda lana y cantala ya.");
		System.out.println(comprimido2);
		System.out.println(comprimido2.toString(2));
		System.out.println(ch.descomprimir(comprimido2));
	}
}

class Nodo implements Comparable<Nodo>{
	private Character simbolo;
	private Float prob;
	private Nodo izquierdo;
	private Nodo derecho;
	private Nodo padre;
	private boolean codigo;
	

	public Nodo(Character simbolo, Float prob) {
		this.simbolo = simbolo;
		this.prob = prob;
	}

	public Nodo(Float prob, Nodo izquierdo, Nodo derecho) {
		this.prob = prob;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
		izquierdo.setPadre(this, true);
		derecho.setPadre(this, false);
	}
	
	public void setPadre(Nodo padre, boolean b) {
		this.padre = padre;
		this.codigo = b;
	}
	
	public Character getSimbolo() {
		return simbolo;
	}

	public String getCodigo() {
		return (padre != null ? padre.getCodigo() : "") + (codigo ? "1" : "0");
	}
	
	public Float getProbabilidad() {
		return prob;
	}
	
	public Nodo getIzquierdo() {
		return izquierdo;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	@Override
	public int compareTo(Nodo o) {
		if (o == null) {
			throw new IllegalStateException(); 
		}
		return this.prob.compareTo(o.prob);
	}
	
	@Override
	public String toString() {
		return simbolo + ": " + prob + " - " + getCodigo();
	}
	
}