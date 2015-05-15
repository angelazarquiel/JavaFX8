package es.iesazarquiel.biblioteca.models.conexiones;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Conexion {
    public Conexion() {
    }
    public Connection getConexion() throws SQLException,Exception{
       //String url="jdbc:oracle:thin:BIBLIOTECA/BIBLIOTECA@//localhost:1521/orcl";
       String url="jdbc:oracle:thin:BIBLIOTECA1DAW/BIBLIOTECA1DAW@80.59.249.199:1521:oradai";
       //String url="jdbc:oracle:thin:BIBLIOTECA/BIBLIOTECA@localhost:1521:orcl";
      // String url="jdbc:oracle:thin:BIBLIOTECA/BIBLIOTECA@192.168.1.45:1521:orcl";

        Connection con; 
        OracleDataSource ods;
        DataSource ds;
        try{
        	// Conexion tradicional sin uso del pool de conexiones
        	
        	   ods=new OracleDataSource();
               ods.setURL(url);
               con=ods.getConnection();
            
      	   //Conexion usando el pool de conexiones definido en glassfish
      	   // asociado al nombre logico: jdbc/Biblioteca
           //haciendo uso de la interfaz JNDI para localizar el recurso.
           /*
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("jdbc/sharedbiblioteca");
            con=ds.getConnection();
            */
        	
        	/* 
        	 * Conectar a un servidor compartido (conexion shared, servicio orclXDB)
        	 * Primera forma invocando un descriptor del arhivo tnsnames.ora.
        	 * Primer paso definir la propiedad tnsadmin direccionada al directorio del tnsnames.
        	   System.setProperty("oracle.net.tns_admin", "C:\\ClientOracle\\ora92\\NETWORK\\ADMIN");
        	  ods = new OracleDataSource();
        	ods.setUser("BIBLIOTECA");
        	ods.setPassword("BIBLIOTECA");
        	ods.setTNSEntryName("ORCLSH"); // entrada del tnsnames dirigida a un servidor compartido.
        	String url = "jdbc:oracle:thin:@ORCLSH";
        	
        	-- Segunda forma: m�s facil--> Usar la url que direcciona servicios en lugar de instancias.
        	*/
			/*
        	String url="jdbc:oracle:thin:BIBLIOTECA/BIBLIOTECA@//localhost:1521/orclXDB"; // servicio de servidor compartido.
        	ods = new OracleDataSource();
        	ods.setURL(url);
        	con=ods.getConnection();
            */
            // gets driver info:
            DatabaseMetaData meta = con.getMetaData();
            System.out.println("JDBC driver version is " + meta.getDriverVersion());
            System.out.println("Data Source definido y conexion establecida");
        }
        catch(SQLException sqle){
        	System.out.println(sqle.toString());
            throw sqle;
        }
        catch(Exception e){
        	System.out.println(e.toString());
            throw e;
        }
        return con;
    }
}
