/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Auto;
import ViajarDB.AutoDB;
import ViajarDB.Calificacion;
import ViajarDB.Usuario;
import ViajarDB.UsuarioDB;
import ViajarDB.Viaje;
import ViajarDB.ViajeDB;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

/**
 *
 * @author alejandro
 */
public class VentanaSumarseViaje extends FrameManager{
   
  
    
    public VentanaSumarseViaje(int id, Usuario usuarioActual){
        ViajeDB v = new ViajeDB();
        Viaje viaje = v.getViajeUsuario(id);
        ArrayList <Calificacion> arrCalif;
       
          
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel labelq = new JLabel(" Detalles del viaje ");  
        labelq.setFont(new Font("Arial",5,26));
        labelq.setForeground(Color.black);
        labelq.setHorizontalAlignment(JLabel.CENTER);
        panelTitulo.add(labelq);
        
        
        JPanel panelConductor = new JPanel();
        GridBagLayout gBag3 = new GridBagLayout ();
        GridBagConstraints res3 = new GridBagConstraints ();
        panelConductor.setLayout(gBag3);
        panelConductor.setBackground(Color.WHITE);
       
        JLabel labelConductor=new JLabel("Conductor: "+viaje.getConductor().getNombre()+" "+viaje.getConductor().getApellido());
        labelConductor.setHorizontalAlignment(JLabel.RIGHT);
        labelConductor.setFont(new Font("Arial",3,12));
        res3.gridx=0;
        res3.gridy=0;
        res3.gridwidth=GridBagConstraints.REMAINDER;
        res3.anchor = GridBagConstraints.CENTER;
       // res3.fill = GridBagConstraints.HORIZONTAL;
        res3.insets = new Insets(10,0,10,30);
        panelConductor.add(labelConductor,res3);
        
        
        ImageIcon imagen;
        JLabel imgAvatar = new JLabel();
        String genero=viaje.getConductor().getGenero();
        if (genero.equals("f")){
             imagen = new ImageIcon(getClass().getResource("/avatarF.jpg"));
             imgAvatar.setIcon(imagen);
        }
        else{
            imagen = new ImageIcon(getClass().getResource("/avatarM.jpg"));
            imgAvatar.setIcon(imagen);
            
        }
        res3.gridx=0;
        res3.gridy=1;
        //res3.gridwidth=1;
        
        panelConductor.add(imgAvatar,res3);   
            
        
        
        
        JPanel panelDetallesViajes1 = new JPanel();
        GridBagLayout gBag1 = new GridBagLayout ();
        GridBagConstraints res1 = new GridBagConstraints ();
        panelDetallesViajes1.setLayout(gBag1);
        panelDetallesViajes1.setBackground(Color.white);
        
        JLabel labelOrigen=new JLabel("Origen: ");
        labelOrigen.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=0;
        res1.gridwidth=1;
        res1.anchor = GridBagConstraints.EAST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(10,0,10,0);
        panelDetallesViajes1.add(labelOrigen,res1);
        JTextField textOrigen=new JTextField(viaje.getOrigen());
        res1.gridx=1;
        res1.gridy=0;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textOrigen,res1);
        
        
        JLabel labelDestino=new JLabel("Destino: ");
        labelDestino.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=1;
        res1.gridwidth=1;
        panelDetallesViajes1.add(labelDestino,res1);
        JTextField textDestino=new JTextField(viaje.getDestino());
        res1.gridx=1;
        res1.gridy=1;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textDestino,res1);
        
        
        JLabel labelFecha=new JLabel("Fecha: ");
        labelFecha.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=2;
        res1.gridwidth=1;
        panelDetallesViajes1.add(labelFecha,res1);
        JTextField textFecha=new JTextField(viaje.getFechaPartida().toString());
        res1.gridx=1;
        res1.gridy=2;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textFecha,res1);
        
        JLabel labelHora=new JLabel("Hora: ");
        labelHora.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=3;
        res1.gridwidth=1;
        panelDetallesViajes1.add(labelHora,res1);
        JTextField textHora=new JTextField(viaje.getHoraPartida().toString());
        res1.gridx=1;
        res1.gridy=3;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textHora,res1);
        
        
        JLabel labelLugar=new JLabel("Lugar de Salida: ");
        labelLugar.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=4;
        res1.gridwidth=1;
        panelDetallesViajes1.add(labelLugar,res1);
        JTextField textLugar=new JTextField(viaje.getLugar_salida());
        res1.gridx=1;
        res1.gridy=4;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textLugar,res1);
       
        JLabel labelGastos=new JLabel("Gastos Aproximados: ");
        labelGastos.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=5;
        res1.gridwidth=1;
        panelDetallesViajes1.add(labelGastos,res1);
        JTextField textGastos=new JTextField(String.valueOf(viaje.getGastosaproximados()));
        res1.gridx=1;
        res1.gridy=5;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textGastos,res1);
       
        JLabel labelMascota=new JLabel("Acepta Mascota?: ");
        labelMascota.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=6;
        res1.gridwidth=1;
        panelDetallesViajes1.add(labelMascota,res1);
        String mascota=String.valueOf(viaje.isMascota());
        if (mascota.equals("true")){
            mascota="Si";
        }
        else{
            mascota="No";
        }
        JTextField textMascota=new JTextField(mascota);
        res1.gridx=1;
        res1.gridy=6;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textMascota,res1);
        
        JLabel labelFumador=new JLabel("Se puede fumar?: ");
        labelFumador.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=7;
        res1.gridwidth=1;
        panelDetallesViajes1.add(labelFumador,res1);
        String fumador=String.valueOf(viaje.isFumador());
        if (fumador.equals("true")){
            fumador="Si";
        }
        else{
            fumador="No";
        }
        JTextField textFumador=new JTextField(fumador);
        res1.gridx=1;
        res1.gridy=7;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textFumador,res1);
       
        JLabel labelAsientos = new JLabel(" Asientos disponibles: ");  
        labelAsientos.setFont(new Font("Arial",3,12));
        labelAsientos.setForeground(Color.black);
        labelAsientos.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=8;
        res1.gridwidth=1;
        panelDetallesViajes1.add(labelAsientos,res1);
        
        AutoDB v2 = new AutoDB();
        Auto auto = v2.getViajeAuto(id);
       
        Integer cantAsientoOcupado= v.getCantidadAsientos(id);
        Integer cantAsientoDisponible =  auto.getCantidad_de_asientos() - cantAsientoOcupado;
        JTextField textDisponible=new JTextField(String.valueOf(cantAsientoDisponible));
        textDisponible.setColumns(5);
        res1.gridx=1;
        res1.gridy=8;
        res1.gridwidth=1;
        panelDetallesViajes1.add(textDisponible,res1);
       
        //-----------------datos del auto---------------------------------------
       
        JPanel panelDetallesViajes2 = new JPanel();
        GridBagLayout gBag2 = new GridBagLayout ();
        GridBagConstraints res2 = new GridBagConstraints ();
        panelDetallesViajes2.setLayout(gBag2);
        panelDetallesViajes2.setBackground(Color.WHITE);
        
        
        
        JLabel labelMarca=new JLabel("Marca: ");
        labelMarca.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=0;
        res2.gridwidth=1;
        res2.anchor = GridBagConstraints.EAST;
        res2.fill = GridBagConstraints.HORIZONTAL;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelMarca,res2);
        JTextField textMarca=new JTextField(auto.getMarca());
      //  textMarca.setHorizontalAlignment(JTextField.LEFT);
        res2.gridx=3;
        res2.gridy=0;
        res2.gridwidth= GridBagConstraints.REMAINDER;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textMarca,res2);
      
        
        JLabel labelModelo=new JLabel("Modelo: ");
        labelModelo.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=1;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelModelo,res2);
        JTextField textModelo=new JTextField(auto.getModelo());
        res2.gridx=3;
        res2.gridy=1;
        res2.gridwidth=GridBagConstraints.REMAINDER;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textModelo,res2);
       
        JLabel labelColor=new JLabel("Color: ");
        labelColor.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=2;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelColor,res2);
        JTextField textColor=new JTextField(auto.getColor());
        res2.gridx=3;
        res2.gridy=2;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textColor,res2);
       
        
        JLabel labelCombustible=new JLabel("Combustible: ");
        labelCombustible.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=3;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelCombustible,res2);
        JTextField textCombustible=new JTextField(auto.getCombustible());
        res2.gridx=3;
        res2.gridy=3;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textCombustible,res2);
        
        JLabel labelAire=new JLabel("Aire acondicionado: ");
        labelAire.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=4;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelAire,res2);
        String aire=String.valueOf(auto.isAire_acondicionado());
        if (aire.equals("true")){
            aire="Si";
        }
        else{
            aire="No";
        }
        JTextField textAire=new JTextField(aire);
        res2.gridx=3;
        res2.gridy=4;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textAire,res2);
        
        
        JLabel labelCalefaccion=new JLabel("Calefaccion: ");
        labelCalefaccion.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=5;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelCalefaccion,res2);
        String calefa=String.valueOf(auto.isCalefaccion());
        if (calefa.equals("true")){
            calefa="Si";
        }
        else{
            calefa="No";
        }
        JTextField textCalefaccion=new JTextField(calefa);
        res2.gridx=3;
        res2.gridy=5;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textCalefaccion,res2);
       
        
        JLabel labelCantidad=new JLabel("Cantidad de Asientos: ");
        labelCantidad.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=6;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelCantidad,res2);
        JTextField textCantidad=new JTextField(String.valueOf(auto.getCantidad_de_asientos()));
        res2.gridx=3;
        res2.gridy=6;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textCantidad,res2);
        
        JLabel labelBaul=new JLabel("Capacidad Baul: ");
        labelBaul.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=7;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelBaul,res2);
        JTextField textBaul=new JTextField(auto.getCapacidad_baul());
        res2.gridx=3;
        res2.gridy=7;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textBaul,res2);
        
        JLabel labelCalificacion=new JLabel("Calificacion: ");
        labelCalificacion.setHorizontalAlignment(JLabel.LEFT);
        res2.gridx=2;
        res2.gridy=8;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(labelCalificacion,res2);
        JTextField textCalificacion=new JTextField(String.valueOf(auto.getCalificacion()));
        res2.gridx=3;
        res2.gridy=8;
        res2.gridwidth=1;
        res2.insets = new Insets(10,0,10,0);
        panelDetallesViajes2.add(textCalificacion,res2);
        
        //----------------Cantidad asientos
        
        JPanel panelAsientos = new JPanel();
        panelAsientos.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        panelAsientos.setBackground(Color.WHITE);
     
       
  //-----Panel Estrellas
  
       
        JPanel panelEstrellas = new JPanel();
        GridBagLayout gBag4 = new GridBagLayout ();
        GridBagConstraints res4 = new GridBagConstraints ();
        panelEstrellas.setLayout(gBag4);
        panelEstrellas.setBackground(Color.white);
        
        JLabel labelCalificacion1 = new JLabel("  Calificacion  ");  
        labelCalificacion1.setFont(new Font("Arial",3,14));
        labelCalificacion1.setForeground(Color.black);
        labelCalificacion1.setHorizontalAlignment(JLabel.RIGHT);
 
        ImageIcon imagenEstrellas;
        JLabel labEstrellas = new JLabel();
        arrCalif = v.obtenerCalificacionesConductor(auto.getId_auto(),viaje.getConductor().getId_usuario());
        int promedio = 0;
        if (arrCalif.size()>0){
            res4.gridx=0;
            res4.gridy=0;
            res4.gridwidth=1;
            panelEstrellas.add(labelCalificacion1,res4);
            for (Calificacion cal: arrCalif){
            promedio+= (cal.getPuntuacion());
            }
            promedio=(int)promedio/arrCalif.size();
            switch (promedio) {
                                case 5:
                                   imagenEstrellas = new ImageIcon(getClass().getResource("/5estrellas.png"));
                                    break;
                                case 4:
                                    imagenEstrellas = new ImageIcon(getClass().getResource("/4estrellas.png"));
                                    break;
                                case 3:
                                    imagenEstrellas = new ImageIcon(getClass().getResource("/3estrellas.png"));
                                    break;
                                case 2:
                                   imagenEstrellas = new ImageIcon(getClass().getResource("/2estrellas.png"));
                                    break;
                                case 1:
                                    imagenEstrellas = new ImageIcon(getClass().getResource("/1estrellas.png"));
                                    break;
                             default: imagenEstrellas = new ImageIcon(getClass().getResource("/0estrellas.png"));; break;
            }
            
            
            
        }
        else{
           imagenEstrellas = new ImageIcon(getClass().getResource("/0estrellas.png"));
           JLabel labSinCal = new JLabel("No fué calificado aún por ningún usuario");
           labSinCal.setFont(new Font("Arial",3,11));
           res4.gridx=0;
           res4.gridy=0;
           res4.gridwidth=1;
           panelEstrellas.add(labSinCal,res4);
        }
        
        labEstrellas.setIcon(imagenEstrellas);
        labEstrellas.setHorizontalAlignment(JLabel.RIGHT);
        //panelEstrellas.add(Box.createRigidArea(new Dimension(80,0)));
        res4.gridx=0;
        res4.gridy=1;
        res4.gridwidth=1;
        panelEstrellas.add(labEstrellas,res4);       
        
        JLabel labelComentario = new JLabel ("Ver comentarios ("+arrCalif.size()+")");
        res4.gridx=1;
        res4.gridy=1;
        res4.gridwidth=1;
        panelEstrellas.add(labelComentario,res4);    
        labelComentario.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseEntered(MouseEvent e) {
              
                labelComentario.setForeground(Color.ORANGE);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                labelComentario.setForeground(Color.BLACK);
            }
            
             @Override
            public void mouseClicked(MouseEvent e) {
                String nombre= viaje.getConductor().getApellido()+ " "+viaje.getConductor().getNombre();
                VentanaComentarios ventanaC = new VentanaComentarios(arrCalif,nombre);
                ventanaC.setVisible(true);
                
            }
        });


