/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Usuario;
import ViajarDB.Viaje;
import ViajarDB.ViajeDB;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vale2
 */
public abstract class FrameManager extends JFrame {
     GridBagLayout gridBag = new GridBagLayout ();
     GridBagConstraints res = new GridBagConstraints ();
     FrameManager self = this;
     
    
     public FrameManager (){
        
        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        
    //----Presentacion ------------------------------------
        
       
        JPanel panelPresent = new JPanel();
        panelPresent.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
        Font fuente = new Font("Calibri",10,24);
        panelPresent.setBackground(Color.ORANGE);
        Boton botonInicio=new Boton("Inicio");
        botonInicio.setBorder(null);
        botonInicio.setFont(fuente);
        //botonInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelPresent.add(botonInicio);
        Boton botonQuien=new Boton("Quienes somos");
        botonQuien.setBorder(null);
        botonQuien.setFont(fuente);
        panelPresent.add(botonQuien);
        Boton botonServicios=new Boton("Servicios");
        botonServicios.setBorder(null);
        botonServicios.setFont(fuente);
        panelPresent.add(botonServicios);
        Boton botonContacto=new Boton("Contacto");
        botonContacto.setBorder(null);
        botonContacto.setFont(fuente);
        panelPresent.add(botonContacto);
        
         botonInicio.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                Cursor cursor;
                //ImageIcon img=new ImageIcon(getClass().getResource("/hand.png"));
                Toolkit t=Toolkit.getDefaultToolkit();
                Image img = t.getImage(getClass().getResource("/hand.png"));
                cursor=t.createCustomCursor(img,new Point(0,0),"Cursor");
               
                botonInicio.setCursor(cursor);
                
              //  botonInicio.setForeground(Color.WHITE);
                
               // int c = Cursor.HAND_CURSOR;
                //botonInicio.setCursor(new Cursor(c));
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                botonInicio.setForeground(Color.BLACK);
            }
            
             @Override
            public void mouseClicked(MouseEvent e) {
                
                  Present log = new Present();
                  log.setVisible(true);
                  self.setVisible(false);
            }
                 
                
            
        });
         
         
          botonQuien.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseEntered(MouseEvent e) {
              
                botonQuien.setForeground(Color.WHITE);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                botonQuien.setForeground(Color.BLACK);
            }
             @Override
            public void mouseClicked(MouseEvent e) {
              
                  VentanaQuienesSomos   ventQ = new VentanaQuienesSomos();
                  ventQ.setVisible(true);
                  self.setVisible(false);
            }
            
            
        });
         
          botonServicios.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseEntered(MouseEvent e) {
              
                botonServicios.setForeground(Color.WHITE);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                botonServicios.setForeground(Color.BLACK);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
              
                  VentanaServicios ventS = new VentanaServicios();
                  ventS.setVisible(true);
                  self.setVisible(false);
            }
            
            
            
            
        });
         
          botonContacto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseEntered(MouseEvent e) {
              
                botonContacto.setForeground(Color.WHITE);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                botonContacto.setForeground(Color.BLACK);
            }
            
        });
         
         
    
         
         
         
        this.setTitle("VIAJAR YA!");
        this.setSize(950,600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        this.setLayout(gridBag);
        
           //----presentacion
     
        ImageIcon imagen = new ImageIcon(getClass().getResource("/auto3.png"));
      
        JLabel img = new JLabel();
        img.setIcon(imagen);
        
        res.gridx=0;
        res.gridy=0;
        res.gridwidth=1;
        res.weightx=1;
        res.weighty=1;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
  
        this.add(img,res);
        res.gridx=0;
        res.gridy=0;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(0,0,0,0);
        this.add(panelPresent,res);
        
      
     
     
     
     }
     
    
}
