/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vale2
 */
public class VentanaServicios extends FrameManager{
    
    public VentanaServicios(){
        
        super();
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 150,0));
        JLabel labelq = new JLabel(" SERVICIOS ");  
        labelq.setFont(new Font("Arial",3,22));
        labelq.setForeground(Color.black);
        labelq.setHorizontalAlignment(JLabel.CENTER);
        panelTitulo.add(labelq);
        
       
         
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(20,0,20,0);
        this.add(panelTitulo,res);
        
   
        ImageIcon imagenTex = new ImageIcon(getClass().getResource("/TextoServicios.png"));
        JLabel imgT = new JLabel();
        imgT.setIcon(imagenTex);
    
    
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.REMAINDER;
       // res.gridheight=GridBagConstraints.RELATIVE;
        res.weightx=1;
        res.weighty=1;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.VERTICAL;
        res.insets = new Insets(0,30,80,30);
       
        this.add(imgT,res);
        
        
        
        
        
    }
    
    
    
}
    

