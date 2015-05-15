package es.iesazarquiel.biblioteca.models.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesazarquiel.biblioteca.models.conexiones.Conexion;
import es.iesazarquiel.biblioteca.models.entidades.Socio;

public class DaoSocio {

	public DaoSocio() {
	}

	public ArrayList<Socio> listadoSocios() throws SQLException, Exception {
		ArrayList<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT * FROM SOCIO ORDER BY NOMBRE";
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setId(rs.getLong("IDSOCIO"));
				//miSocio.setEmail(rs.getString("EMAIL"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				miSocio.setDireccion(rs.getString("DIRECCION"));
				//miSocio.setClave(rs.getString("CLAVE"));
				listasocios.add(miSocio);
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		System.out.println("El listado de socios se devuelve");
		return listasocios;
	}

	/****************************************************************************************/
	public ArrayList<Socio> listadoSocios(String criteriobusqueda)
			throws SQLException, Exception {

		// Problemas con inyeccion SQL maligno.
		// Probar esto en cuadro busqueda: %' AND DIRECCION LIKE 'T
		ArrayList<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT * FROM SOCIO WHERE " + criteriobusqueda
					+ " ORDER BY NOMBRE";
			System.out.println("La orden lanzada es: " + ordenSQL);
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setId(rs.getLong("IDSOCIO"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				miSocio.setDireccion(rs.getString("DIRECCION"));
				//miSocio.setEmail(rs.getString("EMAIL"));
				//miSocio.setClave(rs.getString("CLAVE"));
				listasocios.add(miSocio);
			}

		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();

		}
		return listasocios;
	}

	/**************************************************************/
	public Socio findSocioById(long idsocio) throws SQLException, Exception {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Socio socio = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "SELECT * FROM SOCIO WHERE idsocio=?";
			st = con.prepareStatement(ordenSQL);
			st.setLong(1, idsocio);
			rs = st.executeQuery();
			if (rs.next()) {
				socio = new Socio();
				socio.setId(rs.getLong("IDSOCIO"));
				socio.setNombre(rs.getString("NOMBRE"));
				socio.setDireccion(rs.getString("DIRECCION"));
				//socio.setEmail(rs.getString("EMAIL"));
				//socio.setClave(rs.getString("CLAVE"));
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();

		}
		return socio;

}
	
/***********************************************************************/
	public ArrayList<Socio> listadoSociosByNombre(String nombre)
			throws SQLException, Exception {

		ArrayList<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "SELECT * FROM SOCIO WHERE UPPER(NOMBRE) LIKE UPPER(?)";
			st = con.prepareStatement(ordenSQL);
			System.out.println("Paramtero nombre: " + nombre);
			System.out.println("La orden lanzada es: " + ordenSQL);
			st.setString(1, "%" + nombre + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setId(rs.getLong("IDSOCIO"));
				//miSocio.setEmail(rs.getString("EMAIL"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				miSocio.setDireccion(rs.getString("DIRECCION"));
				//miSocio.setClave(rs.getString("CLAVE"));
				listasocios.add(miSocio);
			}

		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();

		}
		System.out.println(listasocios.isEmpty());
		return listasocios;
	}

	/****************************************************************************************************/
	public ArrayList<Socio> listadoSocios(int pagina, int numregpag)
			throws SQLException, Exception {

		ArrayList<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSql = "SELECT IDSOCIO,NOMBRE,DIRECCION "
					+ "FROM( SELECT ROWNUM FILA ,IDSOCIO,NOMBRE,DIRECCION "
					+ "FROM( SELECT IDSOCIO,NOMBRE,DIRECCION " + "FROM SOCIO "
					+ "ORDER BY NOMBRE" + ")" + ")"
					+ " WHERE FILA >=? AND FILA<=?";
			System.out.println("La orden lanzada es: " + ordenSql);
			st = con.prepareStatement(ordenSql);
			st.setInt(1, (pagina * numregpag) + 1);
			st.setInt(2, (pagina * numregpag) + numregpag);
			rs = st.executeQuery();
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setId(rs.getLong("IDSOCIO"));
				//miSocio.setEmail(rs.getString("EMAIL"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				miSocio.setDireccion(rs.getString("DIRECCION"));
				listasocios.add(miSocio);
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();

		}
		return listasocios;
	}

	/****************************************************************************************************/
	public int getTotalRegistros() throws SQLException, Exception {
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		int numeroRegistros = 0;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT COUNT(*) NUMEROREGISTROS FROM SOCIO";
			rs = st.executeQuery(ordenSQL);
			rs.next();
			numeroRegistros = rs.getInt("NUMEROREGISTROS");
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();

		}
		return numeroRegistros;
	}

	/***************************************************************************************************/
	public int updateSocio(Socio s) throws SQLException, Exception {
		int socioactualizado = 0;
		Connection con = null;
		PreparedStatement sentencia = null;
		PreparedStatement ordenselect = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			con.setAutoCommit(false);
			String ordenSQL = "UPDATE SOCIO SET NOMBRE=?,DIRECCION=? WHERE IDSOCIO=?";
			sentencia = con.prepareStatement(ordenSQL);
			sentencia.setString(1, s.getNombre());
			sentencia.setString(2, s.getDireccion());
			sentencia.setLong(3, s.getId());
			socioactualizado = sentencia.executeUpdate();
		    con.commit();
			sentencia.close();
			con.close();
		} catch (SQLException se) {
			// System.out.println(se.getMessage());
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("se hace el finally");
			if (sentencia != null)
				sentencia.close();
			if (ordenselect != null)
				ordenselect.close();
			if (con != null)
				con.close();
		}
		return socioactualizado;
	}

	/* ********************************************************************** */
	public void insertarSocio(Socio s) throws SQLException, Exception {
		Connection con = null;
		PreparedStatement st = null;
		String ordenSQL = null;
		try {
			Conexion miconex = new Conexion();
			ResultSet rs = null;
			con = miconex.getConexion();
			con.setAutoCommit(false);
			ordenSQL = "SELECT S_SOCIO.NEXTVAL FROM DUAL";
			st = con.prepareStatement(ordenSQL);
			rs = st.executeQuery(ordenSQL);
			rs.next();
			int IdSocio=rs.getInt(1);
			st.close();
			
			ordenSQL = "INSERT INTO SOCIO VALUES(?,?,?)";
			st = con.prepareStatement(ordenSQL);
			st.setInt(1, IdSocio);
			st.setString(2, s.getNombre());
			st.setString(3, s.getDireccion());
			st.executeUpdate();
			st.close();
			con.commit();
			con.close();
			s.setId(IdSocio);
		} catch (SQLException se) {
			con.rollback();
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
	}
	
	public int borrarSocio(Socio s)throws SQLException,Exception{
	       String ordenSQL;
	       int resultado;
	       Connection con=null;
	       PreparedStatement sentencia=null;
	       try{
	            Conexion miconex=new Conexion();
	            con=miconex.getConexion();
	            ordenSQL="DELETE FROM SOCIO WHERE IDSOCIO=?";
	            System.out.println("La ORDEN DE BORRADO ES: "+ordenSQL);
	            sentencia=con.prepareStatement(ordenSQL);
	            sentencia.setInt(1,(int) s.getId());
	            resultado=sentencia.executeUpdate();
	            sentencia.close();
	            con.close();  
	       }catch(SQLException se){
	               throw se;
	       }catch(Exception e){
	       throw e;
	       }
	       finally{
	       	if(sentencia!=null)
	       		sentencia.close();
	       	if(con!=null)
	              con.close();
	       }       
	       return resultado;
	    }
}