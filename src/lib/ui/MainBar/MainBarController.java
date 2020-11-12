//Java imports
package lib.ui.MainBar;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.MainApp.MainAppController;
import lib.ui.loginApp.LoginAppController;

public class MainBarController {
    private MainBarView mainBarView = new MainBarView();
    private MainBarModel mainBarModel = new MainBarModel();
    
    public MainBarController(MainBarView mainBarView, MainBarModel mainBarModel, LoginAppController rootComponent){
        this.mainBarView = mainBarView;
        this.mainBarModel = mainBarModel;
        
        this.mainBarView.getCloseButton().addMouseListener(new BarListener(mainBarView, mainBarModel, rootComponent));
        this.mainBarView.getMinimizingButton().addMouseListener(new BarListener(mainBarView, mainBarModel, rootComponent));
    }
    
    public MainBarController(MainBarView mainBarView, MainBarModel mainBarModel, MainAppController rootComponent){
        this.mainBarView = mainBarView;
        this.mainBarModel = mainBarModel;
        
        this.mainBarView.getCloseButton().addMouseListener(new BarListener(mainBarView, mainBarModel, rootComponent));
        this.mainBarView.getMinimizingButton().addMouseListener(new BarListener(mainBarView, mainBarModel, rootComponent));
    }
    
    class BarListener implements MouseListener{
        private final MainBarView view;
        private final MainBarModel model;
        private LoginAppController rootLoginComponent;
        private MainAppController rootAppComponent;

        public BarListener(MainBarView view, MainBarModel model, LoginAppController rootComponent) {
            this.view = view;
            this.model = model;
            this.rootLoginComponent = rootComponent;
        }
        
        public BarListener(MainBarView view, MainBarModel model, MainAppController rootComponent) {
            this.view = view;
            this.model = model;
            this.rootAppComponent = rootComponent;
        }
        
        @Override
        public void mouseClicked(MouseEvent me){
            if (this.rootLoginComponent != null && this.rootAppComponent == null){
                if (me.getSource() == this.view.getCloseButton()){
                    rootLoginComponent.endProgram();
                }
                else if (me.getSource() == this.view.getMinimizingButton()){
                    this.rootLoginComponent.minimizeFrame();
                }
            }
            else if (this.rootLoginComponent == null && this.rootAppComponent != null){
                if (me.getSource() == this.view.getCloseButton()){
                    rootAppComponent.endProgram();
                }
                else if (me.getSource() == this.view.getMinimizingButton()){
                    this.rootAppComponent.minimizeFrame();
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
            this.view.getCloseButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getMinimizingButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
}
