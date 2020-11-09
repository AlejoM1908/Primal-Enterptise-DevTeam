/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.app;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.CodeSource;
import javax.swing.JOptionPane;

/**
 *
 * @author Fredy AGP
 */
public class Backups {
    
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
               JOptionPane.showMessageDialog(null,"Backup completado");
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
