/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Auto;
import ViajarDB.AutoDB;
import ViajarDB.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author diego
 */
public class VentanaDeleteAuto extends FrameManager{
    
    private JComboBox comboListaAutos;
    private int aux;
    
    public VentanaDeleteAuto(Usuario u,ArrayList <Auto> arrAutos){
        
    final AutoDB adb=new AutoDB();
    java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
    VentanaDeleteAuto self = this;
    JPanel panelListar = new JPanel();
    GridBagLayout gBag = new GridBagLayout ();
    GridBagConstraints gRes = new GridBagConstraints ();
    panelListar.setLayout(gBag);
    panelListar.setBackground(Color.white);
    TitledBorder borde = new TitledBorder("Seleccione un auto");
    borde.setTitleFont(new Font("Arial",3,22));
    panelListar.setBorder(borde);
    
    JLabel laAsientos = new JLabel("Numero    Marca        Modelo           Patente");  
    laAsientos.setFont(new Font("arial",3,12));
    laAsientos.setForeground(Color.BLACK);
    laAsientos.setHorizontalAlignment(JLabel.LEFT);
    gRes.gridx = 0;
    gRes.gridy = 0;
    gRes.gridwidth =1;
    gRes.anchor = GridBagConstraints.WEST;
    gRes.fill = GridBagConstraints.HORIZONTAL;
    gRes.insets = new Insets(0,0,10,10);
    panelListar.add(laAsientos,gRes);
    
    comboListaAutos = new JComboBox();
       
    //recorro el arreglo y lo pongo en el combo
    for (int i=0; i<arrAutos.size();i++){
        StringBuilder mostrar=new StringBuilder(String.valueOf(i+1));
        mostrar.append(" -      \t");
        mostrar.append(arrAutos.get(i).getMarca().toString());
        mostrar.append("       \t");
        mostrar.append(arrAutos.get(i).getModelo().toString());
        mostrar.append("       \t");
        mostrar.append(arrAutos.get(i).getPatente().toString());
        
        comboListaAutos.addItem(mostrar);
    }
        
    comboListaAutos.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboListaAutos
                String id_autoAux=String.valueOf(comboListaAutos.getSelectedItem());
                aux=(int) id_autoAux.charAt(0);
                aux--;
                Auto au=arrAutos.get(aux);
                
            }
        });
        
    
        JPanel panelInferior = new JPanel();
           
        Boton botonVolver=new Boton("Volver");
        botonVolver.setAlignmentX (panelInferior.CENTER_ALIGNMENT);
        panelInferior.add(botonVolver);
        panelInferior.add (Box.createRigidArea (new Dimension (15,15)));
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaMiAuto au = new VentanaMiAuto(u);
                au.setVisible(true);
                self.setVisible(false);
            }
        });
        
        Boton botonEliminar=new Boton("Eliminar");
        botonEliminar.setAlignmentX (panelInferior.CENTER_ALIGNMENT);
        panelInferior.add(botonEliminar);
        panelInferior.add (Box.createRigidArea (new Dimension (15,15)));
        
        botonEliminar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                //llamamos al update de la base de datos para eliminar la cuenta
                adb.deleteCar(arrAutos.get(aux).getId_auto());
                VentanaMiAuto au = new VentanaMiAuto(u);
                au.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        //----Listar Autos
    GridBagConstraints gRes1 = new GridBagConstraints ();
    gRes1.gridx = 0;
    gRes1.gridy = 1;
    gRes1.gridwidth =1;
    gRes1.insets = new Insets(0,0,10,10);
    panelListar.add(comboListaAutos,gRes1);
    res.gridx=0;
    res.gridy=1;
    res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
    res.fill = GridBagConstraints.BOTH;
    res.insets = new Insets(0,50,0,50);
    this.add(panelListar,res);
    Boton botonAceptar=new Boton("Aceptar");
    botonAceptar.setAlignmentX (panelListar.CENTER_ALIGNMENT);
   
    panelListar.add (Box.createRigidArea (new Dimension (15,15)));
    panelListar.add(botonAceptar);
        botonAceptar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                aux=comboListaAutos.getSelectedIndex();
                    
                
            }
        });
        
        // panel inferior
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,10,30,10);
        this.add(panelInferior,res);
    }
}

