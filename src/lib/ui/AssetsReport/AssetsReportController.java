/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.AssetsReport;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.MainApp.MainAppController;
import lib.ui.ReportsMenu.ReportsMenuView;

/**
 *
 * @author user
 */
public class AssetsReportController implements MouseListener{
    private AssetsReportModel model;
    private AssetsReportView view;

    public AssetsReportController(AssetsReportModel model, AssetsReportView view, MainAppController rootComponent) {
        this.model = model;
        this.view = view;
        this.model.setRootComponent(rootComponent);
        this.model.generateGraphic();
        this.view.getJlReturn().addMouseListener(this);
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
    
    
}
