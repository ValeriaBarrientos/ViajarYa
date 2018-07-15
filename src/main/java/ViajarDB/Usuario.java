/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vale2
 */
public class Usuario {
    
    
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String ciudad;
    private Date fecha_nacimiento;
    private String mail;
    private String pass;
    private String imagen; 
    private String genero;
    private boolean activo;
   
  
    
    //Solo para probrar ventana
    public Usuario(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }

    
       //ale cargo algunos datos para el viaje---------------------------------
    public Usuario(String nombre, String apellido,int idUsuario,String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_usuario=idUsuario;
        this.genero=genero;
    }
    //-------------------------------

    

    //carga de datos obligatorio
    public Usuario(int id_usuario, String nombre, String apellido, String telefono, String direccion,String ciudad, Date fecha_de_nacimiento,String mail,  String pass, String genero,boolean activo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.fecha_nacimiento = fecha_de_nacimiento;
        this.mail = mail;
        this.pass = pass;
        this.genero = genero;
        this.activo = activo;
   
    }
    
    
     //carga con imagen
    public Usuario(int id_usuario, String nombre, String apellido, String telefono, String direccion,String ciudad,Date fecha_nacimiento, String mail,String pass, String imagen, String genero,boolean activo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.mail = mail;
        this.pass = pass;
        this.imagen = imagen;
        this.genero = genero;
        this.activo = activo;
       
       
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

  

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    

    

    
    
    
    
}
