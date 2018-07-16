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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;




public class VentanaMisViajes extends FrameManager {
    private int idViaje;
    private Date fechaPar;
    public VentanaMisViajes (Usuario u){
     
        super();
        final ViajeDB viajes = new ViajeDB();    
        final String[] nombreColumnas = {"Id","Salida","Origen","Destino","Lugar Salida","Marca","Modelo","Conductor","Tu calificacion","Tu comentario"};       
        final DefaultTableModel modTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
      
                return false;
            }
            
        };
        
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        JLabel labelq = new JLabel(" Viajes de "+u.getNombre());  
        labelq.setFont(new Font("Arial",3,20));
        labelq.setForeground(Color.black);
        labelq.setHorizontalAlignment(JLabel.CENTER);
        panelTitulo.add(labelq);
        
        //----- Listado de comentarios       
        JPanel panelViajes = new JPanel();
        GridBagLayout gBag3 = new GridBagLayout ();
        GridBagConstraints gRes3 = new GridBagConstraints ();
       panelViajes.setLayout(gBag3);
        panelViajes.setBackground(Color.white);
        TitledBorder borde1 = new TitledBorder("  Listado actualizado de viajes  ");
        borde1.setTitleFont(new Font("Arial",3,16));
        panelViajes.setBorder(borde1);
       
        
        String [][]arrViajes;
        int idUsuario = u.getId_usuario();
        arrViajes = viajes.getMisViajes(idUsuario);
         
        modTabla.setDataVector(arrViajes,nombreColumnas);
        JTable tablaViajes = new JTable(modTabla);
         tablaViajes.setPreferredScrollableViewportSize(new Dimension(300,300));
         //------------oculto la primer columna del id-------------------------ale
            tablaViajes.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaViajes.getColumnModel().getColumn(0).setMinWidth(0);
            tablaViajes.getColumnModel().getColumn(0).setPreferredWidth(0);
            //------------------------------------------------------------------------
       
        tablaViajes.setPreferredScrollableViewportSize(new Dimension(300, 300));
        tablaViajes.setAutoResizeMode (JTable.AUTO_RESIZE_OFF); 
        TableColumn col;
        int ancho;
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        tablaViajes.setRowHeight(25);
         // --- columna 1  fecha 
        col = tablaViajes.getColumnModel ().getColumn(1);
        ancho = 80;  
        col.setPreferredWidth (ancho);
        tablaViajes.getColumnModel().getColumn(1).setCellRenderer(dtcr);    
        // --- columna 2 origen
        col = tablaViajes.getColumnModel ().getColumn(2);
        ancho = 80;  
        col.setPreferredWidth (ancho);
        tablaViajes.getColumnModel().getColumn(2).setCellRenderer(dtcr);     
        // --- columna 3 destino
        col = tablaViajes.getColumnModel ().getColumn(3);
        ancho = 80;  
        col.setPreferredWidth (ancho);
        tablaViajes.getColumnModel().getColumn(3).setCellRenderer(dtcr);     
        // --- columna 4 lugar Salida
        col = tablaViajes.getColumnModel ().getColumn(4);
        ancho = 100;  
        col.setPreferredWidth (ancho);
        tablaViajes.getColumnModel().getColumn(4).setCellRenderer(dtcr);     
        // --- columna 5 marca
        col = tablaViajes.getColumnModel ().getColumn(5);
        ancho = 90;  
        col.setPreferredWidth (ancho);
        tablaViajes.getColumnModel().getColumn(5).setCellRenderer(dtcr);     
         // --- columna 6 modelo
        col = tablaViajes.getColumnModel ().getColumn(6);
        ancho = 120;  
        col.setPreferredWidth (ancho);
        tablaViajes.getColumnModel().getColumn(6).setCellRenderer(dtcr); 
         // --- columna 7 conductor
        col = tablaViajes.getColumnModel ().getColumn(7);
        ancho = 100;  
        col.setPreferredWidth (ancho);
        tablaViajes.getColumnModel().getColumn(7).setCellRenderer(dtcr); 
         // --- columna 8 calificacion
        col = tablaViajes.getColumnModel ().getColumn(8);
        ancho = 60;  
        col.setPreferredWidth (ancho);
        tablaViajes.getColumnModel().getColumn(8).setCellRenderer(dtcr); 
         // --- columna 9
        col = tablaViajes.getColumnModel ().getColumn(9);
        ancho = 200;  
        col.setPreferredWidth (ancho);
        dtcr.setHorizontalAlignment(SwingConstants.LEFT);
        tablaViajes.getColumnModel().getColumn(9).setCellRenderer(dtcr); 
        
       gRes3.gridx=0;
        gRes3.gridy=1;
        gRes3.weightx=1;
        gRes3.weighty=1;
        //gRes3.anchor = GridBagConstraints.NORTH;
        gRes3.fill = GridBagConstraints.BOTH;
        gRes3.insets = new Insets(0,0,10,0);
        
        panelViajes.add(new JScrollPane(tablaViajes),gRes3);
       
        tablaViajes.addMouseListener(new MouseAdapter(){
          
        @Override
            public void mouseClicked(MouseEvent e) {
           
                //tablaViajes.getSelectedRows()
                String id=String.valueOf(tablaViajes.getValueAt(tablaViajes.getSelectedRow(), 0));
                idViaje=Integer.parseInt(id);
            
             }
                           
               
        });
        
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
        Boton botonCalificar=new Boton("CALIFICAR VIAJE");
        panelBotones.add(botonCalificar);
        Boton botonEditar=new Boton("EDITAR VIAJE");
        panelBotones.add(botonEditar);
        Boton botonRetirarse=new Boton("RETIRARSE VIAJE");
        panelBotones.add(botonRetirarse);
        Boton botonVolver=new Boton("VOLVER");
        panelBotones.add(botonVolver);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                    VentanaViajes viajes = new VentanaViajes(u);
                     viajes.setVisible(true);
                     self.setVisible(false);
                
            }
        });
        
        botonRetirarse.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                    
                    ViajeDB v = new ViajeDB();
                    Viaje viaje = v.getViajeUsuario(idViaje);
                    Usuario conductor = viaje.getConductor();
                    if (conductor.getId_usuario() == u.getId_usuario()){
                         JOptionPane.showMessageDialog(null, "Solo pueden retirarse pasajeros","Acción no válida", JOptionPane.WARNING_MESSAGE);
                        
                    }
                    else{
                        v.retirarseViaje(u.getId_usuario(), idViaje);
                        JOptionPane.showMessageDialog(self, "Ya has sido retirado de este viaje");
                    }
                        
                
            }
        });
        
        
        botonCalificar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                ViajeDB v = new ViajeDB();
                Viaje viaje = v.getViajeUsuario(idViaje);
                Calendar fecha = new GregorianCalendar();
                fechaPar=viaje.getFechaPartida();
                Date f = fecha.getTime();
                System.out.println(f);
                System.out.println(fechaPar);
                //Date fechaPar= viaje.getFechaPartida();
                if (fechaPar.after(f)){
                  JOptionPane.showMessageDialog(null, "Aún no se ha realizado este viaje","No se puede calificar" , JOptionPane.WARNING_MESSAGE);
                }
                else{
                
                    VentanaCalificarViaje cv = new VentanaCalificarViaje(u,idViaje);
                     cv.setVisible(true);
                     //self.setVisible(false);
                }
            }
        });
        
        botonEditar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                AutoDB a =new AutoDB(); 
                ArrayList<Auto> arrAutos = new ArrayList<Auto>();
                arrAutos=a.ObtenerAutosUsuario(u.getId_usuario());
                 if (arrAutos.size()>0){
                   
                            ViajeDB v = new ViajeDB();
                            Viaje viaje = v.getViajeUsuario(idViaje);
                            Calendar fecha = new GregorianCalendar();
                            fechaPar=viaje.getFechaPartida();
                            Date f = fecha.getTime();
                            System.out.println(f);
                            System.out.println(fechaPar);
                            //Date fechaPar= viaje.getFechaPartida();
                            if (fechaPar.before(f)){
                              JOptionPane.showMessageDialog(null, "No se puede editar este viaje","Viaje ya realizado" , JOptionPane.WARNING_MESSAGE);
                            }
                            else{

                                VentanaEditarViaje cv = new VentanaEditarViaje(u,viaje);
                                 cv.setVisible(true);
                                 self.setVisible(false);
                            }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null, "No tiene permiso para editar los datos de este viaje","Acción no válida" , JOptionPane.WARNING_MESSAGE);
                    }
            }    
        });
        
        
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(0,40,0,0);
        this.add(panelTitulo,res);
        
   
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,40,30,40);
        this.add(panelViajes,res);
        
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(20,40,0,40);
        this.add(panelBotones,res);
        
    }

    public Object[][] cargarTabla(ArrayList<Calificacion> calificaciones){
        UsuarioDB u = new UsuarioDB();
        int max= calificaciones.size();
        Object[][] datos= new Object[max+10][3];    
        int i=0;
        for(Calificacion cAux : calificaciones){
               Usuario usuario = u.getUnUsuario(calificaciones.get(i).getIdUsuario());
               datos[i][0]=usuario.getNombre() +" "+usuario.getApellido();
               datos[i][1]=cAux.getPuntuacion();
               datos[i][2]=cAux.getComentario();
               i++;
            
        }
        
        return datos;
        
    }


}