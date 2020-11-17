//Java imports
package lib;

//Proyect imports
import lib.models.User;
import lib.ui.MainApp.MainAppController;
import lib.ui.MainApp.MainAppModel;
import lib.ui.MainApp.MainAppView;
import lib.ui.loginApp.LoginAppController;
import lib.ui.loginApp.LoginAppModel;
import lib.ui.loginApp.LoginAppView;

public class Main {
    LoginAppView loginAppView = new LoginAppView();
    LoginAppModel loginAppModel = new LoginAppModel();
    LoginAppController loginAppController = new LoginAppController(
            loginAppView, loginAppModel, this);
    
    MainAppView mainAppView = new MainAppView();
    MainAppModel mainAppModel = new MainAppModel();
    MainAppController mainAppController;
    
    public static void main(String[] args){
        Main main = new Main();
        
        //main.moveToLogin();
        main.moveToMainApp(new User("Admin",0,"admin","b69948501d89b5aff7726b649a27264bcd139dc1",
                -1,"None","None","Admin"));
    }
    
    public void moveToLogin(){
        this.loginAppView.setVisible(true);
        this.mainAppView.setVisible(false);
    }
    
    public void moveToMainApp(User user){
        this.mainAppController = new MainAppController(this.mainAppView, this.mainAppModel, user, this);
        
        this.mainAppView.setVisible(true);
        this.loginAppView.setVisible(false);
    }
    
    public void endProgram(){
        System.exit(0);
    }
}
