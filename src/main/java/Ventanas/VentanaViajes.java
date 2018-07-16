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
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 
 * @author vale2
 */
public class VentanaViajes extends FrameManager{
    private ArrayList <Viaje> arrViajes;
    private int idViaje;

    
    public VentanaViajes(Usuario u){
        
        super();
        final ViajeDB viajes = new ViajeDB();    
        final String[] nombreColumnas = {"id","Dia Salida","Hora Salida","Origen","Destino","Gastos Aprox.","Lugar Salida"};       
        final DefaultTableModel modTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
      
                return false;
            }
            
        };
        JTable tablaViajes = new JTable(modTabla);
 
        
        JPanel panelSaludo = new JPanel();
        panelSaludo.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel labelHola = new JLabel("HOLA!, "+u.getNombre());  
        labelHola.setFont(new Font("Arial",3,18));
        labelHola.setForeground(Color.black);
        labelHola.setHorizontalAlignment(JLabel.RIGHT);
        panelSaludo.add(labelHola);
        
        JPanel panelBuscar = new JPanel();
        GridBagLayout gBag = new GridBagLayout ();
        GridBagConstraints gRes = new GridBagConstraints ();
        panelBuscar.setLayout(gBag);
        panelBuscar.setBackground(Color.white);
        TitledBorder borde = new TitledBorder("Buscá tu viaje:");
        borde.setTitleFont(new Font("Arial",3,22));
        panelBuscar.setBorder(borde);
    
        
        JLabel labelOrigen = new JLabel("Origen:");  
        labelOrigen.setFont(new Font("Arial",3,11));
        labelOrigen.setForeground(Color.black);
        labelOrigen.setHorizontalAlignment(JLabel.CENTER);
        gRes.gridx = 0;
        //gRes.gridy = GridBagConstraints.RELATIVE;
        gRes.anchor = GridBagConstraints.CENTER;
        gRes.insets = new Insets(10,5,10,0);
        panelBuscar.add(labelOrigen,gRes);
        
        
        CiudadDB ciudadMg = new CiudadDB();  
        JComboBox comboOrigen = new JComboBox();
	JComboBox comboDestino = new JComboBox();
        Iterator<Ciudad> it = ciudadMg.getCiudades().iterator();
        ArrayList <String> aux = new ArrayList<String>();
        comboOrigen.addItem("Seleccione ciudad");
        comboDestino.addItem("Seleccione ciudad");
        for (Ciudad nombre : ciudadMg.getCiudades()) {
            String nom = (nombre.getNombre());
            comboOrigen.addItem(nom);
            comboDestino.addItem(nom);
            
        }
        gRes.gridx = GridBagConstraints.RELATIVE;
        panelBuscar.add(comboOrigen,gRes);
          
        JLabel labelDestino = new JLabel("Destino:");  
        labelOrigen.setFont(new Font("Arial",3,11));
        labelOrigen.setForeground(Color.black);
        labelOrigen.setHorizontalAlignment(JLabel.CENTER);
        gRes.anchor = GridBagConstraints.CENTER;
        panelBuscar.add(labelDestino,gRes);
        panelBuscar.add(comboDestino,gRes);
        
        JLabel laFecha = new JLabel("Fecha:");  
        laFecha.setFont(new Font("arial",3,11));
        laFecha.setForeground(Color.black);
        panelBuscar.add(laFecha,gRes);
        
        JDateChooser fecha = new JDateChooser();
        gRes.ipadx = 10;
        panelBuscar.add(fecha,gRes);
        
       
        
    /*    
        String dia=String.valueOf(fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
	String mes=String.valueOf(fecha.getCalendar().get(Calendar.MONTH)+1);
	String año=String.valueOf(fecha.getCalendar().get(Calendar.YEAR));
	//String fecha1=año+"/"+mes+"/"+dia;
        
       
        
    */

                       
        
        Boton botonListar=new Boton("LISTAR");
        gRes.insets = new Insets(10,10,10,10);
        gRes.anchor = GridBagConstraints.CENTER;
        panelBuscar.add(botonListar,gRes);
        
        botonListar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
            
            ViajeDB viajes = new ViajeDB();
            ArrayList <Viaje> arrViajes = new ArrayList<>();   
            String ciudad1=(String)comboOrigen.getSelectedItem();
            String ciudad2=(String)comboDestino.getSelectedItem();
            String fechaSalida="";
          
           
            if (fecha.getDate()!=null){
             Date fecha1=fecha.getDate();
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             fechaSalida = sdf.format(fecha1);
            }; 
            
         
            System.out.println(fechaSalida);
            System.out.println(ciudad1);
            System.out.println(ciudad2);
       
           
            if (!((ciudad1 == "Seleccione ciudad")&(ciudad2 == "Seleccione ciudad"))&(fechaSalida=="")){
                
                arrViajes = viajes.getViajesxCiudades(ciudad1,ciudad2);
                //modTabla.setDataVector(cargarTabla(arrViajes),nombreColumnas);
            }    
            else {
                
                if (!((ciudad1 == "Seleccione ciudad")&(ciudad2 == "Seleccione ciudad"))&(fechaSalida!="")){
                      System.out.println(ciudad1 == "Seleccione una ciudad");
                    arrViajes = viajes.getViajesxCiudadesxFecha(ciudad1, ciudad2,fechaSalida);
                }
                else{
                     
                    if (((ciudad1 == "Seleccione ciudad")&(ciudad2 == "Seleccione ciudad"))&(fechaSalida!="")){
                         System.out.println("4");
                         arrViajes = viajes.getViajesxFecha(fechaSalida); 
                    }    
                } 
            
            }
           
            modTabla.setDataVector(cargarTabla(arrViajes),nombreColumnas);
             //------------oculto la primer columna del id-------------------------ale
            tablaViajes.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaViajes.getColumnModel().getColumn(0).setMinWidth(0);
            tablaViajes.getColumnModel().getColumn(0).setPreferredWidth(0);
            //------------------------------------------------------------------------
            
            }    
        });
        
        Boton botonTodos=new Boton("VER TODOS");
        panelBuscar.add(botonTodos,gRes);
        botonTodos.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                ViajeDB viajes = new ViajeDB();
                ArrayList <Viaje> arrViajes = new ArrayList<>();   
                arrViajes = viajes.getViajesActuales(); 
                modTabla.setDataVector(cargarTabla(arrViajes),nombreColumnas);
                 //------------oculto la primer columna del id-------------------------ale
                tablaViajes.getColumnModel().getColumn(0).setMaxWidth(0);
                tablaViajes.getColumnModel().getColumn(0).setMinWidth(0);
                tablaViajes.getColumnModel().getColumn(0).setPreferredWidth(0);
                //------------------------------------------------------------------------
            }
        });
        
         
