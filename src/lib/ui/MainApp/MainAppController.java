//Java imports
package lib.ui.MainApp;

//Proyect imports
import javax.swing.JFrame;
import lib.Main;
import lib.models.User;
import lib.ui.MainBar.MainBarController;
import lib.ui.buttonBar.ButtonBarController;

public class MainAppController {
    private final MainAppView mainAppView;
    private final MainAppModel mainAppModel;
    private final Main rootComponent;

    public MainAppController(MainAppView mainAppView, MainAppModel mainAppModel, User loggedUser, Main main) {
        this.mainAppView = mainAppView;
        this.mainAppModel = mainAppModel;
        this.rootComponent = main;
        this.mainAppModel.setLoggedUser(loggedUser);
        
        this.mainAppModel.setMainBarController(new MainBarController(this.mainAppModel.getMainBarView(), this.mainAppModel.getMainBarModel(), loggedUser, this));
        this.mainAppModel.setButtonBarController(new ButtonBarController(this.mainAppModel.getButtonBarView(), this.mainAppModel.getButtonBarModel(), this));

        this.mainAppView.setMainBar(this.mainAppModel.getMainBarView());
        this.mainAppView.setButtonBar(this.mainAppModel.getButtonBarView());
    }
    
    public void minimizeFrame(){
        this.mainAppView.setState(JFrame.ICONIFIED);
    }
    
    public void endProgram(){
        this.rootComponent.endProgram();
    }
    
    public void updatePosition(int posX, int posY){
        this.mainAppView.setLocation(posX, posY);
    }
}
