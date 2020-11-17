/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.UsersList;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.ui.MainApp.MainAppController;

/**
 *
 * @author user
 */
public class UsersListController implements MouseListener{
    private UsersListModel model;
    private UsersListView view;

    public UsersListController(UsersListView view, UsersListModel model, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setRootComponent(rootComponent);
        try {
            this.model.fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.view.getJlAddUser().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.view.getJlAddUser().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    public UsersListModel getModel() {
        return model;
    }

    public UsersListView getView() {
        return view;
    }
    
    
}
