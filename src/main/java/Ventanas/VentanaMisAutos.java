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
import java.awt.FlowLayout;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VentanaMisAutos extends FrameManager{
    private String[] nombreColumnas;
    final AutoDB autos = new AutoDB();
    private int idAuto;
    private Auto auto;
    private JComboBox comboListaAutos;
    private JTextField textMarca;
    private JTextField textModelo;
    private JTextField textColor;
    private JComboBox comboCombustible;
    private JTextField textCombustible;
    private JTextField textPatente;
    private JComboBox comboAire;
    private JTextField textAire;
    private JComboBox comboCalefaccion;
    private JTextField textCantAsientos;
    private JComboBox comboCalificacion;
    private JComboBox comboBaul;
    private JTextField textCalefaccion;
    private JTextField textCantidad;
    private JTextField textBaul;
    private JTextField textCalificacion;
    private int aux;
    
    
    /*
    Esta ventana mostrara el listado de autos que tengo
    y la posibilidad de agregar, editar y eliminar un auto
    */
    
   
    
    public VentanaMisAutos(Usuario u){
        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        VentanaMisAutos self = this;
            
        final String[] nombreColumnas = {"id","Marca","Modelo","Color","Combustible","Patente","Aire","Calefacción","Cantidad de asientos","Calificación","Baul"};       
        final DefaultTableModel modTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
      
                return false;
            }
            
        };
        
        
        JPanel panelListar = new JPanel();
        GridBagLayout gBag = new GridBagLayout ();
        GridBagConstraints gRes = new GridBagConstraints ();
        panelListar.setLayout(gBag);
        panelListar.setBackground(Color.white);
        TitledBorder borde = new TitledBorder("Listado de mis autos:");
        borde.setTitleFont(new Font("Arial",3,22));
        panelListar.setBorder(borde);
        
        
        JTable tablaAutos = new JTable(modTabla);
        ArrayList <Auto> arrAutos = new ArrayList<>(); 
        arrAutos=autos.ObtenerAutosUsuario(u.getId_usuario());
        
        if (arrAutos.size()> 0){
                modTabla.setDataVector(cargarTabla(arrAutos),nombreColumnas);
                     //------------oculto la primer columna del id-------------------------ale
                tablaAutos.getColumnModel().getColumn(0).setMaxWidth(0);
                tablaAutos.getColumnModel().getColumn(0).setMinWidth(0);
                tablaAutos.getColumnModel().getColumn(0).setPreferredWidth(0);
                tablaAutos.setPreferredScrollableViewportSize(new Dimension(650, 200));

               tablaAutos.setAutoResizeMode (JTable.AUTO_RESIZE_OFF); 
                TableColumn col;
                int ancho;
                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setHorizontalAlignment(SwingConstants.LEFT);
                tablaAutos.setRowHeight(18);

                // --- columna 1   
                col = tablaAutos.getColumnModel ().getColumn(1);
                ancho = 100;  
                col.setPreferredWidth (ancho);
                tablaAutos.getColumnModel().getColumn(1).setCellRenderer(dtcr);    
                // --- columna 2  
                col = tablaAutos.getColumnModel ().getColumn(2);
                ancho = 180;  
                col.setPreferredWidth (ancho);
                tablaAutos.getColumnModel().getColumn(2).setCellRenderer(dtcr);    
        
                GridBagConstraints gRes3 = new GridBagConstraints ();
                gRes.gridx=0;
                gRes.gridy=1;
                gRes.weightx=1;
                gRes.weighty=1;
                //gRes3.anchor = GridBagConstraints.NORTH;
                gRes.fill = GridBagConstraints.BOTH;
                gRes.insets = new Insets(20,0,0,0);
                panelListar.add(new JScrollPane(tablaAutos),gRes);
        }
        else{
                
                 JLabel labelNoAutos=new JLabel(" NO TIENE AUTOS REGISTRADOS");
                labelNoAutos.setHorizontalAlignment(JLabel.LEFT);
                gRes.gridx=0;
                gRes.gridy=0;
                gRes.gridwidth=1;
                //resa1.anchor = GridBagConstraints.EAST;
                gRes.fill = GridBagConstraints.HORIZONTAL;
                gRes.insets = new Insets(10,0,10,0);
                panelListar.add(labelNoAutos,gRes);
                
                
         }       
                

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        //panelBotones.setBackground(Color.WHITE);
        Boton botonAgregarAuto=new Boton("Agregar Auto");
        botonAgregarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonAgregarAuto);
        panelBotones.add (Box.createRigidArea (new Dimension (15,15)));
       // Boton botonEditarAuto=new Boton("Actualizar Datos");
       // botonEditarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        //panelBotones.add(botonEditarAuto);
        // panelBotones.add (Box.createRigidArea (new Dimension (15,15)));
        Boton botonEliminarAuto=new Boton("Eliminar Auto");
        botonEliminarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonEliminarAuto);
       // Boton botonVolver=new Boton("Volver");
      //  panelBotones.add(botonVolver);

