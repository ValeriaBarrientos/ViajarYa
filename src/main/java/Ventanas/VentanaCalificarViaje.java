/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Auto;
import ViajarDB.AutoDB;
import ViajarDB.Usuario;
import ViajarDB.Viaje;
import ViajarDB.ViajeDB;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author vale2
 */
public class VentanaCalificarViaje extends JFrame{
    private int nota;
    private String comentario;
    public VentanaCalificarViaje(Usuario u, int idViaje){
        
         GridBagLayout gridBag = new GridBagLayout ();
         GridBagConstraints res = new GridBagConstraints ();
         VentanaCalificarViaje self = this;
         
         
        JPanel panelDetalle = new JPanel();
        GridBagLayout gBag2 = new GridBagLayout ();
        GridBagConstraints gRes2 = new GridBagConstraints ();
        panelDetalle.setLayout(gBag2);
        panelDetalle.setBackground(Color.WHITE);
        TitledBorder borde2 = new TitledBorder(" Detalle: ");
        borde2.setTitleFont(new Font("Arial",3,16));
        panelDetalle.setBorder(borde2);
       
        ViajeDB v = new ViajeDB();
        Viaje viaje;
        viaje=v.getViajeUsuario(idViaje);
        
        
        
        JLabel la1 = new JLabel("Viaje realizado desde: "+viaje.getOrigen()+" a "+viaje.getDestino() );  
        la1.setFont(new Font("Calibri",6,16)); 
        la1.setForeground(Color.BLACK);
        gRes2.gridx = 0;
        gRes2.gridy = 0;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        gRes2.anchor = GridBagConstraints.NORTH;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        gRes2.insets = new Insets(0,0,0,0);
        panelDetalle.add(la1,gRes2);
        JLabel la2 = new JLabel("Fecha y hora de partida: "+viaje.getFechaPartida()+"  "+ viaje.getHoraPartida() );  
        la2.setFont(new Font("Calibri",6,16)); 
        la2.setForeground(Color.BLACK);
        gRes2.gridx = 0;
        gRes2.gridy = 1;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        gRes2.anchor = GridBagConstraints.NORTH;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        gRes2.insets = new Insets(0,0,0,0);
        panelDetalle.add(la2,gRes2);
        
        JLabel la3 = new JLabel("El lugar de salida fué: "+viaje.getLugar_salida() );  
        la3.setFont(new Font("Calibri",6,16)); 
        la3.setForeground(Color.BLACK);
        gRes2.gridx = 0;
        gRes2.gridy = 2;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        gRes2.anchor = GridBagConstraints.NORTH;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        gRes2.insets = new Insets(0,0,0,0);
        panelDetalle.add(la3,gRes2);
        
        AutoDB v2 = new AutoDB();
        Auto auto = v2.getViajeAuto(idViaje);
        
        JLabel la4 = new JLabel("El vehículo: "+auto.getMarca()+" "+auto.getModelo() );  
        la4.setFont(new Font("Calibri",6,16)); 
        la4.setForeground(Color.BLACK);
        gRes2.gridx = 0;
        gRes2.gridy = 3;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        gRes2.anchor = GridBagConstraints.NORTH;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        gRes2.insets = new Insets(0,0,0,0);
        panelDetalle.add(la4,gRes2);
        
        JLabel la5 = new JLabel("Dominio : "+auto.getPatente()+" de color  "+auto.getColor());  
        la5.setFont(new Font("Calibri",6,16)); 
        la5.setForeground(Color.BLACK);
        gRes2.gridx = 0;
        gRes2.gridy = 4;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        gRes2.anchor = GridBagConstraints.NORTH;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        gRes2.insets = new Insets(0,0,0,0);
        panelDetalle.add(la5,gRes2);
        
        
        
        JLabel la6 = new JLabel("Tu conductor/ra :  "+ viaje.getConductor().getNombre()+" "+viaje.getConductor().getApellido() );  
        la6.setFont(new Font("Calibri",6,16)); 
        la6.setForeground(Color.BLACK);
        gRes2.gridx = 0;
        gRes2.gridy = 5;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        gRes2.anchor = GridBagConstraints.NORTH;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        gRes2.insets = new Insets(0,0,20,0);
        panelDetalle.add(la6,gRes2);
        
        
     
 
      
        JPanel panelCalificacion = new JPanel();
        panelCalificacion.setLayout(new FlowLayout(FlowLayout.CENTER,60,20));
        panelCalificacion.setBackground(Color.white);
       // panelCalificacion.setSize(800, 800);
        TitledBorder borde = new TitledBorder("Seleccioná la calificación:");
        borde.setTitleFont(new Font("Arial",3,14));
        panelCalificacion.setBorder(borde);
    
        
        
        
        JPanel panelComentario = new JPanel();
        panelComentario.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
        panelComentario.setBackground(Color.white);
        //panelCalificacion.setSize(800, 800);
        TitledBorder borde3 = new TitledBorder("Podés dejar tu comentario:");
        borde.setTitleFont(new Font("Arial",3,14));
        panelComentario.setBorder(borde3);
        
         JTextArea areaTex = new JTextArea();
         areaTex.setEditable(true);
         areaTex.setLineWrap(true);
         areaTex.setBackground(Color.WHITE);
         areaTex.setSize(600,400);
        //areaTex.setPreferredSize(new Dimension (400,400));
         areaTex.setForeground(Color.BLACK);
         panelComentario.add(areaTex);
         
          areaTex.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                areaTex.setText((""));
                
            }
        });
        
      
          
       JRadioButton excButton = new JRadioButton("EXCELENTE");
       excButton.setMnemonic('e');
      // exc

       JRadioButton mbButton = new JRadioButton("MUY BUENO");
       mbButton.setMnemonic('m');
       
       JRadioButton bButton = new JRadioButton("BUENO");
       bButton.setMnemonic('b');
       JRadioButton regButton = new JRadioButton("REGULAR");
       regButton.setMnemonic('r');
       JRadioButton maloButton = new JRadioButton("MALO");
       maloButton.setMnemonic('m');

    
        ButtonGroup calificacion = new ButtonGroup();
        calificacion.add(excButton);
        calificacion.add(mbButton);
        calificacion.add(bButton);
        calificacion.add(regButton);
        calificacion.add(maloButton);
        
        panelCalificacion.add(excButton);
        panelCalificacion.add(mbButton);
        panelCalificacion.add(bButton);
        panelCalificacion.add(regButton);
        panelCalificacion.add(maloButton);
        
    /*    
        String bot=getSelectedButtonText(calificacion);
        System.out.println(bot);
        String notaText= "lala";
         switch (notaText) {

            case "Excelente":
                nota=5;
                break;
            case "Muy bueno":
                nota=4;
                break;
            case "Bueno":
                nota=3;
                break;
            case "Regular":
                nota=2;
                break;
            case "Malo":
                nota=1;
                break;

           
            default: nota =0; break;

        }*/


         
        
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
        Boton botonCalificar=new Boton("CALIFICAR");
        panelBotones.add(botonCalificar);
        Boton botonVolver=new Boton("VOLVER");
        panelBotones.add(botonVolver);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                    VentanaMisViajes viajes = new VentanaMisViajes(u);
                     viajes.setVisible(true);
                     self.setVisible(false); 
                
            }
        });
        
        
        botonCalificar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
               String notaText=getSelectedButtonText(calificacion);
               System.out.println(notaText);
               comentario = areaTex.getText();
               System.out.println(comentario);
               
                switch (notaText) {
                    case "EXCELENTE":
                        nota=5;
                        break;
                    case "MUY BUENO":
                        nota=4;
                        break;
                    case "BUENO":
                        nota=3;
                        break;
                    case "REGULAR":
                        nota=2;
                        break;
                    case "MALO":
                        nota=1;
                        break;
                 default: nota =0; break;
            }
            
                int idAuto= auto.getId_auto();
                int idUsuario=u.getId_usuario();
                v.insertarCalificacion(idViaje, idUsuario, idAuto, nota, comentario);

        }

        });
        
        
         
        this.setTitle("Calificar Viaje");
        this.setSize(850,700);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        //this.setLocation(220,115);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        this.setLayout(gridBag);
        
        
        JLabel labelTitulo = new JLabel("Qué te pareció el viaje...? ");  
        labelTitulo.setFont(new Font("Arial",3,20));
        labelTitulo.setForeground(Color.black);
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        
        
        
        
        
        
        res.gridx=0;
        res.gridy=0;
        //res.gridwidth=2;
        //res.gridheight=2;
        res.weightx=1;
        res.weighty=1;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        //res.ipady = 10;
        this.add(labelTitulo,res);
        
        
        res.gridx=0;
        res.gridy=1;
        //res.gridwidth=2;
        //res.gridheight=2;
        res.weightx=1;
        res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,60,0,60);
        //res.ipady = 10;
        this.add(panelDetalle,res);
        
        
        
        res.gridx=0;
        res.gridy=2;
        //res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=2;
        res.weightx=1;
        res.weighty=1;
       // res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(0,60,0,60);
        this.add(panelCalificacion,res);
        
        
        res.gridx=0;
        res.gridy=3;
        //res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=2;
        res.weightx=1;
        res.weighty=1;
       // res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(0,60,0,60);
        this.add(panelComentario,res);
        
        
        res.gridx=0;
        res.gridy=4;
        //res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=2;
        res.weightx=1;
        res.weighty=1;
       // res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(0,60,0,60);
        this.add(panelBotones,res);
        
      
     
     
     
     }
    
     public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
     
    
}

    

