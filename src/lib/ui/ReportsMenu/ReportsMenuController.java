/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.ReportsMenu;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import lib.ui.MainApp.MainAppController;
import lib.ui.MainMenu.MainMenuView;

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
        this.view.getJlReturn().addMouseListener(this);
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
        if(me.getSource() == this.view.getJlReturn()){
            MainMenuView mainMenuView = this.model.getRootComponent().getMainAppModel().getMainMenuView();
            this.model.getRootComponent().getMainAppView().setMainMenu(mainMenuView);
        }else if(me.getSource() == this.view.getJlAssetsReport()){
            //REDIRIGIR A REPORTE DE ACTIVOS
        }else if(me.getSource() == this.view.getJlMoneyReport()){
            //REDIRIGIR A REPORTE DE FLUJO DE CAJA
        }else if(me.getSource() == this.view.getJlProductionsReport()){
            //REDIRIGIR A REPORTE DE PRODUCCIONES
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
        this.view.getJlAssetsReport().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getJlMoneyReport().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.view.getJlProductionsReport().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    
}
