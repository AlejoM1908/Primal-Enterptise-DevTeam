//Java imports
package lib.ui.MainApp;

//Proyect imports
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import lib.Main;
import lib.models.User;
import lib.ui.AssetRegistration.AssetRegistrationController;
import lib.ui.EditAccount.EditAccountController;
import lib.ui.Inventory.InventoryController;
import lib.ui.MainBar.MainBarController;

import lib.ui.MainMenu.MainMenuController;
import lib.ui.SupplierRegistration.SupplierRegistrationController;
import lib.ui.UsersList.UsersListController;
import lib.ui.userAdministrationMenuView.AdministrationMenuController;
import lib.ui.userAdministrationMenuView.AdministrationMenuView;

import lib.ui.buttonBar.ButtonBarController;
import lib.ui.productionSubmenu.ProductionSubmenuController;


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
        this.mainAppModel.setAssetRegistrationController(new AssetRegistrationController(this.mainAppModel.getAssetRegistrationModel(), this.mainAppModel.getAssetRegistrationView(), this));
        this.mainAppModel.setInventoryController(new InventoryController(this.mainAppModel.getInventoryView(), this.mainAppModel.getInventoryModel(), this));
        this.mainAppModel.setSupplierRegistrationController(new SupplierRegistrationController(this.mainAppModel.getSupplierRegistrationModel(), this.mainAppModel.getSupplierRegistrationView(), this));
        this.mainAppModel.setProductionSubmenuController(new ProductionSubmenuController(this.mainAppModel.getProductionSubmenuView(), this.mainAppModel.getProductionSubmenuModel(), this));

        this.mainAppModel.setButtonBarController(new ButtonBarController(this.mainAppModel.getButtonBarView(), this.mainAppModel.getButtonBarModel(), this));


        this.mainAppView.setMainBar(this.mainAppModel.getMainBarView());

        this.mainAppView.setMainMenu(this.mainAppModel.getMainMenuView());
        

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

    public MainAppView getMainAppView() {
        return mainAppView;
    }

    public MainAppModel getMainAppModel() {
        return mainAppModel;
    }
    
    public void goToProductionSubmenu(){
        this.mainAppView.setProductionSubmenuView(this.mainAppModel.getProductionSubmenuView());
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
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
