//Java imports
package lib.ui.SingleProduction;

import lib.ui.MainApp.MainAppController;

public class SingleProductionModel {
    private MainAppController rootComponent;
    private int id;
    
    public void setRootComponent(MainAppController rootComponent){
        this.rootComponent = rootComponent;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public MainAppController getRootComponent() {return this.rootComponent;}
}
