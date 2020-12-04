/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.createProduction;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.ui.MainApp.MainAppController;
import lib.ui.productionSubmenu.ProductionSubmenuView;

/**
 *
 * @author user
 */
public class CreateProductionController implements MouseListener, ActionListener{
    private CreateProductionModel model;
    private CreateProductionView view;

    public CreateProductionController(CreateProductionModel model, CreateProductionView view , MainAppController rootComponent) {
        this.model = model;
        this.view = view;
        this.model.setRootComponent(rootComponent);
        
        this.view.getJlCreate().addActionListener(this);
        this.view.getJlReturn().addMouseListener(this);
    }
    
    

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == this.view.getJlReturn()){
            ProductionSubmenuView productionSubmenuView = this.model.getRootComponent().getMainAppModel().getProductionSubmenuView();
            this.model.getRootComponent().getMainAppView().setProductionSubmenuView(productionSubmenuView);
            
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            this.model.createProduction();
        } catch (SQLException ex) {
            Logger.getLogger(CreateProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
