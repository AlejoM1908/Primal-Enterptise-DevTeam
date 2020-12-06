//Java imports
package lib.ui.SingleProduction;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.MainApp.MainAppController;

public class SingleProductionController {
    private final SingleProductionView singleProductionView;
    private final SingleProductionModel singleProductionModel;

    public SingleProductionController(SingleProductionView singleProductionView, SingleProductionModel singleProductionModel, MainAppController rootComponent) {
        this.singleProductionView = singleProductionView;
        this.singleProductionModel = singleProductionModel;
        this.singleProductionModel.setRootComponent(rootComponent);
        
        this.singleProductionView.setDate(this.singleProductionModel.getYears(), this.singleProductionModel.getMonths(), this.singleProductionModel.getDays());
        
        this.singleProductionView.getBackButton().addMouseListener(new SingleProductionListener(this.singleProductionView, this.singleProductionModel));
        this.singleProductionView.getUpdateButton().addMouseListener(new SingleProductionListener(this.singleProductionView, this.singleProductionModel));
    }
    
    private class SingleProductionListener implements MouseListener{
        private final SingleProductionView view;
        private final SingleProductionModel model;

        public SingleProductionListener(SingleProductionView singleProductionView, SingleProductionModel singleProductionModel) {
            this.view = singleProductionView;
            this.model = singleProductionModel;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == this.view.getBackButton()){
                this.model.getRootComponent().getMainAppView().setProductionListView(this.model.getRootComponent().getMainAppModel().getProductionListView());
            }
            else if (me.getSource() == this.view.getUpdateButton()){
                
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
            this.view.getBackButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getUpdateButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
        
    }
}
