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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author vale2
 */
public class UsuarioDB extends DbManager{
    
    public ArrayList<Usuario> getUsuarios(){
       
        ArrayList<Usuario> resul= new ArrayList<Usuario>();
        
        
        try {   
             String consulta = "select * from usuario";
             ResultSet st = GET_RESULT_SET(consulta);
       
       
       while (st.next()) {
         int id_usuario = st.getInt("id_usuario");
         String nombre = st.getString("nombre");
         String apellido = st.getString("apellido");
         String telefono = st.getString("telefono");
         String direccion = st.getString("direccion");
         String ciudad = st.getString("ciudad");
         Date fecha_nacimiento = st.getDate("fecha_nacimiento");
         String mail = st.getString("mail");
         String pass = st.getString("pass");
         String imagen = st.getString("imagen");
         String genero = st.getString("genero");
         boolean activo = st.getBoolean("activo");
        
         Usuario u = new Usuario(id_usuario,nombre,apellido,telefono,direccion,ciudad,fecha_nacimiento,mail,pass,imagen,genero,activo);
         resul.add(u);
        }
         closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return resul;  
    
    }
    
    public void updateUser(String id,String nombre,String apellido, String direccion,String ciudad,String genero, String telefono, String fecha_nacimiento, String mail, String pass){
        
      try{ 
        //String SQL="UPDATE usuario set nombre ='"+nombre+"', apellido= '"+apellido+"', direccion='"+direccion+"', ciudad='"+ ciudad+"', telefono='"+ telefono+"', fecha_nacimiento='"+fecha_nacimiento+"', mail='"+mail+"', pass='"+pass+"' WHERE id_usuario ="+id+";'";
        String SQL= "UPDATE usuario set nombre = '"+nombre+"',apellido='"+apellido+"',telefono='"+telefono+"',direccion='"+direccion+"',ciudad='"+ciudad+"',fecha_nacimiento='"+fecha_nacimiento+"',mail='"+mail+"',pass='"+pass+"' WHERE id_usuario ='"+id+"';";
        
        super.InsertSql(SQL);
        closeConections();
      }
       catch (SQLException ex) {
        ex.printStackTrace();
      }  
        
        
    }
    
    public void deleteCuenta(String id){
      try{ 
        String SQL="UPDATE usuario set activo= false WHERE idUsusario='" + id+ "';'";
        super.InsertSql(SQL);
        closeConections();
      }
       catch (SQLException ex) {
        ex.printStackTrace();
      }  
       
    }
    
/*    public boolean UsuarioRegDB(String nombre,String apellido,String telefono,String direccion,String fecha_nacimiento,String mail, String pass,String genero,int activo,int cuenta, String ciudad){
        
         
         String SSQL = "insert into usuario(nombre,apellido,telefono,direccion,fecha_nacimiento,mail,pass,imagen,genero,activo,cuenta,ciudad) values "+
                        "( '"+nombre+"','"+apellido+"','"+telefono+"','"+direccion+"','"+fecha_nacimiento+"','"+mail+"','"+pass+"',' ','"+genero+"',"+activo+","+cuenta+",'"+ciudad+"');";
        
         
         return super.InsertSqlUsuario(SSQL);
             
         
         
    }*/
    
    
      public  final int InsertUsuario(String nombre,String apellido,String telefono,String direccion,String fecha_nacimiento,String mail, String pass,String genero,int activo,String ciudad) {
      
       int autorizado = 0;
       
       String SSQL = "insert into usuario(nombre,apellido,telefono,direccion,fecha_nacimiento,mail,pass,imagen,genero,activo,ciudad) values "+
               "( '"+nombre+"','"+apellido+"','"+telefono+"','"+direccion+"','"+fecha_nacimiento+"','"+mail+"','"+pass+"',' ','"+genero+"',"+activo+",'"+ciudad+"');";
       
       return super.InsertSql(SSQL);
       
    }
       
     public Usuario getUnUsuario (int idUsuario){
         
         Usuario u=null;
          try {   
             String consulta = "select * from usuario where id_usuario =  '"+idUsuario+"';";
             ResultSet st = GET_RESULT_SET(consulta);
            
             
             while (st.next()) {
             
                String nombre = st.getString("nombre");
                String apellido = st.getString("apellido");
                String telefono = st.getString("telefono");
                String direccion = st.getString("direccion");
                String ciudad = st.getString("ciudad");
                Date fecha_nacimiento = st.getDate("fecha_nacimiento");
                String mail = st.getString("mail");
                String pass = st.getString("pass");
                String imagen = st.getString("imagen");
                String genero = st.getString("genero");
                boolean activo = st.getBoolean("activo");
                  
                u = new Usuario(idUsuario,nombre,apellido,telefono,direccion,ciudad,fecha_nacimiento,mail,pass,imagen,genero,activo);
                
             }
              closeConections();
       
            } 
          catch (SQLException ex) {
            ex.printStackTrace();
           
          }
          return u;
     }
     
}
      
         
         
     
       
    

    
    

        
    
    

