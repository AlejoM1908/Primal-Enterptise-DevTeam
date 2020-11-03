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

/**
 *
 * @author user
 */
public class InventoryController implements MouseListener{
    private InventoryView view;
    private InventoryModel model;

    public InventoryController() throws SQLException {
        this.view = new InventoryView();
        this.model = new InventoryModel(view);
        this.model.fillTable();
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
