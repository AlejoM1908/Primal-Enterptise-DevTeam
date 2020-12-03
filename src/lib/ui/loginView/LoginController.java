//Java imports
package lib.ui.loginView;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Proyect imports
import lib.ui.loginApp.LoginAppController;

public class LoginController{
    private final LoginView view;
    private final LoginModel model;

    public LoginController(LoginView view, LoginModel model, LoginAppController rootComponent){
        this.view = view;
        this.model = model;

        this.view.getLoginButton().addMouseListener(new LoginListener(this.view,this.model,rootComponent));
    }
    
    class LoginListener implements MouseListener{
        private final LoginView view;
        private final LoginModel model;
        private final LoginAppController rootComponent;

        public LoginListener(LoginView view, LoginModel model, LoginAppController rootComponent) {
            this.view = view;
            this.model = model;
            this.rootComponent = rootComponent;
        }
        
        @Override
        public void mouseClicked(MouseEvent me){
            String user,password;

            try{
                user = view.getUserName();
                password = view.getPassword();
                    
                model.login(user, password);

                if (model.getError() == 2){
                    this.rootComponent.succesfulLogin(model.getUser());
                }
                else
                    view.displayErrorMessage(model.getError());
            }
            catch (Exception e){

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
            this.view.getLoginButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
}
