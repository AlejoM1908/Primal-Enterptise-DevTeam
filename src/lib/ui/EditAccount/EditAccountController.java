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

/**
 *
 * @author user
 */
public class EditAccountController implements ActionListener, MouseListener{
    private EditAccountModel model;
    private EditAccountView view;

    public EditAccountController(User user) {
        this.view = new  EditAccountView(user);
        this.model = new EditAccountModel(view);
        this.view.getJlEdit().addMouseListener(this);
        this.view.getBtnSave().addActionListener(this);
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
        this.view.getJpfPassword().setEditable(true);
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
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
