//Java imports
package lib.ui.loginApp;

//Proyect imports
import lib.Main;
import lib.models.User;

public class LoginAppController {
    private LoginAppView loginAppView;
    private LoginAppModel loginAppModel;

    public LoginAppController(LoginAppView loginAppView, LoginAppModel loginAppModel, Main main) {
        this.loginAppView = loginAppView;
        this.loginAppModel = loginAppModel;
        
    }
    
    public void succesfulLogin(User user){
        
    }
    
    public void setModel(LoginAppModel loginAppModel){
        this.loginAppModel = loginAppModel;
    }
}
