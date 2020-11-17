//Java imports
package lib.ui.MainApp;

import lib.models.User;
import lib.ui.EditAccount.EditAccountController;
import lib.ui.EditAccount.EditAccountModel;
import lib.ui.EditAccount.EditAccountView;
import lib.ui.MainBar.MainBarController;
import lib.ui.MainBar.MainBarModel;
import lib.ui.MainBar.MainBarView;
import lib.ui.MainMenu.MainMenuController;
import lib.ui.MainMenu.MainMenuModel;
import lib.ui.MainMenu.MainMenuView;
import lib.ui.UsersList.UsersListController;
import lib.ui.UsersList.UsersListModel;
import lib.ui.UsersList.UsersListView;
import lib.ui.userAdministrationMenuView.AdministrationMenuController;
import lib.ui.userAdministrationMenuView.AdministrationMenuModel;
import lib.ui.userAdministrationMenuView.AdministrationMenuView;

public class MainAppModel {
    private User loggedUser;
    
    private final MainBarView mainBarView = new MainBarView();
    private final MainBarModel mainBarModel = new MainBarModel();
    private MainBarController mainBarController;
    
    private final MainMenuView mainMenuView = new MainMenuView();
    private final MainMenuModel mainMenuModel = new MainMenuModel();
    private MainMenuController mainMenuController;
    
    private final EditAccountView editAccountView = new EditAccountView();
    private final EditAccountModel editAccountModel = new EditAccountModel(editAccountView);
    private EditAccountController editAccountController;
    
    private final AdministrationMenuView administrationMenuView = new AdministrationMenuView();
    private final AdministrationMenuModel administrationMenuModel = new AdministrationMenuModel();
    private AdministrationMenuController administrationMenuController;
    
    private final UsersListView usersListView = new UsersListView();
    private final UsersListModel usersListModel = new UsersListModel(usersListView);
    private UsersListController usersListController;
    
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

    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    public MainMenuView getMainMenuView() {
        return mainMenuView;
    }

    public MainMenuModel getMainMenuModel() {
        return mainMenuModel;
    }

    public EditAccountView getEditAccountView() {
        return editAccountView;
    }

    public EditAccountModel getEditAccountModel() {
        return editAccountModel;
    }

    public void setEditAccountController(EditAccountController editAccountController) {
        this.editAccountController = editAccountController;
    }

    public AdministrationMenuView getAdministrationMenuView() {
        return administrationMenuView;
    }

    public AdministrationMenuModel getAdministrationMenuModel() {
        return administrationMenuModel;
    }

    public void setAdministrationMenuController(AdministrationMenuController administrationMenuController) {
        this.administrationMenuController = administrationMenuController;
    }

    public UsersListView getUsersListView() {
        return usersListView;
    }

    public UsersListModel getUsersListModel() {
        return usersListModel;
    }

    public void setUsersListController(UsersListController usersListController) {
        this.usersListController = usersListController;
    }
    
}
