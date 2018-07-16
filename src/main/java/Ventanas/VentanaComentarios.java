/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


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
/**
 *
 * @author alejandro
 */
public class VentanaComentarios extends FrameManager {
    
    public VentanaComentarios (ArrayList<Calificacion> calificaciones, String nombreUsuario){
     
        final String[] nombreColumnas = {"Usuario","Puntuacion","Comentario"};       
        final DefaultTableModel modTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
      
                return false;
            }
            
        };
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        JLabel labelq = new JLabel(" Comentarios sobre  "+nombreUsuario);  
        labelq.setFont(new Font("Arial",3,20));
        labelq.setForeground(Color.black);
        labelq.setHorizontalAlignment(JLabel.CENTER);
        panelTitulo.add(labelq);
        
        //----- Listado de comentarios       
        JPanel panelListaComentarios = new JPanel();
        GridBagLayout gBag3 = new GridBagLayout ();
        GridBagConstraints gRes3 = new GridBagConstraints ();
       panelListaComentarios.setLayout(gBag3);
        panelListaComentarios.setBackground(Color.white);
        TitledBorder borde1 = new TitledBorder("  Listado actualizado de calificaciones  ");
        borde1.setTitleFont(new Font("Arial",3,16));
        panelListaComentarios.setBorder(borde1);
        
         
        modTabla.setDataVector(cargarTabla(calificaciones),nombreColumnas);
        JTable tablaComentario = new JTable(modTabla);
        tablaComentario.setPreferredScrollableViewportSize(new Dimension(300, 300));
        
        tablaComentario.setAutoResizeMode (JTable.AUTO_RESIZE_OFF); 
        TableColumn col;
        int ancho;
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        tablaComentario.setRowHeight(25);
        // --- columna 1   
        col = tablaComentario.getColumnModel ().getColumn(0);
        ancho = 250;  
        col.setPreferredWidth (ancho);
        
        tablaComentario.getColumnModel().getColumn(0).setCellRenderer(dtcr);    
        // --- columna 2
        col = tablaComentario.getColumnModel ().getColumn(1);
        ancho = 150;  
        col.setPreferredWidth (ancho);
        tablaComentario.getColumnModel().getColumn(1).setCellRenderer(dtcr);     
        // --- columna 3
        col = tablaComentario.getColumnModel ().getColumn(2);
        ancho = 600;  
        col.setPreferredWidth (ancho);
        tablaComentario.getColumnModel().getColumn(2).setCellRenderer(dtcr);     
       
       gRes3.gridx=0;
        gRes3.gridy=1;
        gRes3.weightx=1;
        gRes3.weighty=1;
        //gRes3.anchor = GridBagConstraints.NORTH;
        gRes3.fill = GridBagConstraints.BOTH;
        gRes3.insets = new Insets(0,0,10,0);
        
        panelListaComentarios.add(new JScrollPane(tablaComentario),gRes3);
       
        JPanel panelBotones = new JPanel();
        Boton botonVolver=new Boton("VOLVER");
        panelBotones.add(botonVolver);
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                     self.setVisible(false);
                
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
        this.add(panelListaComentarios,res);
        
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