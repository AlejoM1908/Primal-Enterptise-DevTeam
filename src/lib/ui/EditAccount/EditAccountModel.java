/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.EditAccount;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import lib.app.DBConnection;
import lib.models.User;
import lib.ui.MainApp.MainAppController;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class EditAccountModel {
    private DBConnection conn = new DBConnection();
    private EditAccountView view;
    
    private User user;
    
    private MainAppController rootComponent;

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
        String name = "\"" + view.getJtxtName().getText() + "\"";
        String email = "\"" + view.getJtxtEmail().getText() + "\"";
        String loggedUser = "\"" + view.getJtxtUser().getText() + "\"";
        String number = "\"" + view.getJtxtNumber().getText() + "\"";
        String password = "\"" + String.valueOf(view.getJpfPassword().getPassword()) + "\"";
        String rango= "\"" + String.valueOf(view.getJtxtRange().getText()) + "\"";//añadida funcion para editar tambien el rango
        DBConnection conn = new DBConnection();
        conn.getConnection();
        conn.executeQuery("CALL editUserData(" + password +", " +  email +", " + number +", " +  name +", " +  loggedUser +", "+ rango+ ");");
        conn.getConnection();
        
        
    }
    
    public void EditOtherInfo()//carga la informacion en la interfas, del usuario seleccionado
    {
        String user=view.getJtxtUser().getText();
        try
        {
            startConnection();
            ResultSet result =conn.executeQuery("call userList('usuario','"+user+"')");
            if (result.next())
            {
                String nombre=result.getString("nombre");
                String cedula=result.getString("cedula");
                String email=result.getString("email");
                String telefono=result.getString("telefono");
                String rango=result.getString("rango");
                this.view.fillInfoEdit(nombre, cedula, email, telefono, rango);
                
            }
        }
        catch(SQLException e)
        {
            System.out.println("Ha ocurrido una SQLException: "+e.getMessage());
        }
    }
    public EditAccountView getView() {
        return view;
    }

    public void setView(EditAccountView view) {
        this.view = view;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
