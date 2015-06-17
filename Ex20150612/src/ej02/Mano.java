package ej02;

import java.util.ArrayList;
import java.util.List;

public class Mano {
	private List<Carta> cartas;
	
	public Mano() {
		cartas=new ArrayList<Carta>();
	}
	
	public void añadirCarta(Carta c) {
		cartas.add(c);
	}
	
	public void sacarCarta(Carta c) {
		cartas.remove(c);
	}
	
	public Carta sacarCarta(int i) {
		try {
			return cartas.remove(i);
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("No se pudo borrar porque no existe ese indice");
		}
		
		return null;
	}
}
