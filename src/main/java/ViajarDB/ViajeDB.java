/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViajarDB;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author vale2
 */
public class ViajeDB extends DbManager {
    private ArrayList<Viaje> resul= new ArrayList<Viaje>();
    private String consulta;
    private String[][] misViajes;
    private ArrayList<Calificacion> arrCal = new ArrayList<Calificacion>();
    private Viaje viaje;
    
    public ArrayList<Viaje> getViajes() {
        //ArrayList<Viaje> resul= new ArrayList<Viaje>();
        try {
            
            //String consulta = "SELECT * FROM viaje where fechayhora_partida > now()";
            ResultSet st = GET_RESULT_SET(consulta);
            
            while (st.next()) {
                int idViaje= st.getInt("id_viaje");
                String origen = st.getString("origen");
                String destino = st.getString("destino");
                Double gastosAprox = st.getDouble("gastos_aproximados");
                Date fechaPartida = st.getDate("fechayhora_partida");
                Date horaPartida = st.getTime("fechayhora_partida");
                String lugarSalida = st.getString("lugar_salida");
                boolean mascota = st.getBoolean("mascota");
                boolean fumador = st.getBoolean("fumador");
                Date fechaCreacion = st.getDate("fecha_creacion");                
                Viaje v = new Viaje (idViaje,origen,destino,gastosAprox,fechaPartida,horaPartida,lugarSalida,mascota,fumador,fechaCreacion);
                resul.add(v);
            }
            closeConections();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return resul;
    }
   
    
    public ArrayList<Viaje> getViajesActuales(){
            
            this.consulta = "SELECT * FROM viaje where fechayhora_partida > now() order by fechayhora_partida";
            return getViajes();
    }
    
    public ArrayList<Viaje> getViajesxCiudades(String ciudadOrigen,String ciudadDestino){
            
            this.consulta = "SELECT * from viaje where fechayhora_partida > now() and origen= '"+ciudadOrigen+"' and destino= '"+ciudadDestino+"' ";
            return getViajes();
        
        
    }
    
     public ArrayList<Viaje> getViajesxFecha(String fecha){
            
            this.consulta = "SELECT * from viaje where fechayhora_partida like '"+fecha+"%'";
            System.out.println(this.consulta);
            return getViajes();
        
        
    }
     
     public ArrayList<Viaje> getViajesxCiudadesxFecha(String ciudadOrigen,String ciudadDestino,String fecha){
            
            this.consulta = "SELECT * from viaje where fechayhora_partida like '"+fecha+"%' and origen= '"+ciudadOrigen+"' and destino= '"+ciudadDestino+"' ";
            return getViajes();
        
        
    } 
     
     public String[][]getMisViajes(int idUsuario){
            
        String[][] viajes= new String[100][10];   
          
           this.consulta = "select v.id_viaje,v.fechayhora_partida,v.origen,v.destino,v.lugar_salida,a.marca,a.modelo,u.nombre,u.apellido "+
                            "from viaje v "+
                            "inner join viaje_has_usuario as vhu on vhu.Viaje_id_viaje=v.id_viaje "+
                            "inner join auto as a on a.id_auto=vhu.Auto_id_auto "+
                            "inner join usuario as u on u.id_usuario=a.id_propietario "+
                            "where vhu.Usuario_id_usuario ='"+idUsuario+"'"+
                            "order by fechayhora_partida desc;";
            try {
                
               
            ResultSet st = GET_RESULT_SET(consulta);
            int f=0;
            
           
            while (st.next()) {
               
                String idViaje = st.getString("id_viaje");
                int idV = st.getInt("id_viaje");
                viajes[f][0]= idViaje;
                Date fechaPartida = st.getDate("fechayhora_partida");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = sdf.format(fechaPartida);
                viajes[f][1]= fecha;
                String origen = st.getString("origen");
                viajes[f][2]= origen;
                String destino = st.getString("destino");
                viajes[f][3]= destino;
                String lugarSalida = st.getString("lugar_salida");
                viajes[f][4]= lugarSalida;
                String marca = st.getString("marca");
                viajes[f][5]= marca;
                String modelo = st.getString("modelo");
                viajes[f][6]= modelo; 
                String nombre = st.getString("nombre");
                String apellido = st.getString("apellido");
                viajes[f][7]= nombre+" "+apellido;
                Calificacion calif = obtenerCalificacion (idV,idUsuario);
                if(calif != null){
                        System.out.println(calif.getPuntuacion());
                        int puntaje = calif.getPuntuacion();
                        String nota;
                          switch (puntaje) {
                            case 5:
                                nota="EXCELENTE";
                                break;
                            case 4:
                                nota="MUY BUENO";
                                break;
                            case 3:
                                nota="BUENO";
                                break;
                            case 2:
                                nota="REGULAR";
                                break;
                            case 1:
                                nota="MALO";
                                break;
                         default: nota =" "; break;
                    }
                    viajes[f][8]= nota;
                    viajes[f][9]= calif.getComentario();
                }
                else{
                    viajes[f][8]= " ";
                    viajes[f][9]= " ";
                }
            f++;
                
            }
            closeConections();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return viajes;
    }
   
       //----------------------alejandro--------------------------------------------------------
     //------------------------retorno el detalle de un viaje en especifico------------------
    
     public Viaje getViajeUsuario(int idViaje){
       
        
        try {   
             
            String consulta = "select v.*,u.nombre,u.apellido,u.genero,a.*,vhu.Usuario_id_usuario "+
                              "from viaje v "+
                              "inner join viaje_has_usuario as vhu on vhu.Viaje_id_viaje=v.id_viaje "+
                              "inner join auto as a on a.id_auto=vhu.Auto_id_auto "+
                              "inner join usuario as u on u.id_usuario=a.id_propietario "+
                              "where v.id_viaje ='"+idViaje+"'";
            
            
           /* 
            String consulta = "SELECT v.*, u.nombre,u.apellido,a.* FROM viaje v join viaje_has_usuario vu " +
             "on v.id_viaje = vu.Viaje_id_viaje " +
             "join usuario u on u.id_usuario = vu.Usuario_id_usuario " +
             "join auto a on a.id_auto = vu.Auto_id_auto " +
             "where v.id_viaje="+idViaje;*/


             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            int id_usuario = st.getInt("Usuario_id_usuario");
            int id_Viaje = st.getInt("id_viaje");
            String genero = st.getString("genero");
            String nombre = st.getString("nombre");
            String apellido = st.getString("apellido");
            Usuario conductor =new Usuario(nombre, apellido,id_usuario,genero);
            String nombreCiudadOrigen = st.getString("origen");
            String nombreCiudadDestino = st.getString("destino");
            double gastosAprox = st.getDouble("gastos_aproximados");
            String lugarDeSalida = st.getString("lugar_salida");
            boolean mascota = st.getBoolean("mascota");
            System.out.println("acepta mascota"+ mascota);
            boolean fumador = st.getBoolean("fumador");
            Date fechaCreacion = st.getDate("fecha_creacion");
            Date fecha = st.getDate("fechayhora_partida");
            Date hora = st.getTime("fechayhora_partida");
            viaje = new Viaje(id_Viaje,nombreCiudadOrigen,nombreCiudadDestino,gastosAprox,fecha,hora,conductor,lugarDeSalida,mascota,fumador,fechaCreacion);
        
            resul.add(viaje);
        }
         closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return resul.get(0);  
    
    }
    
    public int getCantidadAsientos(int idViaje){
        Viaje viaje = null;
        int cantAsiento=0;
        try {   
             String consulta = "SELECT * FROM viaje_has_usuario where Viaje_id_viaje = '"+idViaje+"'";
             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            cantAsiento++;
        }
         closeConections();
      } 
      catch (SQLException ex) {
        ex.printStackTrace();
      }
        
      return cantAsiento;  
    
    }
     
    public boolean existeUsuarioEnViaje (int idViaje, int idUsuario){
        boolean VoF = false;
        try{
            String consulta="SELECT * FROM viaje_has_usuario where Viaje_id_viaje = '"+idViaje+"' and Usuario_id_usuario= '"+idUsuario+"'";
            ResultSet st = GET_RESULT_SET(consulta);
            if(st.absolute(1))
                VoF=true;
            //else
            //    VoF=true;
            closeConections();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return VoF;
    }
    
    public void insertarUsuarioEnViaje(int idViaje, int idUsuario, int idAuto){
        String SSQL="Insert into viaje_has_usuario(Viaje_id_viaje,Usuario_id_usuario,Auto_id_auto) values ("+idViaje+","+idUsuario+","+idAuto+")";
        super.InsertSql(SSQL);
    }   
    
     public void insertarCalificacion(int idViaje, int idUsuario, int idAuto,int puntaje,String descripcion){
         
        String SSQL="Insert into calificacion (Viaje_has_Usuario_Viaje_id_viaje,Viaje_has_Usuario_Usuario_id_usuario,Viaje_has_Usuario_Auto_id_auto,puntuacion,descripcion)\n" +
                    "values ("+idViaje+","+idUsuario+","+idAuto+","+puntaje+",'"+descripcion+"');";
        super.InsertSql(SSQL);
    }   
   
    public Calificacion obtenerCalificacion (int idViaje,int idUsuario){
        
        Calificacion calif=null ;
        try {   
             String consulta = "SELECT  calificacion.* "+
                               "from calificacion "+
                               "where Viaje_has_Usuario_Viaje_id_viaje ="+idViaje+" and Viaje_has_Usuario_Usuario_id_usuario ="+idUsuario+";";
             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            int idCal=st.getInt("id_calificacion");
            int puntaje = st.getInt("puntuacion");
            String comentario = st.getString("descripcion");
            int idAuto = st.getInt("Viaje_has_Usuario_Auto_id_auto");
            calif = new Calificacion(idCal,puntaje,comentario,idViaje,idUsuario,idAuto);
            
        }
         closeConections();
        
       
        } 
        catch (SQLException ex) {
        ex.printStackTrace();
        }
        
      return calif;  
        
        
    }
   
    
      public ArrayList<Calificacion> obtenerCalificacionesConductor (int idAuto,int idPropietario){
        
        
        Calificacion calif = null;
        try {   
            /* String consulta = "SELECT c.*"+
                  " from auto a join viaje_has_usuario vhu"+
                  " on a.id_auto = vhu.Auto_id_Auto"+
                  " join calificacion c on vhu.Auto_id_Auto = c.Viaje_has_Usuario_Auto_id_Auto"+
                  " where a.id_propietario = " + idPropietario+
                  " Group by Viaje_has_Usuario_Usuario_id_usuario";*/
            
            
             String consulta ="SELECT c.* "+
                            "from calificacion c "+
                            "inner join auto a "+
                            "on a.id_auto = c.Viaje_has_Usuario_Auto_id_auto "+
                            "where a.id_propietario="+idPropietario+";";
            
             System.out.println(consulta);
             ResultSet st = GET_RESULT_SET(consulta);
             
        while (st.next()) {
            int idCal=st.getInt("id_calificacion");
            int puntaje = st.getInt("puntuacion");
            String comentario = st.getString("descripcion");
            int idViaje = st.getInt("Viaje_has_Usuario_Viaje_id_viaje");
            int idUsuario= st.getInt("Viaje_has_Usuario_Usuario_id_usuario");
            calif = new Calificacion(idCal,puntaje,comentario,idViaje,idUsuario,idAuto);
            arrCal.add(calif);
            System.out.println(calif.getId_calificacion());
            System.out.println(calif.getComentario());
        }
         closeConections();
        
       
        } 
        catch (SQLException ex) {
        ex.printStackTrace();
        }
        
      return arrCal; 
        
        
    } 
    
  
    
    public void updateViaje(int id,String origen,String destino,double gastos,String fechayHoraPartida, String lugar, int mascota, int fumador,String hoy){
        
      try{ 
        
        String SQL= "UPDATE viaje set origen = '"+origen+"',destino='"+destino+"',gastos_aproximados='"+gastos+
                                                "',fechayhora_partida='"+fechayHoraPartida+"',lugar_salida='"+lugar+
                                                "',mascota="+mascota+",fumador="+fumador+",fecha_creacion='"+hoy+"' WHERE id_viaje ="+id+";";
        
        System.out.println(SQL);
        super.InsertSql(SQL);
        closeConections();
      }
       catch (SQLException ex) {
        ex.printStackTrace();
      }
      
      
    }
      
    
    
 public void insertViajeHasUsuario(int idViaje,int idUsuario,int idAuto){
           String SSQL = "insert into viaje_has_usuario(Viaje_id_viaje,Usuario_id_usuario,Auto_id_Auto) values "+
                      "( '"+idViaje+"','"+idUsuario+"','"+idAuto+"');";
             super.InsertSql(SSQL);
    }
     
     
public int insertViaje(String ciudadOrigen,String ciudadDestino, double gastos,String fecha,String hora,String lugarSalida,int mascota,int fumador,String hoy){
        String SSQL = "insert into viaje(origen,destino,gastos_aproximados,fechayhora_partida,lugar_salida,mascota,fumador,fecha_creacion) values "+
                      "( '"+ciudadOrigen+"','"+ciudadDestino+"','"+gastos+"','"+fecha+" "+hora+"','"+lugarSalida+"',"+mascota+","+fumador+",'"+hoy+"');";
       return super.InsertSql(SSQL);
    }   
        
   
public void retirarseViaje(int idUsuario,int idViaje){
    
    try{ 
        
        String SQL="DELETE FROM viaje_has_usuario "+
                   "WHERE Viaje_id_viaje ="+idViaje+ " and Usuario_id_usuario ="+idUsuario+";";
        
        System.out.println(SQL);
        super.InsertSql(SQL);
        closeConections();
      }
       catch (SQLException ex) {
        ex.printStackTrace();
      }
      
   
    
}

   public Boolean tieneViajesPendientes(int idAuto){
     
       boolean tiene;
       int cantidadViajes =0;
        try{
             String SSQL = "select count(*) Viaje_id_viaje"+
                         " from viaje_has_usuario as vhu"+
                         " inner join viaje as v"+
                         " on v.id_viaje = vhu.Viaje_id_viaje"+
                         " where v.fechayhora_partida > now() and vhu.Auto_id_auto = "+idAuto+";";

            ResultSet st = GET_RESULT_SET(SSQL);
             while (st.next()){
                cantidadViajes = st.getInt("Viaje_id_viaje");
             }
                 
            closeConections();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if (cantidadViajes == 0 )
               tiene= false;
           else
               tiene= true;
       
  
           
        return tiene;
                        
   }


}
      
      
   
 
    
