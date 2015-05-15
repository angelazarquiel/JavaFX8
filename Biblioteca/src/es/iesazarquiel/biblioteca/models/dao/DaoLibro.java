package es.iesazarquiel.biblioteca.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.biblioteca.models.conexiones.Conexion;
import es.iesazarquiel.biblioteca.models.entidades.Libro;


public class DaoLibro {
	public DaoLibro(){
		
	}
	public void insertaLibro(Libro l)throws SQLException, Exception{
		PreparedStatement st=null;
		Connection con=null;
		try{
            Conexion miconex = new Conexion();
            con = miconex.getConexion();
            String ordenSQL = "INSERT INTO LIBRO VALUES(?,?,?)";
            st=con.prepareStatement(ordenSQL);
            st.setString(1, l.getIsbn());
            st.setString(2,l.getTitulo());
            System.out.println(l.getIdautor());
            if(l.getIdautor()==0)
               st.setNull(3,l.getIdautor());
            else
            	st.setLong(3, l.getIdautor());
            st.execute();
		}
     catch (SQLException se) {
        throw se;
    } catch (Exception e) {
        throw e;
    }
    finally{
     	if(st!=null)
            st.close();
     	if(con!=null)
            con.close();        	
    }  		
	}
	/***************************************************************/
    public ArrayList<Libro> listadoLibros(String titulo,String autor,String isbn) throws SQLException, Exception {
        ArrayList<Libro> listalibros;
        listalibros=new ArrayList<Libro>();
        ResultSet rs;
        PreparedStatement st;
        try {
            Conexion miconex = new Conexion();
            Connection con = miconex.getConexion();
            String ordenSQL="SELECT T.ISBN,TITULO,AUTOR.NOMBRE AUTOR, EJEMPLARESTOTALES, EJEMPLARESENPRESTAMO,(EJEMPLARESTOTALES-EJEMPLARESENPRESTAMO)EJEMPLARESDISPONIBLES"+
                             " FROM LIBRO T,AUTOR,"+
                             "("+
                             " SELECT A.ISBN,EJEMPLARES EJEMPLARESTOTALES,NVL(EJEMPLARESPRESTADOS,0)EJEMPLARESENPRESTAMO"+
                             " FROM"+
                              "(SELECT L.ISBN,COUNT(*)EJEMPLARES"+
                              " FROM LIBRO L,EJEMPLAR E"+
                              " WHERE L.ISBN=E.ISBN"+
                              " GROUP BY L.ISBN)A,"+
                              " (SELECT ISBN,COUNT(*) EJEMPLARESPRESTADOS"+
                              " FROM PRESTAMO P,EJEMPLAR E"+
                              " WHERE P.IDEJEMPLAR=E.IDEJEMPLAR"+
                              " GROUP BY ISBN)B"+
                              " WHERE A.ISBN=B.ISBN(+))A"+
                              " WHERE T.ISBN=A.ISBN"+
                              " AND T.IDAUTOR=AUTOR.IDAUTOR"+
                              " AND TRANSLATE(UPPER(AUTOR.NOMBRE),'�,�,�,�,�','A,E,I,O,U') LIKE TRANSLATE(UPPER(?),'�,�,�,�,�','A,E,I,O,U')"+
                              " AND TRANSLATE(UPPER(T.TITULO),'�,�,�,�,�','A,E,I,O,U') LIKE  TRANSLATE(UPPER(?),'�,�,�,�,�','A,E,I,O,U')"+
                              " AND T.ISBN LIKE ?"+
                              " ORDER BY AUTOR,TITULO";

            System.out.println("El autor es: "+autor);
            System.out.println("El titulo es: "+titulo);
            st=con.prepareStatement(ordenSQL);
            st.setString(1,"%"+autor+"%");
            st.setString(2,"%"+titulo+"%");
            st.setString(3,isbn);
            rs = st.executeQuery();
            System.out.println("Ha pasado sin problemas por los setString");
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIsbn(rs.getString("ISBN"));
                libro.setTitulo(rs.getString("TITULO"));
                libro.setNombreAutor(rs.getString("AUTOR"));
                libro.setEjemplaresTotales(rs.getInt("EJEMPLARESTOTALES"));
                libro.setEjemplaresEnPrestamo(rs.getInt("EJEMPLARESENPRESTAMO"));
                libro.setEjemplaresDisponibles(rs.getInt("EJEMPLARESDISPONIBLES"));
                listalibros.add(libro);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException se) {
            throw se;
        } catch (Exception e) {
            throw e;
        }
        System.out.println(listalibros.size());
        return listalibros;  
    }    
}
