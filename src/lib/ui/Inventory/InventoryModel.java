/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import lib.app.DBConnection;

/**
 *
 * @author user
 */
public class InventoryModel {
    private InventoryView view;

    public InventoryModel(InventoryView view) {
        this.view = view;
    }
    
    public void fillTable() throws SQLException{
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = conn.executeQuery("SELECT nombre_producto, marca_producto, tipo_de_producto, cantidad, fecha_caducidad FROM producto;");
        conn.endCOnnection();
        
        DefaultTableModel model = (DefaultTableModel) view.getJtInventory().getModel();
        while(result.next()){
            model.addRow(new Object[]{"", result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)});
        }
        view.updateUI();
    }

    public InventoryView getView() {
        return view;
    }

    public void setView(InventoryView view) {
        this.view = view;
    }
    
    
}
