package ej02;

public class Caja {
	private double ancho, alto, fondo;

	public Caja(double ancho, double alto, double fondo) {
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getFondo() {
		return fondo;
	}

	public void setFondo(double fondo) {
		this.fondo = fondo;
	}

	public double getVolumen() {
		return (ancho * fondo * alto) / 1000; // litros
	}

	@Override
	public String toString() {
		return "Caja [ancho=" + ancho + ", alto=" + alto + ", fondo=" + fondo
				+ "]";
	}

	public static void main(String[] args) {
		Caja c = new Caja(20, 40, 40);

		System.out.println(c);
		System.out.println(c.getVolumen());
	}

}