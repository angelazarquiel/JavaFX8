package es.iesazarquiel.biblioteca.models.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.biblioteca.models.conexiones.Conexion;
import es.iesazarquiel.biblioteca.models.entidades.Ejemplar;


public class DaoEjemplar {
	public DaoEjemplar() {

	}
	public ArrayList<Ejemplar>listadoEjemplares(String isbn)throws SQLException, Exception{
		ArrayList<Ejemplar>listaejemplares=new ArrayList<Ejemplar>();
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=null;
		try{
			Conexion miconex=new Conexion();
			con=miconex.getConexion();
			String ordenSql="SELECT IDEJEMPLAR,E.ISBN,L.TITULO"+
                            " FROM EJEMPLAR E, LIBRO L"+
                            " WHERE E.ISBN=L.ISBN"+
                            " AND L.ISBN=?"+
                            " AND IDEJEMPLAR NOT IN"+
                            "(SELECT IDEJEMPLAR FROM PRESTAMO)";
			System.out.println("Parametro isbn= "+isbn);
			System. out.println("Orden lanzada: " +ordenSql);
		    ps=con.prepareStatement(ordenSql);
		    ps.setString(1,isbn);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Ejemplar ejemplar=new Ejemplar();
		    	ejemplar.setIdejemplar(rs.getInt("IDEJEMPLAR"));
		    	ejemplar.setIsbn(rs.getString("ISBN"));
		    	ejemplar.setTitulo(rs.getString("TITULO"));
		    	listaejemplares.add(ejemplar);  	
		    } 
		    
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
		throw e;
		}
		finally{
			rs.close();
			ps.close();
			con.close();
     	}
	 return listaejemplares;
	}
/****************************************************************************************/
/* Borrado que no incluye el borrado de la tabla devolucion                             */ 	
/* Dara error si hay devoluciones de ese ejemplar                                       */
/* Nosotros queremos que no se pierdan las devoluciones, para ello habr�a que a�adir    */
/* Un atributo nuevo a ejemplar como por ejemplo estado('BAJA','NUEVO','DETERIORADO'... */
/* Para practicar la llamada a procedimientos almacenados llamaremos al    procedimiento */
/* BORRAREJEMPLAR que hemos realizado en PL/SQL y que elimina las filas de la tabla      */
/****************************************************************************************/
/* 
    public int borrarejemplar(Integer ejemplar) throws SQLException,Exception{
        int borrado=0;
    try{
         Conexion miconex=new Conexion();
         Connection con=miconex.getConexion();
         String ordenSQL="DELETE FROM EJEMPLAR WHERE IDEJEMPLAR=?";
         PreparedStatement sentencia=con.prepareStatement(ordenSQL);
         sentencia.setInt(1,ejemplar);
         borrado=sentencia.executeUpdate();
         System.out.println("Se han borrado: "+ borrado+ " ejemplares");
         sentencia.close();    
         con.close();
       }catch(SQLException se){
                 throw se;
       }catch(Exception e){
         throw e;
       }
        return borrado;
    }
    */	
/******************************************************************************************/	
    public int borrarejemplar(Integer ejemplar) throws SQLException,Exception{
        int borrado=0;
    try{
         Conexion miconex=new Conexion();
         Connection con=miconex.getConexion();
         CallableStatement sentencia=con.prepareCall("BEGIN BORRAREJEMPLAR(?);END;");
         sentencia.setInt(1,ejemplar);
         borrado=sentencia.executeUpdate();
         System.out.println("Se han borrado: "+ borrado+ " ejemplares");
         sentencia.close();    
         con.close();
       }catch(SQLException se){
                 throw se;
       }catch(Exception e){
         throw e;
       }
        return borrado;
    }
 }

