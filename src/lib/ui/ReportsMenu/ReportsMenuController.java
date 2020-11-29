/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.ReportsMenu;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.AssetsReport.AssetsReportView;
import lib.ui.MainApp.MainAppController;
import lib.ui.MainMenu.MainMenuView;
import lib.ui.ProductionsReport.ProductionsReportView;

/**
 *
 * @author user
 */
public class ReportsMenuController implements MouseListener {
    private ReportsMenuModel model;
    private ReportsMenuView view;

    public ReportsMenuController(ReportsMenuModel model, ReportsMenuView view, MainAppController rootComponent) {
        this.model = model;
        this.view = view;
        this.model.setRootComponent(rootComponent);
        this.view.getJlAssetsReport().addMouseListener(this);
        this.view.getJlMoneyReport().addMouseListener(this);
        this.view.getJlProductionsReport().addMouseListener(this);
        
    }

    public ReportsMenuModel getModel() {
        return model;
    }

    public ReportsMenuView getView() {
        return view;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == this.view.getJlAssetsReport()){
            AssetsReportView assetsReportView = this.model.getRootComponent().getMainAppModel().getAssetsReportView();
            this.model.getRootComponent().getMainAppModel().getAssetsReportModel().generateGraphic();
            this.model.getRootComponent().getMainAppView().setAssetsReport(assetsReportView);
        }else if(me.getSource() == this.view.getJlMoneyReport()){
            //REDIRIGIR A REPORTE DE FLUJO DE CAJA
        }else if(me.getSource() == this.view.getJlProductionsReport()){
            ProductionsReportView productionsReportView = this.model.getRootComponent().getMainAppModel().getProductionsReportView();
            this.model.getRootComponent().getMainAppView().setProductionsReport(productionsReportView);
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
        this.view.getJlAssetsReport().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getJlMoneyReport().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getJlProductionsReport().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
