/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.EditAccount;

import javax.swing.JOptionPane;
import lib.app.DBConnection;

/**
 *
 * @author user
 */
public class EditAccountModel {
    
    private EditAccountView view;

    public EditAccountModel(EditAccountView view) {
        this.view = view;
    }
    
    public boolean ValidateLength(){
        String name = view.getJtxtName().getText();
        String email = view.getJtxtEmail().getText();
        String number = view.getJtxtNumber().getText();
        String password = view.getJpfPassword().getText();
        if(name.isEmpty() || email.isEmpty() || number.isEmpty() || password.isEmpty()){
            return true;
        }
        return false;
    }
    
    public boolean validateFormat(){
        try{
            int number = Integer.parseInt(view.getJtxtNumber().getText());
        }catch(NumberFormatException e){
            return true;
        }
        return false;
    }
    
    public void updateUserInfo(){
        String name = view.getJtxtName().getText();
        String email = view.getJtxtEmail().getText();
        int number = Integer.parseInt(view.getJtxtNumber().getText());
        String password = String.valueOf(view.getJpfPassword().getPassword());
        DBConnection conn = new DBConnection();
        conn.getConnection();
        //conn.executeQuery("CALL editar_datos_usuario(" + password +", " +  email +", " 
                           //+ number +", " +  name +", " +  usuario +", " +  ");");
        conn.getConnection();
        
        
    }

    public EditAccountView getView() {
        return view;
    }

    public void setView(EditAccountView view) {
        this.view = view;
    }
    
    
}
