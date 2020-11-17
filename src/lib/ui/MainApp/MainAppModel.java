//Java imports
package lib.ui.MainApp;

import lib.models.User;
import lib.ui.MainBar.MainBarController;
import lib.ui.MainBar.MainBarModel;
import lib.ui.MainBar.MainBarView;
import lib.ui.buttonBar.ButtonBarController;
import lib.ui.buttonBar.ButtonBarModel;
import lib.ui.buttonBar.ButtonBarView;

public class MainAppModel {
    private User loggedUser;
    
    private final MainBarView mainBarView = new MainBarView();
    private final MainBarModel mainBarModel = new MainBarModel();
    private MainBarController mainBarController;

    private final ButtonBarView buttonBarView = new ButtonBarView();
    private final ButtonBarModel buttonBarModel = new ButtonBarModel();
    private ButtonBarController buttonBarController;
    
    public User getLoggedUser(){
        return this.loggedUser;
    }
    
    public void setLoggedUser(User loggedUser){
        this.loggedUser = loggedUser;
    }
    
    protected void setMainBarController(MainBarController mainBarController){
        this.mainBarController = mainBarController;
    }

    protected void setButtonBarController(ButtonBarController buttonBarController){
        this.buttonBarController = buttonBarController;
    }
    
    public MainBarView getMainBarView() {return this.mainBarView;}
    public MainBarModel getMainBarModel() {return this.mainBarModel;}
    public MainBarController getMainBarController() {return this.mainBarController;}

    public ButtonBarView getButtonBarView() {return this.buttonBarView;}
    public ButtonBarModel getButtonBarModel() {return this.buttonBarModel;}
    public ButtonBarController getButtonBarController() {return this.buttonBarController;}
}
