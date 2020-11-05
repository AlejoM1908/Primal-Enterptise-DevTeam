//Java imports
package lib.ui.MainApp;

public class MainAppController {
    private MainAppView mainAppView = new MainAppView();
    private MainAppModel mainAppModel = new MainAppModel();

    public MainAppController(MainAppView mainAppView, MainAppModel mainAppModel) {
        this.mainAppView = mainAppView;
        this.mainAppModel = mainAppModel;
    }
}
