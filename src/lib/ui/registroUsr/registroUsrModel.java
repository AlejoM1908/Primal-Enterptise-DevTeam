/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.registroUsr;


import java.sql.ResultSet;
import java.sql.SQLException;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;
import lib.ui.registroUsr.registroUsr;

/**
 *
 * @author Fredy AGP
 */
public class registroUsrModel {
    private registroUsr view;
    private DBConnection conn = new DBConnection();
    private MainAppController rootComponent;
    
    public registroUsrModel() {
    }

    public registroUsr getView() {
        return view;
    }

    public void setView(registroUsr view) {
        this.view = view;
    }
    
    public void registro(String usuario,int cedula,String rang,String password, String email, int telefono, String direccion,String nombre){
        try
        {
            startConnection();
            conn.executeQuery("call InsertarUsr("+nombre+","+ Integer.toString(cedula) +","+ rang +","+ password +","+ Integer.toString(telefono) +","+ email +","+ direccion +","+ usuario +");");
            ResultSet result = conn.executeQuery("select * from usuarios");
            if(result.next()==false)
            {
                
            }
            endConnection();
        }
        catch(SQLException e)
        {
            System.out.println("Ha ocurrido una SQLExeption: " + e.getMessage());   
        }
        

    }
    
 private void startConnection(){
        conn.getConnection();
    }
 private void endConnection(){
        conn.endCOnnection();
    }
 public MainAppController getRootComponent() {
        return rootComponent;
    }
 public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
}
 