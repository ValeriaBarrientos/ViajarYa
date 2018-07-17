/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author vale2
 */
public abstract class DbManager {
    
    private static PreparedStatement st;
    private static Connection conn;
    
     public static final ResultSet GET_RESULT_SET(String consulta) {
       ResultSet resultSet = null; 
       InfoDataBase infoDb = mySqlInfo();
       
       try {        
      
       conn = DriverManager.getConnection(infoDb.url, infoDb.user,infoDb.pass);
       st = conn.prepareStatement(consulta);
       resultSet = st.executeQuery();
       //st.close();
       //conn.close();
      } 
      catch (SQLException ex) {
        MyLog.write(ex);
        ex.printStackTrace();
      } 
      
      return resultSet;
     }
     
     public final void closeConections() throws SQLException{
         st.close();
         conn.close();
         
     }
     
     
      public  final int InsertSql(String consulta) {
      
        int claveGenerada = 0;
        InfoDataBase infoDb = mySqlInfo();
       
       try {        
        
    
        //String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
     
       conn = DriverManager.getConnection(infoDb.url, infoDb.user,infoDb.pass);
       st = conn.prepareStatement(consulta,PreparedStatement.RETURN_GENERATED_KEYS);
       st.executeUpdate();
       ResultSet rs = st.getGeneratedKeys();
        while (rs.next()) {
           claveGenerada = rs.getInt(1);
           System.out.println("Clave generada = " + claveGenerada);
        }
       
      // st = conn.prepareStatement(consulta);
      // resultSet = st.executeQuery();
      // st.close();
       //conn.close();
      
      } 
      catch (SQLException ex) {
        MyLog.write(ex);
        ex.printStackTrace();
       }
       return claveGenerada;
       
     }
      
    private static InfoDataBase mySqlInfo(){
        Properties prop = new Properties();
	InputStream input = null;
        InfoDataBase infoDb = new InfoDataBase();
        // Parametros por defecto

	try {
                //Obtiene config desde la carpeta del jar
                File jarPath=new File(DbManager.class.getProtectionDomain().getCodeSource().getLocation().getPath());
                String propertiesPath=jarPath.getParentFile().getAbsolutePath();
                input = new FileInputStream(propertiesPath+"/config.properties");
		if (input == null)
                {
                    // no encontro la configuracion
                    infoDb.url = "jdbc:mysql://localhost:3306/viajarya";
                    infoDb.user = "root";
                    infoDb.pass = "admin";
                    return infoDb;
                }
                // load a properties file
		prop.load(input);

		// get the property value and print it out
		infoDb.url=prop.getProperty("dburl");
		infoDb.user=prop.getProperty("dbuser");
		infoDb.pass=prop.getProperty("dbpassword");

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        return infoDb;
        
    }
    
}

