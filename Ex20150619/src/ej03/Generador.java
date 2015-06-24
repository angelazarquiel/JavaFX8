package ej03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.beans.property.SimpleStringProperty;

public class Generador {
	
	private SimpleStringProperty letras;
	private ArrayList<String> cache;
	private ArrayList<Boolean> resultado;
	
	public Generador() {
		letras=new SimpleStringProperty();
		cache=new ArrayList<String>();
		resultado=new ArrayList<Boolean>();
	}

	public String getLetras() {
		return letras.toString();
	}
	
	public void generar() {
		char [] posibles={'a','b','c','d','e',
				'f','g','h','i','j',
				'k','l','m','n','ñ',
				'o','p','q','r','s',
				't','u','v','w','x',
				'y','z'};
		StringBuilder res=new StringBuilder();
		Random random = new Random();
		
		while (res.length()<9) 
			res.append(posibles[random.nextInt(posibles.length)]);
		this.letras.set(res.toString().toUpperCase());
		
		cache.clear();
		resultado.clear();
	}

	public SimpleStringProperty getProperty() {
		
		return this.letras;
	}

	public boolean comprobar(String s) {
		int i=cache.indexOf(s);
		if (i>=0)
			return resultado.get(i);
		
		cache.add(s);
		List<Character> letras=new ArrayList<Character>();
		s=s.toUpperCase();
		for(Character c:this.letras.toString().toCharArray())
			letras.add(c);
	
		for(i=0;i<s.length();i++) {
			if (letras.contains(s.charAt(i)))
				letras.remove((Character)s.charAt(i));
			else {
				resultado.add(false);
				return false;
			}
		}
		
		resultado.add(true);
		return true;
	}

}
