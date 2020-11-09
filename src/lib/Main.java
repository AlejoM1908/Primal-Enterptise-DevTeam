//Java imports
package lib;

//Proyect imports
import lib.ui.loginApp.LoginAppController;
import lib.ui.loginApp.LoginAppModel;
import lib.ui.loginApp.LoginAppView;

public class Main {
    
    public static void main(String[] args){
        
        
        
    }
    
    public void showLogin(){
        LoginAppView loginAppView = new LoginAppView();
        LoginAppModel loginAppModel = new LoginAppModel();
        LoginAppController loginAppController = new LoginAppController(loginAppView, loginAppModel, this);
        
        loginAppView.setVisible(true);
    }
}
