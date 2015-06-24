package ej02;

public class Texto extends Post {
	
	private String texto;
	
	public Texto(String titulo, String autor, String texto) {
		super(titulo, autor);
		this.texto=texto;
	}

	public String getTexto() {
		return texto;
	}

	@Override
	public String toString() {
		return "Texto: " + texto + super.toString();
	}

}
