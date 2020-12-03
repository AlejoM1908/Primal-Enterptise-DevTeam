//Java imports
package lib.ui.MainBar;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//Proyect imports
import lib.models.User;
import lib.ui.MainApp.MainAppController;
import lib.ui.loginApp.LoginAppController;

public class MainBarController {
    private MainBarView mainBarView;
    private MainBarModel mainBarModel;
    private Point point = new Point();
    
    public MainBarController(MainBarView mainBarView, MainBarModel mainBarModel, LoginAppController rootComponent){
        this.mainBarView = mainBarView;
        this.mainBarModel = mainBarModel;
        
        this.mainBarView.hideUserLabel();
        
        this.mainBarView.getCloseButton().addMouseListener(new BarListener(mainBarView, rootComponent, point));
        this.mainBarView.getMinimizingButton().addMouseListener(new BarListener(mainBarView, rootComponent, point));
        this.mainBarView.getMainBarView().addMouseListener(new BarListener(mainBarView, rootComponent, point));
        this.mainBarView.getMainBarView().addMouseMotionListener(new BarMotionListener(rootComponent, point));
    }
    
    public MainBarController(MainBarView mainBarView, MainBarModel mainBarModel, User user, MainAppController rootComponent){
        this.mainBarView = mainBarView;
        this.mainBarModel = mainBarModel;
        this.mainBarModel.setLoggedUser(user);
        
        this.mainBarView.getCloseButton().addMouseListener(new BarListener(mainBarView, rootComponent, point));
        this.mainBarView.getMinimizingButton().addMouseListener(new BarListener(mainBarView, rootComponent, point));
        this.mainBarView.getMainBarView().addMouseListener(new BarListener(mainBarView, rootComponent, point));
        this.mainBarView.getMainBarView().addMouseMotionListener(new BarMotionListener(rootComponent, point));
        this.mainBarView.setUserName(this.mainBarModel.getLoggedUser());
    }
    
    class BarListener implements MouseListener{
        private final MainBarView view;
        private LoginAppController rootLoginComponent;
        private MainAppController rootAppComponent;
        Point point;

        public BarListener(MainBarView view, LoginAppController rootComponent, Point point) {
            this.view = view;
            this.rootLoginComponent = rootComponent;
            this.point = point;
        }
        
        public BarListener(MainBarView view, MainAppController rootComponent, Point point) {
            this.view = view;
            this.rootAppComponent = rootComponent;
            this.point = point;
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
            point.setMouseX(me.getX());
            point.setMouseY(me.getY());
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
    
    class BarMotionListener implements MouseMotionListener{
        private LoginAppController rootLoginComponent;
        private MainAppController rootAppComponent;
        Point point;
        
        public BarMotionListener(LoginAppController rootComponent, Point point) {
            this.rootLoginComponent = rootComponent;
            this.point = point;
        }
        
        public BarMotionListener(MainAppController rootComponent, Point point) {
            this.rootAppComponent = rootComponent;
            this.point = point;
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            int x = me.getXOnScreen();
            int y = me.getYOnScreen();
            
            if (this.rootLoginComponent != null && this.rootAppComponent == null){
                rootLoginComponent.updatePosition(x-point.getMouseX(),y-point.getMouseY());
            }
            else if (this.rootLoginComponent == null && this.rootAppComponent != null){
                rootAppComponent.updatePosition(x-point.getMouseX(),y-point.getMouseY());
            }
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            
        }
        
    }
    
    private class Point{
        int posX, posY;
        
        protected void setMouseX(int posX){
            this.posX = posX;
        }
        
        protected void setMouseY(int posY){
            this.posY = posY;
        }
        
        protected int getMouseX() {return this.posX;}
        protected int getMouseY() {return this.posY;}
    }
}
