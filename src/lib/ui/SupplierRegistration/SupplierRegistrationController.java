/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.SupplierRegistration;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lib.ui.MainApp.MainAppController;
import lib.ui.userAdministrationMenuView.AdministrationMenuView;

/**
 *
 * @author user
 */
public class SupplierRegistrationController implements ActionListener, MouseListener{
    private SupplierRegistrationModel model;
    private SupplierRegistrationView view;

    public SupplierRegistrationController(SupplierRegistrationModel model, SupplierRegistrationView view, MainAppController rootComponent) {
        this.model = model;
        this.view = view;
        this.model.setRootComponent(rootComponent);
        this.view.btnRegister.addActionListener(this);
        this.view.getJlReturn().addMouseListener(this);
    }
    
    

    public SupplierRegistrationModel getModel() {
        return model;
    }

    public void setModel(SupplierRegistrationModel model) {
        this.model = model;
    }

    public SupplierRegistrationView getView() {
        return view;
    }

    public void setView(SupplierRegistrationView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(model.validateLength()){
            JOptionPane.showMessageDialog(null, "Hay campos sin llenar", 
                "", JOptionPane.WARNING_MESSAGE);
        }else{
            if(model.validateFormat()){
                JOptionPane.showMessageDialog(null, "Debes llenar correctamente todos los campos", 
                "", JOptionPane.WARNING_MESSAGE);
            }else{
                try {
                    if(model.validateNit(Integer.parseInt(view.getJtxtNit().getText()))){
                        JOptionPane.showMessageDialog(null, "El NIT ingresado ya está registrado", 
                            "", JOptionPane.WARNING_MESSAGE);
                    }else{
                        model.registerSupplier();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == this.view.getJlReturn()){
            AdministrationMenuView view = this.model.getRootComponent().getMainAppModel().getAdministrationMenuView();
            this.model.getRootComponent().getMainAppView().setAdministrationMenu(view);
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
        this.view.getJlReturn().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
