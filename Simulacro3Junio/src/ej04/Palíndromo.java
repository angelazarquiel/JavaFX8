package ej04;

public class Palíndromo {
	public static boolean esPalíndromo(String s, boolean comoFrase) {
		boolean palindromo = true;
		String analizable;
	    
		if (comoFrase) {
			analizable=s.toLowerCase();
			analizable = analizable.replace(" ", "");
			analizable = analizable.replace(".", "");
			analizable = analizable.replace(",", "");
			//	reemplazo con expresión regular
			//	analizable = analizable.replaceAll("[., ]","");
		}
		else
			analizable=s;

		for (int i = 0; i < analizable.length() / 2; i++) {
			if (analizable.charAt(i) != analizable.charAt(analizable.length() - i
					- 1)) {
				palindromo = false;
				break;
			}

		}
	
		return palindromo;
	}
}
