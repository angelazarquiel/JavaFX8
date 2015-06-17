package ej02;

public class Esbirro extends Carta {

	private int vida;
	private int ataque;
	private String gritoDeBatalla;
	
	public Esbirro(String nombre, int coste, int vida, int ataque) {
		super(nombre, coste);
		this.vida=vida;
		this.ataque=ataque;
		this.gritoDeBatalla=null;
	}
	
	public Esbirro(String nombre, int coste, int vida, int ataque, String gritoDeBatalla) {
		super(nombre, coste);
		this.vida=vida;
		this.ataque=ataque;
		this.gritoDeBatalla=gritoDeBatalla;
	}

	@Override
	public String toString() {
		String str;
		
		str= "Esbirro-" + super.toString()
				+ "-(" + ataque + "," + vida + ")";
		
		if (gritoDeBatalla!=null)
			str +=" - Grito de Batalla: " + this.gritoDeBatalla;
		
		return str;
	}

	public int getAtaque() {
		return ataque;
	}

	public String getGritoDeBatalla() {
		return gritoDeBatalla;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public boolean tieneGritoDeBatalla() {
		return gritoDeBatalla!=null;
	}
	
}
