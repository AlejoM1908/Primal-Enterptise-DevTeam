/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.userAdministrationMenuView;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdministrationMenuController implements MouseListener {
    private AdministrationMenuModel model;
    private AdministrationMenuView view;

    public AdministrationMenuController() {
        this.view = new AdministrationMenuView();
        this.model = new AdministrationMenuModel();
        
        this.view.getAddUserslb().addMouseListener(this);
        this.view.getUsersListlb().addMouseListener(this);
        this.view.getRolesCreationlb().addMouseListener(this);

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
            //DIRIGIR A VENTANA AGREGAR USUARIO
        }else if (me.getSource() == view.getUsersListlb()){
            //DIRIGIR A VENTANA LISTA DE USUARIOS
        }else if(me.getSource() == view.getRolesCreationlb()){
            //DIRIGIR A VENTANA CREACION DE ROLES
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
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
