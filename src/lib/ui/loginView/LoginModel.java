//Java imports
package lib.ui.loginView;
import java.sql.ResultSet;
import java.sql.SQLException;

//Proyect imports
import lib.app.DBConnection;
import lib.models.User;

public class LoginModel {
    private DBConnection conn = new DBConnection();
    private String userName = "";
    private String range = "";
    private User loggedUser = null;
    private int error = -1;
    
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
                    result = conn.executeQuery("call userList('usuario','"+userName+"')");

                    if (result.next()){
                        int telefono = -1;
                        String tel = result.getString("telefono");
                        if (tel != null)
                            telefono = Integer.parseInt(tel);
                        String email = result.getString("email");
                        String direccion = result.getString("direccion");
                        String nombre = result.getString("nombre");

                        loggedUser = new User(userName,0,range,password,telefono,email, direccion, nombre);

                        System.out.println("Ingresado al sistema exitosamente como: " + userName);
                    }
                }
            }
            
            endConnection();
        }
        catch(SQLException e){
            System.out.println("Ha ocurrido una SQLException: "+e.getMessage());
        }
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
