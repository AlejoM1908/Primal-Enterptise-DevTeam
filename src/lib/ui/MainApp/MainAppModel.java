//Java imports
package lib.ui.MainApp;

import lib.models.User;
import lib.ui.MainBar.MainBarController;
import lib.ui.MainBar.MainBarModel;
import lib.ui.MainBar.MainBarView;

public class MainAppModel {
    private User loggedUser;
    
    private final MainBarView mainBarView = new MainBarView();
    private final MainBarModel mainBarModel = new MainBarModel();
    private MainBarController mainBarController;
    
    public User getLoggedUser(){
        return this.loggedUser;
    }
    
    public void setLoggedUser(User loggedUser){
        this.loggedUser = loggedUser;
    }
    
    protected void setMainBarController(MainBarController mainBarController){
        this.mainBarController = mainBarController;
    }
    
    public MainBarView getMainBarView() {return this.mainBarView;}
    public MainBarModel getMainBarModel() {return this.mainBarModel;}
}
