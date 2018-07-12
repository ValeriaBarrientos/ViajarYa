/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

/**
 *
 * @author vale2
 */
public class Calificacion {
    private int id_calificacion; 
    private int puntuacion;
    private String comentario;
    private int idViaje;
    private int idUsuario;
    private int idAuto;

    public Calificacion(int id_calificacion, int puntuacion, String comentario, int idViaje, int idUsuario, int idAuto) {
        this.id_calificacion = id_calificacion;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.idViaje = idViaje;
        this.idUsuario = idUsuario;
        this.idAuto = idAuto;
    }

    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdviaje() {
        return idViaje;
    }

    public void setIdviaje(int idviaje) {
        this.idViaje = idviaje;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }
    
    
    






}
