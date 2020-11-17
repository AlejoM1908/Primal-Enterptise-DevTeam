//Java imports
package lib.ui.MainApp;

//Proyect imports
import javax.swing.JFrame;
import lib.Main;
import lib.models.User;
import lib.ui.EditAccount.EditAccountController;
import lib.ui.MainBar.MainBarController;
import lib.ui.MainMenu.MainMenuController;

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
        this.mainAppModel.setMainMenuController(new MainMenuController(this.mainAppModel.getMainMenuView(), mainAppModel.getMainMenuModel(), loggedUser, this));
        this.mainAppModel.setEditAccountController(new EditAccountController(this.mainAppModel.getEditAccountModel(), this.mainAppModel.getEditAccountView(), loggedUser, this));
        
        this.mainAppView.setMainBar(this.mainAppModel.getMainBarView());
        this.mainAppView.setMainMenu(this.mainAppModel.getMainMenuView());
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

    public MainAppView getMainAppView() {
        return mainAppView;
    }

    public MainAppModel getMainAppModel() {
        return mainAppModel;
    }
    
    
}
