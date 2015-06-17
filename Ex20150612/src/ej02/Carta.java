package ej02;

public class Carta {

	private String nombre;
	private int coste;
	
	public Carta(String nombre, int coste){
		this.nombre=nombre;
		this.coste=coste;
	}

	@Override
	public String toString() {
		return "\"" + nombre + "\" Coste: " + coste;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCoste() {
		return coste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
