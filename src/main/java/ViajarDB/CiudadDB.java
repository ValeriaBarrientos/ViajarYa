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

/**
 *
 * @author vale2
 */
public class CiudadDB extends DbManager{
    
    public ArrayList<Ciudad> getCiudades() {
        ArrayList<Ciudad> resul= new ArrayList<Ciudad>();
        try {
            
            String consulta = "select * from ciudad";
            ResultSet st = GET_RESULT_SET(consulta);
            
            while (st.next()) {
                Ciudad c = new Ciudad(st.getInt("id_Ciudad"),st.getString("nombre"));
                resul.add(c);
            }
            closeConections();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return resul;
    }
    
}    