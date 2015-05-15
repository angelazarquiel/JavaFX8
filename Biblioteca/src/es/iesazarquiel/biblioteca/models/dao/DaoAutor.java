package es.iesazarquiel.biblioteca.models.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesazarquiel.biblioteca.models.conexiones.Conexion;
import es.iesazarquiel.biblioteca.models.entidades.Autor;

public class DaoAutor {
    public DaoAutor() {
    }
    public ArrayList<Autor> listadoAutores() throws SQLException, Exception {
        ArrayList<Autor> listaautores;
        listaautores=new ArrayList<Autor>();
        Connection con=null;
        ResultSet rs=null;
        Statement st=null;
        try {
            Conexion miconex = new Conexion();
            con = miconex.getConexion();
            st = con.createStatement();
            String ordenSQL = "SELECT * FROM AUTOR ORDER BY NOMBRE";
            rs = st.executeQuery(ordenSQL);
            while (rs.next()) {
                Autor miAutor = new Autor();
                miAutor.setIdAutor(rs.getInt("IDAUTOR"));
                miAutor.setNombre(rs.getString("NOMBRE"));
                miAutor.setFechaNacimiento(rs.getDate("FECHANACIMIENTO"));
                listaautores.add(miAutor);
            }
        } catch (SQLException se) {
            throw se;
        } catch (Exception e) {
            throw e;
        }
        finally{
        	if(rs!=null)
                rs.close();
         	if(st!=null)
                st.close();
         	if(con!=null)
                con.close();  
        }
        return listaautores;  
    }
/************************************************************************************/
    public void insertaAutor(Autor a) throws SQLException, Exception {
        Connection con=null;
        PreparedStatement st=null;
        try {
            Conexion miconex = new Conexion();
            con = miconex.getConexion();
            Date fecha=new Date(a.getFechaNacimiento().getTime());
            String ordenSQL = "INSERT INTO AUTOR VALUES(S_AUTOR.NEXTVAL,?,?)";
            st = con.prepareStatement(ordenSQL);
            st.setString(1, a.getNombre());
            st.setDate(2,fecha);
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException se) {
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

}