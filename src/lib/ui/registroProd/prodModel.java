/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.registroProd;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.app.DBConnection;

/**
 *
 * @author Fredy AGP
 */
public class prodModel {
    private DBConnection conn = new DBConnection();
    
    public int registro_prod(String nombre, String marca,String tipo,int nit,int cantidad, String metodo,String lugar,String fecha,String usr,String descrip){
        int retornador=0;   
        try
        {
            startConnection();
            conn.executeQuery("INSERT INTO productos VALUES("+"null"+usr+","+ Integer.toString(nit) +","+ marca +","+ tipo +","+ Integer.toString(cantidad) +","+ metodo+","+lugar+","+nombre+","+descrip+", STR_TO_DATE("+fecha+", '%Y-%m-%d'));");
            ResultSet result = conn.executeQuery("select pru_nombre from productos ");
            if(result.next()==false)
            {
                retornador=0;
            }
            else
            {
                retornador=1;
            }
            endConnection();
        }
        catch(SQLException e)
        {
            System.out.println("Ha ocurrido una SQLExeption: " + e.getMessage());   
        }
           return retornador;
    }
    
 private void startConnection(){
        conn.getConnection();
    }
 private void endConnection(){
        conn.endCOnnection();
    }
}
 

