//Java imports
package lib.ui.loginApp;

//Proyect imports
import lib.models.User;

public class LoginAppController {
    private LoginAppView loginAppView;
    private LoginAppModel loginAppModel;

    public LoginAppController(LoginAppView loginAppView) {
        this.loginAppView = loginAppView;
    }
    
    public void succesfulLogin(User user){
        
    }
    
    public void setModel(LoginAppModel loginAppModel){
        this.loginAppModel = loginAppModel;
    }
}
