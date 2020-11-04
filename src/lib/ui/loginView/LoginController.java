//Java imports
package lib.ui.loginView;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginController{
    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view, LoginModel model){
        this.view = view;
        this.model = model;

        this.view.getLoginButton().addMouseListener(new LoginListener(this.view,this.model));
        this.view.getLoginButton().addMouseListener(new LoginListener(this.view,this.model));
        this.view.getLoginButton().addMouseListener(new LoginListener(this.view,this.model));
    }

    
    
    class LoginListener implements MouseListener{
        private LoginView view;
        private LoginModel model;

        public LoginListener(LoginView view, LoginModel model) {
            this.view = view;
            this.model = model;
        }
        
        @Override
        public void mouseClicked(MouseEvent me){
            if (me.getSource() == this.view.getLoginButton()){
                String user,password = "";

                try{
                    user = view.getUserName();
                    password = view.getPassword();
                    
                    model.login(user, password);

                    view.displayErrorMessage(model.getError());
                }
                catch (Exception e){

                }
            }
            
            if (me.getSource() == this.view.getForgotPasswordButton()){
                //ToDo: logica para ir a la pantalla de recupercaión de contraseña
            }
            
            if (me.getSource() == this.view.getNewUserButton()){
                //Todo: logica para ir a la pantalla de creacion de usario
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
            this.view.getForgotPasswordButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.view.getNewUserButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    }
}
