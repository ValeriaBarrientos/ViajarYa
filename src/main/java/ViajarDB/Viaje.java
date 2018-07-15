/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class Viaje {
    private int idViaje;
    private String origen;
    private String destino;
    double gastosaproximados;
    Date fechaPartida;
    Date horaPartida;
    Usuario conductor;
    private String lugar_salida;
    private boolean mascota;
    private boolean fumador;
    private Date fecha_creacion;
 
    
    
    Viaje(int id,String origen, String destino, double gastosaproximados, Date fecha,Date hora, Usuario conductor,String lugar_salida,boolean mascota,boolean fumador,Date fecha_creacion){
        this.idViaje=id;
        this.origen=origen;
        this.destino=destino;
        this.gastosaproximados=gastosaproximados;
        this.fechaPartida=fecha;
        this.horaPartida=hora;
        this.conductor=conductor;
        this.lugar_salida=lugar_salida;
        this.mascota=mascota;
        this.fumador=fumador;
        this.fecha_creacion=fecha_creacion;
    }
    
    
      // ---------constructor sin conductor solo para probar tabla en pantalla
    Viaje(int id,String origen, String destino, double gastosaproximados,Date fecha,Date hora,String lugar_salida,boolean mascota,boolean fumador,Date fecha_creacion){
        this.idViaje=id;
        this.origen=origen;
        this.destino=destino;
        this.gastosaproximados=gastosaproximados;
        this.fechaPartida=fecha;
        this.horaPartida=hora;
        this.lugar_salida=lugar_salida;
        this.mascota=mascota;
        this.fumador=fumador;
        this.fecha_creacion=fecha_creacion;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }
    
    
    
    public void setOrigen(String origen){
        this.origen=origen;
    }
    
    public String getOrigen(){
        return this.origen;
    }
    
    public void setDestino(String destino){
        this.destino=destino;
    }
    
    public String getDestino(){
        return this.destino;
    }

    public double getGastosaproximados() {
        return gastosaproximados;
    }

    public void setGastosaproximados(double gastosaproximados) {
        this.gastosaproximados = gastosaproximados;
    }
    
    
    
    public void setFechaPartida(Date fechora){
        this.fechaPartida=fechora;
    }
    
    public Date getFechaPartida(){
        return this.fechaPartida;
    }

    public Date getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Date horaPartida) {
        this.horaPartida = horaPartida;
    }
    
    
    
    public void setConductor(Usuario conductor){
        this.conductor=conductor;
    }
    
    public Usuario getConductor(){
        return this.conductor;
    }

    public String getLugar_salida() {
        return lugar_salida;
    }

    public void setLugar_salida(String lugar_salida) {
        this.lugar_salida = lugar_salida;
    }

    public boolean isMascota() {
        return mascota;
    }

    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }

    public boolean isFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    
  
    
 
}
