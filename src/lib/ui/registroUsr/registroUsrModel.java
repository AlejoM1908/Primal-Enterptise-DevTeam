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

/**
 *
 * @author Fredy AGP
 */
public class registroUsrModel {

    private DBConnection conn = new DBConnection();

    private registroUsr registroUsrView;
    private MainAppController rootComponent;

    public registroUsrModel(registroUsr registroUsrView) {
        this.registroUsrView = registroUsrView;
    }

    public void registro(String usuario, int cedula, String rang, String password, String email, int telefono, String direccion, String nombre) {
        try {
            startConnection();
            conn.executeQuery("call InsertUser(" + nombre + "," + Integer.toString(cedula) + "," + rang + "," + password + "," + Integer.toString(telefono) + "," + email + "," + direccion + "," + usuario + ");");
            ResultSet result = conn.executeQuery("select * from usuarios");
            if (result.next() == false) {

            }
            endConnection();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una SQLExeption: " + e.getMessage());
        }

    }
    
    public void clearFields(){
        this.registroUsrView.getNombreTF().setText("");
        this.registroUsrView.getCedulaTF().setText("");
        this.registroUsrView.getEmailTF().setText("");
        this.registroUsrView.getTelefonoTF().setText("");
        this.registroUsrView.getDireccionTF().setText("");
        this.registroUsrView.getRangoTF().setText("");
        this.registroUsrView.getNombreUsuarioTF().setText("");
        this.registroUsrView.getContraseñaTF().setText("");
    }

    public registroUsr getRegistroUsrView() {
        return registroUsrView;
    }

    public void setRegistroUsrView(registroUsr registroUsrView) {
        this.registroUsrView = registroUsrView;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    

    private void startConnection() {
        conn.getConnection();
    }

    private void endConnection() {
        conn.endCOnnection();
    }
}
