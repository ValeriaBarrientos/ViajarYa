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
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author diego
 */
public class VentanaEditAuto extends FrameManager{
    private JComboBox comboListaAutos;
    private JTextField textMarca;
    private JTextField textModelo;
    private JTextField textColor;
    private JComboBox comboCombustible;
    private JTextField textPatente;
    private JComboBox comboAire;
    private JComboBox comboCalefaccion;
    private JTextField textCantAsientos;
    private JComboBox comboCalificacion;
    private JComboBox comboBaul;
    private int aux;
    
    
    
    public VentanaEditAuto(Usuario u,ArrayList <Auto> arrAutos){
        
    final AutoDB adb=new AutoDB();
    java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
    VentanaEditAuto self = this;
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
    
    JPanel panelAuto = new JPanel();
    
    
    
    
    //lista de atributos a modificar
    //MARCA--------------------
        JLabel laMarca = new JLabel("Marca:");  
        laMarca.setFont(new Font("arial",3,12));
        laMarca.setForeground(Color.BLACK);
        laMarca.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 0;
        gRes.gridy = 1;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.WEST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laMarca,gRes);
        textMarca = new JTextField();
        textMarca.setColumns(25);
        gRes.gridx = 1;
        gRes.gridy = 1;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(textMarca,gRes);
        
