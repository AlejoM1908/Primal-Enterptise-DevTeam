/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.SupplierRegistration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SupplierRegistrationController implements ActionListener{
    private SupplierRegistrationModel model;
    private SupplierRegistrationView view;

    public SupplierRegistrationController(SupplierRegistrationModel model, SupplierRegistrationView view) {
        this.model = model;
        this.view = view;
        this.view.btnRegister.addActionListener(this);
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
    
    
}
