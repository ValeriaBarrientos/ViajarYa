/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Button;
import java.awt.Color;
import static java.awt.SystemColor.text;
import javax.swing.JButton;

/**
 *
 * @author vale2
 */
public class Boton extends JButton{
    
       public Boton(String text) {
        super(text);
        this.setForeground(Color.BLACK);
        //this.setBounds(350,430,100,30);
        this.setBackground(Color.ORANGE);
        //this.setSize(100, 30);
        
        
        
    }

    Boton setCursor(int HAND_CURSOR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
}
