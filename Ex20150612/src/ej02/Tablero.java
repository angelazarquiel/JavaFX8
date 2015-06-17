package ej02;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

	private List<Esbirro> jugador1,jugador2;
	private int turno;
	
	public Tablero() {
		jugador1=new ArrayList<Esbirro>();
		jugador2=new ArrayList<Esbirro>();
		turno = (int)(Math.random()*2+1);
	}
	
	public int getTurno() {
		return turno;
	}
	
	public void avanzaTurno() {
		turno = (turno==2?1:2);
	}
	
	public void sacaEsbirro(Esbirro a) {
		if (turno==1)
			jugador1.add(a);
		else
			jugador2.add(a);
	}
	
	public void atacar(int esbirro1, int esbirro2) {
		if (turno==1) {
			Esbirro e1,e2;
			e1=jugador1.get(esbirro1);
			e2=jugador2.get(esbirro2);
			
			e1.setVida(e1.getVida()-e2.getAtaque());
			e2.setVida(e2.getVida()-e1.getAtaque());
			
			if (e1.getVida()<=0) jugador1.remove(esbirro1);
			if (e2.getVida()<=0) jugador2.remove(esbirro2);
		} else {
			Esbirro e1,e2;
			e1=jugador2.get(esbirro1);
			e2=jugador1.get(esbirro2);
			
			e1.setVida(e1.getVida()-e2.getAtaque());
			e2.setVida(e2.getVida()-e1.getAtaque());
			
			if (e1.getVida()<=0) jugador2.remove(esbirro1);
			if (e2.getVida()<=0) jugador1.remove(esbirro2);
		}
	}

	@Override
	public String toString() {
		return "Tablero [jugador1=" + jugador1 + ", jugador2=" + jugador2
				+ ", turno=" + turno + "]";
	}
}
