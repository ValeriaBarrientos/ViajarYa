/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import static Ventanas.FrameManager.loguetin;
import ViajarDB.Ciudad;
import ViajarDB.CiudadDB;
import ViajarDB.MyLog;
import ViajarDB.Usuario;
import ViajarDB.UsuarioDB;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author vale2
 */
public class VentanaRegistracion extends FrameManager{
    
    private JTextField textMail;
    private JPasswordField textPass;
    private JTextField textNombre;
    private JTextField textCalle;
    private JTextField textNro;
    private JTextField textTelefono;
    private JTextField textFechaNac;
   
   
    
   
    
    
    public VentanaRegistracion(){
        super();
        String usuario = ""; 
        String pass = "";
        //String usuario = "juanp@gmail.com";
        //String pass = "1234";

        MyLog.write("Inicio VentanaRegistracion");

        java.util.Locale.setDefault(java.util.Locale.forLanguageTag("es-AR"));
        VentanaRegistracion self = this;
    //----Presentacion ------------------------------------
    
        //----Loguin
        JPanel panel1 = new JPanel();
        GridBagLayout gBag1 = new GridBagLayout ();
        GridBagConstraints gRes1 = new GridBagConstraints ();
        panel1.setLayout(gBag1);
        panel1.setBackground(Color.WHITE);
        TitledBorder borde = new TitledBorder(" INICIO DE SESION  ");
        borde.setTitleFont(new Font("Arial",3,16));
        panel1.setBorder(borde);
       
        JLabel la2 = new JLabel("Ingrese mail y contraseña : ");  
        la2.setFont(new Font("Calibri",3,16));
        la2.setForeground(Color.BLACK);
        la2.setHorizontalAlignment(JLabel.LEFT);
        gRes1.gridx = 0;
        gRes1.gridy = 0;
        gRes1.gridwidth =GridBagConstraints.REMAINDER;  
        gRes1.insets = new Insets(0,0,40,0);
        panel1.add(la2,gRes1);
        
        JLabel labelMail = new JLabel("Mail: ");
        labelMail.setFont(new Font("arial",3,12));
        labelMail.setForeground(Color.BLACK);
        labelMail.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 1;
        gRes1.gridwidth =1;
        gRes1.anchor = GridBagConstraints.WEST;
        gRes1.fill = GridBagConstraints.HORIZONTAL;
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(labelMail,gRes1);
       
        textMail = new JTextField(usuario);
        textMail.setColumns(15);
        gRes1.gridx = 1;
        gRes1.gridwidth = GridBagConstraints.REMAINDER;
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(textMail,gRes1);
        
        JLabel labelPass = new JLabel("Contraseña: ");
        labelPass.setFont(new Font("arial",3,12));
        labelPass.setForeground(Color.BLACK);
        labelPass.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 2;
        gRes1.gridwidth =1;
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(labelPass,gRes1);
        
        textPass = new JPasswordField(pass);
        textPass.setColumns(15);
        gRes1.gridx = 1;
        gRes1.gridwidth =GridBagConstraints.REMAINDER;
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(textPass,gRes1);
        
        JLabel labelOlvido = new JLabel("¿Olvido Su Contraseña?");
        labelOlvido.setFont(new Font("arial",3,12));
        labelOlvido.setForeground(Color.DARK_GRAY);
        labelOlvido.setHorizontalAlignment(JLabel.RIGHT);
        gRes1.gridx = 0;
        gRes1.gridy = 3;
        gRes1.gridwidth =GridBagConstraints.REMAINDER;  
        gRes1.insets = new Insets(0,0,10,0);
        panel1.add(labelOlvido,gRes1);
        
        
        labelOlvido.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e) {
              
                labelOlvido.setForeground(Color.ORANGE);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
              
                labelOlvido.setForeground(Color.DARK_GRAY);
            }
            
            
            @Override
            public void mouseClicked(MouseEvent e){
                
                
                UsuarioDB usuarios = new UsuarioDB();
                ArrayList <Usuario> arrUsuarios = new ArrayList<>();
                arrUsuarios = usuarios.getUsuarios(); 
                               
                String envioPass = JOptionPane.showInputDialog("ingrese Mail Para Validar Y Enviar Contraseña");
                
                boolean autorizado = false;
                 for (Usuario uAux : arrUsuarios) {
                
                    if ((uAux.getMail().equals(envioPass))){                        
                        JOptionPane.showMessageDialog(self, "Mail Enviado A " +uAux.getMail());
                        autorizado = true;
                       }
                 }
                    if (autorizado == false){                                
                                JOptionPane.showMessageDialog(self, "Mail No Existente");
                                }
                    
                } 
                 
                
        });
    //-------- PANEL 2-----------------
        
        JPanel panel2 = new JPanel();
        GridBagLayout gBag2 = new GridBagLayout ();
        GridBagConstraints gRes2 = new GridBagConstraints ();
        panel2.setLayout(gBag2);
        panel2.setBackground(Color.WHITE);
        TitledBorder borde2 = new TitledBorder(" REGISTRARSE ");
        borde2.setTitleFont(new Font("Arial",3,16));
        panel2.setBorder(borde2);
       
        JLabel laReg2 = new JLabel("           Creá tu cuenta");  
        laReg2.setFont(new Font("Calibri",3,18)); 
        laReg2.setForeground(Color.BLACK);
        gRes2.gridx = 0;
        gRes2.gridy = 0;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        gRes2.anchor = GridBagConstraints.NORTH;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
       gRes2.insets = new Insets(0,0,10,0);
        panel2.add(laReg2,gRes2);
        
        //-------NOMBRE--------------------
        JLabel laNombre = new JLabel("Nombre: ");  
        laNombre.setFont(new Font("arial",3,12));
        laNombre.setForeground(Color.BLACK);
        laNombre.setHorizontalAlignment(JLabel.RIGHT);
        gRes2.gridx = 0;
        gRes2.gridy = 1;
        gRes2.gridwidth =1;
        gRes2.anchor = GridBagConstraints.WEST;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        gRes2.insets = new Insets(0,0,10,0);
        panel2.add(laNombre,gRes2);
        
        JTextField textNom = new JTextField();
        textNom.setColumns(25);
        gRes2.gridx = 1;
        gRes2.gridy = 1;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        //gRes2.insets = new Insets(0,0,10,0);
        panel2.add(textNom,gRes2);
        
          //-------APELLIDO--------------------
        JLabel laApellido = new JLabel("Apellido: ");  
        laApellido.setFont(new Font("arial",3,12));
        laApellido.setForeground(Color.BLACK);
        laApellido.setHorizontalAlignment(JLabel.RIGHT);
        gRes2.gridx = 0;
        gRes2.gridy = 2;
        gRes2.gridwidth =1;
        gRes2.insets = new Insets(0,0,10,0);
        panel2.add(laApellido,gRes2);
        
        JTextField textApe = new JTextField();
        textApe.setColumns(25);
        gRes2.gridx = 1;
        gRes2.gridy = 2;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        //gRes2.insets = new Insets(0,0,10,0);
        panel2.add(textApe,gRes2);
        
         
        //-------- Genero ---------------
        JLabel laGenero = new JLabel(" Genero : ");  
        laGenero.setFont(new Font("arial",3,12));
        laGenero.setForeground(Color.BLACK);
        laGenero.setHorizontalAlignment(JLabel.RIGHT);
        gRes2.gridx =0;
        gRes2.gridy =3;
       gRes2.gridwidth =1;
        //gRes2.anchor = GridBagConstraints.WEST;
        //gRes2.fill = GridBagConstraints.BOTH;
        panel2.add(laGenero,gRes2);
       
        JPanel panelMoF = new JPanel();
        panelMoF.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        panelMoF.setBackground(Color.white);
        //TitledBorder borde1 = new TitledBorder("");
        //panelMoF.setBorder(borde1);
        JRadioButton RBm = new JRadioButton("Masculino");
        RBm.setSelected(true);
        RBm.setBackground(Color.WHITE);
        JRadioButton RBf = new JRadioButton("Femenino");
        RBf.setBackground(Color.WHITE);
        ButtonGroup RB=new ButtonGroup();
        RB.add(RBm);
        RB.add(RBf);
        panelMoF.add(RBm);
        panelMoF.add(RBf);
        gRes2.gridx =1;
        gRes2.gridy =3;
        panel2.add(panelMoF,gRes2);
        

        //---------Direccion
        JLabel laDireccion = new JLabel("Direccion:");  
        laDireccion.setFont(new Font("arial",3,12));
        laDireccion.setForeground(Color.BLACK);
        laDireccion.setHorizontalAlignment(JLabel.RIGHT);
        gRes2.gridx = 0;
        gRes2.gridy = 4;
        gRes2.gridwidth =1;
        gRes2.anchor=GridBagConstraints.EAST;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(laDireccion,gRes2);
        
        JTextField textCalle = new JTextField("Calle y número");
        textCalle.setColumns(25); 
        gRes2.gridx =1;
        gRes2.gridy = 4;
        gRes2.gridwidth =1;
        
        panel2.add(textCalle,gRes2);
        
       
         textCalle.addMouseListener(new MouseAdapter() { 
            public void mouseClicked (MouseEvent e) {
                textCalle.setText((""));
                
            }
        });
        
        
       
        
         //------- Ciudad------
     
        JLabel labelCiudad = new JLabel("Ciudad:");  
        labelCiudad.setFont(new Font("arial",3,12));
        labelCiudad.setForeground(Color.black);
        labelCiudad.setHorizontalAlignment(JLabel.RIGHT);
        gRes2.gridx = 0;
        gRes2.gridy = 5;
        gRes2.gridwidth =1;
        gRes2.anchor = GridBagConstraints.WEST;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(labelCiudad,gRes2);      
        
        CiudadDB ciudadMg = new CiudadDB();  
        JComboBox comboOrigen = new JComboBox();
	comboOrigen.setBackground(Color.WHITE);
        Iterator<Ciudad> it = ciudadMg.getCiudades().iterator();
        ArrayList <String> aux = new ArrayList<String>();
        gRes2.gridx = 1;
        gRes2.gridy = 5;
        gRes2.gridwidth =1;
        comboOrigen.addItem("Seleccione ciudad");
        for (Ciudad nombre : ciudadMg.getCiudades()) {
            String nom = (nombre.getNombre());
            comboOrigen.addItem(nom);
        }
        
        //cb.getItemAt(cb.getSelectedIndex()); 
        panel2.add(comboOrigen,gRes2);
    

        // --------- Telefono -------
        
        JLabel laTel = new JLabel("Telefono : ");  
        laTel.setFont(new Font("arial",3,12));
        laTel.setForeground(Color.BLACK);
        laTel.setHorizontalAlignment(JLabel.RIGHT);
        gRes2.gridx =0;
        gRes2.gridy =6;
        gRes2.gridwidth =1;
        panel2.add(laTel,gRes2);
     
        JTextField textNumTel = new JTextField("Codigo de area y Numero");
        textNumTel.setColumns(15);
        gRes2.gridx =1;
        gRes2.gridwidth =GridBagConstraints.REMAINDER;
        gRes2.fill = GridBagConstraints.NONE;
        panel2.add(textNumTel,gRes2);
                  
       textNumTel.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked (MouseEvent e) {
                textNumTel.setText((""));
            }
        });
        
        
        //--Fecha Nacimiento
        JLabel laFechaNac = new JLabel("Fecha de nacimiento:");  
        laFechaNac.setFont(new Font("arial",3,12));
        laFechaNac.setForeground(Color.BLACK);
        gRes2.gridx =0;
        gRes2.gridy =7;
        gRes2.gridwidth =1;
        panel2.add(laFechaNac,gRes2);
        
        //Bajar libreria jCalendar para agregar JdateChooser
        JDateChooser dateNac = new JDateChooser();
        gRes2.gridx =1;
        gRes2.ipadx = 20;
        panel2.add(dateNac,gRes2);
        
        //-------- Mail ---------------
        JLabel laMail = new JLabel(" Mail : ");  
        laMail.setFont(new Font("arial",3,12));
        laMail.setForeground(Color.BLACK);
        laMail.setHorizontalAlignment(JLabel.RIGHT);
        gRes2.gridx =0;
        gRes2.gridy =8;
        gRes2.gridwidth =1;
        gRes2.anchor = GridBagConstraints.WEST;
        gRes2.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(laMail,gRes2);
        JTextField textMailReg = new JTextField();
        textMailReg.setColumns(20);
        gRes2.gridx =1;
        gRes2.gridwidth =1;
        panel2.add(textMailReg,gRes2);
        
        JLabel labelPassReg = new JLabel("Contraseña : ");
        labelPassReg.setForeground(Color.BLACK);
        labelPassReg.setHorizontalAlignment(JLabel.RIGHT);
        gRes2.gridx =0;
        gRes2.gridy =9;
        gRes2.gridwidth =1;
        panel2.add(labelPassReg,gRes2);
        JPasswordField textPassReg = new JPasswordField();
        textPassReg.setColumns(10);
        gRes2.gridx =1;
        gRes2.gridwidth =1;
        panel2.add(textPassReg,gRes2);
    
    //-----PANEL 3-------------------------
        
          JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        Boton botonEntrar=new Boton("ENTRAR");
        panel3.add(botonEntrar);
      
        botonEntrar.addMouseListener(new MouseAdapter() { 
            
            @Override
            public void mouseClicked(MouseEvent e) {
               
                UsuarioDB usuarios = new UsuarioDB();
                ArrayList <Usuario> arrUsuarios = new ArrayList<>();
                arrUsuarios = usuarios.getUsuarios();
               
                boolean autorizado = false;
                char passArray[] = textPass.getPassword();
                String pass = new String(passArray);
                System.out.println(pass);
                Iterator iter = arrUsuarios.iterator();
                Usuario uAux=null;
              
                
                 while ((iter.hasNext())&(autorizado == false)){
                     uAux=(Usuario)iter.next();
                    if ((uAux.getMail().equals(textMail.getText()))&& (uAux.getPass().equals(pass)))
                    {        
                        autorizado = true;
                        System.out.println(autorizado);
                        
                    }
                    
                }
                
                
                
                if (autorizado == true){
                     //new VentanaViajes().setVisible(true);
                     int nro=2;
                     loguetin = true;
                     usuarioActual = uAux;
                     VentanaViajes viajes = new VentanaViajes(uAux);
                     viajes.setVisible(true);
                     self.setVisible(false);
                }
               
                else{
                    
                    JOptionPane.showMessageDialog(self,"Nombre o pass Incorrecto");
                    textMail.setText("");
                    textPass.setText(""); 
                    
                 }
            }
        });
        
        
    //----PANEL 4 ---------------------
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.TRAILING,0,0));
        Boton botonRegis=new Boton("REGISTRARSE");
        panel4.add(botonRegis);
        
        botonRegis.addMouseListener(new MouseAdapter() { //MouseAdapter, lee cuando se clikea sobre el boton
            @Override
            public void mouseClicked (MouseEvent e) {
                String genero;
                if (RBm.isSelected() == true) {
                    genero = "m";
                } else {
                    genero = "f";
                }
               
                
                String Ciudad = (String)comboOrigen.getItemAt(comboOrigen.getSelectedIndex());
                boolean noAutorizado = false;
                UsuarioDB usuarios = new UsuarioDB();
                ArrayList <Usuario> arrUsuarios = new ArrayList<>();
                arrUsuarios = usuarios.getUsuarios();  
                for(Usuario uAux : arrUsuarios){
                    if (uAux.getMail().equals(textMailReg.getText()))
                    {
                           noAutorizado = true;
                    JOptionPane.showMessageDialog(self, "Mail Ya Existente");
                    }
                }                    
                if (textMailReg.getText().isEmpty() || textPassReg.getText().isEmpty() || textNom.getText().isEmpty()
                         || textCalle.getText().isEmpty() || textNumTel.getText().isEmpty()
                        || textApe.getText().isEmpty() && dateNac.isValid() || (!"f".equals(genero) 
                        && !"m".equals(genero)) || noAutorizado == true || "Seleccione ciudad".equals(Ciudad)){
                            JOptionPane.showMessageDialog(self, "Faltan Datos o Hay Datos Erroneos"); 
                        
                } 
                else {
                    String nombre = textNom.getText();
                    String apellido = textApe.getText();
                    String mail = textMailReg.getText();
                //   String contras = textPassReg.getText();
              
                    char passArray[] = textPassReg.getPassword();
                    String pass = new String(passArray);
                    String numTel = textNumTel.getText();
                    String direccion = textCalle.getText();
               
                    //Calendar fechaNa = dateNac.getCalendar();
                    String gene = genero;
                    int activo = 1;
                    int cuenta = 1;
                    java.util.Date fecha =  dateNac.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    String fechaNacSalida = sdf.format(fecha);
                    String ciudad = (String)comboOrigen.getSelectedItem();
                    UsuarioDB u = new UsuarioDB();
                    //UsuarioRegDB usuNewReg = new UsuarioRegDB(nombre, apellido, numTel, direccion, fechaNacSalida, mail, contras, gene, activo, cuenta, Ciudad);
                    int idUsuario = u.InsertUsuario(nombre,apellido, numTel, direccion, fechaNacSalida, mail,pass, gene, activo, ciudad);
                    System.out.println(idUsuario);
                    if(idUsuario != 0){
                        Usuario auxu = u.getUnUsuario(idUsuario);
                        JOptionPane.showMessageDialog(self, "Creación de cuenta exitoso");
                        loguetin = true;
                        usuarioActual = auxu;
                        VentanaViajes viajes = new VentanaViajes(auxu);
                        viajes.setVisible(true);
                        self.setVisible(false);
                    }
                
                }
            }
            
          });
        
                
     
 
    //-----panel1
        res.gridx=0;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.RELATIVE;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,20,0,0);
        this.add(panel1,res);
        
    //------panel2
        res.gridx=1;
        res.gridy=1;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.fill = GridBagConstraints.BOTH;
        res.insets = new Insets(0,0,0,20);
        res.ipady = 0;
        this.add(panel2,res);
        
    //-----panel3
        res.gridx=0;
        res.gridy=2;
        res.gridheight=GridBagConstraints.REMAINDER;
        res.gridwidth=GridBagConstraints.RELATIVE;
        res.anchor = GridBagConstraints.CENTER;
        res.fill = GridBagConstraints.HORIZONTAL;
        res.insets = new Insets(0,0,0,0);
     
        this.add(panel3,res);
        
    //-----panel4
        res.gridx=1;
        res.gridy=2;
        res.gridheight=GridBagConstraints.REMAINDER;
        res.gridwidth=GridBagConstraints.REMAINDER;
        res.insets = new Insets(10,0 ,0,20);
        this.add(panel4,res);
       
        MyLog.write("Cargo VentanaRegistracion");
   }
    
}
 
   
  
   
    
    

    
    