//-------------------botones--------------------------------------------   
       
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,40,0));
        //panelBotones.setBackground(Color.WHITE);
        
        Boton botonSumarse=new Boton("SUMARSE");
        panelBotones.add(botonSumarse);
        
        if (cantAsientoDisponible == 0)
            botonSumarse.setEnabled(false);
        
        botonSumarse.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                int idUsuarioActual= usuarioActual.getId_usuario();
                if((v.existeUsuarioEnViaje(id, idUsuarioActual)) && true)
                    JOptionPane.showMessageDialog(null, "Ya estas sumado en el viaje!", "Error al sumarse en el viaje", JOptionPane.WARNING_MESSAGE);
                else{
                    v.insertarUsuarioEnViaje(id,idUsuarioActual,auto.getId_auto());
                    JOptionPane.showMessageDialog(null,"Ya estas sumado al viaje! En breve te llegará un mail con los detalles del viaje","Operación realizada correctamente",JOptionPane.INFORMATION_MESSAGE);
                    //self.setVisible(false);
                }
            }
        });
        
        
     
        
        Boton botonVolver=new Boton("VOLVER");
        panelBotones.add(botonVolver);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                 VentanaViajes viajes = new VentanaViajes(usuarioActual);
                 viajes.setVisible(true);
                 self.setVisible(false);
                
            }
        });
     
        
        //-----------titulo
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=GridBagConstraints.RELATIVE;
        res.weightx=0;
        res.weighty=1;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(0,0,0,0);
        this.add(panelTitulo,res);


        //--------detalles del viaje1
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=1;
       // res.gridheight=GridBagConstraints.RELATIVE;
        res.weightx=0;
       // res.weighty=1;
        res.anchor = GridBagConstraints.EAST;//derecha
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,40,0,0);
        this.add(panelDetallesViajes1,res);
        
        
      
        
        //--------detalles del viaje2
        res.gridx=1;
        res.gridy=2;
        res.gridwidth=1;
        res.weightx=0.8;
     
        res.anchor = GridBagConstraints.EAST;//derecha
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0,0,0);
        this.add(panelDetallesViajes2,res);
        
        
               
        //--------Conductor
        res.gridx=2;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.weightx=0;
        res.anchor = GridBagConstraints.EAST;
        //res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0,0,40);
        this.add(panelConductor,res);
  
        //Panel Asientos disponibles
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.RELATIVE;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,40,0,0);
        this.add(panelAsientos,res);
        
         //Panel Estrellas
        res.gridx=2;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.weightx=0.3;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0,0,40);
       
        this.add(panelEstrellas,res);
        
          
        //Panel Botones
        res.gridx=0;
        res.gridy=4;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(10,0,0,0);
        this.add(panelBotones,res);
        
        
        
      
        
        
        
   
        
    }    
}