// panel inferior
        
        JPanel panelInferior = new JPanel();
        //panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 100,0));
        Boton botonActualizar=new Boton("Actualizar");
       // botonEditarAuto.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelInferior.add(botonActualizar);
        Boton botonVolver=new Boton("Volver");
       // botonVolver.setAlignmentX (panelInferior.CENTER_ALIGNMENT);
        panelInferior.add(botonVolver);
       // panelInferior.add (Box.createRigidArea (new Dimension (15,15)));
      
        
         //-----------------datos del auto---------------------------------------
       
       
        
        
        
        JPanel panelDetalleAuto1 = new JPanel();
        GridBagLayout gBaga1 = new GridBagLayout ();
        GridBagConstraints resa1 = new GridBagConstraints ();
        panelDetalleAuto1.setLayout(gBaga1);
        panelDetalleAuto1.setBackground(Color.WHITE);
        
        JLabel labelMarca=new JLabel("Marca: ");
        labelMarca.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=0;
        resa1.gridwidth=1;
        //resa1.anchor = GridBagConstraints.EAST;
        resa1.fill = GridBagConstraints.HORIZONTAL;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelMarca,resa1);
        JTextField textMarca=new JTextField("                                              ");
      //  textMarca.setHorizontalAlignment(JTextField.LEFT);
        resa1.gridx=1;
        resa1.gridy=0;
        resa1.gridwidth= GridBagConstraints.REMAINDER;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(textMarca,resa1);
      
        
        JLabel labelModelo=new JLabel("Modelo: ");
        labelModelo.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=1;
        resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelModelo,resa1);
        JTextField textModelo=new JTextField("");
        resa1.gridx=1;
        resa1.gridy=1;
        resa1.gridwidth=GridBagConstraints.REMAINDER;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(textModelo,resa1);
       
        JLabel labelColor=new JLabel("Color: ");
        labelColor.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=2;
        resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelColor,resa1);
        JTextField textColor=new JTextField("");
        resa1.gridx=1;
        resa1.gridy=2;
        //resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(textColor,resa1);
       
        
        JLabel labelCombustible=new JLabel("Combustible: ");
        labelCombustible.setHorizontalAlignment(JLabel.LEFT);
        resa1.gridx=0;
        resa1.gridy=3;
        resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(labelCombustible,resa1);
        JTextField textCombustible=new JTextField("             ");
        resa1.gridx=1;
        resa1.gridy=3;
       // resa1.gridwidth=1;
        resa1.insets = new Insets(10,0,10,0);
        panelDetalleAuto1.add(textCombustible,resa1);
        
       
        JPanel panelDetalleAuto2 = new JPanel();
        GridBagLayout gBaga2 = new GridBagLayout ();
        GridBagConstraints resa2 = new GridBagConstraints ();
        panelDetalleAuto2.setLayout(gBaga2);
        panelDetalleAuto2.setBackground(Color.WHITE);
        //TitledBorder borde3 = new TitledBorder("");
        //borde3.setTitleFont(new Font("Arial",3,14));
       // panelDetalleAuto2.setBorder(borde3);
        
        
        
        JLabel labelAire=new JLabel("Aire acondicionado:");
        labelAire.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=0;
        resa2.gridwidth=1;
        resa2.anchor = GridBagConstraints.EAST;
        resa2.fill = GridBagConstraints.HORIZONTAL;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelAire,resa2);
       /* String aire=String.valueOf(auto.isAire_acondicionado());
        if (aire.equals("true")){
            aire="Si";
        }
        else{
            aire="No";
        }*/
        JTextField textAire=new JTextField("               ");
        resa2.gridx=1;
        resa2.gridy=0;
        resa2.gridwidth=GridBagConstraints.REMAINDER;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(textAire,resa2);
        
        
        JLabel labelCalefaccion=new JLabel("Calefaccion:");
        labelCalefaccion.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=1;
        resa2.gridwidth=1;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelCalefaccion,resa2);
       /* String calefa=String.valueOf(auto.isCalefaccion());
        if (calefa.equals("true")){
            calefa="Si";
        }
        else{
            calefa="No";
        }*/
        JTextField textCalefaccion=new JTextField("             ");
        resa2.gridx=1;
        resa2.gridy=1;
        resa2.gridwidth=GridBagConstraints.REMAINDER;;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(textCalefaccion,resa2);
       
        
        JLabel labelCantidad=new JLabel("Cantidad de Asientos: ");
        labelCantidad.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=2;
        resa2.gridwidth=1;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelCantidad,resa2);
        JTextField textCantidad=new JTextField("               ");
        resa2.gridx=1;
        resa2.gridy=2;
        resa2.gridwidth=GridBagConstraints.REMAINDER;;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(textCantidad,resa2);
        
        JLabel labelBaul=new JLabel("Capacidad Baul: ");
        labelBaul.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=3;
        resa2.gridwidth=1;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelBaul,resa2);
        JTextField textBaul=new JTextField("                      ");
        resa2.gridx=1;
        resa2.gridy=3;
        resa2.gridwidth=GridBagConstraints.REMAINDER;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(textBaul,resa2);
        
        /*JLabel labelCalificacion=new JLabel("Calificacion: ");
        labelCalificacion.setHorizontalAlignment(JLabel.LEFT);
        resa2.gridx=0;
        resa2.gridy=4;
        resa2.gridwidth=1;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(labelCalificacion,resa2);
        JTextField textCalificacion=new JTextField("                ");
        resa2.gridx=1;
        resa2.gridy=4;
        resa2.gridwidth=GridBagConstraints.REMAINDER;
        resa2.insets = new Insets(10,0,10,0);
        panelDetalleAuto2.add(textCalificacion,resa2);*/
         
        
        JPanel panelDetalleAuto3 = new JPanel();
        panelDetalleAuto3.setLayout(new FlowLayout(FlowLayout.CENTER, 100,0));
        panelDetalleAuto3.setBackground(Color.WHITE);
        JLabel labelCalificacion=new JLabel("Calificacion: ");
        labelCalificacion.setHorizontalAlignment(JLabel.CENTER);
        
        panelDetalleAuto3.add(labelCalificacion);
        JTextField textCalificacion=new JTextField("                 ");
        panelDetalleAuto3.add(textCalificacion);
        
        
        
        
        
        JPanel panelDetalleAuto = new JPanel();
        GridBagLayout gBag2 = new GridBagLayout ();
        GridBagConstraints res2 = new GridBagConstraints ();
        panelDetalleAuto.setLayout(gBag2);
        panelDetalleAuto.setBackground(Color.WHITE);
        TitledBorder borde2 = new TitledBorder("Editar datos:");
        borde2.setTitleFont(new Font("Arial",3,14));
        panelDetalleAuto.setBorder(borde2);
        
        res2.gridx=0;
        res2.gridy=0;
        res2.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
       // res.weighty=0;
        res2.anchor = GridBagConstraints.WEST;
        res2.fill = GridBagConstraints.BOTH;
        res2.insets = new Insets(0,0,0,0);
       panelDetalleAuto.add(panelDetalleAuto1,res2);
       
        res2.gridx=1;
        res2.gridy=0;
        res2.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
       // res.weighty=0;
       res2.anchor = GridBagConstraints.EAST;
        res2.fill = GridBagConstraints.BOTH;
        res2.insets = new Insets(0,0,0,0);
       panelDetalleAuto.add(panelDetalleAuto2,res2);
        
       
        res2.gridx=0;
        res2.gridy=2;
        res2.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
       // res.weighty=0;
       // res2.anchor = GridBagConstraints.EAST;
        res2.fill = GridBagConstraints.BOTH;
        res2.insets = new Insets(10,0,0,0);
       panelDetalleAuto.add(panelDetalleAuto3,res2);
        
        
        tablaAutos.addMouseListener(new MouseAdapter(){
          
        @Override
            public void mouseClicked(MouseEvent e) {
                AutoDB a = new AutoDB();
                //auto=null;
                //tablaViajes.getSelectedRows()
                String id=String.valueOf(tablaAutos.getValueAt(tablaAutos.getSelectedRow(), 0));
                idAuto=Integer.parseInt(id);
                System.out.println("Auto"+idAuto);
                auto=a.ObtenerDatosAuto(idAuto);
               
                textMarca.setText(auto.getMarca());
                textModelo.setText(auto.getModelo());
                textColor.setText(auto.getColor());
                textCombustible.setText(auto.getCombustible());
                String aire=String.valueOf(auto.isAire_acondicionado());
                if (aire.equals("true")){
                    aire="Si";
                }
                else{
                    aire="No";
                }
                textAire.setText(aire);
                String calefa=String.valueOf(auto.isCalefaccion());
                if (calefa.equals("true")){
                    calefa="Si";
                }
                else{
                    calefa="No";
                }
                
                textCalefaccion.setText(calefa);
                textCantidad.setText(String.valueOf(auto.getCantidad_de_asientos()));
                textBaul.setText(auto.getCapacidad_baul());
                textCalificacion.setText(String.valueOf(auto.getCalificacion()));
                
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
        
        botonAgregarAuto.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                VentanaAuto va=new VentanaAuto(u);
                va.setVisible(true);
                self.setVisible(false);
                
            }
        });
        
        botonActualizar.addMouseListener(new MouseAdapter() { 
            
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
       // res.weightx=0;
       // res.weighty=0;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,50,0,0);
        this.add(panelListar,res);
        
        // panel de botones
        res.gridx=1;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=GridBagConstraints.RELATIVE;
       // res.weightx=0;
        //res.weighty=0.2;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.NONE;
        res.insets = new Insets(0,0,20,0);
        this.add(panelBotones,res);
        
        
            
        //----detalle Auto
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=0;
        res.anchor = GridBagConstraints.WEST;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,50,0,0);
        this.add(panelDetalleAuto,res);
        
          //----detalle Auto2
       /* res.gridx=1;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.REMAINDER;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
      //  res.weighty=1;
        res.anchor = GridBagConstraints.EAST;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0,0,30);
        this.add(panelDetalleAuto2,res);*/
                
                
        

        

        // panel inferior
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(20,0,0,0);
        this.add(panelInferior,res);
        
        
        
    
    }
    
     public Object[][] cargarTabla(ArrayList<Auto> arrAutos){
        
        int max= arrAutos.size();
        Object[][] datos= new Object[max+3][11];    
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
    
}
