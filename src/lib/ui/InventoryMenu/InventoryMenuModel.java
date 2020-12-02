/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.InventoryMenu;

import lib.ui.MainApp.MainAppController;

/**
 *
 * @author user
 */
public class InventoryMenuModel {
    private InventoryMenuView view;
    
    private MainAppController rootComponent;

    public InventoryMenuModel(InventoryMenuView view) {
        this.view = view;
    }

    public InventoryMenuView getView() {
        return view;
    }

    public void setView(InventoryMenuView view) {
        this.view = view;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    
}
