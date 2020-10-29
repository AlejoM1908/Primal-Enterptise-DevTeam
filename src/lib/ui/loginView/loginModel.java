//Java imports
package lib.ui.loginView;
import java.security.MessageDigest;

//Proyect imports
import lib.app.DBConnection;

public class loginModel {
    private DBConnection conn = new DBConnection();
    
    public void login(String user, String password){
        
    }
    
    private void startConnection(){
        conn.getConnection();
    }
    
    private void endConnection(){
        conn.endCOnnection();
    }
}
