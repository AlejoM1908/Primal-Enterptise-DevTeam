/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.userAdministrationMenuView;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.MainApp.MainAppController;
import lib.ui.SupplierRegistration.SupplierRegistrationView;
import lib.ui.UsersList.UsersListView;
import lib.ui.registroUsr.registroUsr;

public class AdministrationMenuController implements MouseListener {
    private AdministrationMenuModel model;
    private AdministrationMenuView view;

    public AdministrationMenuController(AdministrationMenuView view, AdministrationMenuModel model,
                                        MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setRootComponent(rootComponent);
        
        this.view.getAddUserslb().addMouseListener(this);
        this.view.getUsersListlb().addMouseListener(this);
        this.view.getRolesCreationlb().addMouseListener(this);
        this.view.getJlSupplier().addMouseListener(this);
    }
    
   
    
    public AdministrationMenuModel getModel(){
        return model;
    }       
    
    public AdministrationMenuView getView(){
        return view;
    }  
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == view.getAddUserslb()){
            registroUsr registerUserView = this.model.getRootComponent().getMainAppModel().getRegisterUserView();
            this.model.getRootComponent().getMainAppModel().getRegisterUserModel().clearFields();
            this.model.getRootComponent().getMainAppView().setRegisterUser(registerUserView);
        }else if (me.getSource() == view.getUsersListlb()){
            UsersListView usersListView = this.model.getRootComponent().getMainAppModel().getUsersListView();
            this.model.getRootComponent().getMainAppModel().getUsersListModel().updateTable();
            usersListView.updateUI();
            this.model.getRootComponent().getMainAppView().setUsersList(usersListView);
        }else if(me.getSource() == view.getRolesCreationlb()){
            //DIRIGIR A VENTANA CREACION DE ROLES
        }else if(me.getSource() == view.getJlSupplier()){
            SupplierRegistrationView supplierRegistrationView = this.model.getRootComponent().getMainAppModel().getSupplierRegistrationView();
            this.model.getRootComponent().getMainAppModel().getSupplierRegistrationModel().clearFields();
            this.model.getRootComponent().getMainAppView().setSupplierRegistration(supplierRegistrationView);
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
        view.getAddUserslb().setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        view.getUsersListlb().setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        view.getRolesCreationlb().setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        view.getJlSupplier().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
