package ej02;

public interface Postal {
	public double COSTE_MINIMO=2.30;
	public void enviar(String dirección);
	public boolean entregado();
	public double portes(); 
}
