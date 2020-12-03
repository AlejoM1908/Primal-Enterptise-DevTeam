//Java imports
package lib.ui.loginApp;

//Proyect imports
import javax.swing.JFrame;
import lib.Main;
import lib.models.User;
import lib.ui.MainBar.MainBarController;
import lib.ui.loginView.LoginController;

public class LoginAppController {
    private final LoginAppView loginAppView;
    private final LoginAppModel loginAppModel;
    private final Main rootComponent;

    public LoginAppController(LoginAppView loginAppView, LoginAppModel loginAppModel, Main main) {
        this.loginAppView = loginAppView;
        this.loginAppModel = loginAppModel;
        this.rootComponent = main;
        
        this.loginAppModel.setLoginController(new LoginController(
                this.loginAppModel.getLoginView(), this.loginAppModel.getLoginModel(), this));
        
        this.loginAppModel.setMainBarController(new MainBarController(this.loginAppModel.getMainBarView(), 
                this.loginAppModel.getMainBarModel(), this));
        
        this.loginAppModel.setRootComponent(main);
        this.loginAppView.setLogin(this.loginAppModel.getLoginView());
        this.loginAppView.setBar(this.loginAppModel.getMainBarView());
    }
    
    public void succesfulLogin(User user){
        this.loginAppModel.getRootComponent().moveToMainApp(user);
    }
    
    public void minimizeFrame(){
        this.loginAppView.setState(JFrame.ICONIFIED);
    }
    
    public void endProgram(){
        this.rootComponent.endProgram();
    }
    
    public void updatePosition(int posX, int posY){
        this.loginAppView.setLocation(posX, posY);
    }
}
