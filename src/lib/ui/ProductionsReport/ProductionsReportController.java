/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.ProductionsReport;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.MainApp.MainAppController;
import lib.ui.ReportsMenu.ReportsMenuView;

/**
 *
 * @author user
 */
public class ProductionsReportController implements MouseListener, ActionListener{
    private ProductionsReportView view;
    private ProductionsReportModel model;

    public ProductionsReportController(ProductionsReportView view, ProductionsReportModel model, MainAppController rootComponent) {
        this.view = view;
        this.model = model;
        this.model.setRootComponent(rootComponent);
        this.view.getJlReturn().addMouseListener(this);
        this.view.getBtnAmount().addActionListener(this);
        this.view.getBtnStatus().addActionListener(this);
        this.view.getBtnType().addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        ReportsMenuView view = this.model.getRootComponent().getMainAppModel().getReportsMenuView();
        this.model.getRootComponent().getMainAppView().setReportsMenu(view);
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
        if(ae.getSource() == this.view.getBtnStatus()){
            this.model.generateGraphic("torta", "estado");
        }else if(ae.getSource() == this.view.getBtnType()){
            this.model.generateGraphic("torta", "tipo");
        }else if(ae.getSource() == this.view.getBtnAmount()){
            this.model.generateGraphic("barras", "cantidad");
        }
    }
    
    
}
