//Java imports
package lib.ui.loginView;
import java.sql.ResultSet;
import java.sql.SQLException;

//Proyect imports
import lib.app.DBConnection;

public class loginModel {
    private DBConnection conn = new DBConnection();
    private String userName = "";
    private String range = "";
    private int error = 0;
    
    public void login(String user, String password){
        try{
            startConnection();
            ResultSet result = conn.executeQuery("call login("+user+","+password+")");

            error = Integer.parseInt(result.getString("error"));
            
            if (error == 2){
                userName = result.getString("nombre");
                range = result.getString("rango");
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
        return userName;
    }
    
    public String getRange(){
        return range;
    }

    public int getError(){
        return error;
    }
}
