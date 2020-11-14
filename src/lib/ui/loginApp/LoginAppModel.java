//Java imports
package lib.ui.loginApp;

//Proyect imports
import lib.Main;
import lib.ui.MainBar.MainBarController;
import lib.ui.MainBar.MainBarModel;
import lib.ui.MainBar.MainBarView;
import lib.ui.loginView.LoginController;
import lib.ui.loginView.LoginModel;
import lib.ui.loginView.LoginView;

public class LoginAppModel {
    private LoginView loginView = new LoginView();
    private LoginModel loginModel = new LoginModel();
    private LoginController loginController;
    
    private MainBarView mainBarView = new MainBarView();
    private MainBarModel mainBarModel = new MainBarModel();
    private MainBarController mainBarController;
    private Main rootComponent;

    public void setLoginController(LoginController loginController){
        this.loginController = loginController;
    }
    
    public void setMainBarController(MainBarController mainBarController){
        this.mainBarController = mainBarController;
    }
    
    public void setRootComponent (Main rootComponent){
        this.rootComponent = rootComponent;
    }
    
    public LoginView getLoginView() {return this.loginView;}
    public LoginModel getLoginModel() {return this.loginModel;}
    public MainBarView getMainBarView() {return this.mainBarView;}
    public MainBarModel getMainBarModel() {return this.mainBarModel;}
    public Main getRootComponent() {return this.rootComponent;}
}
