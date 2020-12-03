//Java imports
package lib.ui.MainApp;

//Proyect imports
import lib.models.User;
import lib.ui.AssetRegistration.AssetRegistrationController;
import lib.ui.AssetRegistration.AssetRegistrationModel;
import lib.ui.AssetRegistration.AssetRegistrationView;
import lib.ui.EditAccount.EditAccountController;
import lib.ui.EditAccount.EditAccountModel;
import lib.ui.EditAccount.EditAccountView;
import lib.ui.Inventory.InventoryController;
import lib.ui.Inventory.InventoryModel;
import lib.ui.Inventory.InventoryView;
import lib.ui.MainBar.MainBarController;
import lib.ui.MainBar.MainBarModel;
import lib.ui.MainBar.MainBarView;
import lib.ui.MainMenu.MainMenuController;
import lib.ui.MainMenu.MainMenuModel;
import lib.ui.MainMenu.MainMenuView;
import lib.ui.SupplierRegistration.SupplierRegistrationController;
import lib.ui.SupplierRegistration.SupplierRegistrationModel;
import lib.ui.SupplierRegistration.SupplierRegistrationView;
import lib.ui.UsersList.UsersListController;
import lib.ui.UsersList.UsersListModel;
import lib.ui.UsersList.UsersListView;
import lib.ui.userAdministrationMenuView.AdministrationMenuController;
import lib.ui.userAdministrationMenuView.AdministrationMenuModel;
import lib.ui.userAdministrationMenuView.AdministrationMenuView;
import lib.ui.buttonBar.ButtonBarController;
import lib.ui.buttonBar.ButtonBarModel;
import lib.ui.buttonBar.ButtonBarView;
import lib.ui.productionSubmenu.ProductionSubmenuController;
import lib.ui.productionSubmenu.ProductionSubmenuModel;
import lib.ui.productionSubmenu.ProductionSubmenuView;
import lib.ui.registroUsr.registroUsr;
import lib.ui.registroUsr.registroUsrController;
import lib.ui.registroUsr.registroUsrModel;


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
    
    private final AssetRegistrationView assetRegistrationView = new AssetRegistrationView();
    private final AssetRegistrationModel assetRegistrationModel = new AssetRegistrationModel(assetRegistrationView);
    private AssetRegistrationController assetRegistrationController;
    
    private final InventoryView inventoryView = new InventoryView();
    private final InventoryModel inventoryModel = new InventoryModel(inventoryView);
    private InventoryController inventoryController;
    
    private final SupplierRegistrationView supplierRegistrationView = new SupplierRegistrationView();
    private final SupplierRegistrationModel supplierRegistrationModel = new SupplierRegistrationModel(supplierRegistrationView);
    private SupplierRegistrationController supplierRegistrationController;
   
    private final ProductionSubmenuView productionSubmenuView = new ProductionSubmenuView();
    private final ProductionSubmenuModel productionSubmenuModel = new ProductionSubmenuModel();
    private ProductionSubmenuController productionSubmenuController;
    
    private final registroUsr registro=new registroUsr();
    private final registroUsrModel registromodelo=new registroUsrModel();
    private registroUsrController registrocontroller;
    
    private final ButtonBarView buttonBarView = new ButtonBarView();
    private final ButtonBarModel buttonBarModel = new ButtonBarModel();
    private ButtonBarController buttonBarController;

     public registroUsr getRegistro() {
        return registro;
    }

    public registroUsrModel getRegistromodelo() {
        return registromodelo;
    }

    public registroUsrController getRegistrocontroller() {
        return registrocontroller;
    }

    public void setRegistrocontroller(registroUsrController registrocontroller) {
        this.registrocontroller = registrocontroller;
    }
    
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

    public AssetRegistrationView getAssetRegistrationView() {
        return assetRegistrationView;
    }

    public AssetRegistrationModel getAssetRegistrationModel() {
        return assetRegistrationModel;
    }

    public void setAssetRegistrationController(AssetRegistrationController assetRegistrationController) {
        this.assetRegistrationController = assetRegistrationController;
    }

    public InventoryView getInventoryView() {
        return inventoryView;
    }

    public InventoryModel getInventoryModel() {
        return inventoryModel;
    }

    public void setInventoryController(InventoryController inventoryController) {
        this.inventoryController = inventoryController;
    }

    public SupplierRegistrationView getSupplierRegistrationView() {
        return supplierRegistrationView;
    }

    public SupplierRegistrationModel getSupplierRegistrationModel() {
        return supplierRegistrationModel;
    }

    public void setSupplierRegistrationController(SupplierRegistrationController supplierRegistrationController) {
        this.supplierRegistrationController = supplierRegistrationController;
    }
    
    public void setProductionSubmenuController(ProductionSubmenuController productionSubmenuController){
        this.productionSubmenuController = productionSubmenuController;
    }
    
    public MainBarController getMainBarController() {return this.mainBarController;}
    
    public ButtonBarView getButtonBarView() {return this.buttonBarView;}
    public ButtonBarModel getButtonBarModel() {return this.buttonBarModel;}
    public ButtonBarController getButtonBarController() {return this.buttonBarController;}
    
    public ProductionSubmenuView getProductionSubmenuView() {return this.productionSubmenuView;}
    public ProductionSubmenuModel getProductionSubmenuModel() {return this.productionSubmenuModel;}
    public ProductionSubmenuController getProductionSubmenuController() {return this.productionSubmenuController;}
}
