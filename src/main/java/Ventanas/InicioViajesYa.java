/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.MyLog;
import ViajarDB.Usuario;

/**
 *
 * @author vale2
 */
public class InicioViajesYa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyLog.write("Inicio main");
        VentanaRegistracion log = new VentanaRegistracion();
        log.setVisible(true);
       
        
   
       //VentanaViajes viajes = new VentanaViajes(u);
       // viajes.setVisible(true);
         
        
    }
    
}
