/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

/**
 *
 * @author Diego
 */
public class Auto {
    private Usuario conductor;
    private int id_auto;
    private String marca;
    private String modelo;
    private String color;
    private String combustible;
    private String patente;
    private boolean aire_acondicionado;
    private boolean calefaccion;
    private short cantidad_de_asientos;
    private String capacidad_baul;
    private String foto;
//private String condiciones; // hace referencia a si esta en buenas condiones de viajar. (VTV, cinturon de seguridad, etc)
    private short calificacion; //calificacion del 1 al 10 del estado general del auto
    private boolean cuenta;
    
    Auto(int id_auto,String marca, String modelo, String color, String combustible, String patente, boolean aireacondicionado, boolean calefaccion, short cantidad_de_asientos, short calificacion,String capacidad_baul,String foto,boolean cuenta){
        //this.conductor=conductor;
        this.id_auto=id_auto;
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
        this.combustible=combustible;
        this.patente=patente;
        this.aire_acondicionado=aireacondicionado;
        this.calefaccion=calefaccion;
        this.cantidad_de_asientos=cantidad_de_asientos;
        this.capacidad_baul=capacidad_baul;
        this.foto=foto;
        this.calificacion=calificacion;
        this.cuenta = cuenta;
    }
    
    //constructor sin color
    Auto(String marca, String modelo, String combustible, String patente, boolean aireacondicionado, boolean calefaccion, short cantidad_de_asientos, short calificacion){
        this.marca=marca;
        this.modelo=modelo;
        this.combustible=combustible;
        this.patente=patente;
        this.aire_acondicionado=aireacondicionado;
        this.calefaccion=calefaccion;
        this.cantidad_de_asientos=cantidad_de_asientos;
        this.calificacion=calificacion;
    }

    public boolean isCuenta() {
        return cuenta;
    }

    public void setCuenta(boolean cuenta) {
        this.cuenta = cuenta;
    }

   
    
    
    
    
    
    public Usuario getConductor() {
        return conductor;
    }

    public void setConductor(Usuario conductor) {
        this.conductor = conductor;
    }

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public boolean isAire_acondicionado() {
        return aire_acondicionado;
    }

    public void setAire_acondicionado(boolean aire_acondicionado) {
        this.aire_acondicionado = aire_acondicionado;
    }

    public boolean isCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    public short getCantidad_de_asientos() {
        return cantidad_de_asientos;
    }

    public void setCantidad_de_asientos(short cantidad_de_asientos) {
        this.cantidad_de_asientos = cantidad_de_asientos;
    }

    public String getCapacidad_baul() {
        return capacidad_baul;
    }

    public void setCapacidad_baul(String capacidad_baul) {
        this.capacidad_baul = capacidad_baul;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public short getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(short calificacion) {
        this.calificacion = calificacion;
    }
    
   
    
}
