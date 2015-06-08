package ej03;

public class Partido {
	private String local,visitante;
	private char resultado;
	
	public Partido(String local, String visitante) {
		this.local = local;
		this.visitante = visitante;
	}

	public char getResultado() {
		return resultado;
	}

	public void setResultado(char resultado) {
		if (resultado=='x') resultado='X';
		if (resultado=='1' || resultado=='2' || resultado=='X')
			this.resultado = resultado;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public String toString() {
		return String.format("%s-%s\t %c",local,visitante,resultado);
	}

	public String getLocal() {
		return local;
	}

	public String getVisitante() {
		return visitante;
	}
	
	
}
