/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;
import lib.ui.UsersList.UsersListModel;

/**
 *
 * @author user
 */
public class InventoryModel {
    private InventoryView view;
    
    private MainAppController rootComponent;

    public InventoryModel(InventoryView view) {
        this.view = view;
    }
    
    public void fillTable() throws SQLException{
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = conn.executeQuery("SELECT pru_nombre, pru_marca, pru_tipo, pru_cantidad, pru_fecha_caducidad, pru_id FROM productos WHERE pru_estado != 2;");
        conn.endCOnnection();
        
        DefaultTableModel model = (DefaultTableModel) view.getJtInventory().getModel();
        while(result.next()){
            model.addRow(new Object[]{"", result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getInt(6)});
        }
        view.updateUI();
    }
    
    public void updateTable(){
        DefaultTableModel model = (DefaultTableModel) view.getJtInventory().getModel();
        int rowCount = model.getRowCount();
        for(int i = 0; i < rowCount; i++){
            model.removeRow(0);
        }
        try {
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(UsersListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.updateUI();
    }

    public InventoryView getView() {
        return view;
    }

    public void setView(InventoryView view) {
        this.view = view;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }
    
    
}
