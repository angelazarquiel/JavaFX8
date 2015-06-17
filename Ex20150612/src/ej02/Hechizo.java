package ej02;

public class Hechizo extends Carta {

	private String efecto;
	
	public Hechizo(String nombre, int coste, String efecto) {
		super(nombre, coste);
		this.efecto=efecto;
	}

	public String getEfecto() {
		return efecto;
	}

	@Override
	public String toString() {
		return "Hechizo - " + super.toString() + " - " +  efecto;
	}

}
