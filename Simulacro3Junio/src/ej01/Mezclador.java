package ej01;

import java.util.Scanner;

public class Mezclador {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce la primera frase:");
		String str1 = scanner.nextLine();
		System.out.println("Introduce la segunda frase:");
		String str2 = scanner.nextLine();
		System.out.println(mix(str1, str2));
	}

	public static String mix(String s1, String s2) {

		int minLength = s1.length() > s2.length() ? s2.length() : s1.length();
		int i = 0, fincadena;
		StringBuilder resultado = new StringBuilder();

		for (i = 0; i < minLength; i += 2) {
			fincadena = i + 2 > s1.length() ? s1.length() : i + 2;
			resultado.append(s1.substring(i, fincadena));
			fincadena = i + 2 > s2.length() ? s2.length() : i + 2;
			resultado.append(s2.substring(i, fincadena));
		}

		if (s1.length() > i)
			resultado.append(s1.substring(i));
		if (s2.length() > i)
			resultado.append(s2.substring(i));

		return resultado.toString();
	}
}