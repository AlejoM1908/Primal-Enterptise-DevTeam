/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.Inventory;

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
public class InventoryController implements MouseListener{
    private InventoryView view;
    private InventoryModel model;

    public InventoryController(InventoryView view, InventoryModel model, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setRootComponent(rootComponent);
        try {
            this.model.fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.view.getJlEdit().addMouseListener(this);
        this.view.getJlAddProduct().addMouseListener(this);
        this.view.getJlReturn().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == view.getJlAddProduct()){
            //DIRIGIR A REGISTRAR PRODUCTO
        }else if(me.getSource() == view.getJlEdit()){
            //DIRIGIR A VISTA DE PRODUCTO
        }else if(me.getSource() == view.getJlReturn()){
            //DIRIGIR A MENÚ
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
       
        view.getJlEdit().setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        view.getJlAddProduct().setCursor(new Cursor(Cursor.HAND_CURSOR));
        
       
        view.getJlReturn().setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
    public InventoryView getView() {
        return view;
    }

    public void setView(InventoryView view) {
        this.view = view;
    }

    public InventoryModel getModel() {
        return model;
    }

    public void setModel(InventoryModel model) {
        this.model = model;
    }

}
