//Java imports
package lib.ui.SingleProduction;

import lib.ui.MainApp.MainAppController;

public class SingleProductionController {
    private SingleProductionView singleProductionView;
    private SingleProductionModel singleProductionModel;

    public SingleProductionController(SingleProductionView singleProductionView, SingleProductionModel singleProductionModel, MainAppController rootComponent) {
        this.singleProductionView = singleProductionView;
        this.singleProductionModel = singleProductionModel;
        this.singleProductionModel.setRootComponent(rootComponent);
    }
}
