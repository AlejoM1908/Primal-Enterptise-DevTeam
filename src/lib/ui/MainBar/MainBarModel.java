//Java imports
package lib.ui.MainBar;

import lib.models.User;

public class MainBarModel {
    private User loggedUser;
    
    protected void setLoggedUser (User loggedUser){
        this.loggedUser = loggedUser;
    }
    
    public User getLoggedUser() {return this.loggedUser;}
}