//------------- 3 Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
   
        Boton botonMisViajes=new Boton("MIS VIAJES");
        botonMisViajes.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonMisViajes);
        panelBotones.add (Box.createRigidArea (new Dimension (5,5)));
        Boton botonMicuenta=new Boton("MI CUENTA");
        botonMicuenta.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonMicuenta);
         panelBotones.add (Box.createRigidArea (new Dimension (5,5)));
        Boton botonMisAutos=new Boton("MIS AUTOS");
        botonMisAutos.setAlignmentX (panelBotones.CENTER_ALIGNMENT);
        panelBotones.add(botonMisAutos);
        
        
         botonMisViajes.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                    VentanaMisViajes viajes = new VentanaMisViajes(u);
                     viajes.setVisible(true);
                     self.setVisible(false);
            }
        });   

         
          botonMicuenta.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                    VentanaCuenta c = new VentanaCuenta(u);
                     c.setVisible(true);
                     self.setVisible(false);
            }
        });      
         
        
         botonMisAutos.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                    VentanaMisAutos va = new VentanaMisAutos(u);
                     va.setVisible(true);
                     self.setVisible(false);
            }
        });   
        
        
        
       
 //----- Listado de viajes       
        JPanel panelListadoViajes = new JPanel();
        GridBagLayout gBag3 = new GridBagLayout ();
        GridBagConstraints gRes3 = new GridBagConstraints ();
        panelListadoViajes.setLayout(gBag3);
        panelListadoViajes.setBackground(Color.white);
        TitledBorder borde1 = new TitledBorder("  Listado actualizado  ");
        borde1.setTitleFont(new Font("Arial",3,14));
        panelListadoViajes.setBorder(borde1);
        
         ArrayList <Viaje> arrViajes = new ArrayList<>();
         arrViajes = viajes.getViajesActuales();
   
        modTabla.setDataVector(cargarTabla(arrViajes),nombreColumnas);
       // JTable tablaViajes = new JTable(modTabla);
        tablaViajes.setPreferredScrollableViewportSize(new Dimension(200, 200));
        gRes3.gridx=0;
        gRes3.gridy=1;
        gRes3.weightx=1;
        gRes3.weighty=1;
        //gRes3.anchor = GridBagConstraints.NORTH;
        gRes3.fill = GridBagConstraints.BOTH;
        gRes3.insets = new Insets(20,0,5,0);
        panelListadoViajes.add(new JScrollPane(tablaViajes),gRes3);
       
        //------------oculto la primer columna del id-------------------------ale
        tablaViajes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaViajes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaViajes.getColumnModel().getColumn(0).setPreferredWidth(0);
        //------------------------------------------------------------------------
       
        tablaViajes.addMouseListener(new MouseAdapter(){
          
        @Override
            public void mouseClicked(MouseEvent e) {
                //tablaViajes.getSelectedRows()
                String id=String.valueOf(tablaViajes.getValueAt(tablaViajes.getSelectedRow(), 0));
                idViaje=Integer.parseInt(id);
            
             }
               
               
        });
        
       

       
        
        
 //----- Botones agregar viaje sumarse a viaje       
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 100,0));
        Boton botonDetalles=new Boton("DETALLES VIAJE");
        panel3.add(botonDetalles);
