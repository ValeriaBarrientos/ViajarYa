/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vale2
 */
public abstract class DbManager {
    
    private static PreparedStatement st;
    private static Connection conn;
    
     public static final ResultSet GET_RESULT_SET(String consulta) {
       ResultSet resultSet = null; 
       try {        
       String url = "jdbc:mysql://localhost:3306/viajarya";
       conn = DriverManager.getConnection(url, "root", "admin");
       st = conn.prepareStatement(consulta);
       resultSet = st.executeQuery();
       //st.close();
       //conn.close();
      } 
      catch (SQLException ex) {
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
       
       try {        
       
        String url = "jdbc:mysql://localhost:3306/viajarya";
        //String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
       conn = DriverManager.getConnection(url, "root", "admin");
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
        ex.printStackTrace();
        
        
       }
       return claveGenerada;
       
     }
      
}


       

    
      
      
    
    



  

