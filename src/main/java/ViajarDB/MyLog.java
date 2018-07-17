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

 import java.io.*;
import java.net.URLDecoder;
 import java.text.*;
 import java.util.*;

     public class MyLog {

    public static void write(Exception ex) {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        String exceptionDetails = sw.toString();   
        write("Error:" + exceptionDetails);
     }

     public static void write(String s) {
         TimeZone tz = TimeZone.getTimeZone("EST"); // or PST, MID, etc ...
         Date now = new Date();
         DateFormat df = new SimpleDateFormat ("yyyy.mm.dd hh:mm:ss ");
         df.setTimeZone(tz);
         String currentTime = df.format(now);
         
         try {
             //Directorio donde corre el jar
            File path = new File(MyLog.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String jarPath = URLDecoder.decode(path.getParent(), "UTF-8");
                
            //archivo logs
            FileWriter aWriter = new FileWriter(jarPath + "\\viajarYaLog.txt", true);
            aWriter.write(currentTime + " " + s + "\n");
            aWriter.flush();
            aWriter.close();
         }
         catch(IOException ex) 
         {
            ex.printStackTrace();
         }
     }
 }

