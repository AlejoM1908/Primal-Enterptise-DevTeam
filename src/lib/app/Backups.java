/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.app;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.CodeSource;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fredy AGP
 */
public class Backups {
    
   public void Preferencias(String nombre_db,String user,String pass)
   {
        LocalDate actual = LocalDate.now();
        LocalDate programacion = actual.plusDays(10);
        String programacion_futura=programacion.toString();
        File config = new File("Preferencias.txt");
        Scanner lector;
        LocalDate recuperada=LocalDate.now();;
        if(config.exists())//si el doc existe
        {
            try//recupera la fecha almacenada en el doc
            {
                lector=new Scanner(config);
                String fecha="";
                while(lector.hasNextLine())
                {
                    fecha=lector.next();
                }
                lector.close();
                recuperada = LocalDate.parse(fecha);
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            long result = ChronoUnit.DAYS.between(actual,recuperada);//Busca la diferencia entre la fecha actual y la almacenada
            if(result<=0)//Si la diferencia de dias es menos o igual a 0, hace backups y refresca la fecha para el proximo
            {
                Guardar(nombre_db,user,pass);
                try
                {
                    FileWriter fw = new FileWriter(config);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(programacion_futura);
                    bw.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            Guardar(nombre_db,user,pass);
            try
            {
                FileWriter fw = new FileWriter(config);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(programacion_futura);
                bw.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }    
   }
    public void Guardar(String nombre_db,String user,String pass)
    {
        try {


           //crea las limitaciones para el backup
           //el archivo se llama backup.sql y se guarda en la carpeta backup
           
            String ruta_guardado = "backup.sql";

           //crea el comando cmd para ejecutar el backup
           String exe = "C:/Program Files/MySQL/MySQL Server 8.0/bin/mysqldump --routines -u" + user + " -p" + pass + " " + nombre_db + " -r " + ruta_guardado;

           //ejecuta el comando
           Process runtimeProcess = Runtime.getRuntime().exec(exe);
           int completo = runtimeProcess.waitFor();

           //si completo==0, se ejecuto correctamente, si no Tiene algun otro valor
           if (completo == 0) {
               System.out.println("Backup Exitosos");
           } else {
               JOptionPane.showMessageDialog(null,"Backup fallo");
           }

       } catch (IOException | InterruptedException ex) {
           JOptionPane.showMessageDialog(null, "Error de backup" + ex.getMessage());
       }
    }
    
    public void Restaurar (String nombre_db,String user,String pass)
    {
        try
        {
               String ruta_restauracion = "backup.sql";
               String[] exe = new String[]{"mysql", nombre_db, "-u" + user, "-p" + pass, "-e", " source " + ruta_restauracion};

               Process ejecutar = Runtime.getRuntime().exec(exe);
               int completo = ejecutar.waitFor();
               
               if (completo == 0) {
                   JOptionPane.showMessageDialog(null, "restauracion Exitosa");
               } else {
                   JOptionPane.showMessageDialog(null, "Restauracion fallida");
               }

           } catch (IOException | InterruptedException | HeadlessException ex) {
               JOptionPane.showMessageDialog(null, "Error al restaurar" + ex.getMessage());
           }

    }
}