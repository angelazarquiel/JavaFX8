package ej03;

import java.util.Random;

public class Dado {
	
	private int caras;
	
	public Dado() {
		caras=6;
	}

	public void setCaras(int caras) {
		this.caras=caras;
	}
	
	public int tirar() {
		Random random = new Random();

		return random.nextInt(caras)+1;
	}

}
