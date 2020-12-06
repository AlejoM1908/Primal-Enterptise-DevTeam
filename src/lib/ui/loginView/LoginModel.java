//Java imports
package lib.ui.loginView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import lib.app.Backups;

//Proyect imports
import lib.app.DBConnection;
import lib.models.User;

public class LoginModel {
    private DBConnection conn = new DBConnection();
    private String userName = "";
    private String range = "";
    private User loggedUser = null;
    private int error = -1;
    private List<String> nombres_login=new ArrayList<String>();
    private List<Integer> intentos=new ArrayList<Integer>();
    private Backups respaldo= new Backups();
    
    public void login(String user, String password){
        if (user.compareTo("") == 0 || password.compareTo("") == 0){
            this.error = 3;
            return;
        }
        
        try{
            startConnection();
            ResultSet result = conn.executeQuery("call login('"+user+"','"+password+"')");

            if (result.next()){
                error = Integer.parseInt(result.getString("error"));
                
                if (error == 2){
                    userName = result.getString("nombre");
                    range = result.getString("rango");
                    System.out.println(userName + " , " + range);
                    String query = "call userList('usuario',\""+userName+"\")";
                    result = conn.executeQuery(query);

                    if (result.next()){
                        int telefono = -1;
                        String tel = result.getString("telefono");
                        if (tel != null)
                            telefono = Integer.parseInt(tel);
                        String email = result.getString("email");
                        String direccion = result.getString("direccion");
                        String nombre = result.getString("nombre");

                        loggedUser = new User(userName,0,range,password,telefono,email, direccion, nombre);
                        respaldo.Preferencias("primalEnterpricedb","root","fool9411");
                        System.out.println("Ingresado al sistema exitosamente como: " + userName);
                    }
                }
                else if(error==1)
                {
                    if(nombres_login.contains(user))
                    {
                        int posisision=nombres_login.indexOf(user);
                        int nuevo=intentos.get(posisision)+1;
                        intentos.set(posisision,nuevo);
                    }
                    else 
                    {
                        nombres_login.add(user);
                        intentos.add(1);
                    }
                    if(intentos.contains(3))
                    {
                        int lugar_nombre=intentos.indexOf(3);
                        String ususario = nombres_login.get(lugar_nombre);
                        result=conn.executeQuery("call bloqueo('"+ususario+"')");
                        JOptionPane.showMessageDialog(null,"EL usuario "+ususario+" ha sido bloqueado, 3 intentos fallidos");
                        intentos.remove(lugar_nombre);
                        nombres_login.remove(lugar_nombre);
                    }
                }
            } 
        }
        catch(SQLException e){
            System.out.println("Ha ocurrido una SQLException: "+e.getMessage());
        }
        
        endConnection();
    }
    
    private void startConnection(){
        conn.getConnection();
    }
    
    private void endConnection(){
        conn.endCOnnection();
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getRange(){
        return this.range;
    }

    public int getError(){
        return this.error;
    }
    
    public User getUser(){
        return this.loggedUser;
    }
}
