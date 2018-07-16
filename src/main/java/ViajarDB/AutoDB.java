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
/**
 *
 * @author alejandro
 */
public class AutoDB extends DbManager {
    public Auto getViajeAuto(int idViaje){
        Auto auto = null;
        try {   
             String consulta = "SELECT a.* FROM viaje v join viaje_has_usuario vu " +
             "on v.id_viaje = vu.Viaje_id_viaje " +
             "join auto a on a.id_auto = vu.Auto_id_Auto " +
             "where v.id_viaje="+idViaje;
             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            int id_auto = st.getInt("id_auto");
            String marca = st.getString("marca");
            String modelo = st.getString("modelo");
            String color = st.getString("color");
            String combustible = st.getString("combustible");
            boolean aire = st.getBoolean("aireacondicionado");
            boolean calefaccion = st.getBoolean("calefaccion");
            short cantAsientos = st.getShort("cantidad_de_asientos");
            String baul = st.getString("capacidad_de_baul");
            short calificacion = st.getShort("calificacion");
            String patente = st.getString("patente");
            boolean cuenta = st.getBoolean("cuenta");
            auto = new Auto(id_auto,marca,modelo,color,combustible,patente,aire,calefaccion,cantAsientos,calificacion,baul," ",cuenta);
         
        }
         closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return auto;  
    
    }
    
     public void addCar(String marca, String modelo, String color,String combustible, String patente, int aire, int calefaccion, String cantAsientos, String calificacion, String baul, int idUsuario){
        String SQL="insert into auto(modelo,marca,color,combustible,patente,aireacondicionado,calefaccion,cantidad_de_asientos,calificacion,capacidad_de_baul,id_propietario) values ('"+marca+"','"+modelo+"','"+color+"','"+combustible+"','"+patente+"',"+aire+","+calefaccion+",'"+cantAsientos+"','"+calificacion+"','"+baul+"',"+idUsuario+ ")";
        System.out.println(SQL);
        super.InsertSql(SQL);
    }
    
  /*  public void updateCar(String marca, String modelo, String color,String combustible, String patente, String aire, String calefaccion, String cantAsientos, String calificacion, String baul, String idAuto){
        String SQL="'UPDATE auto set modelo = '" + modelo +"',marca= '" + marca + "',baul= '" + baul + "',color= '" + color + "',combustible= '" + combustible + "',patente= '" + patente + "',aire= '" + aire + "',calefaccion= '" + calefaccion + "',cantidad_asientos= '" + cantAsientos + "',calificacion= '" + calificacion + "'WHERE idAuto = '" + idAuto + "';'";
        super.InsertSql(SQL);
        
        
    }*/
     
     
    public void updateCar(String marca, String modelo, String color,String combustible, String patente, String aire, String calefaccion, String cantAsientos, String calificacion, String baul, int idAuto){
        String SQL="UPDATE auto set marca = '" + marca 
                + "',modelo= '" + modelo 
                + "',capacidad_de_baul= '" + baul 
                + "',color= '" + color 
                + "',combustible= '" + combustible 
                + "',patente= '" + patente 
                + "',aireacondicionado= " + aire 
                + ",calefaccion= " + calefaccion 
                + ",cantidad_de_asientos= '" + cantAsientos 
                + "',calificacion= '" + calificacion 
                + "' WHERE id_Auto = " + idAuto +";";
        super.InsertSql(SQL);
        
        
    }
    
    public void deleteCar(int id_auto){ 
        String SQL="update auto set cuenta = 0 WHERE id_Auto=" + id_auto + ";";
        super.InsertSql(SQL);
    }
    
    
     public ArrayList<Auto> ObtenerAutosUsuario(int idUsuario){
        
          ArrayList<Auto>arrAutos = new ArrayList<Auto>();
        
        try {   
             String consulta = "select * from auto where id_propietario ='"+idUsuario+"' AND cuenta=1";
             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            int id_auto = st.getInt("id_auto");
            System.out.println(id_auto);
            String marca = st.getString("marca");
            String modelo = st.getString("modelo");
            String color = st.getString("color");
            String combustible = st.getString("combustible");
            boolean aire = st.getBoolean("aireacondicionado");
            boolean calefaccion = st.getBoolean("calefaccion");
            short cantAsientos = st.getShort("cantidad_de_asientos");
            String baul = st.getString("capacidad_de_baul");
            short calificacion = st.getShort("calificacion");
            String patente = st.getString("patente");
            boolean cuenta = st.getBoolean("cuenta");
            Auto auto = new Auto(id_auto,marca,modelo,color,combustible,patente,aire,calefaccion,cantAsientos,calificacion,baul," ",cuenta);
            arrAutos.add(auto);
        }
        closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return arrAutos;  
           
    }
    
    
    public Auto ObtenerDatosAuto (int idAuto){
        
     Auto auto = null;
        
        try {   
             String consulta = "select * from auto where id_auto ="+idAuto+" AND cuenta=1";
             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            
            String marca = st.getString("marca");
            String modelo = st.getString("modelo");
            String color = st.getString("color");
            String combustible = st.getString("combustible");
            boolean aire = st.getBoolean("aireacondicionado");
            boolean calefaccion = st.getBoolean("calefaccion");
            short cantAsientos = st.getShort("cantidad_de_asientos");
            String baul = st.getString("capacidad_de_baul");
            short calificacion = st.getShort("calificacion");
            String patente = st.getString("patente");
            boolean cuenta = st.getBoolean("cuenta");
            auto = new Auto(idAuto,marca,modelo,color,combustible,patente,aire,calefaccion,cantAsientos,calificacion,baul," ",cuenta);
           
        }
        closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return auto;
        
        
    }
    
}
