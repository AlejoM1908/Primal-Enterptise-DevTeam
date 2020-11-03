/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.AssetRegistration;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class AssetRegistrationController implements ActionListener, MouseListener{
    private AssetRegistrationModel model;
    private AssetRegistrationView view;

    public AssetRegistrationController() {
        this.view = new AssetRegistrationView();
        this.model = new AssetRegistrationModel(view);
        this.view.getBtnRegister().addActionListener(this);
        this.view.getJlReturn().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.model.validateLength()){
            JOptionPane.showMessageDialog(null, "Hay campos sin llenar", 
                "", JOptionPane.WARNING_MESSAGE);
        }else{
            if(this.model.validateFormat()){
                JOptionPane.showMessageDialog(null, "Debes llenar correctamente todos los campos", 
                "", JOptionPane.WARNING_MESSAGE);
            }else{
                try {
                    if(this.model.validateNit()){
                        JOptionPane.showMessageDialog(null, "El proveedor ingresado no está registrado",
                                "", JOptionPane.WARNING_MESSAGE);
                    }else{
                        this.model.registerAsset();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AssetRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //DIRIGIR A VENTANA
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
