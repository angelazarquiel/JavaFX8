package ej01;

public class Permutador {

	public static String permutar(String s) {
		StringBuilder resultado = new StringBuilder(s);

		// quitamos puntuaciones
		for(int i=0;i<resultado.length();i++)
			if (!Character.isLetter(resultado.charAt(i)))
				resultado.deleteCharAt(i--);
		// rotamos
		resultado.reverse();
		// volvemos a poner puntuaciones
		for(int i=0;i<s.length();i++)
			if (!Character.isLetter(s.charAt(i)))
				resultado.insert(i,s.charAt(i));
		
		return resultado.toString();
	}
	
	public static String permutar2(String s) {
		StringBuilder resultado = new StringBuilder(s);
		int i=0,j=resultado.length()-1;
	
		//rotamos "manualmente" intercambiando caracter en i por j
		// hasta que se crucen
		while(i<=j) {
			// mientras no sean letras pasamos
			while(!Character.isLetter(resultado.charAt(i)) && i<resultado.length()) {
				i++;
			}
			while(!Character.isLetter(resultado.charAt(j)) && j>0) {
				j--;
			}
			
			//intercambio
			if(i<=j) {
				char c;
				c=resultado.charAt(i);
				resultado.setCharAt(i, resultado.charAt(j));
				resultado.setCharAt(j, c);
			}
			i++;j--;
		}
		
		return resultado.toString();
	}

	public static void main(String[] args) {
		System.out.println("Hola Mundo");
		System.out.println(permutar("Hola Mundo"));
		System.out.println(permutar2("Hola Mundo"));
		System.out.println("Java, o no Java, decidete.");
		System.out.println(permutar("Java, o no Java, decidete."));
		System.out.println(permutar2("Java, o no Java, decidete."));
		System.out.println("Otro ejemplo");
		System.out.println(permutar("Otro ejemplo"));
		System.out.println(permutar2("Otro ejemplo"));
	}
}
