/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.InventoryMenu;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.Inventory.InventoryView;
import lib.ui.MainApp.MainAppController;
import lib.ui.registroProd.registroProd;

/**
 *
 * @author user
 */
public class InventoryMenuController implements MouseListener{
    private InventoryMenuModel model;
    private InventoryMenuView view;

    public InventoryMenuController(InventoryMenuModel model, InventoryMenuView view, MainAppController rootComponent) {
        this.model = model;
        this.view = view;
        this.model.setRootComponent(rootComponent);
        
        this.view.getJlProductsList().addMouseListener(this);
        this.view.getJlRegisterProduct().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == this.view.getJlProductsList()){
            InventoryView inventoryView = this.model.getRootComponent().getMainAppModel().getInventoryView();
            this.model.getRootComponent().getMainAppView().setInventory(inventoryView);
        }else if(me.getSource() == this.view.getJlRegisterProduct()){
            registroProd registerProductView = this.model.getRootComponent().getMainAppModel().getRegisterProductView();
            this.model.getRootComponent().getMainAppView().setRegisterProduct(registerProductView);
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
        this.view.getJlProductsList().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getJlRegisterProduct().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
