/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.registroUsr;
import lib.ui.registroUsr.registroUsrModel;
/**
 *
 * @author Fredy AGP
 */
public class registroUsrController {
    
    
    
    public int registrados (String nombre, String email,String direccion,String rol,String usr, String pass,String cedula,String telefono)
    {
        int cedula_num;
        int telefono_num;
         try
       {
           cedula_num=Integer.parseInt(cedula);
           
       } catch (NumberFormatException ex)
       {
           return 0;
       }
          try
       {
           telefono_num=Integer.parseInt(telefono);
           
       } catch (NumberFormatException ex)
       {
           return 0;
       }
        if(usr.length()>=25)
        {
            return 0;
        }
        if(pass.length()>=25)
        {
            return 0;
        }
        if(email.contains("@")==false)
        {
            return 0;
        }
         registroUsrModel insercion = new registroUsrModel();
         insercion.registro(usr, cedula_num, rol, pass, email, telefono_num, direccion, nombre);
        return 1;
    }
}
