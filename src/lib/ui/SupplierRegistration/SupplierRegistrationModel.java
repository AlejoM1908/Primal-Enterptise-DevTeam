/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.SupplierRegistration;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;

/**
 *
 * @author user
 */
public class SupplierRegistrationModel {
    
    private SupplierRegistrationView view;
    
    private MainAppController rootComponent;

    public SupplierRegistrationModel(SupplierRegistrationView view) {
        this.view = view;
    }
    
    
    public boolean validateLength(){
        String name = view.getJtxtName().getText();
        String nit = view.getJtxtNit().getText();
        String address = view.getJtxtAddress().getText();
        String email = view.getJtxtEmail().getText();
        String phoneNumber = view.getJtxtPhoneNumber().getText();
        if(name.isEmpty() || nit.isEmpty() || address.isEmpty() || email.isEmpty()
            || phoneNumber.isEmpty()){
            return true;
        }
        return false;
    }
    
    public boolean validateFormat(){
        try{
            int nit = Integer.parseInt(view.getJtxtNit().getText());
            int phoneNumber = Integer.parseInt(view.getJtxtPhoneNumber().getText());
        }catch(NumberFormatException e){
            return true;
        } 
        return false;
    }
    
    public boolean validateNit(int nitEntered) throws SQLException{
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = conn.executeQuery("SELECT COUNT(pve_nit) FROM proveedores WHERE pve_nit = " + Integer.toString(nitEntered) + ";");
        result.next();
        if(result.getInt(1) > 0){
            conn.endCOnnection();
            return true;
        }
        conn.endCOnnection();
        return false;
    }
    
    public void registerSupplier(){
        DBConnection conn = new DBConnection();
        conn.getConnection();
        String name = "\"" + view.getJtxtName().getText() + "\"";
        int nit = Integer.parseInt(view.getJtxtNit().getText());
        String address = "\"" + view.getJtxtAddress().getText() + "\"";
        String email = "\"" + view.getJtxtEmail().getText() + "\"";
        int phoneNumber = Integer.parseInt(view.getJtxtPhoneNumber().getText());
        String user = "\"" + this.rootComponent.getMainAppModel().getLoggedUser().getUser() + "\"";
        conn.executeQuery("CALL insertProvider(" + name + "," + nit + "," 
                         + phoneNumber + "," + email + "," + address + "," + user + ");");
        conn.endCOnnection();
    }
    
    public void clearFields(){
        this.view.getJtxtAddress().setText("");
        this.view.getJtxtEmail().setText("");
        this.view.getJtxtName().setText("");
        this.view.getJtxtNit().setText("");
        this.view.getJtxtPhoneNumber().setText("");
    }

    public SupplierRegistrationView getView() {
        return view;
    }

    public void setView(SupplierRegistrationView view) {
        this.view = view;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    
}
