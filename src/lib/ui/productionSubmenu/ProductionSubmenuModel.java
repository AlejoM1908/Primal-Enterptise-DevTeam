//Java imports
package lib.ui.productionSubmenu;

import lib.ui.MainApp.MainAppController;

public class ProductionSubmenuModel {
    private MainAppController rootComponent;
    
    public void setRootComponent(MainAppController rootComponent){
        this.rootComponent = rootComponent;
    }
    
    public MainAppController getRootComponent() {return this.rootComponent;}
}
