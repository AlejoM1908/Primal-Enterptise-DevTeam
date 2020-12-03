package lib.ui.MainMenu;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.models.User;
import lib.ui.EditAccount.EditAccountView;
import lib.ui.MainApp.MainAppController;

public class MainMenuController implements MouseListener{
    private MainMenuView view;
    private MainMenuModel model;

    public MainMenuController(MainMenuView view, MainMenuModel model, User user, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setUser(user);
        this.model.setRootComponent(rootComponent);
        this.view.fillInfo(model.getUser());
        this.view.jlEdit.addMouseListener(this);
    }

    public MainMenuView getView() {
        return view;
    }

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public MainMenuModel getModel() {
        return model;
    }

    public void setModel(MainMenuModel model) {
        this.model = model;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //DIRIGIR A MOD CUENTA
        EditAccountView editAccountView = this.model.getRootComponent().getMainAppModel().getEditAccountView();
        this.model.getRootComponent().getMainAppView().setEditAccount(editAccountView);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.view.jlEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
