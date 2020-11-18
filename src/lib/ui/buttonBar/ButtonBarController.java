//Java imports
package lib.ui.buttonBar;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Proyect imports
import lib.ui.MainApp.MainAppController;

public class ButtonBarController {
    private ButtonBarView buttonBarView;
    private ButtonBarModel buttonBarModel;
    
    public ButtonBarController(ButtonBarView buttonBarView, ButtonBarModel buttonBarModel, MainAppController rootComponent){
        this.buttonBarView = buttonBarView;
        this.buttonBarModel = buttonBarModel;
        
        this.buttonBarView.getHomeButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getInventoryButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getProductionButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getUsersButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
        this.buttonBarView.getActivesButton().addMouseListener(new ButtonBarListener(buttonBarView, rootComponent));
                        
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
                
            }
            else if (me.getSource() == this.view.getInventoryButton()){
                
            }
            else if (me.getSource() == this.view.getProductionButton()){
                
            }
            else if (me.getSource() == this.view.getUsersButton()){
                
            }
            else if (me.getSource() == this.view.getActivesButton()){
                
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
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
}