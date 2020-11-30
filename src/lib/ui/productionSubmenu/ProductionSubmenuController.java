//Java imports
package lib.ui.productionSubmenu;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Proyect imports
import lib.ui.MainApp.MainAppController;

public class ProductionSubmenuController {
    private final ProductionSubmenuView productionSubmenuView;
    private final ProductionSubmenuModel productionSubmenuModel;

    public ProductionSubmenuController(ProductionSubmenuView productionSubmenuView, ProductionSubmenuModel productionSubmenuModel, MainAppController rootComponent) {
        this.productionSubmenuView = productionSubmenuView;
        this.productionSubmenuModel = productionSubmenuModel;
        this.productionSubmenuModel.setRootComponent(rootComponent);
        
        this.productionSubmenuView.getRegisterProductionsButton().addMouseListener(new ProductionSubmenuListener(this.productionSubmenuView, this.productionSubmenuModel));
        this.productionSubmenuView.getRegisterProductButton().addMouseListener(new ProductionSubmenuListener(this.productionSubmenuView, this.productionSubmenuModel));
        this.productionSubmenuView.getProductionsListButton().addMouseListener(new ProductionSubmenuListener(this.productionSubmenuView, this.productionSubmenuModel));
        this.productionSubmenuView.getProductListButton().addMouseListener(new ProductionSubmenuListener(this.productionSubmenuView, this.productionSubmenuModel));
    }
    
    private class ProductionSubmenuListener implements MouseListener{
        private final ProductionSubmenuView view;
        private final ProductionSubmenuModel model;

        public ProductionSubmenuListener(ProductionSubmenuView productionSubmenuView, ProductionSubmenuModel productionSubmenuModel) {
            this.view = productionSubmenuView;
            this.model = productionSubmenuModel;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == view.getRegisterProductionsButton()){
                
            }
            else if (me.getSource() == view.getRegisterProductButton()){
                
            }
            else if (me.getSource() == view.getProductionsListButton()){
                
            }
            else if (me.getSource() == view.getProductListButton()){
                
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
            view.getRegisterProductionsButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.getRegisterProductButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.getProductionsListButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.getProductListButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    
    }
}