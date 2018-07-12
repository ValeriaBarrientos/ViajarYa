/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Auto;
import ViajarDB.AutoDB;
import ViajarDB.Ciudad;
import ViajarDB.CiudadDB;
import ViajarDB.Usuario;
import ViajarDB.Viaje;
import ViajarDB.ViajeDB;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author vale2
 */

    
 
public class VentanaEditarViaje extends FrameManager{
    
    
    
    public VentanaEditarViaje(Usuario u,Viaje v){
        
         super();
        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        VentanaEditarViaje self = this;
       
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel labelq = new JLabel("Editar Viaje ");  
        labelq.setFont(new Font("Verdana",5,22));
        labelq.setForeground(Color.black);
        labelq.setHorizontalAlignment(JLabel.CENTER);
        panelTitulo.add(labelq);
        
        
        JPanel panelDatosViaje = new JPanel();
        GridBagLayout gBag1 = new GridBagLayout ();
        GridBagConstraints res1 = new GridBagConstraints ();
        panelDatosViaje.setLayout(gBag1);
        panelDatosViaje.setBackground(Color.white);
        TitledBorder borde1 = new TitledBorder(" Detalle ");
        borde1.setTitleFont(new Font("Arial",3,16));
        panelDatosViaje.setBorder(borde1);
       
        JLabel labelOrigen = new JLabel("Origen: ");
        labelOrigen.setFont(new Font("arial",3,12));
        labelOrigen.setForeground(Color.BLACK);
        labelOrigen.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 0;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(labelOrigen,res1);
       
        CiudadDB ciudadMg = new CiudadDB();  
        JComboBox comboOrigen = new JComboBox();
	JComboBox comboDestino = new JComboBox();
        comboOrigen.setBackground(Color.WHITE);
        comboDestino.setBackground(Color.WHITE);
        Iterator<Ciudad> it = ciudadMg.getCiudades().iterator();
        ArrayList <String> aux = new ArrayList<String>();
        //comboOrigen.addItem("Seleccione ciudad");
        //comboDestino.addItem("Seleccione ciudad");
        comboOrigen.addItem(v.getOrigen());
        comboDestino.addItem(v.getDestino());
        for (Ciudad nombre : ciudadMg.getCiudades()) {
            String nom = (nombre.getNombre());
            comboOrigen.addItem(nom);
            comboDestino.addItem(nom);
            
        }
        res1.gridx = 1;
        res1.gridy = 0;
        res1.gridwidth = GridBagConstraints.RELATIVE;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(comboOrigen,res1);
        
        
        
        JLabel labelDestino = new JLabel("Destino: ");
        labelDestino.setFont(new Font("arial",3,12));
        labelDestino.setForeground(Color.BLACK);
        labelDestino.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 1;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(labelDestino,res1);
       
        
        res1.gridx = 1;
        res1.gridy = 1;
        res1.gridwidth = GridBagConstraints.RELATIVE;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(comboDestino,res1);
        
        
        JLabel labelGastos = new JLabel("Gastos Aproximados: ");
        labelGastos.setFont(new Font("arial",3,12));
        labelGastos.setForeground(Color.BLACK);
        labelGastos.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 2;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(labelGastos,res1);
       
        JTextField textGastos = new JTextField(String.valueOf(v.getGastosaproximados()));
        textGastos.setColumns(15);
        res1.gridx = 1;
        res1.gridy = 2;
        res1.gridwidth = GridBagConstraints.RELATIVE;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(textGastos,res1);
        
        
        JLabel labelFechaSalida = new JLabel("Fecha de salida: ");
        labelFechaSalida.setFont(new Font("arial",3,12));
        labelFechaSalida.setForeground(Color.BLACK);
        labelFechaSalida.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 3;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(labelFechaSalida,res1);
       
        JDateChooser FechaSalida = new JDateChooser(v.getFechaPartida());
        res1.gridx = 1;
        res1.gridy = 3;
        res1.gridwidth = GridBagConstraints.RELATIVE;
        res1.insets = new Insets(5,0,10,0);
        res1.ipadx = 20;
        panelDatosViaje.add(FechaSalida,res1);
        
        JLabel labelHoraSalida = new JLabel("Horario de salida: ");
        labelHoraSalida.setFont(new Font("arial",3,12));
        labelHoraSalida.setForeground(Color.BLACK);
        labelHoraSalida.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 4;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(labelHoraSalida,res1);
       
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner spinnerHoraSalida = new JSpinner(dateModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinnerHoraSalida, "HH:mm:ss");
        spinnerHoraSalida.setEditor(timeEditor);
        spinnerHoraSalida.setValue(v.getHoraPartida());
        res1.gridx = 1;
        res1.gridy = 4;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(spinnerHoraSalida,res1);
        
        JLabel labelLugar = new JLabel("Lugar de Salida: ");
        labelLugar.setFont(new Font("arial",3,12));
        labelLugar.setForeground(Color.BLACK);
        labelLugar.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 5;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(labelLugar,res1);
       
         JTextField textLugar = new JTextField(v.getLugar_salida());
        textLugar.setColumns(15);
        res1.gridx = 1;
        res1.gridy = 5;
        res1.gridwidth = GridBagConstraints.RELATIVE;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(textLugar,res1);
        
        
        JLabel labelMascota = new JLabel("Acepta Mascota?: ");
        labelMascota.setFont(new Font("arial",3,12));
        labelMascota.setForeground(Color.BLACK);
        labelMascota.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 6;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(labelMascota,res1);
        
        
        JComboBox comboMascota = new JComboBox();
        comboMascota.setBackground(Color.WHITE);
        comboMascota.addItem("Si");
        comboMascota.addItem("No");
        if (v.isMascota())
            comboMascota.setSelectedItem("Si");
        else
            comboMascota.setSelectedItem("No");
        
        res1.gridx = 1;
        res1.gridy = 6;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(comboMascota,res1);
        
        JLabel labelFumador = new JLabel("Se puede fumar?: ");
        labelFumador.setFont(new Font("arial",3,12));
        labelFumador.setForeground(Color.BLACK);
        labelFumador.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 7;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(5,0,10,0);
        panelDatosViaje.add(labelFumador,res1);
       
        JComboBox comboFumador = new JComboBox();
        comboFumador.setBackground(Color.WHITE);
        comboFumador.addItem("No");
        comboFumador.addItem("Si");
        if (v.isFumador())
            comboFumador.setSelectedItem("Si");
        else
            comboFumador.setSelectedItem("No");
        
        
        
        res1.gridx = 1;
        res1.gridy = 7;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(10,0,10,0);
        panelDatosViaje.add(comboFumador,res1);
        
     
         
        JLabel labelAuto = new JLabel("Automovil: ");
        labelAuto.setFont(new Font("arial",3,14));
        labelAuto.setForeground(Color.BLACK);
        labelAuto.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx = 0;
        res1.gridy = 8;
        res1.gridwidth =1;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(10,0,10,0);
        panelDatosViaje.add(labelAuto,res1);
        
       
       
       
       
        AutoDB autodb = new AutoDB();  
        JComboBox comboAutos = new JComboBox();
        comboAutos.setBackground(Color.WHITE); 
        ArrayList<Auto> arrAutos = new ArrayList<Auto>();
        arrAutos=autodb.ObtenerAutosUsuario(u.getId_usuario());
        if (arrAutos.size()>0){
            for (Auto a : arrAutos) {
                String nom = (a.getMarca()+" "+a.getModelo()+" - Dominio: "+a.getPatente());
                comboAutos.addItem(nom);
            }
            
        }
        else
            comboAutos.addItem("No tiene autos registrados");
        
        comboAutos.setSelectedItem(autodb.getViajeAuto(v.getIdViaje()));                
        res1.gridx = 0;
        res1.gridy = 9;
        res1.gridwidth =GridBagConstraints.REMAINDER;
        res1.anchor = GridBagConstraints.WEST;
        res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(10,0,10,0);
        panelDatosViaje.add(comboAutos,res1);
        
        
        //-------------------botones--------------------------------------------   
       
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,120,0));   
        Boton botonActualizar=new Boton("ACTUALIZAR");
        panelBotones.add(botonActualizar);
        Boton botonVolver=new Boton("VOLVER");
        panelBotones.add(botonVolver);
        
         botonActualizar.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                
                ViajeDB vDB = new ViajeDB();
                String origen = (String)comboOrigen.getItemAt(comboOrigen.getSelectedIndex());
                String destino = (String)comboDestino.getItemAt(comboOrigen.getSelectedIndex());
                Double gastosAux = Double.parseDouble(textGastos.getText());  
                double gastos = gastosAux;
               // Date fechaSa = FechaSalida.getDate();
                //Date horaSa =  (Date) spinnerHoraSalida.getValue();
                //System.out.println(horaSa);
                java.util.Date fechaSa =  FechaSalida.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String fechaSalida = sdf.format(fechaSa);
                java.util.Date horaSa = (Date) spinnerHoraSalida.getValue();
                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
                String horaSalida = sdf1.format(horaSa);
                
                String lugar = textLugar.getText();
                
                int mascota;
                if (((String)comboMascota.getItemAt(comboMascota.getSelectedIndex())).equals("si")){
                    mascota=1;
                }
                else
                    mascota=0;
                
                int fumador;
                if (((String)comboFumador.getItemAt(comboFumador.getSelectedIndex())).equals("si")){
                    fumador=1;
                }
                else
                    fumador=0;
                
                Calendar fecha = new GregorianCalendar();
                int anio = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH);
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                
                String a =String.valueOf(anio);
                String m =String.valueOf(mes);
                String d =String.valueOf(dia);
                String hoy = (a +"-");
                hoy= hoy +m+"-";
                hoy=hoy+d;
                System.out.println("hoy  "+hoy);
               
                java.util.Date fechahoy=fecha.getTime();
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-mm-dd");
                formateador.format(fechahoy);
              
                System.out.println("fechahoy  "+fechahoy);
                /* java.util.Date fechahoy = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-mm-dd");
                formateador.format(fechahoy);
                System.out.println("fechahoy  "+fechahoy);*/
                String fechayHoraPartida=fechaSalida+" "+horaSalida;
                vDB.updateViaje(v.getIdViaje(),origen, destino,gastos,fechayHoraPartida,lugar, mascota,fumador,hoy);
                v.setOrigen(origen);
                v.setDestino(destino);
                v.setGastosaproximados(gastos);
                v.setFechaPartida(fechaSa);
                v.setHoraPartida(horaSa);
                v.setLugar_salida(lugar);
                if (mascota==1)
                    v.setMascota(true);
                else
                     v.setMascota(false);
                
                if (fumador==1)
                    v.setFumador(true);
                else
                     v.setFumador(false);
                
                v.setFecha_creacion(fechahoy);
                JOptionPane.showMessageDialog(self,"Sus datos han sido actualizados");
                
            }
        });
        
        
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                 
                VentanaViajes viajes = new VentanaViajes(u);
                 viajes.setVisible(true);
                 self.setVisible(false);
                
            }
        });
        
        


//-----panel Titulo
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.RELATIVE;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0,0,0);
        this.add(panelTitulo,res);
        
//------panel Detalle de nuevo viaje
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,180,0,180);
        //res.ipady = 40;
        //res.ipadx = 40;
        this.add(panelDatosViaje,res);
            
     
//------panel Botones
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(15,0,0,0);
        res.ipady = 0;
        this.add(panelBotones,res);     
        
        
        
        
        
    }
    
    
    
    
    
}

    

