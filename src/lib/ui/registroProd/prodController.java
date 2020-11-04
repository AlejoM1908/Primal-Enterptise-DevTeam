/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.registroProd;

/**
 *
 * @author Fredy AGP
 */
public class prodController {
    
    public int registrados (String nombre, String marca,String tipo,String nit,String cantidad, String metodo,String lugar,String fecha,String usr,String descrip)
    {
        int registro_retorno;
        int num_nit;
        int num_cantidad;
         try
       {
           num_nit=Integer.parseInt(nit);
           
       } catch (NumberFormatException ex)
       {
           return 0;
       }
          try
       {
           num_cantidad=Integer.parseInt(cantidad);
           
       } catch (NumberFormatException ex)
       {
           return 0;
       }
        prodModel registro =new prodModel();
        registro_retorno= registro.registro_prod(nombre,marca,tipo,num_nit,num_cantidad,metodo,lugar,fecha,usr,descrip);
        return registro_retorno;
    }
}
