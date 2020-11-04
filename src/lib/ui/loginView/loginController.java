//Java imports
package lib.ui.loginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class loginController {
    private loginView view;
    private loginModel model;

    public loginController(loginView view, loginModel model){
        this.view = view;
        this.model = model;

        this.view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0){
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
    }
}
