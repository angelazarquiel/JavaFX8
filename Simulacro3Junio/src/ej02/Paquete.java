package ej02;

public class Paquete extends Caja implements Postal {

	private double peso;
	private String direcciónEnvío;
	private double coste;
	private boolean entregado;

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDirecciónEnvío() {
		return direcciónEnvío;
	}

	public void setDirecciónEnvío(String direcciónEnvío) {
		this.direcciónEnvío = direcciónEnvío;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
		if (this.coste < COSTE_MINIMO)
			this.coste = COSTE_MINIMO;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public Paquete(double ancho, double alto, double fondo, double peso) {
		super(ancho, alto, fondo);
		this.peso = peso;
		direcciónEnvío = "Desconocida";
		this.coste = COSTE_MINIMO;
		entregado = false;
	}

	@Override
	public void enviar(String dirección) {
		direcciónEnvío = dirección;
	}

	@Override
	public boolean entregado() {
		return entregado;
	}

	@Override
	public double portes() {
		return coste;
	}

	public static void main(String[] args) {
		Paquete p = new Paquete(20, 10, 20, 2.4);

		p.getVolumen();
		p.enviar("C\\Betanzos 14\nArboleda del Trajal\n14567 Sevilla");
		p.setEntregado(true);
		System.out.println(p);
		System.out.println(p.getDirecciónEnvío());
		System.out.println("Entregado: " + p.entregado());

	}

}