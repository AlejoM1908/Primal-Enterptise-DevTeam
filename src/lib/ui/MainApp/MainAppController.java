//Java imports
package lib.ui.MainApp;

//Proyect imports
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import lib.Main;
import lib.models.User;
import lib.ui.EditAccount.EditAccountController;
import lib.ui.MainBar.MainBarController;
import lib.ui.MainMenu.MainMenuController;
import lib.ui.UsersList.UsersListController;
import lib.ui.userAdministrationMenuView.AdministrationMenuController;
import lib.ui.userAdministrationMenuView.AdministrationMenuView;

public class MainAppController implements MouseListener{
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
        this.mainAppModel.setAdministrationMenuController(new AdministrationMenuController(this.mainAppModel.getAdministrationMenuView(), this.mainAppModel.getAdministrationMenuModel(), this));
        this.mainAppModel.setUsersListController(new UsersListController(this.mainAppModel.getUsersListView(), this.mainAppModel.getUsersListModel(), this));
        
        this.mainAppView.setMainBar(this.mainAppModel.getMainBarView());
        this.mainAppView.setMainMenu(this.mainAppModel.getMainMenuView());
        
        this.mainAppView.getJlMainMenu().addMouseListener(this);
        this.mainAppView.getJlInventory().addMouseListener(this);
        this.mainAppView.getJlProductions().addMouseListener(this);
        this.mainAppView.getJlAdminUsers().addMouseListener(this);
        this.mainAppView.getJlAdminProducts().addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == mainAppView.getJlMainMenu()){
            this.mainAppView.setMainMenu(this.mainAppModel.getMainMenuView());
            
        }else if(me.getSource() == mainAppView.getJlInventory()){
            
        }else if(me.getSource() == mainAppView.getJlProductions()){
            
        }else if(me.getSource() == mainAppView.getJlAdminUsers()){
            AdministrationMenuView adminView = this.mainAppModel.getAdministrationMenuView();
            this.mainAppView.setAdministrationMenu(adminView);
        }else if(me.getSource() == mainAppView.getJlAdminProducts()){
            
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
