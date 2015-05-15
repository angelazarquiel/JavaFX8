package es.iesazarquiel.biblioteca.views.console;

import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.biblioteca.models.dao.DaoSocio;
import es.iesazarquiel.biblioteca.models.entidades.Socio;

public class MainConsola {

	public static void main(String[] args) throws SQLException, Exception {
		DaoSocio daoSocio;
		
		daoSocio=new DaoSocio();
		
		ArrayList<Socio> losSocios;
		
		losSocios=daoSocio.listadoSocios();
		
		System.out.print(losSocios);

	}

}
