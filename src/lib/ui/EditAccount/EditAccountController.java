/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.EditAccount;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import lib.models.User;
import lib.ui.MainApp.MainAppController;
import lib.ui.MainMenu.MainMenuView;

/**
 *
 * @author user
 */
public class EditAccountController implements ActionListener, MouseListener{
    private EditAccountModel model;
    private EditAccountView view;

    public EditAccountController(EditAccountModel model, EditAccountView view, User user, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setUser(user);
        this.model.setRootComponent(rootComponent);
        this.model.getView().fillInfo(user);
        this.view.getJlEdit().addMouseListener(this);
        this.view.getBtnSave().addActionListener(this);
        this.view.getJlReturn().addMouseListener(this);
    }

    public EditAccountModel getModel() {
        return model;
    }

    public EditAccountView getView() {
        return view;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(model.ValidateLength()){
            JOptionPane.showMessageDialog(null, "Hay campos sin llenar", 
                "", JOptionPane.WARNING_MESSAGE);
        }else{
            if(model.validateFormat()){
                JOptionPane.showMessageDialog(null, "Debes llenar correctamente todos los campos", 
                "", JOptionPane.WARNING_MESSAGE);
            }else{
                model.updateUserInfo();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == this.view.getJlEdit()){
            this.view.getJpfPassword().setEditable(true);
            
        }else if(me.getSource() == this.view.getJlReturn()){
            MainMenuView mainMenuView = this.model.getRootComponent().getMainAppModel().getMainMenuView();
            this.model.getRootComponent().getMainAppView().setMainMenu(mainMenuView);
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
        this.view.getJlEdit().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getJlReturn().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
