package ej02;

public class PruebaJuego {
	public static void main(String[] args) {
		Mano mano1 = new Mano(), mano2 = new Mano();
		Tablero tablero = new Tablero();

		mano1.añadirCarta(new Esbirro("Minibot", 2, 2, 2));
		mano1.añadirCarta(new Esbirro("Caballero de Sangre", 3, 3, 3,
				"Pierden escudo divino"));
		mano1.añadirCarta(new Hechizo("Preparación para la batalla", 3,
				"Arma más tres reclutas"));

		mano2.añadirCarta(new Hechizo("Disparo presuroso", 2,
				"Inflinge 3 p. de daño"));
		mano2.añadirCarta(new Esbirro("Científico loco", 2, 2, 2));
		mano2.añadirCarta(new Esbirro("Gnomo paria", 1, 2, 1));

		
		tablero.sacaEsbirro((Esbirro) mano1.sacarCarta(0));
		System.out.println(tablero);
		tablero.avanzaTurno();

		
		tablero.sacaEsbirro((Esbirro) mano2.sacarCarta(1));
		System.out.println(tablero);
		tablero.avanzaTurno();
		
		tablero.atacar(0, 0);
		tablero.sacaEsbirro((Esbirro) mano1.sacarCarta(0));
		System.out.println(tablero);
		tablero.avanzaTurno();

	}

}