        textMarca.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textMarca.setText((""));
                
            }
        });
        
        //MODELO--------------------
        JLabel laModelo = new JLabel("Modelo:");  
        laModelo.setFont(new Font("arial",3,12));
        laModelo.setForeground(Color.BLACK);
        laModelo.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 2;
        gRes.gridy = 1;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.WEST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laModelo,gRes);
        textModelo = new JTextField();
        textModelo.setColumns(25);
        gRes.gridx = 3;
        gRes.gridy = 1;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(textModelo,gRes);
        
        textModelo.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textModelo.setText((""));
                
            }
        });
        
        //COLOR--------------------
        JLabel laColor = new JLabel("Color:");  
        laColor.setFont(new Font("arial",3,12));
        laColor.setForeground(Color.BLACK);
        laColor.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 0;
        gRes.gridy = 2;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.WEST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laColor,gRes);
        textColor = new JTextField();
        textColor.setColumns(25);
        gRes.gridx = 1;
        gRes.gridy = 2;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(textColor,gRes);
        
        textColor.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textColor.setText((""));
                
            }
        });
        
        //COMBUSTIBLE--------------------
        JLabel laCombustible = new JLabel("Combustible:");  
        laCombustible.setFont(new Font("arial",3,12));
        laCombustible.setForeground(Color.BLACK);
        laCombustible.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 2;
        gRes.gridy = 2;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.WEST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laCombustible,gRes);
        comboCombustible = new JComboBox();
        comboCombustible.addItem("NAFTA");
        comboCombustible.addItem("DIESEL");
        comboCombustible.addItem("GAS");
        gRes.gridx = 3;
        gRes.gridy = 2;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(comboCombustible,gRes);
        
        comboCombustible.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboCombustible
                
            }
        });
        
        //PATENTE--------------------
        JLabel laPatente = new JLabel("Patente:");  
        laPatente.setFont(new Font("arial",3,12));
        laPatente.setForeground(Color.BLACK);
        laPatente.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 0;
        gRes.gridy = 3;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.WEST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laPatente,gRes);
        textPatente = new JTextField();
        textPatente.setColumns(25);
        gRes.gridx = 1;
        gRes.gridy = 3;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(textPatente,gRes);
        
        textPatente.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textPatente.setText((""));
                
            }
        });
        
        //AIRE--------------------
        JLabel laAire = new JLabel("Aire:");  
        laAire.setFont(new Font("arial",3,12));
        laAire.setForeground(Color.BLACK);
        laAire.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 2;
        gRes.gridy = 3;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.WEST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laAire,gRes);
        comboAire = new JComboBox();
        comboAire.addItem("Si");
        comboAire.addItem("No");
        gRes.gridx = 3;
        gRes.gridy = 3;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(comboAire,gRes);
        
        comboAire.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboAire
                
            }
        });
        
        //Calefaccion--------------------
        JLabel laCalefaccion = new JLabel("Calefacción:");  
        laCalefaccion.setFont(new Font("arial",3,12));
        laCalefaccion.setForeground(Color.BLACK);
        laCalefaccion.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 0;
        gRes.gridy = 4;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.WEST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laCalefaccion,gRes);
        comboCalefaccion = new JComboBox();
        comboCalefaccion.addItem("Si");
        comboCalefaccion.addItem("No");
        gRes.gridx = 1;
        gRes.gridy = 4;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(comboCalefaccion,gRes);
        
        comboCalefaccion.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboCalefaccion
                
            }
        });
        
        //Cantidad de asientos--------------------
        
        JLabel laAsiento = new JLabel("Cantidad de asientos:");  
        laAsiento.setFont(new Font("arial",3,12));
        laAsiento.setForeground(Color.BLACK);
        laAsiento.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 2;
        gRes.gridy = 4;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.WEST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laAsiento,gRes);
        textCantAsientos = new JTextField();
        textCantAsientos.setColumns(25);
        gRes.gridx = 3;
        gRes.gridy = 4;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(textCantAsientos,gRes);
        
        textCantAsientos.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                textCantAsientos.setText((""));
                
            }
        });
        
        //Calificacion--------------------
        JLabel laCalificacion = new JLabel("Califique el estado del auto:");  
        laCalificacion.setFont(new Font("arial",3,12));
        laCalificacion.setForeground(Color.BLACK);
        laCalificacion.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 0;
        gRes.gridy = 5;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.EAST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laCalificacion,gRes);
        comboCalificacion = new JComboBox();
        for (int i=0;i<10;i++){
            comboCalificacion.addItem(i+1);
        }
        gRes.gridx = 1;
        gRes.gridy = 5;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(comboCalificacion,gRes);
        
        comboCalificacion.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboCalificacion.
                
            }
        });
        
        //Baul--------------------
        JLabel laBaul = new JLabel("Tamaño de baul:");  
        laBaul.setFont(new Font("arial",3,12));
        laBaul.setForeground(Color.BLACK);
        laBaul.setHorizontalAlignment(JLabel.RIGHT);
        gRes.gridx = 2;
        gRes.gridy = 5;
        gRes.gridwidth =1;
        gRes.anchor = GridBagConstraints.EAST;
        gRes.fill = GridBagConstraints.HORIZONTAL;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(laBaul,gRes);
        comboBaul = new JComboBox();
        comboBaul.addItem("GRANDE");
        comboBaul.addItem("MEDIANO");
        comboBaul.addItem("CHICO");
        gRes.gridx = 3;
        gRes.gridy = 5;
        gRes.gridwidth =1;
        gRes.insets = new Insets(0,0,10,10);
        panelAuto.add(comboBaul,gRes);
        
        comboBaul.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseReleased(MouseEvent e) {
                //comboBaul.
                
            }
        });
    
    
    //----Panel Auto
    res.gridx=0;
    res.gridy=2;
    res.gridwidth=GridBagConstraints.RELATIVE;
        //res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
        //res.weighty=1;
        //res.anchor = GridBagConstraints.NORTH;
    res.fill = GridBagConstraints.BOTH;
    res.insets = new Insets(0,50,0,50);
    this.add(panelAuto,res);
    
    
    
    
    
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
                //Muestro los valores de los datos que tenian hasta el momento
                textMarca.setText((arrAutos.get(aux)).getMarca());
                textModelo.setText((arrAutos.get(aux)).getModelo());
                textColor.setText((arrAutos.get(aux)).getColor());;
                for (int j=0;j<3;j++){
                    if (arrAutos.get(aux).getCombustible().equals(comboCombustible.getItemAt(j).toString()))
                        comboCombustible.setSelectedIndex(j);   
                }
                
                //setToolTipText()
                textPatente.setText((arrAutos.get(aux)).getPatente());
                if(arrAutos.get(aux).isAire_acondicionado())
                    comboAire.setSelectedIndex(0);
                else
                    comboAire.setSelectedIndex(1);
                if(arrAutos.get(aux).isCalefaccion())
                    comboCalefaccion.setSelectedIndex(0);
                else
                    comboCalefaccion.setSelectedIndex(1);
                textCantAsientos.setText(String.valueOf((int)arrAutos.get(aux).getCantidad_de_asientos()));
                for (int j=0;j<10;j++){
                    if (arrAutos.get(aux).getCalificacion()==Short.parseShort(comboCalificacion.getItemAt(j).toString()))
                        comboCalificacion.setSelectedIndex(j);   
                }
                comboCalificacion.setToolTipText(String.valueOf(arrAutos.get(aux).getCalificacion()));
                for (int j=0;j<3;j++){
                    if (arrAutos.get(aux).getCapacidad_baul().equals(comboBaul.getItemAt(j).toString()))
                        comboBaul.setSelectedIndex(j);   
                }
                
                
            }
        });
        // panel inferior
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
        
    Boton botonActualizar=new Boton("Actualizar");
    botonActualizar.setAlignmentX (panelInferior.CENTER_ALIGNMENT);
    panelInferior.add(botonActualizar);
    panelInferior.add (Box.createRigidArea (new Dimension (15,15)));
        
        botonActualizar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                //llamamos al update de la base de datos
                String marca=textMarca.getText();
                String modelo=textModelo.getText();
                String color=textColor.getText();
                String combustible=String.valueOf(comboCombustible.getSelectedItem());
                String patente=textPatente.getText();
                String aire=String.valueOf(comboAire.getSelectedItem());
                String calefaccion=String.valueOf(comboCalefaccion.getSelectedItem());
                String cantAsientos=textCantAsientos.getText();
                String calificacion=String.valueOf(comboCalificacion.getSelectedItem());
                String baul=String.valueOf(comboBaul.getSelectedItem());
                //String foto=" ";//falta asignar la foto
                if (comboAire.getSelectedItem().toString()=="Si")
                    aire="0";
                else
                    aire="1";
                if (comboCalefaccion.getSelectedItem().toString()=="Si")
                    calefaccion="0";
                else
                    calefaccion="1";
                
                
                adb.updateCar(marca, modelo, color, combustible, patente, aire, calefaccion, cantAsientos, calificacion, baul, arrAutos.get(aux).getId_auto());
                JOptionPane.showMessageDialog(self,"El auto se ha actualizado satisfactoriamente");
                VentanaMiAuto au = new VentanaMiAuto(u);
                au.setVisible(true);
                self.setVisible(false);
                
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

