package lib.ui.MainMenu;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import lib.models.User;

public class MainMenuController implements MouseListener{
    private MainMenuView view;
    private MainMenuModel model;

    public MainMenuController(User user) throws SQLException {
        this.view = new MainMenuView(user);
        this.model = new MainMenuModel();
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
        //this.view.jlEdit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
}