//------Ale        
        botonDetalles.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
               
                if (idViaje > -1){
                   VentanaSumarseViaje ventana = new VentanaSumarseViaje(idViaje, u);
                    ventana.setVisible(true);
                    self.setVisible(false);
                }
            }
        });
        
        
        Boton botonAgregar=new Boton("AGREGAR VIAJE");
        panel3.add(botonAgregar);
        
        botonAgregar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                AutoDB a = new AutoDB();
                ArrayList<Auto> arrAutos = a.ObtenerAutosUsuario(u.getId_usuario());
                if (arrAutos.size() > 0){
                    VentanaAgregarViaje ventana = new VentanaAgregarViaje(u,arrAutos);
                    ventana.setVisible(true);
                    self.setVisible(false);
                }else
                    JOptionPane.showMessageDialog(self, "Debe cargar un auto para poder crear un viaje.");
            }
        });

     
 
        
        //Panel Saludo
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.REMAINDER;
       // res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
       // res.weighty=1;
        res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(10,0,0,0);
        this.add(panelSaludo,res);
        
        
        
        //----buscar viaje
        res.gridx=0;
        res.gridy=2;
        res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,50,0,0);
        this.add(panelBuscar,res);
        

        //-----botones: Mis viajes, mi cuenta mis Autos
        res.gridx=1;
        res.gridy=2;
        //res.gridheight=GridBagConstraints.REMAINDER;
        res.gridwidth=GridBagConstraints.REMAINDER;
        //res.weightx=0.2;
        //res.weighty=0.0;
        //res.anchor = GridBagConstraints.WEST;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0,0,0);
        this.add(panelBotones,res);
   //------Listado Viajes
        res.gridx=0;
        res.gridy=3;
        res.gridheight=GridBagConstraints.RELATIVE;
        res.gridwidth=GridBagConstraints.REMAINDER;
        //res.weightx=0;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTHWEST;
        //res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(10,30,0,30);
        this.add(panelListadoViajes,res);
        
    //----- Botones agregar viaje, detalles viaje
        res.gridx=0;
        res.gridy=4;
        res.gridheight=GridBagConstraints.REMAINDER;
        res.insets = new Insets(40,0 ,40,0);
        this.add(panel3,res);
        
        

       
     
    }
    
    public Object[][] cargarTabla(ArrayList<Viaje> arrViajes){
        
        int max= arrViajes.size();
        Object[][] datos= new Object[max+10][7];    
        int i=0;
        for(Viaje vAux : arrViajes){
                
               datos[i][0]=vAux.getIdViaje();
               datos[i][1]=vAux.getFechaPartida();
               datos[i][2]=vAux.getHoraPartida();
               datos[i][3]=vAux.getOrigen();
               datos[i][4]=vAux.getDestino();
               datos[i][5]=vAux.getGastosaproximados();
               datos[i][6]=vAux.getLugar_salida();
                i++;
            
        }
        
        return datos;
        
    }

    public ArrayList<Viaje> getArrViajes() {
        return arrViajes;
    }

    public void setArrViajes(ArrayList<Viaje> arrViajes) {
        this.arrViajes = arrViajes;
    }
  
}
