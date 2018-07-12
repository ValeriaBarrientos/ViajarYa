/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import ViajarDB.Auto;
import ViajarDB.AutoDB;
import ViajarDB.Calificacion;
import ViajarDB.Ciudad;
import ViajarDB.CiudadDB;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
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
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;


/**
 *
 * @author alejandro
 */
/**
 *
 * @author vale2
 */
public class VentanaAgregarViaje extends FrameManager{

 //private ArrayList<Auto> arrAutos;
    int i;
    
    public VentanaAgregarViaje(Usuario usuario, ArrayList<Auto> arrAutos){   
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel labelq = new JLabel(" A donde vas a viajar?... ");  
        labelq.setFont(new Font("Arial",5,26));
        labelq.setForeground(Color.black);
        labelq.setHorizontalAlignment(JLabel.CENTER);
        panelTitulo.add(labelq);
        
        JPanel panelViaje = new JPanel();
        GridBagLayout gBag1 = new GridBagLayout ();
        GridBagConstraints res1 = new GridBagConstraints ();
        panelViaje.setLayout(gBag1);
        panelViaje.setBackground(Color.white);
       
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
        
        JLabel labelOrigen=new JLabel("Origen: ");
        labelOrigen.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=0;
        res1.gridwidth=1;
        res1.anchor = GridBagConstraints.CENTER;
        res1.fill = GridBagConstraints.HORIZONTAL;
        panelViaje.add(labelOrigen,res1);
        res1.gridx=1;
        res1.gridy=0;
        res1.gridwidth=1;
        panelViaje.add(comboOrigen,res1);
        
        JLabel labelDestino=new JLabel("Destino: ");
        labelDestino.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=1;
        res1.gridwidth=1;
        res1.anchor = GridBagConstraints.CENTER;
        res1.fill = GridBagConstraints.HORIZONTAL;
        panelViaje.add(labelDestino,res1);
        res1.gridx=1;
        res1.gridy=1;
        res1.gridwidth=1;
        panelViaje.add(comboDestino,res1);
        
        JLabel labelFecha =new JLabel ("Fecha: ");
        labelFecha.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=2;
        res1.gridwidth=1;
        res1.anchor = GridBagConstraints.CENTER;
        res1.fill = GridBagConstraints.HORIZONTAL;
        panelViaje.add(labelFecha,res1);
        res1.gridx=1;
        res1.gridy=2;
        res1.gridwidth=1;
        JDateChooser dateViaje = new JDateChooser();
        panelViaje.add(dateViaje,res1);
        
        JLabel labelHora=new JLabel("Hora de salida: ");
        labelHora.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=3;
        res1.gridwidth=1;
        res1.anchor = GridBagConstraints.CENTER;
        res1.fill = GridBagConstraints.HORIZONTAL;
        panelViaje.add(labelHora,res1);
        
        JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        res1.gridx=1;
        res1.gridy=3;
        res1.gridwidth=1;
        res1.anchor = GridBagConstraints.CENTER;
        res1.fill = GridBagConstraints.HORIZONTAL;
        panelViaje.add(timeSpinner,res1);
        
        JLabel labelGastos=new JLabel("Gastos Aproximados: ");
        labelGastos.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=4;
        res1.gridwidth=1;
        panelViaje.add(labelGastos,res1);
        JTextField textGastos=new JTextField();
        res1.gridx=1;
        res1.gridy=4;
        res1.gridwidth=1;
        panelViaje.add(textGastos,res1);
       
        JLabel labelSalida=new JLabel("Lugar de salida: ");
        labelSalida.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=5;
        res1.gridwidth=1;
        panelViaje.add(labelSalida,res1);
        JTextField textSalida=new JTextField();
        res1.gridx=1;
        res1.gridy=5;
        res1.gridwidth=1;
        panelViaje.add(textSalida,res1);
       
        JLabel labelMascota=new JLabel("Acepta mascota: ");
        labelMascota.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=6;
        res1.gridwidth=1;
        panelViaje.add(labelMascota,res1);
        JComboBox comboMascota = new JComboBox();
        comboMascota.addItem("SI");
        comboMascota.addItem("NO");
        res1.gridx=1;
        res1.gridy=6;
        res1.gridwidth=1;
        panelViaje.add(comboMascota,res1);
       
        JLabel labelFumador=new JLabel("Acepta que fumen: ");
        labelFumador.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=0;
        res1.gridy=7;
        res1.gridwidth=1;
        panelViaje.add(labelFumador,res1);
        JComboBox comboFumador = new JComboBox();
        comboFumador.addItem("SI");
        comboFumador.addItem("NO");
        res1.gridx=1;
        res1.gridy=7;
        res1.gridwidth=1;
        panelViaje.add(comboFumador,res1);
       
        //----------------datos del auto-------------------
        
        JLabel labelMarca=new JLabel("Auto modelo:");
        labelMarca.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=0;
        res1.gridwidth=1;
        //res1.anchor = GridBagConstraints.NORTH;
        //res1.fill = GridBagConstraints.HORIZONTAL;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelMarca,res1);
        JComboBox comboAuto = new JComboBox();
      //  textMarca.setHorizontalAlignment(JTextField.LEFT);
        res1.gridx=5;
        res1.gridy=0;
        res1.gridwidth= GridBagConstraints.REMAINDER;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(comboAuto,res1);
      
        for(int i=0; i<arrAutos.size();i++)
            comboAuto.addItem(arrAutos.get(i).getModelo());
        
        //marca no modelo
        JLabel labelModelo=new JLabel("Marca: ");
        labelModelo.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=1;
        res1.gridwidth=1;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelModelo,res1);
        JTextField textModelo=new JTextField(arrAutos.get(comboAuto.getSelectedIndex()).getMarca());
        res1.gridx=5;
        res1.gridy=1;
        res1.gridwidth=GridBagConstraints.REMAINDER;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(textModelo,res1);
       
