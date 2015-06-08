package ej03;

import java.util.ArrayList;
import java.util.List;

public class Apuesta {
	private List<Partido> partidos;
	
	public Apuesta(List<Partido> partidos) {
		this.partidos=new ArrayList<Partido>();
		for(Partido p:partidos)
			this.partidos.add(new Partido(p.getLocal(),p.getVisitante()));
	}
	
	public void setResultado(int posición, char resultado) {
		partidos.get(posición).setResultado(resultado);
	}
	
	public int getAciertos(Apuesta ganadora) {
		int cuentaAciertos=0;
		
		for(int i=0;i<partidos.size();i++) {
			if (partidos.get(i).getResultado()==
				ganadora.partidos.get(i).getResultado())
				cuentaAciertos++;
		}
		
		return cuentaAciertos;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder todo=new StringBuilder();
		
		for(Partido p:partidos)
			todo.append(p+"\n");
		
		return todo.toString();
	}

	public static void main(String[] args) {
		System.out.println("Prueba");
		
		Apuesta ap;
		Apuesta ganadora;
		
		List<Partido> partidos1=new ArrayList<Partido>();
		partidos1.add(new Partido("Levante","R.Madrid"));
		partidos1.add(new Partido("Murcia","Albacete"));
		
		ap=new Apuesta(partidos1);
		ap.setResultado(0, '2');
		ap.setResultado(1, '2');
		
		ganadora=new Apuesta(partidos1);
		ganadora.setResultado(0, 'X');
		ganadora.setResultado(1, '2');
		
		System.out.println(ap.getAciertos(ganadora));
		
	}
}
