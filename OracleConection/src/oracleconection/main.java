//importar los java para la conecion sql
package oracleconection;
//referencias de conexion
import java.io.*;
import java.sql.*;
import javax.swing.*;

/**
 * Esta clase define la conexion de la dase de datos oracle 11g como se define al crear un objeto
 * @author Gorge Armando londoño Ocampo
 * @version 20/06/2015/A1
 */

public class main {
    
     // campos de la clase
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    static String bd="XE";
    static String login="bddemo1";
    static String password="123";
    static String url="jdbc:oracle:thin:@localhost:1521:XE";
    
    /**
     *
     * @param conn
     * @return enlace con los paametros conn de la calse connection
     * @throws SQLException
     */
    public static Connection Enlace(Connection conn)throws SQLException    {
        try {
         Class.forName("oracle.jdbc.OracleDriver");
         conn=DriverManager.getConnection(url, login, password);
        }
        catch(ClassNotFoundException e )
        {
            System.out.print("Clase no encontrada");
        }
        return conn;
    }
    
    /**
     *
     * @param st
     * @return los campos de captura de datos para ser ingresados a oracle 
     * @throws SQLException
     */
    public static Statement sta(Statement st)throws SQLException    {
        conn=Enlace(conn);
        st=conn.createStatement();
        return st;
    }

    /**
     *
     * @param rs
     * @return consulta EnlEst con la variable rs que asigna resultado de la consulta
     * @throws SQLException
     */
    public static ResultSet EnlEst(ResultSet rs)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery("select * from autor");
        return rs;
    }
    
}
// fin de la clase main