        JLabel labelColor=new JLabel("Color: ");
        labelColor.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=2;
        res1.gridwidth=1;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelColor,res1);
        JTextField textColor=new JTextField(arrAutos.get(i).getColor());
        res1.gridx=5;
        res1.gridy=2;
        res1.gridwidth=1;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(textColor,res1);
       
        
        JLabel labelCombustible=new JLabel("Combustible: ");
        labelCombustible.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=3;
        res1.gridwidth=1;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelCombustible,res1);
        JTextField textCombustible=new JTextField(arrAutos.get(i).getCombustible());
        res1.gridx=5;
        res1.gridy=3;
        res1.gridwidth=1;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(textCombustible,res1);
        
        JLabel labelAire=new JLabel("Aire acondicionado: ");
        labelAire.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=4;
        res1.gridwidth=1;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelAire,res1);
        String aire=String.valueOf(arrAutos.get(i).isAire_acondicionado());
        if (aire.equals("true")){
            aire="Si";
        }
        else{
            aire="No";
        }
        JTextField textAire=new JTextField(aire);
        res1.gridx=5;
        res1.gridy=4;
        res1.gridwidth=1;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(textAire,res1);
        
        
        JLabel labelCalefaccion=new JLabel("Calefaccion: ");
        labelCalefaccion.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=5;
        res1.gridwidth=1;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelCalefaccion,res1);
        String calefa=String.valueOf(arrAutos.get(i).isCalefaccion());
        if (calefa.equals("true")){
            calefa="Si";
        }
        else{
            calefa="No";
        }
        JTextField textCalefaccion=new JTextField(calefa);
        res1.gridx=5;
        res1.gridy=5;
        res1.gridwidth=1;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(textCalefaccion,res1);
       
        
        JLabel labelCantidad=new JLabel("Cantidad de Asientos: ");
        labelCantidad.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=6;
        res1.gridwidth=1;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelCantidad,res1);
        JTextField textCantidad=new JTextField(String.valueOf(arrAutos.get(i).getCantidad_de_asientos()));
        res1.gridx=5;
        res1.gridy=6;
        res1.gridwidth=1;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(textCantidad,res1);
        
        JLabel labelBaul=new JLabel("Capacidad Baul: ");
        labelBaul.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=7;
        res1.gridwidth=1;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelBaul,res1);
        JTextField textBaul=new JTextField(arrAutos.get(i).getCapacidad_baul());
        res1.gridx=5;
        res1.gridy=7;
        res1.gridwidth=1;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(textBaul,res1);
        
        JLabel labelCalificacion=new JLabel("Calificacion: ");
        labelCalificacion.setHorizontalAlignment(JLabel.LEFT);
        res1.gridx=4;
        res1.gridy=8;
        res1.gridwidth=1;
        res1.insets = new Insets(10,20,10,0);
        panelViaje.add(labelCalificacion,res1);
        JTextField textCalificacion=new JTextField(String.valueOf(arrAutos.get(i).getCalificacion()));
        res1.gridx=5;
        res1.gridy=8;
        res1.gridwidth=1;
        res1.insets = new Insets(10,0,10,0);
        panelViaje.add(textCalificacion,res1);
        
        comboAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                textModelo.setText(arrAutos.get(comboAuto.getSelectedIndex()).getMarca());
                textColor.setText(arrAutos.get(comboAuto.getSelectedIndex()).getColor());
                textCombustible.setText(arrAutos.get(comboAuto.getSelectedIndex()).getCombustible());
                textCantidad.setText(String.valueOf(arrAutos.get(comboAuto.getSelectedIndex()).getCantidad_de_asientos()));
                textCalificacion.setText(String.valueOf(arrAutos.get(comboAuto.getSelectedIndex()).getCalificacion()));
                String calefa=String.valueOf(arrAutos.get(comboAuto.getSelectedIndex()).isCalefaccion());
                if (calefa.equals("true")){
                    calefa="Si";
                }
                else{
                    calefa="No";
                }
                textCalefaccion.setText(calefa);
                calefa=String.valueOf(arrAutos.get(comboAuto.getSelectedIndex()).isAire_acondicionado());
                if (calefa.equals("true")){
                    calefa="Si";
                }
                else{
                    calefa="No";
                }
                textAire.setText(calefa);
                
            }
                //JComboBox comboBox = (JComboBox) event.getSource();
            
        
        });   
      
        //-------------------botones--------------------------------------------   
       
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,40,0));
        //panelBotones.setBackground(Color.WHITE);
        
        Boton botonCrear=new Boton("CREAR VIAJE");
        panelBotones.add(botonCrear);
        Boton botonVolver=new Boton("VOLVER");
        panelBotones.add(botonVolver);
        
        textGastos.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)&& (caracter != '.')) {
                    e.consume(); // ignorar el evento de teclado
                }
            }
        });
        
        botonCrear.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
                java.util.Date fecha = new Date();
                if (comboOrigen.getSelectedIndex() <= 0)
                    JOptionPane.showMessageDialog(self, "Falta ingresar ciudad de origen");
                else
                    if (comboDestino.getSelectedIndex() <= 0)
                        JOptionPane.showMessageDialog(self, "Falta ingresar ciudad de destino");
                    else
                        if ((dateViaje.getDate().compareTo(fecha)) <= 0)
                            JOptionPane.showMessageDialog(self, "Fecha de salida incorrecta");
                        else
                            if (textGastos.getText().isEmpty())
                                JOptionPane.showMessageDialog(self, "Falta ingresar los gastos");
                            else
                                if (textSalida.getText().isEmpty())
                                    JOptionPane.showMessageDialog(self, "Falta ingresar el lugar de salida");
                                else
                                    if (comboOrigen.getSelectedIndex() == comboDestino.getSelectedIndex())
                                        JOptionPane.showMessageDialog(self, "Ingreso la misma ciudad en Origen y Destino");
                                    else{
                                        String ciudadOrigen = (String)comboOrigen.getSelectedItem();
                                        String ciudadDestino = (String)comboDestino.getSelectedItem();
                                        double gastos = Double.valueOf(textGastos.getText());
                                        
                                        fecha = dateViaje.getDate();
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                        String fechaSalida = sdf.format(fecha);
                                        
                                        java.util.Date hora;
                                        hora = (Date)timeSpinner.getValue();
                                        SimpleDateFormat hms=new SimpleDateFormat("HH:mm:ss");
                                        String horaSalida = hms.format(hora);
                                        
                                        String lugarSalida = textSalida.getText();
                                        int mascota=0;
                                        int fumador=0;
                                        if (comboMascota.getSelectedItem().equals("SI"))
                                            mascota=1;
                                        if (comboFumador.getSelectedItem().equals("SI"))
                                            fumador=1;
                                        //String fechaActual = String.valueOf(new Date());
                                        Calendar fechaAc = new GregorianCalendar();
                                        int anio = fechaAc.get(Calendar.YEAR);
                                        int mes = fechaAc.get(Calendar.MONTH);
                                        int dia = fechaAc.get(Calendar.DAY_OF_MONTH);

                                        String a =String.valueOf(anio);
                                        String m =String.valueOf(mes);
                                        String d =String.valueOf(dia);
                                        String hoy = (a +"-");
                                        hoy= hoy +m+"-";
                                        hoy=hoy+d;
                                        System.out.println("hoy  "+hoy);
                                        
                                        
                                        ViajeDB v = new ViajeDB();
                                        int id = v.insertViaje(ciudadOrigen,ciudadDestino,gastos,fechaSalida,horaSalida,lugarSalida,mascota,fumador,hoy);
                                        if(id!= 0){
                                            v.insertViajeHasUsuario(id,usuario.getId_usuario(),arrAutos.get(comboAuto.getSelectedIndex()).getId_auto());
                                            JOptionPane.showMessageDialog(self, "La creacion del viaje fue exitosa");
                                        }
                                        
                                
                                    }
            }
        });
        
        botonVolver.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                 VentanaViajes viajes = new VentanaViajes(usuario);
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
        res.gridwidth=GridBagConstraints.RELATIVE;
       // res.gridheight=GridBagConstraints.RELATIVE;
        res.weightx=1;
       // res.weighty=1;
        res.anchor = GridBagConstraints.EAST;//derecha
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,40,0,0);
        this.add(panelViaje,res);
        
               
         
        //Panel Botones
        res.gridx=0;
        res.gridy=3;
        res.gridwidth=GridBagConstraints.REMAINDER;
       // res.gridheight=GridBagConstraints.RELATIVE;
        //res.weightx=1;
       // res.weighty=1;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(10,0,0,0);
        this.add(panelBotones,res);
    }













    
}

