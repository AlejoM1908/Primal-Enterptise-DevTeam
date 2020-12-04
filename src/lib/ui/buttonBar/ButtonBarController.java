//Java imports
package lib.ui.buttonBar;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.models.User;
import lib.ui.InventoryMenu.InventoryMenuView;

//Proyect imports
import lib.ui.MainApp.MainAppController;
import lib.ui.ReportsMenu.ReportsMenuView;
import lib.ui.userAdministrationMenuView.AdministrationMenuView;

public class ButtonBarController {
    private ButtonBarView buttonBarView;
    private ButtonBarModel buttonBarModel;
    
    public ButtonBarController(ButtonBarView buttonBarView, ButtonBarModel buttonBarModel, MainAppController rootComponent){
        this.buttonBarView = buttonBarView;
        this.buttonBarModel = buttonBarModel;
        this.buttonBarView.setVisibility(rootComponent.getMainAppModel().getLoggedUser());
        this.buttonBarView.getHomeButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getInventoryButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getProductionButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getUsersButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getActivesButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getReportsButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));                
    }
    
    class ButtonBarListener implements MouseListener{
        private final ButtonBarView view;
        private final MainAppController rootComponent;
        
        protected ButtonBarListener(ButtonBarView buttonBarView, MainAppController rootComponent){
            this.view = buttonBarView;
            this.rootComponent = rootComponent;
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == this.view.getHomeButton()){
                this.rootComponent.getMainAppModel().getMainMenuView().fillInfo(this.rootComponent.getMainAppModel().getLoggedUser());
                this.rootComponent.getMainAppView().setMainMenu(this.rootComponent.getMainAppModel().getMainMenuView());
            }
            else if (me.getSource() == this.view.getInventoryButton()){
                if(this.view.getInventoryButton().isEnabled())
                {
                    InventoryMenuView inventoryMenuView = this.rootComponent.getMainAppModel().getInventoryMenuView();
                    this.rootComponent.getMainAppView().setInventoryMenu(inventoryMenuView);
                }
            }
            else if (me.getSource() == this.view.getProductionButton()){
                if(this.view.getProductionButton().isEnabled())
                {
                    rootComponent.goToProductionSubmenu();
                }
            }
            else if (me.getSource() == this.view.getUsersButton()){
                if(this.view.getUsersButton().isEnabled())
                {
                     AdministrationMenuView adminView = this.rootComponent.getMainAppModel().getAdministrationMenuView();
                     this.rootComponent.getMainAppView().setAdministrationMenu(adminView);
                }
               
            }
            else if (me.getSource() == this.view.getActivesButton()){
                if(this.view.getActivesButton().isEnabled())
                {
                    
                }
            }
            else if (me.getSource() == this.view.getReportsButton()){
                if(this.view.getReportsButton().isEnabled())
                {
                    ReportsMenuView reportsMenuView = this.rootComponent.getMainAppModel().getReportsMenuView();
                    this.rootComponent.getMainAppView().setReportsMenu(reportsMenuView);
                }
                
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
            this.view.getHomeButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getInventoryButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getProductionButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getUsersButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getActivesButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getReportsButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
}
