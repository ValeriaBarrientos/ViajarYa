/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Auto;
import ViajarDB.AutoDB;
import ViajarDB.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class VentanaMiAuto extends FrameManager{
    private String[] nombreColumnas;
    final AutoDB autos = new AutoDB();
    /*
    Esta ventana mostrara el listado de autos que tengo
    y la posibilidad de agregar, editar y eliminar un auto
    */
    
    public Object[][] cargarTabla(ArrayList<Auto> arrAutos){
        
        int max= arrAutos.size();
        Object[][] datos= new Object[max][11];    
        int i=0;
        for(Auto vAux : arrAutos){
            if(vAux.isCuenta())    
            {
               datos[i][0]=vAux.getId_auto();
               datos[i][1]=vAux.getMarca();
               datos[i][2]=vAux.getModelo();
               datos[i][3]=vAux.getColor();
               datos[i][4]=vAux.getCombustible();
               datos[i][5]=vAux.getPatente();
               if (vAux.isAire_acondicionado())
                   datos[i][6]="Si";
               else
                   datos[i][6]="No";
               if (vAux.isCalefaccion())
                   datos[i][7]="Si";
               else
                   datos[i][7]="No";
               datos[i][8]=vAux.getCantidad_de_asientos();
               datos[i][9]=vAux.getCalificacion();
               datos[i][10]=vAux.getCapacidad_baul();
            }
               
            i++;
            
        }
        
        return datos;
        
    }
    
    public VentanaMiAuto(Usuario u){
        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        VentanaMiAuto self = this;
            
        final String[] nombreColumnas = {"id","Marca","Modelo","Color","Combustible","Patente","Aire","Calefacción","Cantidad de asientos","Calificación","Baul"};       
        final DefaultTableModel modTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
      
                return false;
            }
            
        };
        JTable tablaAutos = new JTable(modTabla);
        ArrayList <Auto> arrAutos = new ArrayList<>(); 
        arrAutos=autos.ObtenerAutosUsuario(u.getId_usuario());
        modTabla.setDataVector(cargarTabla(arrAutos),nombreColumnas);
             //------------oculto la primer columna del id-------------------------ale
        tablaAutos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAutos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaAutos.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaAutos.setPreferredScrollableViewportSize(new Dimension(650, 200));
        
        
        JPanel panelListar = new JPanel();
        GridBagLayout gBag = new GridBagLayout ();
        GridBagConstraints gRes = new GridBagConstraints ();
        panelListar.setLayout(gBag);
        panelListar.setBackground(Color.white);
        TitledBorder borde = new TitledBorder("Listado de mis autos:");
        borde.setTitleFont(new Font("Arial",3,22));
        panelListar.setBorder(borde);
        
        GridBagConstraints gRes3 = new GridBagConstraints ();
        gRes3.gridx=0;
        gRes3.gridy=1;
        gRes3.weightx=1;
        gRes3.weighty=1;
        //gRes3.anchor = GridBagConstraints.NORTH;
        gRes3.fill = GridBagConstraints.BOTH;
        gRes3.insets = new Insets(20,0,5,0);
        panelListar.add(new JScrollPane(tablaAutos),gRes3);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
   
        Boton botonAgregarAuto=new Boton("Agregar Auto");
        botonAgregarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonAgregarAuto);
        panelBotones.add (Box.createRigidArea (new Dimension (15,15)));
        Boton botonEditarAuto=new Boton("Editar Auto");
        botonEditarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonEditarAuto);
         panelBotones.add (Box.createRigidArea (new Dimension (15,15)));
        Boton botonEliminarAuto=new Boton("Eliminar Auto");
        botonEliminarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonEliminarAuto);
        // panel inferior
        JPanel panelInferior = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
   
        Boton botonVolver=new Boton("Volver");
        botonVolver.setAlignmentX (panelInferior.CENTER_ALIGNMENT);
        panelInferior.add(botonVolver);
        panelInferior.add (Box.createRigidArea (new Dimension (15,15)));
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaViajes viajes = new VentanaViajes(u);
                viajes.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        botonAgregarAuto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaAuto va=new VentanaAuto(u);
                va.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        botonEditarAuto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                
                VentanaEditAuto va=new VentanaEditAuto(u,autos.ObtenerAutosUsuario(u.getId_usuario()));
                va.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        
        botonEliminarAuto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaDeleteAuto elimAuto = new VentanaDeleteAuto(u,autos.ObtenerAutosUsuario(u.getId_usuario()));
                elimAuto.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        //----Listar Autos
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
        
        // panel de botones
        res.gridx=1;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,10,0,10);
        this.add(panelBotones,res);
        
        // panel inferior
        res.gridx=1;
        res.gridy=2;
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
