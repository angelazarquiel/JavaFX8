package ej01;

import java.util.Arrays;

public class Patrones {

	public static int buscarPatron(int[] array,int[] patron) {
		int encontrados=0;
		
		for(int i=0;i<(array.length-patron.length+1);i++) {
			int coinciden=0;
			for(int j=0;j<patron.length;j++) {
				if (array[i+j]==patron[j])
					coinciden++;
				else
					break;
			}
			if (coinciden==patron.length)
				encontrados++;
		}
		
		return encontrados;
	}

	public static void main(String[] args) {
		int[] prueba1={2,5,1,1},
			  patron1={1,1},
			  prueba2={0,1,2,3,4,0,0,0},
			  patron2={0,0},
			  patron3={2,5,1,1,0};
		
		System.out.println(Arrays.toString(prueba1));
		System.out.println(buscarPatron(prueba1,patron1));
		System.out.println(buscarPatron(prueba1,patron2));
		System.out.println(buscarPatron(prueba1,patron3));
		System.out.println(Arrays.toString(prueba2));
		System.out.println(buscarPatron(prueba2,patron1));
		System.out.println(buscarPatron(prueba2,patron2));
	}
}
