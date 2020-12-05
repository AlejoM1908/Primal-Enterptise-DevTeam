//Java imports
package lib.ui.MainApp;

//Proyect imports
import lib.models.User;
import lib.ui.AssetRegistration.AssetRegistrationController;
import lib.ui.AssetRegistration.AssetRegistrationModel;
import lib.ui.AssetRegistration.AssetRegistrationView;
import lib.ui.AssetsReport.AssetsReportController;
import lib.ui.AssetsReport.AssetsReportModel;
import lib.ui.AssetsReport.AssetsReportView;
import lib.ui.EditAccount.EditAccountController;
import lib.ui.EditAccount.EditAccountModel;
import lib.ui.EditAccount.EditAccountView;
import lib.ui.Inventory.InventoryController;
import lib.ui.Inventory.InventoryModel;
import lib.ui.Inventory.InventoryView;
import lib.ui.InventoryMenu.InventoryMenuController;
import lib.ui.InventoryMenu.InventoryMenuModel;
import lib.ui.InventoryMenu.InventoryMenuView;
import lib.ui.MainBar.MainBarController;
import lib.ui.MainBar.MainBarModel;
import lib.ui.MainBar.MainBarView;
import lib.ui.MainMenu.MainMenuController;
import lib.ui.MainMenu.MainMenuModel;
import lib.ui.MainMenu.MainMenuView;
import lib.ui.ProductionList.ProductionListController;
import lib.ui.ProductionList.ProductionListModel;
import lib.ui.ProductionList.ProductionListView;
import lib.ui.ProductionsReport.ProductionsReportController;
import lib.ui.ProductionsReport.ProductionsReportModel;
import lib.ui.ProductionsReport.ProductionsReportView;
import lib.ui.ReportsMenu.ReportsMenuController;
import lib.ui.ReportsMenu.ReportsMenuModel;
import lib.ui.ReportsMenu.ReportsMenuView;
import lib.ui.SingleProduction.SingleProductionController;
import lib.ui.SingleProduction.SingleProductionModel;
import lib.ui.SingleProduction.SingleProductionView;
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
import lib.ui.consultProductView.ConsultProductController;
import lib.ui.consultProductView.ConsultProductModel;
import lib.ui.consultProductView.ConsultProductView;
import lib.ui.createProduction.CreateProductionController;
import lib.ui.createProduction.CreateProductionModel;
import lib.ui.createProduction.CreateProductionView;
import lib.ui.registroProd.prodController;
import lib.ui.registroProd.prodModel;
import lib.ui.registroProd.registroProd;
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
    private final AssetsReportView assetsReportView = new AssetsReportView();
    private final AssetsReportModel assetsReportModel = new AssetsReportModel(assetsReportView);
    private AssetsReportController assetsReportController;
    
    private final ReportsMenuView reportsMenuView = new ReportsMenuView();
    private final ReportsMenuModel reportsMenuModel = new ReportsMenuModel();
    private ReportsMenuController reportsMenuController;
    
    private final ProductionsReportView productionsReportView = new ProductionsReportView();
    private final ProductionsReportModel productionsReportModel = new ProductionsReportModel(productionsReportView);
    private ProductionsReportController productionsReportController;
    
    private final InventoryMenuView inventoryMenuView = new InventoryMenuView();
    private final InventoryMenuModel inventoryMenuModel = new InventoryMenuModel(inventoryMenuView);
    private InventoryMenuController inventoryMenuController;
    
    private final registroProd registerProductView = new registroProd();
    private final prodModel registerProductModel = new prodModel(registerProductView);
    private prodController registerProductController;
    
    private final registroUsr registerUserView = new registroUsr();
    private final registroUsrModel registerUserModel = new registroUsrModel(registerUserView);
    private registroUsrController registerUserController;
    
    private final ConsultProductView consultProductView = new ConsultProductView();
    private final ConsultProductModel consultProductModel = new ConsultProductModel(consultProductView);
    private ConsultProductController consultProductController;
    
    private final CreateProductionView createProductionView = new CreateProductionView();
    private final CreateProductionModel createProductionModel = new CreateProductionModel(createProductionView);
    private CreateProductionController createProductionController;
    private final ProductionListView productionListView = new ProductionListView();
    private final ProductionListModel productionListModel = new ProductionListModel(productionListView);
    private ProductionListController productionListController;

    public void setProductionListController(ProductionListController productionListController) {
        this.productionListController = productionListController;
    }

    public ProductionListView getProductionListView() {
        return productionListView;
    }

    public ProductionListModel getProductionListModel() {
        return productionListModel;
    }

    public ProductionListController getProductionListController() {
        return productionListController;
    }

    private final SingleProductionView singleProductionView = new SingleProductionView();
    private final SingleProductionModel singleProductionModel = new SingleProductionModel();
    private SingleProductionController singleProductionController;

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

    public AssetsReportView getAssetsReportView() {
        return assetsReportView;
    }

    public AssetsReportModel getAssetsReportModel() {
        return assetsReportModel;
    }

    public void setAssetsReportController(AssetsReportController assetsReportController) {
        this.assetsReportController = assetsReportController;
    }

    public ReportsMenuView getReportsMenuView() {
        return reportsMenuView;
    }

    public ReportsMenuModel getReportsMenuModel() {
        return reportsMenuModel;
    }

    public void setReportsMenuController(ReportsMenuController reportsMenuController) {
        this.reportsMenuController = reportsMenuController;
    }

    public ProductionsReportView getProductionsReportView() {
        return productionsReportView;
    }

    public ProductionsReportModel getProductionsReportModel() {
        return productionsReportModel;
    }

    public void setProductionsReportController(ProductionsReportController productionsReportController) {
        this.productionsReportController = productionsReportController;
    }

    public InventoryMenuView getInventoryMenuView() {
        return inventoryMenuView;
    }

    public InventoryMenuModel getInventoryMenuModel() {
        return inventoryMenuModel;
    }

    public void setInventoryMenuController(InventoryMenuController inventoryMenuController) {
        this.inventoryMenuController = inventoryMenuController;
    }

    public registroProd getRegisterProductView() {
        return registerProductView;
    }

    public prodModel getRegisterProductModel() {
        return registerProductModel;
    }

    public void setRegisterProductController(prodController registerProductController) {
        this.registerProductController = registerProductController;
    }

    public registroUsr getRegisterUserView() {
        return registerUserView;
    }

    public registroUsrModel getRegisterUserModel() {
        return registerUserModel;
    }

    public void setRegisterUserController(registroUsrController registerUserController) {
        this.registerUserController = registerUserController;
    }

    public ConsultProductView getConsultProductView() {
        return consultProductView;
    }

    public ConsultProductModel getConsultProductModel() {
        return consultProductModel;
    }

    public void setConsultProductController(ConsultProductController consultProductController) {
        this.consultProductController = consultProductController;
    }

    public CreateProductionView getCreateProductionView() {
        return createProductionView;
    }

    public CreateProductionModel getCreateProductionModel() {
        return createProductionModel;
    }

    public void setCreateProductionController(CreateProductionController createProductionController) {
        this.createProductionController = createProductionController;
    }
    
    
    public void setProductionSubmenuController(ProductionSubmenuController productionSubmenuController){
        this.productionSubmenuController = productionSubmenuController;
    }
    
    public void setSingleProductionController(SingleProductionController singleProductionController){
        this.singleProductionController = singleProductionController;
    }
    
    public MainBarController getMainBarController() {return this.mainBarController;}
    
    public ButtonBarView getButtonBarView() {return this.buttonBarView;}
    public ButtonBarModel getButtonBarModel() {return this.buttonBarModel;}
    public ButtonBarController getButtonBarController() {return this.buttonBarController;}
    
    public ProductionSubmenuView getProductionSubmenuView() {return this.productionSubmenuView;}
    public ProductionSubmenuModel getProductionSubmenuModel() {return this.productionSubmenuModel;}
    public ProductionSubmenuController getProductionSubmenuController() {return this.productionSubmenuController;}
    
    public SingleProductionView getSingleProductionView() {return this.singleProductionView;}
    public SingleProductionModel getSingleProductionModel() {return this.singleProductionModel;}
    public SingleProductionController getSingleProductionController() {return this.singleProductionController;}
}
