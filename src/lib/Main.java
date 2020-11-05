//Java imports
package lib;

//Proyect imports
import lib.ui.loginApp.LoginAppController;
import lib.ui.loginApp.LoginAppModel;
import lib.ui.loginApp.LoginAppView;

public class Main {
    public static void main(String[] args){
        LoginAppView loginAppView = new LoginAppView();
        LoginAppController loginAppController = new LoginAppController(loginAppView);
        LoginAppModel loginAppModel = new LoginAppModel(loginAppController);
        loginAppController.setModel(loginAppModel);
        
        loginAppView.setVisible(true);
    }
}
