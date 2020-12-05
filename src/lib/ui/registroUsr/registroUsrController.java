/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.registroUsr;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import lib.ui.MainApp.MainAppController;
import lib.ui.registroUsr.registroUsrModel;
import lib.ui.userAdministrationMenuView.AdministrationMenuView;
import javax.swing.JComboBox;

/**
 *
 * @author Fredy AGP
 */
public class registroUsrController implements MouseListener {

    private registroUsr view;
    private registroUsrModel model;

    public registroUsrController(registroUsr view, registroUsrModel model, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setRootComponent(rootComponent);

        this.view.getRegistrarB().addMouseListener(this);
        this.view.getRegresarB().addMouseListener(this);
    }

    public int registrados(String nombre, String email, String direccion, String rol, String usr, String pass, String cedula, String telefono) {
        int cedula_num;
        int telefono_num;
        try {
            cedula_num = Integer.parseInt(cedula);

        } catch (NumberFormatException ex) {
            return 0;
        }
        try {
            telefono_num = Integer.parseInt(telefono);

        } catch (NumberFormatException ex) {
            return 0;
        }
        if (usr.length() >= 25) {
            return 0;
        }
        if (pass.length() >= 25) {
            return 0;
        }
        if (email.contains("@") == false) {
            return 0;
        }
        
        this.model.registro(usr, cedula_num, rol, pass, email, telefono_num, direccion, nombre);
        return 1;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.view.getRegresarB()) {
            AdministrationMenuView dministrationMenuView = this.model.getRootComponent().getMainAppModel().getAdministrationMenuView();
            this.model.getRootComponent().getMainAppView().setAdministrationMenu(dministrationMenuView);
        } else if (me.getSource() == this.view.getRegistrarB()) {
            int indicador;
            indicador = registrados("\"" + this.view.getNombreTF().getText() + "\"",
                    "\"" + this.view.getEmailTF().getText() + "\"", "\"" + this.view.getDireccionTF().getText() + "\"", "\"" + this.view.getRangoTF().getSelectedItem().toString() + "\"", "\"" + this.view.getNombreUsuarioTF().getText() + "\"",
                    "\"" + this.view.getContraseñaTF().getText() + "\"", this.view.getCedulaTF().getText(), this.view.getTelefonoTF().getText());
            if (indicador == 0) {
                JOptionPane.showMessageDialog(this.view, "Datos Incorrectos Igrese nuevamente");
            } else {
                JOptionPane.showMessageDialog(this.view, "Usuario Registrado Correctamente");
            }
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
        this.view.getRegistrarB().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getRegresarB().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}
