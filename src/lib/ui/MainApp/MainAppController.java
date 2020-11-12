//Java imports
package lib.ui.MainApp;

//Proyect imports
import javax.swing.JFrame;
import lib.Main;
import lib.models.User;

public class MainAppController {
    private MainAppView mainAppView;
    private MainAppModel mainAppModel;
    private Main rootComponent;

    public MainAppController(MainAppView mainAppView, MainAppModel mainAppModel, User loggedUser, Main main) {
        this.mainAppView = mainAppView;
        this.mainAppModel = mainAppModel;
        this.rootComponent = main;
        this.mainAppModel.setLoggedUser(loggedUser);
    }
    
    public void minimizeFrame(){
        this.mainAppView.setState(JFrame.ICONIFIED);
    }
    
    public void endProgram(){
        this.rootComponent.endProgram();
    }
}
