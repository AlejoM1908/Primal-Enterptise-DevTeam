//Java imports
package lib.ui.MainApp;

import lib.models.User;

public class MainAppModel {
    private User loggedUser;
    
    public User getLoggedUser(){
        return this.loggedUser;
    }
    
    public void setLoggedUser(User loggedUser){
        this.loggedUser = loggedUser;
    }
}
